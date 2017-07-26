package joH1.oo_rpg;


public class Mob extends Creature {
	private static final long serialVersionUID = 3L;

	public Mob(String name, int level, int initialHealth, int force, int defence, int speed) {
		super(name, level, initialHealth, force, defence, speed);
	}

	@Override
	public void fight(Creature c) {
	
	}
	
	@Override
	public void flee(Creature c) {
		
	}
}

