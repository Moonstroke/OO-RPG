package joH1.oo_rpg;

public interface Consumable {

	/**
	 * Uses the {@link Item} once.
	 *
	 * @return {@code true} if the {@link Item item} can still be used
	 *         afterwards
	 */
	public boolean consume();

}
