package millscraft.jrpg.models;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

/**
 * @author Grant Mills
 * @since 3/10/17
 */
public class Combatant {
	@Id
	private String id;

	@NotNull
	protected String name;
	@NotNull
	protected int initiative;
	@NotNull
	protected int combatSpeed;

	public Combatant() {}

	public Combatant(String name, int initiative, int combatSpeed) {
		this.name = name;
		this.initiative = initiative;
		this.combatSpeed = combatSpeed;
	}

	public int getCalculatedSpeed(int round) {
		if(round <= 0) {
			throw new IllegalArgumentException("Round must be a positive integer");
		}
		//y=mx+b y = calculatedSpeed, x = round, m = speed, b = initiative
		return ((combatSpeed*round) + initiative);
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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Combatant combatant = (Combatant) o;

		if (initiative != combatant.initiative) return false;
		return name.equals(combatant.name);
	}

	@Override
	public int hashCode() {
		int result = name.hashCode();
		result = 31 * result + initiative;
		return result;
	}
}
