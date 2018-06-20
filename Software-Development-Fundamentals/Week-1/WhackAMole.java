import java.util.Random;
import java.util.Scanner;

public class WhackAMole {
	int score;
	int molesLeft;
	int attempsLeft;
	char[][] moleGrid;
	
	public WhackAMole(int numAttempts, int gridDimension) {
		this.score = 0;
		this.attempsLeft = numAttempts;
		this.moleGrid = new char[gridDimension][gridDimension];
	}

	public boolean place(int x, int y) {
		boolean thereIsMole = this.moleGrid[x][y] != '*';
		if(thereIsMole) {
			this.moleGrid[x][y] = 'M';
			this.molesLeft++;
		}
		return thereIsMole;
	}
	
	public void whack(int x, int y) {
		if(this.moleGrid[x][y] == 'M') {
			this.score++;
			this.attempsLeft--;
			this.molesLeft--;
			this.moleGrid[x][y] = 'W';
		} else {
			this.attempsLeft--;
		}
	}
	
	public void printGridToUser() {
		for(int i = 0; i < this.moleGrid.length; i++) {
			for(int j = 0; j < this.moleGrid[i].length; j++) {
				if(this.moleGrid[i][j] == 'W') {
					System.out.print('W');
				}
				System.out.print('*');
			}
			System.out.println();
		}
	}
	
	public void printGrid() {
		for(int i = 0; i < this.moleGrid.length; i++) {
			for(int j = 0; j < this.moleGrid[i].length; j++) {
				if(this.moleGrid[i][j] == 'W') {
					System.out.print('W');
				} else if(this.moleGrid[i][j] == 'M') {
					System.out.print('M');
				} else {
					System.out.print('*');
				}
			}
			System.out.println();
		}
	}
	
	public static void main (String[] args) {
		WhackAMole theGrid = new WhackAMole(50,10);
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		
		for(int i = 0; i < 10; i++) {
			int x = random.nextInt(10);
			int y = random.nextInt(10);
			if(theGrid.place(x, y)) {
				continue;
			} else {
				i--;
			}

		}
		System.out.println(theGrid.molesLeft);
		System.out.println("You have 50 attempts to get all the moles.");
		
		while(theGrid.molesLeft > 0 && theGrid.attempsLeft > 0) {
			theGrid.printGridToUser();
			System.out.println("Specify the position where you want to whack. Entering -1, -1 finishes the game");
			System.out.println("Enter x: ");
			int x = scanner.nextInt();
			System.out.println("Enter y: ");
			int y = scanner.nextInt();
			if(x == -1 && y == -1) {
				System.out.println("You terminated the game. Here is the grid:");
				theGrid.printGrid();
				break;
			}
			theGrid.whack(x, y);
		}
	}
}
