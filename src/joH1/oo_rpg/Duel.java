package joH1.oo_rpg;


public class Duel {

	private Duellist left;

	private Duellist right;


	public Duel(Duellist left, Duellist right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return String.format("Duel <%s> vs <%s>", left.toString(), right.toString());
	}

	/**
	 * Retrieve the creatures involved in the duel
	 *
	 * @return An array of {@link Creature Creatures} whose size is always 2
	 */
	public Duellist[] Duellists() {
		return new Duellist[] {left, right};
	}

	/**
	 * Gets the opponent of the creature (the other Duellist)
	 *
	 * @param c The creature to retrieve the opponent
	 *
	 * @return The Creature involved in duel and which is not {@code c}
	 *         or {@code null} if c does not belong to the duel
	 */
	public Duellist getOpponent(Duellist d) {
		if(left.equals(d))
			return right;
		else if(right.equals(d))
			return left;
		return null;
	}
	/**
	 * One round of the duel.
	 * TODO take creatures' speed into account
	 *
	 * @return The winner of the duel, if one; otherwise {@code null}
	 */
	public Duellist round() {
		left.duelTurn(this);
		right.duelTurn(this);
		return winner();
	}

	public Duellist winner() {
		if(left.hasDied())
			return right;
		else if(right.hasDied())
			return left;
		return null;
	}

	public boolean over() {
		return left.hasDied() || right.hasDied();
	}

}

