package joH1.oo_rpg;


public class Item extends Entity {
	private static final long serialVersionUID = 3L;

	/**
	 * Can the item be dropped by a creature?
	 */
	protected boolean lootable;

	/**
	 * The integrity of the item (amount of mechanical wear of the item).
	 * When the durability reaches 0, the item breaks (disappears)
	 */
	protected int durability;

	/**
	 * The max value of the item's {@linkplain #durability}
	 *
	 * If this value is -1, the item is unbreakable
	 */
	protected final int maxDurability;


	protected Item(Item i) {
		super(i);
		durability = i.durability;
		maxDurability = i.maxDurability;
		lootable = i.lootable;
	}

	public Item(String name, int level, int initialDurability, boolean lootable) { // Use this
		super(name, level);
		this.durability = this.maxDurability = durability;
		this.lootable = lootable;
	}


	@Override
	public String toString() {
		return String.format("%s [%d/%d], loot? %b", super.toString(), durability, maxDurability, lootable);
	}

	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Item && super.equals(o)))
			return false;
		Item i = (Item)o;
		return durability == i.durability && lootable == i.lootable;
	}

	public boolean isLootable() {
		return lootable;
	}

	public int durability() {
		return durability;
	}

	public int repair(int amount) {
		int sum = durability + amount;
		return sum > maxDurability ? (durability = maxDurability) : (durability = sum);
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
