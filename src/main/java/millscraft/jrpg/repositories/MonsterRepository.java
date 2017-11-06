package millscraft.jrpg.repositories;

import millscraft.jrpg.models.Monster;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Grant Mills
 * @since 11/5/17
 */
@Repository
public interface MonsterRepository extends MongoRepository<Monster, String> {
}
