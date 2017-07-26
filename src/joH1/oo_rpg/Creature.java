package joH1.oo_rpg;


public class Creature extends Entity {
	private static final long serialVersionUID = 2L;


	/**
	 * Every stat.
	 * Stats can be {@code OR}ed together (but this has no use yet)
	 */
	public static final int STAT_HEALTH = 0x1;
	
	public static final int STAT_FORCE = 0x2;

	public static final int STAT_DEFENCE = 0x4;

	public static final int STAT_SPEED = 0x8;

	public static final int STAT_COURAGE = 0x10;


	protected int health;

	protected final int maxHealth;

	protected boolean alive;

	protected int force;

	protected int defence;

	protected int speed;

	/**
	 * The courage of the creature (ie. its ability, in combat, to not be frightened during battle)
	 * 0 <= courage <= 100
	 * A courage of 0 means the creature will always try to flee and never attacks
	 * (like peaceful creatures)
	 * A courage of 100 means the creature will never flee a battle -- used with players
	 * (who will decide by themselves to fight or flee) or bosses
	 */
	protected int courage;


	public Creature(String name, int level, int initialHealth, int force, int defence, int speed, int courage) { // Use this
		super(name, level);
		health = maxHealth = initialHealth;
		alive = true;
		this.force = force;
		this.defence = defence;
		this.speed = speed;
		this.courage = courage;
	}

	protected Creature(String name, int level, int health, int maxHealth, boolean alive, int force, int defence, int speed, int courage) {
		super(name, level);
		this.health = health;
		this.maxHealth = maxHealth;
		this.alive = alive;
		this.alive = alive;
		this.force = force;
		this.defence = defence;
		this.speed = speed;
		this.courage = courage;
	}

	@Override
	public boolean equals(Object o) {
		if(!(super.equals(o) && o instanceof Creature))
			return false;
		Creature c = (Creature)o;
		return health == c.health && maxHealth == c.maxHealth && c.force == force && c.defence == defence && c.speed == speed;
	}

	@Override
	public String toString() {
		return String.format("%s [%d/%d], %d / %d -- %d | %d%%", super.toString(), health, maxHealth, force, defence, speed, courage);
	}

	@Override
	public Creature clone() {
		return new Creature(new String(name), level, health, maxHealth, alive, force, defence, speed, courage);
	}


	public boolean isAlive() {
		return alive;
	}

	public void die() {
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
		if((health -= amount) <= 0) {
			die();
			return false;
		}
		return true;
	}

	/**
	 * Restores {@code amount} life points to the creature
	 *
	 * @param amount The maximum amount of life points to add to its health
	 *
	 * @return The new health of the creature
	 */
	public int restore(int amount) {
		return health + amount > maxHealth ? (health = maxHealth) : (health += amount);
	}

	/**
	 * Increases the value of one of the creature's statistics
	 *
	 * @param stat   The statistic to increase
	 * @param amount The value by which to increqse the stat
	 *
	 * @return The new value of the statistic
	 */
	public int buffStat(int stat, int amount) throws IllegalArgumentException {
		switch(stat) {
			case STAT_HEALTH:
				return health += amount;
			case STAT_FORCE:
				return force += amount;
			case STAT_DEFENCE:
				return defence += amount;
			case STAT_SPEED:
				return speed += amount;
			case STAT_COURAGE:
				return courage = (courage + amount) > 100 ? 100 : courage + amount;
			default:
				throw new IllegalArgumentException(stat + " is not a valid stat value");
		}
	}

	/**
	 * Draw a single hit on a creature.
	 *
	 * @param c the striked creature
	 */
	public void strike(Creature c) {
		// TODO
	}

	/**
	 * Can the creature be challenged in duel?
	 *
	 * @return {@code true} iff the {@code Challengeable} annotation is present
	 *         on the creature's end class
	 */
	public boolean isChallengeable() {
		return this.getClass().isAnnotationPresent(Challengeable.class);
	}

	/**
	 * Start a combat with another creature.
	 * Should be overriden for aggressive creatures
	 *
	 * @param c The attacked creature
	 *
	 * @return a {@link Duel} between the creature and the attacked creature
	 *         if the latter {@link Challengeable can be challenged},
	 *         {@code null} otherwise
 	 */
	public Duel fight(Creature c) {
		if(c.isChallengeable())
			return new Duel(this, c);
		strike(c);
		return null;
	}

	/**
	 * Run in fear from a creature
	 * If courage is 0, will always run away, even outside of battle
	 *
	 * @param c The creature it runs from
	 */
	public void flee(Creature c) {
		// TODO
	}


	/**
	 * Added for tests.
	 *
	 * @param args CLI arguments
	 */
	public static void main(String[] args) {
		Creature z = new Creature("Zombie", 5, 25, 10, 8, 5, 80);
		System.out.println("z = " + z);

		Creature k = new Creature("Knight", 5, 25, 12, 10, 4, 100);
		System.out.println("k = " + k);

		System.out.println("\n----------------\n");

		Creature z2 = z.clone();
		System.out.println("z2 = " + z2);
		boolean equals = z2.equals(z);
		System.out.println("z2 == z ? " + equals);
		if(!equals) {
			System.out.println("Odd: z and z2 should compare equals");
			return;
		}
		else {
			System.out.println("OK");
		}
		System.out.println("\n----------------\n");
		k.hurt(5);
		System.out.println("k hurt by 5 = " + k);

		System.out.println("\n----------------\n");
		z.hurt(30);
		System.out.println("z - 30 HP = " + z);
		if(z.isAlive()) {
			System.out.println("Odd: z should be dead now");
		}
		else {
			System.out.println("OK");
		}

	}

}

