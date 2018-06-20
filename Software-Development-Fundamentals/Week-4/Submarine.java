
public class Submarine extends Ship {

	public Submarine() {
		super();
		this.setLength(3);
		this.setHit(new boolean[3]);
	}

	@Override
	public String getShipType() {
		return "Submarine";
	}
	
	

}
