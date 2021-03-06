package joH1.oo_rpg;


@Deprecated
public interface Duellist {

	/**
	 * Is the duellist currently involved in a duel?
	 *
	 * @return {@code true} if the duellisty is in duel
	 */
	public boolean inDuel();

	/**
	 * Plays its turn in the duel
	 */
	public void duelTurn(Duel d);

	/*
	 * Has the duellist died during the last turn?
	 * @return {@code true} if the creature is dead
	 */
	public boolean hasDied();

	/**
	 * Start a combat with another creature.
	 *
	 * @param c The attacked creature
	 *
	 * @return a {@link Duel} between the creature and the attacked creature
	 *         if the latter can be challenged,
	 *         {@code null} otherwise
 	 */
	public default Duel challenge(Duellist d) {
		return new Duel(this, d);
	}

	/**
	 * Run in fear from a duel with another creature
	 *
	 * @param d The duel it runs from
	 */
	public abstract void flee(Duel d);
}

