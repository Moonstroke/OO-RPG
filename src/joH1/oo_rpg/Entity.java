package joH1.oo_rpg;

import java.lang.StringBuilder;
import java.io.Serializable;

public class Entity implements Cloneable, Serializable {
	private static final long serialVersionUID = 1L;

	protected String name;

	/**
	 * Determines the global ranking of the entity among its type
	 */
	protected int level;


	protected Entity() { // Default ctor
		name = "";
		level = 0;
	}

	protected Entity(Entity e) { // Copy ctor
		name = new String(e.name);
		level = e.level;
	}

	protected Entity(String name, int level) { // Use this
		this.name = name;
		this.level = level;
	}

	@Override
	public String toString() {
		// Leaving 7 chars for String representations of `health` and `maxHealth` seems reasonable
		StringBuilder sb = new StringBuilder(name.length() + 20);
		sb.append("Entity \"").append(name).append("\" [").append(String.valueOf(health));
		sb.append('/').append(String.valueOf(maxHealth)).append(']');
		return sb.toString();
	}

	@Override
	public boolean equals(Object o) {
		if(o == null || ! (o instanceof Entity))
			return false;
		Entity e = (Entity)o;
		return name.equals(e.name) && level = e.level;
	}

	@Override
	public Entity clone() {
		return new Entity(new String(name), level);
	}

	/**
	 * Changes the entity's name to {@code newName}.
	 *
	 * @param newName The new name to give to the entity
	 */
	public void rename(String newName) {
		name = newName;
	}

}

