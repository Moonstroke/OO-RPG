package joH1.oo_rpg;


public class Creature extends Entity {
	private static final long serialVersionUID = -3646561874867278364L;

	protected boolean alive;

	protected int force;

	protected int defence;

	protected int speed;


	/**
	 * Copy ctor
	 */
	protected Creature(Creature c) {
		super(c);
		alive = c.alive;
		force = c.force;
		defence = c.defence;
		speed = c.speed;
	}

	/**
	 * Public constructor: use this
	 */
	public Creature(String name, int level, int initialHealth, int force, int defence, int speed) {
		super(name, level, initialHealth);
		alive = true;
		this.force = force;
		this.defence = defence;
		this.speed = speed;
	}


	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Creature && super.equals(o)))
			return false;
		Creature c = (Creature)o;
		return c.force == force && c.defence == defence && c.speed == speed;
	}

	@Override
	public String toString() {
		return String.format("%s, %d / %d -- %d", super.toString(), force, defence, speed);
	}

	public int health() {
		return integrity;
	}

	public boolean isAlive() {
		return alive;
	}

	@Override
	public void end() {
		alive = false;
	}

	/**
	 * Decreases health of {@code amount} life points.
	 * Health can drop below 0, but it's actually no big deal
	 *
	 * @param amount The amount of life points to remove to it
	 *
	 * @return {@code alive}
	 */
	public boolean hurt(int amount) {
		return alive = damage(amount);
	}

	/**
	 * Restores {@code amount} life points to the creature
	 *
	 * @param amount The maximum amount of life points to add to its health
	 *
	 * @return The new health of the creature
	 */
	public int heal(int amount) {
		return restore(amount);
	}

	/**
	 * Increases the value of one of the creature's statistics
	 *
	 * @param stat   The statistic to increase
	 * @param amount The value by which to increase the stat
	 *
	 * @return The new value of the {@code Stat statistic} or {@code 0} if the stat could not be
	 *         found
	 */
	public int buffStat(Stat stat, int amount) {
		switch(stat) {
			case HEALTH:
				if(maxIntegrity >= 0) maxIntegrity += amount;
				return maxIntegrity;
			case FORCE:
				return force += amount;
			case DEFENCE:
				return defence += amount;
			case SPEED:
				return speed += amount;
			default:
				return 0;
		}
	}

	/**
	 * Draw a single hit on a creature.
	 *
	 * @param c the striked creature
	 */
	public void strike(Creature c) {}

	/**
	 * Run in fear from another creature
	 *
	 * @param c The creature to run from
	 */
	public void runFrom(Creature c) {}
	
	public static void main(String[] args) {
		Creature randomMob = new Creature("Random mob", 1, 10, 5, 5, 5);
		System.out.println("randomMob = " + randomMob);

		System.out.println("\n----------\n");

		Creature c1 = new Creature("Big monster", 15, 450, 60, 80, 50);
		Creature c2 = new Creature(c1);
		System.out.println("c1 = " + c1 + "\nc2 = " + c2);
		System.out.print("\nc1.equals(c2) ? ");
		if(c1.equals(c2)) {
			System.out.println("OK");
		} else {
			System.out.println("Odd, not equals...");
		}
	}
}

