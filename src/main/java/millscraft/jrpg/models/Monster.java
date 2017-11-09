package millscraft.jrpg.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

/**
 * Monster combatants
 * @author Grant Mills
 * @since 3/10/17
 */

public class Monster extends Combatant {
	private static Integer totalMonsterCount = 0;
	private static final String BASE_MONSTER_NAME = "Monster ";

	@JsonCreator
	public Monster(@NotNull @JsonProperty("initiative") int initiative, @NotNull @JsonProperty("combatSpeed") Double combatSpeed) {
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
