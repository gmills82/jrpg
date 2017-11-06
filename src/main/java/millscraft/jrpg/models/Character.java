package millscraft.jrpg.models;

/**
 * Character combatants
 * @author Grant Mills
 * @since 3/10/17
 */

public class Character extends Combatant {

	public Character(String name, int initiative, int combatSpeed) {
		super(name, initiative, combatSpeed);
	}

	public String getName() {
		return name;
	}

	public int getInitiative() {
		return initiative;
	}

	public int getCombatSpeed() {
		return combatSpeed;
	}

	@Override
	public String toString() {
		return "Character{" +
			"name='" + name + '\'' +
			", initiative=" + initiative +
			", combatSpeed=" + combatSpeed +
			'}';
	}
}
