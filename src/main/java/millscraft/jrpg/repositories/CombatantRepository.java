package millscraft.jrpg.repositories;

import millscraft.jrpg.models.Character;
import millscraft.jrpg.models.Combatant;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Grant Mills
 * @since 3/10/17
 */
public interface CombatantRepository extends MongoRepository<Combatant, String> {
	Character findByName(String name);
}
