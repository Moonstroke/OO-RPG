package joH1.oo_rpg;


public class Item extends Entity {
	private static final long serialVersionUID = 3L;

	/**
	 * Can the item be dropped by a creature?
	 */
	protected boolean lootable;

	/**
	 * The value of the item (in trade)
	 */
	protected int value;


	protected Item(Item i) {
		super(i);
		lootable = i.lootable;
		value = i.value;
	}

	/**
	 * Public constructor
	 *
	 * @param name              the name of the Item
	 * @param level             its level
	 * @param initialDurability the durability (and maximum durability) it holds to begin with
	 * @param value             its value, set it to -1 and the item can't be dropped upon death
	 */
	public Item(String name, int level, int initialDurability, int value) { // Use this
		super(name, level, initialDurability);
		this.lootable = lootable;
		lootable = (this.value = value) >= 0;
	}


	@Override
	public String toString() {
		return String.format("%s, $%d (%s loot)", super.toString(), value, lootable ? "is" : "not");
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

	public void breakItem() {
	}

	/**
	 * Added for tests.
	 *
	 * @param args CLI arguments
	 */
	public static void main(String[] args) {
		Item s = new Item("Sword", 4, 100, 42);
		System.out.println("s = " + s);

		Item h = new Item("Shield", 5, 120, -1);
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
