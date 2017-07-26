package joH1.oo_rpg;

import java.lang.StringBuilder;
import java.io.Serializable;

public abstract class Entity implements Cloneable, Serializable {
	private static final long serialVersionUID = 1L;

	protected String name;

	/**
	 * Determines the global ranking of the entity among its type
	 */
	protected int level;


	@Override
	public abstract String toString();

	@Override
	public boolean equals(Object o) {
		if(o == null || ! (o instanceof Entity.class))
			return false;
		Entity e = (Entity)o;
		return name.equals(e.name) && level = e.level;
	}

	/**
	 * Changes the entity's name to {@code newName}.
	 *
	 * @param newName The new name to give to the entity
	 */
	public void rename(String newName) {
		name = newName;
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

