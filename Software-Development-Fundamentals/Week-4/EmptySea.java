
public class EmptySea extends Ship {

	public EmptySea() {
		super();
		this.setLength(1);
	}
	
	@Override
	public boolean shootAt(int row, int column) {
		return false;
	}
	
	@Override
	public boolean isSunk() {
		return false;
	}
	
	@Override
	public String toString() {
		return "0";
	}
	
	@Override
	public String getShipType() {
		return "empty";
	}

}
