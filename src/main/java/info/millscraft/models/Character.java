package info.millscraft.models;

import org.springframework.data.annotation.Id;

/**
 * Character combatants
 * @author Grant Mills
 * @since 3/10/17
 */

public class Character implements Combatant {

	@Id
	private String id;

	private String name;
	private int initiative;
	private int combatSpeed;

	//no default constructor
	private Character() {}

	public Character(String name, int initiative, int combatSpeed) {
		this.name = name;
		this.initiative = initiative;
		this.combatSpeed = combatSpeed;
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
		return String.format(
			"Customer[id=%s, name='%s']",
			id, name);
	}
}
