package millscraft.jrpg.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

/**
 * @author Grant Mills
 * @since 3/10/17
 */
public class Combatant {
	@Id
	@JsonIgnore
	private String id;

	@NotNull
	protected String name;
	@NotNull
	protected Integer initiative;
	@NotNull
	protected Double combatSpeed;

	public Combatant() {}

	public Combatant(String name, Integer initiative, Double combatSpeed) {
		this.name = name;
		this.initiative = initiative;
		this.combatSpeed = combatSpeed;
	}

	public double getCalculatedSpeed(int round) {
		if(round <= 0) {
			throw new IllegalArgumentException("Round must be a positive integer");
		}
		//y=mx+b y = calculatedSpeed, x = round, m = speed, b = initiative
		return ((combatSpeed*round) + initiative);
	}

	public String getName() {
		return name;
	}

	public Integer getInitiative() {
		return initiative;
	}

	public Double getCombatSpeed() {
		return combatSpeed;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Combatant combatant = (Combatant) o;

		if (!name.equals(combatant.name)) return false;
		if (!initiative.equals(combatant.initiative)) return false;
		return combatSpeed.equals(combatant.combatSpeed);
	}

	@Override
	public int hashCode() {
		int result = name.hashCode();
		result = 31 * result + initiative.hashCode();
		result = 31 * result + combatSpeed.hashCode();
		return result;
	}
}
