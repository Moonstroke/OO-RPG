package joH1.oo_rpg;

import java.util.Random;


public class Die {

	private static final Random die = new Random();


	public int roll(int max) {
		return die.nextInt(max);
	}

	public int roll() {
		return die.nextInt(100);
	}

}
