package joH1.oo_rpg;


public abstract class Creature extends Entity {
	private static final long serialVersionUID = 2L;

	/**
	 * Its level
	 * Determines the global ranking of the creature among its type
	 */
	private int level;

	/**
	 * Its force (in combat)
	 * The amount of damages dealt when strikes
	 * might be 0 for peaceful creatures
	 */
	private int force;

	/**
	 * Its defence (in combat)
	 * The amount of damage it can undergo in combat
	 */
	private int defence;

	/**
	 * Its speed (in combat / flight)
	 */
	private int speed;

	/**
	 * Its courage (ie. its ability, in combat, to not run flee from the battle)
	 * 0 <= courage <= 100
	 * A courage of 0 means the creature will always try to flee and never attacks
	 * (like peaceful creatures)
	 * A courage of 100 means the creature will never flee a battle -- used with players,
	 * who will decide by themselves to fight or flee
	 */
	private int courage;


	@Override
	public boolean equals(Object o) {
		if(o instanceof Creature) {
			Creature c = (Creature)o;
			return c.name.equals(name) && c.level == level && c.force == force && c.defence == defence && c.speed == speed;
		}
		return false;
	}

	@Override
	public String toString() {
		return String.format(java.util.Locale.US, "Creature \"%s\" level %d, %d / %d - %d", name, level, force, defence, speed);
	}


	/**
	 * Increases the level of the creature.
	 * Should be overriden to increase others stats
	 */
	public int levelUp() {
		return ++level;
	}


	/**
	 * Start a combat with another creature
	 * Should be overriden for aggressive creatures
	 * @param c The attacked creature
	 */
	public void fight(Creature c) {}

	/**
	 * Run in fear from a creature
	 * If courage is 0, will always run away, even outside of battle
	 *
	 * @param c The creature it runs from
	 */
	public abstract void flee(Creature c);

	
}

