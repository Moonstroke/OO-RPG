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


	public Item(String name, int level, int modifiedStat, boolean isLootable) {
		super(name, level);
		stat = modifiedStat;
		lootable = isLootable;
	}

	@Override
	public String toString() {
		return String.format("Item \"%s\" : %d, loot? %b", name, stat, lootable);
	}

	@Override
	public boolean equals(Object o) {
		if(!(super.equals(o) && o instanceof Item.class))
			return false;
		Item i = (Item)o;
		return stat == i.stat && lootable == i.lootable;
	}

	public boolean isLootable() {
		return lootable;
	}

	public int category() {
		return cat;
	}

}

