package joH1.oo_rpg;

import java.util.List;
import java.util.ArrayList;

/**
 * Every stat.
 * Stats can be {@code OR}ed together (but this has no use yet)
 */
public enum Stat {

	HEALTH(0x1),
	FORCE(0x2),
	DEFENCE(0x4),
	SPEED(0x8),
	COURAGE(0x10);

	private int value;

	Stat(int value) {
		this.value = value;
	}

	public static ArrayList<Stat> from(int stats) {
		ArrayList<Stat> s = new ArrayList<Stat>(5);
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
		s.trimToSize();
		return s;
	}
	
	public static int from(List<Stat> stats) {
		int n = 0;
		for(Stat s : stats)
			n &= s.value;
		return n;
	}

	public static int from (Stat[] stats) {
		int n = 0;
		final int l = stats.length;
		for(int i = 0; i < l; ++i)
			n &= stats[i].value;
		return n;
	}

}

