package joH1.oo_rpg;

public class Item extends Entity {
	private static final long serialVersionUID = 3L;

	/**
	 * The stat the item affects (force, resistance, health, speed)
	 */
	protected int stat;

	/**
	 * Can the item be dropped by a creature?
	 */
	protected boolean lootable;


	/**
	 * Ctors
	 */
	protected Item() {
		super();
		cat = 0;
		lootable = false;
	}

	public Item(String name, int level, int modifiedStat, boolean isLootable) {
		super(name, level);
		cat = category;
		lootable = isLootable;
	}


	public boolean isLootable() {
		return lootable;
	}

	public int category() {
		return cat;
	}
}

