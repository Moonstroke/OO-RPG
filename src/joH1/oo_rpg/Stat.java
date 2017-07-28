package joH1.oo_rpg;

import java.util.ArrayList;
import java.util.EnumSet;


/**
 * Every stat.
 * Stats can be {@code OR}ed together (but this has no use yet)
 */
public enum Stat {

	HEALTH(0x1),
	FORCE(0x2),
	DEFENCE(0x4),
	SPEED(0x8),
	COURAGE(0x10),
	AGGRESSIVITY(0X20);

	private int value;

	Stat(int value) {
		this.value = value;
	}

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

	public static <C extends Iterable<Stat>> int merge(C stats) {
		int n = 0;
		for(Stat s : stats)
			n |= s.value;
		return n;
	}

	public static int merge(Stat[] stats) {
		int n = 0;
		final int l = stats.length;
		for(int i = 0; i < l; ++i)
			n |= stats[i].value;
		return n;
	}

}

