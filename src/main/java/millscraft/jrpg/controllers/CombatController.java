package millscraft.jrpg.controllers;

import millscraft.jrpg.models.Combat;
import millscraft.jrpg.models.Combatant;
import millscraft.jrpg.repositories.CombatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Grant Mills
 * @since 11/6/17
 */
@RestController
@BasePathAwareController
public class CombatController {
	private final CombatRepository mCombatRepository;

	@Autowired
	public CombatController(CombatRepository combatRepository) {
		mCombatRepository = combatRepository;
	}

	@RequestMapping(method= RequestMethod.PUT, value="/combat/{combatId}/add/combatant")
	public @ResponseBody ResponseEntity<?> addCombatant(@PathVariable String combatId, @RequestBody Combatant combatant) {
		Combat combat = mCombatRepository.findOne(combatId);

		combat.addCombatant(combatant);
		mCombatRepository.save(combat);

		Resource<Combat> combatResource = new Resource<>(combat);
		return ResponseEntity.ok(combatResource);
	}
}
