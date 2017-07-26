package joH1.oo_rpg;


public class Creature extends Entity {
	private static final long serialVersionUID = 2L;


	/**
	 * Every stat.
	 * Categories can be {@code OR}ed together (but this has no use yet)
	 */
	public static final int STAT_HEALTH = 1;
	
	public static final int STAT_FORCE = 2;

	public static final int STAT_DEFENCE = 4;

	public static final int STAT_SPEED = 8;


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


	public Creature(String name, int level, int initialHealth, int force, int defence, int speed) {
		health = maxHealth = initialHealth;
		alive = true;
		this.force = force;
		this.defence = defence;
		this.speed = speed;
	}


	@Override
	public boolean equals(Object o) {
		if(!(super.equals(o) && o instanceof Creature.class))
			return false;
		Creature c = (Creature)o;
		return health == c.health && maxHealth == c.maxHealth && c.force == force && c.defence == defence && c.speed == speed;
	}

	@Override
	public String toString() {
		return String.format(java.util.Locale.US, "Creature \"%s\" level %d, %d / %d - %d", name, level, force, defence, speed);
	}

	@Override
	public Creature clone() {
		return new Creature(new String(name), level, health, maxHealth, force, defence, speed);
	}


	public boolean isAlive() {
		return alive;
	}

	/**
	 * Increases the level of the creature.
	 * Should be overriden to increase others stats
	 *
	 * @return the new level of the creature
	 */
	public int levelUp() {
		return ++level;
	}

	public void die() {
		alive = false;
	}

	/**
	 * Decreases health of {@code amount} life points.
	 *
	 * @param amount The amount of life points to remove to it
	 *
	 * @return {@code alive}
	 */
	public boolean hurt(int amount) {
		if((health -= amount) == 0) {
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
	 * Start a combat with another creature.
	 * Should be overriden for aggressive creatures
	 *
	 * @param c The attacked creature
	 */
	public void fight(Creature c) {}

	/**
	 * Run in fear from a creature
	 * If courage is 0, will always run away, even outside of battle
	 *
	 * @param c The creature it runs from
	 */
	public void flee(Creature c) {}
	
}

