package joH1.oo_rpg;

import java.util.Random;


public class Die {

	private static final Random die = new Random();


	public static int roll(int max) {
		return die.nextInt(max);
	}

	public static int roll() {
		return die.nextInt(100);
	}

}
