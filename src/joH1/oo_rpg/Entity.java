package joH1.oo_rpg;

import java.lang.StringBuilder;
import java.io.Serializable;


public abstract class Entity implements Cloneable, Serializable {
	private static final long serialVersionUID = 1L;

	protected final String name;

	/**
	 * Determines the global ranking of the entity among its type
	 */
	protected int level;

	/**
	 * The value that defines the health or integrity of the entity,
	 * the amount of points it has to lose before dying (or disappearing).
	 *
	 * This value is equivalent to a {@linkplain Creature}'s health, or
	 * an {@linkplain Item}'s durability.
	 */
	protected int integrity;

	/**
	 * The maximum lasting points the entity can own
	 *
	 * A value of {@code -1} means the entity is unkillable (/unbreakable)
	 */
	protected int maxIntegrity;

	protected Entity(Entity e) {
		name = e.name;
		level = e.level;
		integrity = e.integrity;
		maxIntegrity = e.maxIntegrity;
	}

	public Entity(String name, int level, int initialIntegrity) {
		this.name = name;
		this.level = level;
		this.integrity = this.maxIntegrity = initialIntegrity;
	}


	@Override
	public String toString() {
		return String.format("%s \"%s\" level %d [%d/%d]", this.getClass().getSimpleName(), name, level, integrity, maxIntegrity);
	}

	@Override
	public int hashCode() {
		return name.hashCode() + 17 * level + 31 * integrity + 127 * maxIntegrity;
	}

	@Override
	public boolean equals(Object o) {
		if(o == null || ! (o instanceof Entity))
			return false;
		Entity e = (Entity)o;
		return name.equals(e.name) && level == e.level && integrity == e.integrity && maxIntegrity == e.maxIntegrity;
	}

	/**
	 * Increases the entity's level.
	 * This basic implementation should be overriden
	 *
	 * @return The new level of the entity
	 */
	public int levelUp() {
		return ++level;
	}

	/**
	 * Restores {@code amount} points to the entity's integrity
	 *
	 * @return the new value of the entity's integrity
	 */
	protected int restore(int amount) {
		int sum = integrity + amount;
		return integrity = (sum > maxIntegrity) ? maxIntegrity : sum;
	}

	/**
	 * Decreases the entity's integrity by {@code amount} points
	 *
	 * @return {@code true} if the new integrity value is <= 0, {@code false} otherwise
	 *         ie. the boolean value for {@code Has the entity died/broken?}
	 */
	protected boolean damage(int amount) {
		return maxIntegrity < 0 || (integrity -= amount) > 0;
	}

}
