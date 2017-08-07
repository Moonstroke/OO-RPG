package joH1.oo_rpg;

public class Artifact extends Item implements Consumable, Applicable {
	private static final long serialVersionUID = 9159061021810651583L;

	/**
	 * The {@linkplain Stat statistic} the artifact affects
	 */
	protected Stat stat;


	/**
	 * Copy ctor
	 */
	protected Artifact(Artifact a) {
		super(a);
		stat = a.stat;
	}

	/**
	 * Public constructor: use this
	 */
	public Artifact(String name, int level, int uses, int value, Stat stat) {
		super(name, level, uses, value);
		this.stat = stat;
	}


	@Override
	public int apply(Creature c) {
		consume();
		return c.buffStat(stat, level);
	}

	@Override
	public boolean consume() {
		return damage(1);
	}

}

