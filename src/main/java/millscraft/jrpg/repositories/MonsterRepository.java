package millscraft.jrpg.repositories;

import millscraft.jrpg.models.Monster;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Grant Mills
 * @since 11/5/17
 */
public interface MonsterRepository extends MongoRepository<Monster, String> {
}
