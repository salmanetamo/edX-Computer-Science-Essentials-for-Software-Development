
class Squarelotron {
	int[][] squarelotron;
	int size;
	
	Squarelotron(int n) {
		this.size = n;
		int counter = 1;
		this.squarelotron = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				this.squarelotron[i][j] = counter;
				counter++;
			}
		}
	}
	
	Squarelotron upsideDownFlip(int ring) {
		Squarelotron newSquarelotron = new Squarelotron(this.size);
		int correspondingIndex = this.size - 2*(ring - 1) -1;
		for(int i = 0; i < (this.size - 2*(ring - 1))/2; i++) {						
			if(i == 0) {
				for(int j = 0; j < this.size - 2*(ring - 1); j++) {
					newSquarelotron.squarelotron[i + (ring - 1)][j + (ring - 1)] = this.squarelotron[correspondingIndex][j + (ring - 1)];
					newSquarelotron.squarelotron[correspondingIndex][j + (ring - 1)] = this.squarelotron[i + (ring - 1)][j + (ring - 1)];
				}
				correspondingIndex--;
			} else {
				for(int k = 0; k < this.size - 2*(ring - 1); k += this.size - 2*(ring - 1) -1) {
					newSquarelotron.squarelotron[i + (ring - 1)][k + (ring - 1)] = this.squarelotron[correspondingIndex][k + (ring - 1)];
					newSquarelotron.squarelotron[correspondingIndex][k + (ring - 1)] = this.squarelotron[i + (ring - 1)][k + (ring - 1)];
				}
				correspondingIndex--;
			}
		
		}
		return newSquarelotron;
	}

	Squarelotron mainDiagonalFlip(int ring) {
		Squarelotron newSquarelotron = new Squarelotron(this.size);
		for(int i = 0; i < (this.size - 2*(ring - 1)) - 1; i++) {
			if( i ==  0) {
				for(int j = 1; j < this.size - 2*(ring - 1); j++) {
					newSquarelotron.squarelotron[i + (ring - 1)][j + (ring - 1)] = this.squarelotron[j + (ring - 1)][i + (ring - 1)];
					newSquarelotron.squarelotron[j + (ring - 1)][i + (ring - 1)] = this.squarelotron[i + (ring - 1)][j + (ring - 1)];
				}
			} else {
				newSquarelotron.squarelotron[i + (ring - 1)][this.size -2*(ring - 1) - 1] = this.squarelotron[this.size -2*(ring - 1) - 1][i + (ring - 1)];
				newSquarelotron.squarelotron[this.size -2*(ring - 1) - 1][i + (ring - 1)] = this.squarelotron[i + (ring - 1)][this.size -2*(ring - 1) - 1];
			}
		}
		return newSquarelotron;
	}
	
	void rotateRight(int numberOfTurns) {		
		int[][] copy = this.squarelotron;
		if(numberOfTurns%this.size == 1 || numberOfTurns%this.size == -3) {
			int rowIndex = 0;
			int index = this.size - 1;
			for(int j = 0; j < this.size; j++) {
				rowIndex++;
				for(int k = 0; k < this.size; k++) {
					this.squarelotron[j][k] = copy[rowIndex][index];
					rowIndex++;
				}
				index--;
			}
		} else if(numberOfTurns%this.size == 2 || numberOfTurns%this.size == -2) {
			int rowIndex = this.size - 1;
			int index = this.size - 1;
			for(int j = 0; j < this.size; j++) {
				index = this.size - 1;
				for(int k = 0; k < this.size; k++) {
					this.squarelotron[j][k] = copy[rowIndex][index];
					index--;
				}
				rowIndex--;
			}
		} else if (numberOfTurns%this.size == 3 || numberOfTurns%this.size == -1) {
			int rowIndex = this.size - 1;
			int index = 0;
			for(int j = 0; j < this.size; j++) {
				rowIndex = this.size - 1;
				for(int k = 0; k < this.size; k++) {
					this.squarelotron[j][k] = copy[rowIndex][index];
					rowIndex--;
				}
				index++;
			}
		}		
	}
}