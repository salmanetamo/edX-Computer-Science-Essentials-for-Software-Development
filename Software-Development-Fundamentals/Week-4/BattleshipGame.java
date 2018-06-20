
public class BattleshipGame {
	Ocean ocean;
	
	public BattleshipGame() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Ocean ocean = new Ocean();
		ocean.placeAllShipsRandomly();
		ocean.print();
		for(int row = 0; row<20;row++) {
			for(int column = 0; column<20;column++) {
				ocean.getShipArray()[row][column].shootAt(row, column);
			}
		}
		ocean.print();
	}

}
