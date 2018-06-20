
public class Destroyer extends Ship {

	public Destroyer() {
		super();
		this.setLength(4);
		this.setHit(new boolean[4]);
	}

	@Override
	public String getShipType() {
		return "Destroyer";
	}

}
