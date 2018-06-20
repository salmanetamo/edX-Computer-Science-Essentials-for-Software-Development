import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SquarelotronTest {
	Squarelotron squarelotron1;
	Squarelotron squarelotron2;
	@Before
	public void setUp() throws Exception {
		squarelotron1 = new Squarelotron(4);
		squarelotron2 = new Squarelotron(5);
	}

	@Test
	public void testUpsideDownFlip() {
		//Testing the method for the outer ring
		Squarelotron returnedSquarelotron1 = squarelotron1.upsideDownFlip(1);
		assertEquals(returnedSquarelotron1.squarelotron[0][0], 13);
		assertEquals(returnedSquarelotron1.squarelotron[0][1], 14);
		assertEquals(returnedSquarelotron1.squarelotron[0][2], 15);
		assertEquals(returnedSquarelotron1.squarelotron[0][3], 16);
		
		assertEquals(returnedSquarelotron1.squarelotron[1][0], 9);
		assertEquals(returnedSquarelotron1.squarelotron[1][1], 6);
		assertEquals(returnedSquarelotron1.squarelotron[1][2], 7);
		assertEquals(returnedSquarelotron1.squarelotron[1][3], 12);
		
		assertEquals(returnedSquarelotron1.squarelotron[2][0], 5);
		assertEquals(returnedSquarelotron1.squarelotron[2][1], 10);
		assertEquals(returnedSquarelotron1.squarelotron[2][2], 11);
		assertEquals(returnedSquarelotron1.squarelotron[2][3], 8);
		
		assertEquals(returnedSquarelotron1.squarelotron[3][0], 1);
		assertEquals(returnedSquarelotron1.squarelotron[3][1], 2);
		assertEquals(returnedSquarelotron1.squarelotron[3][2], 3);
		assertEquals(returnedSquarelotron1.squarelotron[3][3], 4);
		
		//Testing the method for the inner ring
		Squarelotron returnedSquarelotron2 = squarelotron1.upsideDownFlip(2);
		assertEquals(returnedSquarelotron2.squarelotron[1][1], 6);
		assertEquals(returnedSquarelotron2.squarelotron[1][2], 7);
		assertEquals(returnedSquarelotron2.squarelotron[2][1], 10);
		assertEquals(returnedSquarelotron2.squarelotron[2][2], 11);
	}
	@Test
	public void testMainDiagonalFlip() {
		//Testing for ring 1
		Squarelotron returnedSquarelotron1 = squarelotron2.mainDiagonalFlip(1);
		assertEquals(returnedSquarelotron1.squarelotron[0][0], 1);
		assertEquals(returnedSquarelotron1.squarelotron[0][1], 6);
		assertEquals(returnedSquarelotron1.squarelotron[0][2], 11);
		assertEquals(returnedSquarelotron1.squarelotron[0][3], 16);
		assertEquals(returnedSquarelotron1.squarelotron[0][4], 21);
		
		assertEquals(returnedSquarelotron1.squarelotron[1][0], 2);
		assertEquals(returnedSquarelotron1.squarelotron[1][1], 7);
		assertEquals(returnedSquarelotron1.squarelotron[1][2], 8);
		assertEquals(returnedSquarelotron1.squarelotron[1][3], 9);
		assertEquals(returnedSquarelotron1.squarelotron[1][4], 22);
		
		assertEquals(returnedSquarelotron1.squarelotron[2][0], 3);
		assertEquals(returnedSquarelotron1.squarelotron[2][1], 12);
		assertEquals(returnedSquarelotron1.squarelotron[2][2], 13);
		assertEquals(returnedSquarelotron1.squarelotron[2][3], 14);
		assertEquals(returnedSquarelotron1.squarelotron[2][4], 23);
		
		assertEquals(returnedSquarelotron1.squarelotron[3][0], 4);
		assertEquals(returnedSquarelotron1.squarelotron[3][1], 17);
		assertEquals(returnedSquarelotron1.squarelotron[3][2], 18);
		assertEquals(returnedSquarelotron1.squarelotron[3][3], 19);
		assertEquals(returnedSquarelotron1.squarelotron[3][4], 24);
		
		assertEquals(returnedSquarelotron1.squarelotron[4][0], 5);
		assertEquals(returnedSquarelotron1.squarelotron[4][1], 10);
		assertEquals(returnedSquarelotron1.squarelotron[4][2], 15);
		assertEquals(returnedSquarelotron1.squarelotron[4][3], 20);
		assertEquals(returnedSquarelotron1.squarelotron[4][4], 25);
		
	//Testing for ring 2
		Squarelotron returnedSquarelotron2 = squarelotron2.mainDiagonalFlip(2);
		assertEquals(returnedSquarelotron2.squarelotron[0][0], 1);
		assertEquals(returnedSquarelotron2.squarelotron[0][1], 2);
		assertEquals(returnedSquarelotron2.squarelotron[0][2], 3);
		assertEquals(returnedSquarelotron2.squarelotron[0][3], 4);
		assertEquals(returnedSquarelotron2.squarelotron[0][4], 5);
		
		assertEquals(returnedSquarelotron2.squarelotron[1][0], 6);
		assertEquals(returnedSquarelotron2.squarelotron[1][1], 7);
		assertEquals(returnedSquarelotron2.squarelotron[1][2], 12);
		assertEquals(returnedSquarelotron2.squarelotron[1][3], 17);
		assertEquals(returnedSquarelotron2.squarelotron[1][4], 10);
		
		assertEquals(returnedSquarelotron2.squarelotron[2][0], 11);
		assertEquals(returnedSquarelotron2.squarelotron[2][1], 8);
		assertEquals(returnedSquarelotron2.squarelotron[2][2], 13);
		assertEquals(returnedSquarelotron2.squarelotron[2][3], 14);
		assertEquals(returnedSquarelotron2.squarelotron[2][4], 15);
		
		assertEquals(returnedSquarelotron2.squarelotron[3][0], 16);
		assertEquals(returnedSquarelotron2.squarelotron[3][1], 9);
		assertEquals(returnedSquarelotron2.squarelotron[3][2], 18);
		assertEquals(returnedSquarelotron2.squarelotron[3][3], 19);
		assertEquals(returnedSquarelotron2.squarelotron[3][4], 20);
		
		assertEquals(returnedSquarelotron2.squarelotron[4][0], 21);
		assertEquals(returnedSquarelotron2.squarelotron[4][1], 22);
		assertEquals(returnedSquarelotron2.squarelotron[4][2], 23);
		assertEquals(returnedSquarelotron2.squarelotron[4][3], 24);
		assertEquals(returnedSquarelotron2.squarelotron[4][4], 25);
	}
	@Test
	public void testRotateRight() {
		//Testing for a positive number
		squarelotron2.rotateRight(2);
		assertEquals(squarelotron2.squarelotron[0][0], 25);
		assertEquals(squarelotron2.squarelotron[0][1], 24);
		assertEquals(squarelotron2.squarelotron[0][2], 23);
		assertEquals(squarelotron2.squarelotron[0][3], 22);
		assertEquals(squarelotron2.squarelotron[0][4], 21);
		
		assertEquals(squarelotron2.squarelotron[1][0], 20);
		assertEquals(squarelotron2.squarelotron[1][1], 19);
		assertEquals(squarelotron2.squarelotron[1][2], 18);
		assertEquals(squarelotron2.squarelotron[1][3], 17);
		assertEquals(squarelotron2.squarelotron[1][4], 16);
		
		assertEquals(squarelotron2.squarelotron[2][0], 15);
		assertEquals(squarelotron2.squarelotron[2][1], 14);
		assertEquals(squarelotron2.squarelotron[2][2], 13);
		assertEquals(squarelotron2.squarelotron[2][3], 12);
		assertEquals(squarelotron2.squarelotron[2][4], 11);
		
		assertEquals(squarelotron2.squarelotron[3][0], 10);
		assertEquals(squarelotron2.squarelotron[3][1], 9);
		assertEquals(squarelotron2.squarelotron[3][2], 8);
		assertEquals(squarelotron2.squarelotron[3][3], 7);
		assertEquals(squarelotron2.squarelotron[3][4], 6);
		
		assertEquals(squarelotron2.squarelotron[4][0], 5);
		assertEquals(squarelotron2.squarelotron[4][1], 4);
		assertEquals(squarelotron2.squarelotron[4][2], 3);
		assertEquals(squarelotron2.squarelotron[4][3], 2);
		assertEquals(squarelotron2.squarelotron[4][4], 1);
		
		//Testing for zero
		squarelotron2.rotateRight(0);
		assertEquals(squarelotron2.squarelotron[0][0], 1);
		assertEquals(squarelotron2.squarelotron[0][1], 2);
		assertEquals(squarelotron2.squarelotron[0][2], 3);
		assertEquals(squarelotron2.squarelotron[0][3], 4);
		assertEquals(squarelotron2.squarelotron[0][4], 5);
		
		assertEquals(squarelotron2.squarelotron[1][0], 6);
		assertEquals(squarelotron2.squarelotron[1][1], 7);
		assertEquals(squarelotron2.squarelotron[1][2], 8);
		assertEquals(squarelotron2.squarelotron[1][3], 9);
		assertEquals(squarelotron2.squarelotron[1][4], 10);
		
		assertEquals(squarelotron2.squarelotron[2][0], 11);
		assertEquals(squarelotron2.squarelotron[2][1], 12);
		assertEquals(squarelotron2.squarelotron[2][2], 13);
		assertEquals(squarelotron2.squarelotron[2][3], 14);
		assertEquals(squarelotron2.squarelotron[2][4], 15);
		
		assertEquals(squarelotron2.squarelotron[3][0], 16);
		assertEquals(squarelotron2.squarelotron[3][1], 17);
		assertEquals(squarelotron2.squarelotron[3][2], 18);
		assertEquals(squarelotron2.squarelotron[3][3], 19);
		assertEquals(squarelotron2.squarelotron[3][4], 20);
		
		assertEquals(squarelotron2.squarelotron[4][0], 21);
		assertEquals(squarelotron2.squarelotron[4][1], 22);
		assertEquals(squarelotron2.squarelotron[4][2], 23);
		assertEquals(squarelotron2.squarelotron[4][3], 24);
		assertEquals(squarelotron2.squarelotron[4][4], 25);
		
		//Testing for a negative number
		squarelotron2.rotateRight(-3);
		assertEquals(squarelotron2.squarelotron[0][0], 21);
		assertEquals(squarelotron2.squarelotron[0][1], 16);
		assertEquals(squarelotron2.squarelotron[0][2], 11);
		assertEquals(squarelotron2.squarelotron[0][3], 6);
		assertEquals(squarelotron2.squarelotron[0][4], 1);
		
		assertEquals(squarelotron2.squarelotron[1][0], 22);
		assertEquals(squarelotron2.squarelotron[1][1], 17);
		assertEquals(squarelotron2.squarelotron[1][2], 12);
		assertEquals(squarelotron2.squarelotron[1][3], 7);
		assertEquals(squarelotron2.squarelotron[1][4], 2);
		
		assertEquals(squarelotron2.squarelotron[2][0], 23);
		assertEquals(squarelotron2.squarelotron[2][1], 18);
		assertEquals(squarelotron2.squarelotron[2][2], 13);
		assertEquals(squarelotron2.squarelotron[2][3], 8);
		assertEquals(squarelotron2.squarelotron[2][4], 3);
		
		assertEquals(squarelotron2.squarelotron[3][0], 24);
		assertEquals(squarelotron2.squarelotron[3][1], 19);
		assertEquals(squarelotron2.squarelotron[3][2], 14);
		assertEquals(squarelotron2.squarelotron[3][3], 9);
		assertEquals(squarelotron2.squarelotron[3][4], 4);
		
		assertEquals(squarelotron2.squarelotron[4][0], 25);
		assertEquals(squarelotron2.squarelotron[4][1], 20);
		assertEquals(squarelotron2.squarelotron[4][2], 15);
		assertEquals(squarelotron2.squarelotron[4][3], 10);
		assertEquals(squarelotron2.squarelotron[4][4], 5);
	}
}
