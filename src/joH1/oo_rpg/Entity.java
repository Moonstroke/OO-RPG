package joH1.oo_rpg;

import java.lang.StringBuilder;
import java.io.Serializable;

public class Entity implements Cloneable, Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * The name of the entity
	 */
	protected String name;

	/**
	 * The total amount of health points the entity can lose
	 * before dying
	 */
	protected int health;

	/**
	 * The maximum (and initial) number of life points it owns
	 */
	protected int maxHealth;


	/**
	 * Ctor with no argument
	 */
	protected Entity() {
		name = "";
		health = 0;
		maxHealth = 0;
	}

	/**
	 * Adequate ctor
	 */
	protected Entity(String name, int health, int maxHealth) {
		this.name = name;
		this.health = health;
		this.maxHealth = maxHealth;
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
	public int hashCode() {
		return 42;
	}

	@Override
	public boolean equals(Object o) {
		if(o == null || ! (o instanceof Entity))
			return false;
		Entity e = (Entity)o;
		return name.equals(e.name) && health == e.health && maxHealth == e.maxHealth;
	}

	@Override
	public Entity clone() {
		return new Entity(new String(name), health, maxHealth);
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
	 * The method to call when the entity's health reaches 0.
	 */
	public void die() {}

	/**
	 * Decreases health of {@code amount} life points.
	 *
	 * @param amount The amount of life points to remove to it
	 *
	 * @return {@code false} if the entity has died
	 */
	public boolean takeHit(int amount) {
		if((health -= amount) == 0) {
			die();
			return false;
		}
		return true;
	}

	/**
	 * Restores {@code amount} life points to it
	 *
	 * @param amount The maximum amount of life points to add to its health
	 *
	 * @return The new health of the entity
	 */
	public int restore(int amount) {
		return health + amount > maxHealth ? (health = maxHealth) : (health += amount);
	}
}

