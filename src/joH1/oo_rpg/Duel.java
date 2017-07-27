package joH1.oo_rpg;


public class Duel {

	private Duellist left, right;


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
	 * Using {@code SuppressWarnings("unchecked")} is bad practice, but
	 * {@code left} and {@code right} will always be subclasses of both
	 * {@link Creature} and {@link Duellist}, so the warning here is just useless
	 *
	 * @param c The creature to retrieve the opponent
	 *
	 * @return The Creature involved in duel and which is not {@code c}
	 *         or {@code null} if c does not belong to the duel
	 */
	@SuppressWarnings("unchecked")
	public <C extends Creature & Duellist> C getOpponent(C d) {
		if(left.equals(d))
			return (C)right;
		else if(right.equals(d))
			return (C)left;
		return null;
	}

	/**
	 * One round of the duel.
	 * TODO take creatures' speed into account
	 *
	 * @return The winner of the duel, if one; otherwise {@code null}
	 */
	public <C extends Creature & Duellist> C round() {
		left.duelTurn(this);
		right.duelTurn(this);
		return winner();
	}

	@SuppressWarnings("unchecked")
	public <C extends Creature & Duellist> C winner() {
		if(left.hasDied())
			return (C)right;
		else if(right.hasDied())
			return (C)left;
		return null;
	}

	public boolean over() {
		return left.hasDied() || right.hasDied();
	}

}

