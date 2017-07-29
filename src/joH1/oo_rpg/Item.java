package joH1.oo_rpg;


public class Item extends Entity {
	private static final long serialVersionUID = 3L;

	/**
	 * Can the item be dropped by a creature?
	 */
	protected boolean lootable;


	public Item(String name, int level, boolean isLootable) {
		super(name, level);
		lootable = isLootable;
	}

	@Override
	public String toString() {
		return String.format("Item \"%s\", loot? %b", name, stat, lootable);
	}

	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Item && super.equals(o)))
			return false;
		Item i = (Item)o;
		return lootable == i.lootable;
	}

	@Override
	public Item clone() {
		return new Item(new String(name), level, lootable);
	}

	public boolean isLootable() {
		return lootable;
	}


	/**
	 * Added for tests.
	 *
	 * @param args CLI arguments
	 */
	public static void main(String[] args) {
		Item s = new Item("Sword", 4, true);
		System.out.println("s = " + s);

		Item h = new Item("Shield", 5, true);
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
