package millscraft.jrpg.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.Id;

import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Combat object which returns combat order given a round.
 * Maintains a list of combatants
 * @author Grant Mills
 * @since 11/5/17
 */
public class Combat {
	@Id
	private String id;

	@JsonProperty("combatants")
	private LinkedList<Combatant> allCombatants;

	private static final Logger log = LoggerFactory.getLogger(Combat.class);

	public void addCharacter(Character combatant) {
		log.debug(combatant.getName() + " was added to the combat");
		allCombatants.addLast(combatant);
	}

	public void addMonster(Monster combatant) {
		log.debug(combatant.getName() + " was added to the combat");
		allCombatants.addLast(combatant);
	}

	public <T extends Combatant> void removeCombatant(T combatant) {
		if(allCombatants.contains(combatant)) {
			allCombatants.remove(combatant);
			log.debug(combatant.getName() + " was removed from combat");
		} else {
			log.debug(combatant.toString() + " not found in combat.");
		}
	}

	private LinkedList<Combatant> sortByCalculatedSpeedForRound(int round) {

		this.allCombatants.sort((c1, c2) -> {
			//Descending order so
			// -1 is less than, 1 is greater than
			int result;

			//higher intiative the better
			if(c1.getCalculatedSpeed(round) > c2.getCalculatedSpeed(round)) {
				result = -1;
			}else if (c2.getCalculatedSpeed(round) > c1.getCalculatedSpeed(round)) {
				result = 1;
			}else {
				int rando = ThreadLocalRandom.current().nextInt();
				if(rando % 2 == 0) {
					result = 1;
				}else {
					result = -1;
				}
			}

			return result;
		});

		return this.allCombatants;
	}

	/**
	 * Get the order for any given positive non-zero round
	 * @param round - positive non-zero round
	 * @return ordered list of combatants
	 */
	public LinkedList<Combatant> getRoundOrder(int round) {
		if(round <=0) {
			throw new IllegalArgumentException("Round must be a positive non-zero integer");
		}else {
			return this.sortByCalculatedSpeedForRound(round);
		}
	}

	//Getters and Setters
	public LinkedList<Combatant> getAllCombatants() {
		return allCombatants;
	}

	public void setAllCombatants(LinkedList<Combatant> allCombatants) {
		this.allCombatants = allCombatants;
	}

	public String getId() {
		return id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Combat combat = (Combat) o;

		if (!id.equals(combat.id)) return false;
		return allCombatants.equals(combat.allCombatants);
	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + allCombatants.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "Combat{" +
			"allCombatants=" + allCombatants +
			'}';
	}
}
