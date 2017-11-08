package millscraft.jrpg.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

/**
 * @author Grant Mills
 * @since 3/10/17
 */
@JsonTypeInfo(
	use = JsonTypeInfo.Id.NAME,
	include = JsonTypeInfo.As.PROPERTY,
	property = "type")
@JsonSubTypes({
	@Type(value = Character.class, name = "character"),
	@Type(value = Monster.class, name = "monster")
})
public abstract class Combatant {
	@Id
	@JsonIgnore
	protected String id;

	@NotNull
	protected String name;
	@NotNull
	protected Integer initiative;
	@NotNull
	protected Double combatSpeed;

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

	public String getId() {
		return id;
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

		if (!id.equals(combatant.id)) return false;
		return name.equals(combatant.name);
	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + name.hashCode();
		return result;
	}
}
