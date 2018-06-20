
public abstract class Ship {
	private int bowRow;
	private int bowColumn;
	private int length;
	private boolean horizontal;
	private boolean[] hit;
	
	public Ship() {
		// Constructor
	}

	public abstract String getShipType();
	
	public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		if(row > 19 || row < 0 || column > 19 || column < 0 ) return false;
		
		if(horizontal) {
			for(int i = column; i < this.getLength(); i++) {
				if(ocean.isOccupied(row, i)) return false;
				if(row > 0) {
					if(column > 0 && ocean.isOccupied(row - 1, column - 1)) return false;
					if(ocean.isOccupied(row - 1, i)) return false;
					if(column < 19 && ocean.isOccupied(row - 1, column + this.getLength())) return false;
				}
				if(row < 19) {
					if(column > 0 && ocean.isOccupied(row + 1, column - 1)) return false;
					if(ocean.isOccupied(row + 1, i)) return false;
					if(column < 19 && ocean.isOccupied(row + 1, column + this.getLength())) return false;
				}
				if(column > 0 && ocean.isOccupied(row, column - 1)) return false;
				if(column < 19 && ocean.isOccupied(row, column + this.getLength())) return false;
			}
		} else {
			for(int i = row; i < this.getLength(); i++) {
				if(ocean.isOccupied(i, column)) return false;
				if(column > 0) {
					if(row > 0 && ocean.isOccupied(row - 1, column - 1)) return false;
					if(ocean.isOccupied(i, column - 1)) return false;
					if(row < 19 && ocean.isOccupied(row + this.getLength(), column - 1)) return false;
				}
				if(column < 19) {
					if(row > 0 && ocean.isOccupied(row - 1, column + 1)) return false;
					if(ocean.isOccupied(i, column + 1)) return false;
					if(row < 19 && ocean.isOccupied(row + this.getLength(), column + 1)) return false;
				}
				if(row > 0 && ocean.isOccupied(row + 1, column)) return false;
				if(row < 19 && ocean.isOccupied(row + this.getLength(), column)) return false;
			}
		}
		return true;
	}
	
	public Ship get() {
		return this;
	}
	
	public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		this.setBowRow(row);
		this.setBowColumn(column);
		this.setHorizontal(horizontal);
		
		if(horizontal) {
			for(int i = column; i < this.getLength(); i++) {
				ocean.getShipArray()[row][i] = this.get();
			}
		} else {
			for(int i = column; i < this.getLength(); i++) {
				ocean.getShipArray()[i][column] = this.get();
			}
		}
	}
	
	public boolean shootAt(int row, int column) {
		if(this.isSunk()) {
			return false;
		} else {
			if(this.isHorizontal()) {
				for(int i = this.getBowColumn(); i < this.getLength(); i++) {
					if(column == i && row == this.getBowRow()) {
						this.getHit()[i] = true;
						return true;
					}
				}
			} else {
				for(int i = this.getBowRow(); i < this.getLength(); i++) {
					if(column == this.getBowColumn() && row == i) {
						this.getHit()[i] = true;
						return true;
					}
				}
			}
			return false;
		}
	}
	
	public boolean isSunk() {
		for(boolean hit : this.getHit()) {
			if(!hit) return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		if(this.isSunk())return "X";
		return "S";
	}
	
	public int getBowRow() {
		return bowRow;
	}

	public void setBowRow(int bowRow) {
		this.bowRow = bowRow;
	}

	public int getBowColumn() {
		return bowColumn;
	}

	public void setBowColumn(int bowColumn) {
		this.bowColumn = bowColumn;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public boolean isHorizontal() {
		return horizontal;
	}

	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}

	public boolean[] getHit() {
		return hit;
	}

	public void setHit(boolean[] hit) {
		this.hit = hit;
	}

	
}
