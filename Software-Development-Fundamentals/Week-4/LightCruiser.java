
public class LightCruiser extends Ship {

	public LightCruiser() {
		super();
		this.setLength(5);
		this.setHit(new boolean[5]);
	}

	@Override
	public String getShipType() {
		return "LightCruiser";
	}

}
