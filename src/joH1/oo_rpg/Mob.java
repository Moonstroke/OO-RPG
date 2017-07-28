package joH1.oo_rpg;

import java.util.Random;

public class Mob extends Creature implements Duellist {
	private static final long serialVersionUID = 3L;

	/**
	 * The courage of the creature (ie. its ability, in combat, to not be frightened during battle)
	 * 0 <= courage <= 100
	 * A courage of 0 means the creature will always try to flee and never attacks
	 * (like peaceful creatures)
	 * A courage of 100 means the creature will never flee a battle -- used with players
	 * (who will decide by themselves to fight or flee) or bosses
	 */
	protected int courage;


	public Mob(String name, int level, int initialHealth, int force, int defence, int speed, int courage) {
		super(name, level, initialHealth, initialHealth, true, force, defence, speed);
		this.courage = courage;
	}

	protected Mob(String name, int level, int health, int maxHealth, boolean alive, int force, int defence, int speed, int courage) {
		super(name, level, health, maxHealth, alive, force, defence, speed);
		this.courage = courage;
	}

	@Override
	public String toString() {
		return String.format("%s | %d%%", super.toString(), courage);
	}

	@Override
	public Mob clone() {
		return new Mob(new String(name), level, health, maxHealth, alive, force, defence, speed, courage);
	}

	@Override
	public int buffStat(Stat stat, int amount) {
		int res = super.buffStat(stat, amount);
		if(res != 0)
			return res;
		switch(stat) {
			case COURAGE:
				return courage = (courage + amount) > 100 ? 100 : courage + amount;
			default:
				return 0;
		}
	}

	/**
	 * Start a combat with another creature.
	 * Should be overriden for aggressive creatures
	 *
	 * @param c The attacked creature
	 *
	 * @return a {@link Duel} between the creature and the attacked creature
	 *         if the latter {@link Creature#isChalleangeable() can be challenged to duel},
	 *         {@code null} otherwise
	 */
	public Duel fight(Creature c) {
		if(c.isChallengeable())
			return challenge((Duellist)c);
		strike(c);
		return null;
	}

	@Override
	public void runFrom(Creature d) {
		// TODO
	}


	@Override
	public void strike(Creature c) {
		// TODO
	}
	
	/**
	 * Run in fear from a duel with another creature
	 *
	 * @param d The duel it runs from
	 */
	@Override
	public void flee(Duel d) {
		runFrom(d.getOpponent(this));
	}

	@Override
	public void duelTurn(Duel d) {
		Creature opponent = d.getOpponent(this);
		if(new Random().nextInt(100) >= courage) // roll the dice
			flee(d);
		else
			strike(opponent);
	}

	@Override
	public boolean hasDied() {
		return !alive;
	}
}

