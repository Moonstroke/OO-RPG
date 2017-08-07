package joH1.oo_rpg;


public class Equipment extends Item {
	private static final long serialVersionUID = 7886225280296061276L;

	/**
	 * The stat the item affects (force, resistance, health, speed)
	 */
	protected Stat stat;


	/**
	 * Copy ctor
	 */
	protected Equipment(Equipment e) {
		super(e);
		stat = e.stat;
	}

	/**
	 * Public constructor: use this
	 */
	public Equipment(String name, int level, int durability, int value, Stat stat) {
		super(name, level, durability, value);
		this.stat = stat;
	}


	@Override
	public String toString() {
		return String.format("%s, affects: %s", super.toString(), stat);
	}

	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Equipment && super.equals(o)))
			return false;
		Equipment e = (Equipment)o;
		return stat == e.stat;
	}

	public int equip(Creature c) throws IllegalArgumentException {
		return c.buffStat(stat, level);
	}

	public Stat modifiedStat() {
		return stat;
	}

}

