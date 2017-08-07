package joH1.oo_rpg;

public interface Applicable {

	/**
	 * Applies this {@link Item item} to the given creature
	 *
	 * @return the new value of the {@link Stat stat} modified by
	 *         this {@link Item item}
	 */
	public int apply(Creature c);
}

