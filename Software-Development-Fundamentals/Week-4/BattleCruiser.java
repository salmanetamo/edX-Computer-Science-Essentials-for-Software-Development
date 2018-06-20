
public class BattleCruiser extends Ship {

	public BattleCruiser() {
		super();
		this.setLength(7);
		this.setHit(new boolean[7]);
	}

	@Override
	public String getShipType() {
		return "BattleCruiser";
	}

}
