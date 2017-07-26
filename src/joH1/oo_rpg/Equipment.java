package joH1.oo_rpg;


public class Equipment extends Item {
	private static final long serialVersionUID = 5L;

	public Equipment(String name, int level, Stat modifiedStat, boolean isLootable) {
		super(name, level, modifiedStat, isLootable);
	}

	public int equip(Creature c) throws IllegalArgumentException {
		return c.buffStat(stat, level);
	}
}

