package joH1.oo_rpg;

public class Equipment extends Item {
	private static final serialVersionUID = 5L;

	public Equipment(String name, int level, int category, boolean isLootable) { // Use this
		super(name, level, category, isLootable);
	}

	public int equip(Creature c) throws IllegalArgumentException {
		return c.buffStat(cat, level);
	}
}

