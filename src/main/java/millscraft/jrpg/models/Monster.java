package millscraft.jrpg.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Monster combatants
 * @author Grant Mills
 * @since 3/10/17
 */

public class Monster extends Combatant {
	private static Integer totalMonsterCount = 0;
	private static final String BASE_MONSTER_NAME = "Monster ";

	@JsonCreator
	public Monster(String name, Integer initiative, Double combatSpeed) {
		super(name, initiative, combatSpeed);
	}

	@JsonCreator
	public Monster(@JsonProperty("initiative") int initiative, @JsonProperty("combatSpeed") Double combatSpeed) {
		super(BASE_MONSTER_NAME + totalMonsterCount.toString(), initiative, combatSpeed);

		//Increment to count total number of monster made
		totalMonsterCount++;
	}

	@Override
	public String toString() {
		return "Monster{" +
			"name='" + name + '\'' +
			", initiative=" + initiative +
			", combatSpeed=" + combatSpeed +
			'}';
	}
}
