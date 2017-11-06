package millscraft.jrpg.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Character combatants
 * @author Grant Mills
 * @since 3/10/17
 */

public class Character extends Combatant {

	@JsonCreator
	public Character(@JsonProperty("name") String name, @JsonProperty("initiative") Integer initiative, @JsonProperty("combatSpeed") Double combatSpeed) {
		super(name, initiative, combatSpeed);
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
