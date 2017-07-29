package joH1.oo_rpg;


public class Equipment extends Item {
	private static final long serialVersionUID = 5L;

	/**
	 * The stat the item affects (force, resistance, health, speed)
	 */
	protected Stat stat;


	public Equipment(String name, int level, boolean isLootable, Stat modifiedStat) {
		super(name, level, isLootable);
		stat = modifiedStat;
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

	@Override
	public Equipment clone() {
		return new Equipment(new String(name), level, lootable, stat);
	}

	public int equip(Creature c) throws IllegalArgumentException {
		return c.buffStat(stat, level);
	}

	public Stat modifiedStat() {
		return stat;
	}

}
