package joH1.oo_rpg;

import java.util.ArrayList;
import java.util.EnumSet;


/**
 * Every stat.
 *
 * Stats can be {@code OR}ed together with proper methods (but this has no use yet)
 */
public enum Stat {

	HEALTH(0x1),
	FORCE(0x2),
	DEFENCE(0x4),
	SPEED(0x8),
	COURAGE(0x10),
	AGGRESSIVITY(0X20);

	private final int value;

	Stat(int value) {
		this.value = value;
	}

	/**
	 * Splits an {@code int} into different {@link Stat} by the values.
	 *
	 * @param stats The int value to split
	 *
	 * @return An {@link ArrayList} of the splitted stats
	 */
	public static ArrayList<Stat> splitList(int stats) {
		ArrayList<Stat> l = new ArrayList<Stat>(6);
		if((stats & HEALTH.value) != 0)
			l.add(HEALTH);
		if((stats & FORCE.value) != 0)
			l.add(FORCE);
		if((stats & DEFENCE.value) != 0)
			l.add(DEFENCE);
		if((stats & SPEED.value) != 0)
			l.add(SPEED);
		if((stats & COURAGE.value) != 0)
			l.add(COURAGE);
		if((stats & AGGRESSIVITY.value) != 0)
			l.add(AGGRESSIVITY);
		l.trimToSize();
		return l;
	}

	/**
	 * Splits an {@code int} into different {@link Stat} by the values.
	 *
	 * @param stats The int value to split
	 *
	 * @return An {@link EnumSet} of the splitted stats
	 */
	public static EnumSet<Stat> splitSet(int stats) {
		EnumSet<Stat> s = EnumSet.noneOf(Stat.class);
		if((stats & HEALTH.value) != 0)
			s.add(HEALTH);
		if((stats & FORCE.value) != 0)
			s.add(FORCE);
		if((stats & DEFENCE.value) != 0)
			s.add(DEFENCE);
		if((stats & SPEED.value) != 0)
			s.add(SPEED);
		if((stats & COURAGE.value) != 0)
			s.add(COURAGE);
		if((stats & AGGRESSIVITY.value) != 0)
			s.add(AGGRESSIVITY);
		return s;
	}

	/**
	 * Merges an {@link Iterable} into an {@code int}.
	 *
	 * @param stats The {@code Iterable<Stat>} to merge
	 *
	 * @return An {@code int} of the bitwise {@code or}'d values
	 */
	public static <C extends Iterable<Stat>> int merge(C stats) {
		int n = 0;
		for(Stat s : stats)
			n |= s.value;
		return n;
	}

	/**
	 * Merges a {@code Stat[]} into an {@code int}.
	 *
	 * @param stats The array of {@link Stat} to merge
	 *
	 * @return An {@code int} of the bitwise {@code or}'d values
	 */
	public static int merge(Stat[] stats) {
		int n = 0;
		final int l = stats.length;
		for(int i = 0; i < l; ++i)
			n |= stats[i].value;
		return n;
	}

	/**
	 * For tests.
	 *
	 * @param args CLI arguments
	 */
	public static void main(String[] args) {
		Stat[] resilienceStat = new Stat[] {DEFENCE, COURAGE};
		int resilience = merge(resilienceStat);

		System.out.format("resilience stats: %h <=> %s%n", resilience, splitList(resilience).toString());

		ArrayList<Stat> violenceStats = new ArrayList<Stat>(2);
		violenceStats.add(FORCE);
		violenceStats.add(AGGRESSIVITY);
		int violence = merge(violenceStats);
		System.out.println("violence stats ArrayList = " + violenceStats);
		System.out.format("violence stats: %h <=> %s%n", violence, splitSet(violence).toString());
	}

}

