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


	protected Item() { // Default ctor
		super();
		cat = 0;
		lootable = false;
	}

	protected Item(Item i) {
		super(i);
		cat = i.cat;
		lootable = i.lootable;
	}

	public Item(String name, int level, int modifiedStat, boolean isLootable) { // Use this
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

