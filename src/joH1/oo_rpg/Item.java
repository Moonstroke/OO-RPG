package joH1.oo_rpg;


public class Item extends Entity {
	private static final long serialVersionUID = 3L;

	/**
	 * The stat the item affects (force, resistance, health, speed)
	 */
	protected Stat stat;

	/**
	 * Can the item be dropped by a creature?
	 */
	protected boolean lootable;


	public Item(String name, int level, Stat modifiedStat, boolean isLootable) {
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
		if(!(super.equals(o) && o instanceof Item))
			return false;
		Item i = (Item)o;
		return stat == i.stat && lootable == i.lootable;
	}

	@Override
	public Item clone() {
		return new Item(new String(name), level, stat, lootable);
	}

	public boolean isLootable() {
		return lootable;
	}

	public Stat modifiedStat() {
		return stat;
	}


	/**
	 * Added for tests.
	 *
	 * @param args CLI arguments
	 */
	public static void main(String[] args) {
		Item s = new Item("Sword", 4, Stat.FORCE, true);
		System.out.println("s = " + s);

		Item h = new Item("Shield", 5, Stat.DEFENCE, true);
		System.out.println("h = " + h);

		System.out.println("\n----------------\n");

		Item s2 = s.clone();
		System.out.println("s2 = " + s2);
		boolean equals = s2.equals(s);
		System.out.println("s2 == s ? " + equals);
		if(! equals) {
			System.out.println("Odd: s and s2 should compare equals");
		}
		else {
			System.out.println("OK");
		}
	}

}
