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


	protected Entity(String name, int level) {
		this.name = name;
		this.level = level;
	}

	@Override
	public abstract String toString();

	@Override
	public int hashCode() {
		return 31 * name.hashCode() + level;
	}

	@Override
	public boolean equals(Object o) {
		if(o == null || ! (o instanceof Entity))
			return false;
		Entity e = (Entity)o;
		return name.equals(e.name) && level == e.level;
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
}

