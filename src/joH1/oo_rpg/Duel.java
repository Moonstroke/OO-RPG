package joH1.oo_rpg;


public class Duel {

	private Creature left;

	private Creature right;


	public Duel(Creature left, Creature right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return String.format("Duel <%s> vs <%s>", left.toString(), right.toString());
	}

	public Creature[] fighters() {
		return new Creature[] {left, right};
	}

	public boolean over() {
		return !(left.isAlive() && right.isAlive());
	}

	public void round() {
		// TODO
	}

	public Creature winner() {
		if(!left.isAlive())
			return right;
		else if(!right.isAlive())
			return left;
		return null;
	}
}

