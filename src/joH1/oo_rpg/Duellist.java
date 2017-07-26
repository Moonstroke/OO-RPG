package joH1.oo_rpg;

public interface Duellist {

	public void duelTurn(Duel d);

	public boolean hasDied();

	/**
	 * Start a combat with another creature.
	 * Should be overriden for aggressive creatures
	 *
	 * @param c The attacked creature
	 *
	 * @return a {@link Duel} between the creature and the attacked creature
	 *         if the latter {@link Challengeable can be challenged},
	 *         {@code null} otherwise
 	 */
	public default Duel challenge(Duellist d) {
		return new Duel(this, d);
	}

	/**
	 * Run in fear from a duel with another creature
	 * If courage is 0, will always run away (TODO even outside of battle)
	 *
	 * @param d The duel it runs from
	 */
	public abstract void flee(Duel d);

}
