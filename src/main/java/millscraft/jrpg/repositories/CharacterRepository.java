package millscraft.jrpg.repositories;

import millscraft.jrpg.models.Character;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Grant Mills
 * @since 3/10/17
 */
public interface CharacterRepository extends MongoRepository<Character, String> {
	Character findByName(String name);
}
