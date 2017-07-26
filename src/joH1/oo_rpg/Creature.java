package joH1.oo_rpg;


public abstract class Creature extends Entity {
	private static final long serialVersionUID = 2L;

	protected int health;

	protected final int maxHealth;

	protected boolean alive;

	protected int force;

	protected int defence;

	protected int speed;


	protected Creature(String name, int level, int health, int maxHealth, boolean alive, int force, int defence, int speed) { // Use this
		super(name, level);
		this.health = health;
		this.maxHealth = maxHealth;
		this.alive = alive;
		this.force = force;
		this.defence = defence;
		this.speed = speed;
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
		return String.format("%s [%d/%d], %d / %d -- %d", super.toString(), health, maxHealth, force, defence, speed);
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
	 * @return The new value of the statistic or {@code 0} if the stat could not be found
	 */
	public int buffStat(Stat stat, int amount) {
		switch(stat) {
			case HEALTH:
				return health += amount;
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
	public abstract void strike(Creature c);

	/**
	 * Run in fear from another creature
	 *
	 * @param c The creature to run from
	 */
	public abstract void runFrom(Creature c);

	/**
	 * Can the creature be challenged in duel?
	 *
	 * @return {@code true} iff the {@code Challengeable} annotation is present
	 *         on the creature's end class
	 */
	public boolean isChallengeable() {
		for(Class<?> i : this.getClass().getInterfaces())
			if(i.equals(Duellist.class))
				return true;
		return false;
	}

}

