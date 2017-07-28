package joH1.oo_rpg;

import java.util.Random;

public class Monster extends Creature implements Aggressive {
	private static final long serialVersionUID = 3L;

	/**
	 * The courage of the creature (ie. its ability, in combat, to not be frightened during battle)
	 * {@code 0 < courage <= 100}
	 * A courage of 100 means the creature will never flee a battle -- used with bosses
	 */
	protected int courage;

	/**
	 * The probability that the creature will attack another, in percent
	 * {@code 0 < aggressivity <= 100}
	 */
	protected int aggressivity;

	public Monster(String name, int level, int initialHealth, int force, int defence, int speed, int courage, int aggressivity) {
		super(name, level, initialHealth, initialHealth, true, force, defence, speed);
		this.courage = courage;
		this.aggressivity = aggressivity;
	}

	protected Monster(String name, int level, int health, int maxHealth, boolean alive, int force, int defence, int speed, int courage, int aggressivity) {
		super(name, level, health, maxHealth, alive, force, defence, speed);
		this.courage = courage;
		this.aggressivity = aggressivity;
	}

	@Override
	public String toString() {
		return String.format("%s | %d%%", super.toString(), courage);
	}

	@Override
	public Monster clone() {
		return new Monster(new String(name), level, health, maxHealth, alive, force, defence, speed, courage, aggressivity);
	}

	@Override
	public int buffStat(Stat stat, int amount) {
		int res = super.buffStat(stat, amount);
		if(res != 0)
			return res;
		switch(stat) {
			case COURAGE:
				return courage = (courage + amount) > 100 ? 100 : courage + amount;
			case AGGRESSIVITY:
				return aggressivity = (aggressivity + amount) > 100 ? 100 : aggressivity + amount;
			default:
				return 0;
		}
	}

	@Override
	public void runFrom(Creature c) {
		// TODO
	}


	@Override
	public void strike(Creature c) {
		// TODO
	}

	@Override
	public void retaliate(Creature c) {
		if(new Random().nextInt(100) < courage) // roll the dice
			strike(c);
		else
			runFrom(c);
	}

	@Override
	public void attackSpontaneously(Creature c) {
		if(new Random().nextInt(100) < aggressivity) // roll the dice
			strike(c);
	}
}

