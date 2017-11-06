package millscraft.jrpg.repositories;

import millscraft.jrpg.models.Combat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Grant Mills
 * @since 11/6/17
 */
@Repository
public interface CombatRepository extends MongoRepository<Combat, String> {
}
