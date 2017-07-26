package joH1.oo_rpg;


@Challengeable
public class Mob extends Creature {
	private static final long serialVersionUID = 3L;

	public Mob(String name, int level, int initialHealth, int force, int defence, int speed, int courage) {
		super(name, level, initialHealth, force, defence, speed, courage);
	}

	@Override
	public void strike(Creature c) {
	
	}
	
	@Override
	public void flee(Creature c) {
		
	}
}

