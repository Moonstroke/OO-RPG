package joH1.oo_rpg;

public class Spell extends Item implements Consumable, Applicable {

	/**
	 * The stat modified by this object
	 */
	private Stat stat;


	/**
	 * Copy ctor
	 */
	protected Spell(Spell s) {
		super(s);
		stat = s.stat;
	}
	public Spell(String name, int level, int value, Stat stat) {
		super(name, level, 1, value);
		this.stat = stat;
	}


	@Override
	public int apply(Creature c) {
		int newValue = c.buffStat(stat, level);
		consume();
		return newValue;
	}

	@Override
	public boolean consume() {
		end();
	}
}

