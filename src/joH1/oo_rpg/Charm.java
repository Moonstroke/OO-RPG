package joH1.oo_rpg;

public class Charm extends Item implements Consumable, Applicable {
	private static final long serialVersionUID = -426939949763150537L;

	/**
	 * The stat modified by this object
	 */
	private Stat stat;


	/**
	 * Copy ctor
	 */
	protected Charm(Charm s) {
		super(s);
		stat = s.stat;
	}
	public Charm(String name, int level, int value, Stat stat) {
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
		return false;
	}
}

