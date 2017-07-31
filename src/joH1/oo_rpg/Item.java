package joH1.oo_rpg;


public class Item extends Entity {
	private static final long serialVersionUID = 3L;

	/**
	 * Can the item be dropped by a creature?
	 */
	protected boolean lootable;

	protected Item(Item i) {
		super(i);
		lootable = i.lootable;
	}

	public Item(String name, int level, int initialDurability, boolean lootable) { // Use this
		super(name, level, initialDurability);
		this.lootable = lootable;
	}


	@Override
	public String toString() {
		return String.format("%s, loot? %b", super.toString(), lootable);
	}

	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Item && super.equals(o)))
			return false;
		Item i = (Item)o;
		return lootable == i.lootable;
	}

	public boolean isLootable() {
		return lootable;
	}

	public int durability() {
		return integrity;
	}

	public int mend(int amount) {
		return restore(amount);
	}

	public void break_() {
	}

	/**
	 * Added for tests.
	 *
	 * @param args CLI arguments
	 */
	public static void main(String[] args) {
		Item s = new Item("Sword", 4, 100, true);
		System.out.println("s = " + s);

		Item h = new Item("Shield", 5, 120, true);
		System.out.println("h = " + h);

		System.out.println("\n----------------\n");

		Item s2 = new Item(s);
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
