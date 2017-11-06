package millscraft.jrpg.repositories;

import millscraft.jrpg.models.Character;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Grant Mills
 * @since 3/10/17
 */
@Repository
public interface CharacterRepository extends MongoRepository<Character, String> {
	Character findByName(String name);
}
