import java.util.*;
public class Ocean {
	private Ship[][] ships = new Ship[20][20];
	private int shotsFired;
	private int hitCount;
	private int shipsSunk;
	
	public Ocean() {
		for(int i = 0; i < this.ships.length; i++){
			for(int j = 0; j < this.ships.length; j++){
				this.ships[i][j] = new EmptySea();
			}
		}
		this.shotsFired = 0;
		this.hitCount = 0;
		this.shipsSunk = 0;
	}

	public Ocean get() {
		return this;
	}
	
	public void placeAllShipsRandomly() {		
		ArrayList<Ship> allShips = new ArrayList<Ship>();
		BattleCruiser battleCruiser = new BattleCruiser();
		allShips.add(battleCruiser);
		Battleship battleship = new Battleship();
		allShips.add(battleship);
		Cruiser cruiser1 = new Cruiser();
		allShips.add(cruiser1);
		Cruiser cruiser2 = new Cruiser();
		allShips.add(cruiser2);
		LightCruiser lightCruiser1 = new LightCruiser();
		allShips.add(lightCruiser1);
		LightCruiser lightCruiser2 = new LightCruiser();
		allShips.add(lightCruiser2);
		Destroyer destroyer1 = new Destroyer();
		allShips.add(destroyer1);
		Destroyer destroyer2 = new Destroyer();
		allShips.add(destroyer2);
		Destroyer destroyer3 = new Destroyer();
		allShips.add(destroyer3);
		Submarine submarine1 = new Submarine();
		allShips.add(submarine1);
		Submarine submarine2 = new Submarine();
		allShips.add(submarine2);
		Submarine submarine3 = new Submarine();
		allShips.add(submarine3);
		Submarine submarine4 = new Submarine();
		allShips.add(submarine4);
		
		Random random = new Random();
		int randomRow;
		int randomColumn;
		boolean randomHorizontal;
		
		boolean allShipsNotPlaced = true;
		int shipsPlaced = 0; 
		
		while(allShipsNotPlaced) {
			randomRow = random.nextInt(20);
			randomColumn = random.nextInt(20);
			randomHorizontal = random.nextBoolean();
			for(int i = 0; i < allShips.size(); i++) {
				if(allShips.get(i).okToPlaceShipAt(randomRow, randomColumn, randomHorizontal, this.get())) {
					allShips.get(i).placeShipAt(randomRow, randomColumn, randomHorizontal, this.get());
					shipsPlaced++;
				} else {
					i--;
					break;
				}
			}
			if(shipsPlaced == 13) allShipsNotPlaced = false;
		}
	}
	
	public boolean isOccupied(int row, int column) {
		return !(this.getShipArray()[row][column] instanceof EmptySea);
	}
	
	public boolean shootAt(int row, int column) {
		this.hitCount++;
		this.shotsFired++;
		if(!this.isOccupied(row, column) || this.getShipArray()[row][column].isSunk()) {
			this.shotsFired--;
			return false;
		}
		return true;
	}

	public int getShotsFired() {
		return this.shotsFired;
	}

	public int getHitCount() {
		return this.hitCount;
	}

	public int getShipsSunk() {
		return this.shipsSunk;
	}
	
	public boolean isGameOver() {
		for(int row = 0; row < this.getShipArray().length; row++ ) {
			for(int column = 0; column < this.getShipArray().length; column++ ) {
				if(this.isOccupied(row, column) && !this.getShipArray()[row][column].isSunk()) {
					return false;
				}
			}
		}
		return true;
	}
	public Ship[][] getShipArray(){
		return this.ships;
	}
	
	public void print() {
		System.out.print("   ");
		for(int colNumbers = 0; colNumbers < 20; colNumbers++) {
			if(colNumbers < 10) {
				System.out.print(colNumbers+"  ");
			} else {
				System.out.print(colNumbers+" ");
			}
		}
		System.out.println();
		for(int row = 0; row < this.getShipArray().length; row++ ) {
			if(row < 10) {
				System.out.print(row+"  ");
			} else {
				System.out.print(row+" ");
			}
			for(int column = 0; column < this.getShipArray().length; column++ ) {
				if(!this.isOccupied(row, column)) {
					if(!this.getShipArray()[row][column].shootAt(row, column)) {
						System.out.print("."+"  ");
					} else {
						System.out.print("-"+"  ");
					}				
				} else if(this.getShipArray()[row][column].isSunk()) {
					System.out.print("X"+"  ");
				} else if(this.getShipArray()[row][column].shootAt(row, column)) {
					System.out.print("S"+"  ");
				}
			}
			System.out.println();
		}
	}
	
}

