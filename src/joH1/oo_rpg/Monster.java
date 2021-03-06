package joH1.oo_rpg;


public class Monster extends Creature implements Aggressive {
	private static final long serialVersionUID = 115921631885276461L;

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


	protected Monster(Monster m) {
		super(m);
		courage = m.courage;
		aggressivity = m.aggressivity;
	}

	public Monster(String name, int level, int initialHealth, int force, int defence, int speed, int courage, int aggressivity) {
		super(name, level, initialHealth, force, defence, speed);
		this.courage = courage;
		this.aggressivity = aggressivity;
	}


	@Override
	public String toString() {
		return String.format("%s | %d%%", super.toString(), courage);
	}

	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Monster && super.equals(o)))
			return false;
		Monster m = (Monster)o;
		return courage == m.courage && aggressivity == m.aggressivity;
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
		if(Die.roll() < courage)
			strike(c);
		else
			runFrom(c);
	}

	@Override
	public void attackSpontaneously(Creature c) {
		if(Die.roll() < aggressivity)
			strike(c);
	}
}

