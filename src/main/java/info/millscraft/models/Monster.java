package info.millscraft.models;

/**
 * Monster combatants
 * @author Grant Mills
 * @since 3/10/17
 */

public class Monster implements Combatant {
	private static Integer totalMonsterCount = 0;

	private String name;
	private int initiative;
	private int combatSpeed;

	private Monster(){};

	public Monster(int initiative, int combatSpeed) {
		this.initiative = initiative;
		this.combatSpeed = combatSpeed;
		totalMonsterCount++;
	}

	@Override
	public String getName() {
		String baseMonsterName = "Monster ";
		return baseMonsterName + totalMonsterCount.toString();
	}

	@Override
	public int getInitiative() {
		return initiative;
	}

	@Override
	public int getCombatSpeed() {
		return combatSpeed;
	}
}
