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


	/**
	 * The total amount of health points the creature can lose
	 * before dying
	 */
	protected int health;

	/**
	 * The maximum (and initial) number of life points it owns
	 */
	protected final int maxHealth;

	/**
	 * Is the creature alive or dead?
	 */

	protected boolean alive;
	/**
	 * Its force (in combat)
	 * The amount of damages dealt when strikes
	 * might be 0 for peaceful creatures
	 */
	protected int force;

	/**
	 * Its defence (in combat)
	 * The amount of damage it can undergo in combat
	 */
	protected int defence;

	/**
	 * Its speed (in combat / flight)
	 */
	protected int speed;

	/**
	 * Its courage (ie. its ability, in combat, to not run flee from the battle)
	 * 0 <= courage <= 100
	 * A courage of 0 means the creature will always try to flee and never attacks
	 * (like peaceful creatures)
	 * A courage of 100 means the creature will never flee a battle -- used with players,
	 * who will decide by themselves to fight or flee
	 */
	protected int courage;


	/**
	 * Default ctor
	 */
	protected Creature() {
		super();
		health = maxHealth = 0;
		alive = false;
		force = 0;
		defence = 0;
		speed = 0;
	}

	/**
	 * Copy ctor
	 */
	protected Creature(Creature c) {
		super(c);
		health = c.health;
		maxHealth = c.maxHealth;
		alive = c.alive;
		force = c.force;
		defence = c.defence;
		speed = c.speed;
	}

	/**
	 * Ctor to be used
	 */
	public Creature(String name, int level, int initialHealth, int force, int defence, int speed) {
		super(name, level);
		health = maxHealth = initialHealth;
		alive = true;
		this.force = force;
		this.defence = defence;
		this.speed = speed;
	}


	@Override
	public boolean equals(Object o) {
		if(!(super.equals(o) && o instanceof Creature))
			return false;
		Creature c = (Creature)o;
		return health == e.health && maxHealth == e.maxHealth && c.force == force && c.defence == defence && c.speed == speed;
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

	/**
	 * The method to call when the creature's health reaches 0.
	 */
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
	public boolean takeHit(int amount) {
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

