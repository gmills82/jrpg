package millscraft.jrpg.controllers;

import millscraft.jrpg.models.Character;
import millscraft.jrpg.models.Combat;
import millscraft.jrpg.models.Monster;
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

/**
 * @author Grant Mills
 * @since 11/6/17
 */
@BasePathAwareController
@RequestMapping("/api/combat")
public class CombatController {
	private final CombatRepository mCombatRepository;

	@Autowired
	public CombatController(CombatRepository combatRepository) {
		mCombatRepository = combatRepository;
	}

	@RequestMapping(method= RequestMethod.PUT, value="/{combatId}/add/character")
	public @ResponseBody ResponseEntity<?> addCharacter(@PathVariable String combatId, @RequestBody Character combatant) {
		Combat combat = mCombatRepository.findOne(combatId);

		combat.addCharacter(combatant);
		mCombatRepository.save(combat);

		Resource<Combat> combatResource = new Resource<>(combat);
		return ResponseEntity.ok(combatResource);
	}

	@RequestMapping(method= RequestMethod.PUT, value="/{combatId}/add/monster")
	public @ResponseBody ResponseEntity<?> addMonster(@PathVariable String combatId, @RequestBody Monster combatant) {
		Combat combat = mCombatRepository.findOne(combatId);

		combat.addMonster(combatant);
		mCombatRepository.save(combat);

		Resource<Combat> combatResource = new Resource<>(combat);
		return ResponseEntity.ok(combatResource);
	}
}
