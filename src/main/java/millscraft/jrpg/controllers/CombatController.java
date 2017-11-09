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

/**
 * @author Grant Mills
 * @since 11/6/17
 */
@BasePathAwareController
@RequestMapping("/api/combats")
public class CombatController {
	private final CombatRepository mCombatRepository;

	@Autowired
	public CombatController(CombatRepository combatRepository) {
		mCombatRepository = combatRepository;
	}

	@RequestMapping(method = RequestMethod.PUT, value ="/{combatId}/add/combatant")
	public @ResponseBody ResponseEntity<?> addCombatant(@PathVariable String combatId, @RequestBody Combatant combatant) {
		Combat combat = mCombatRepository.findOne(combatId);

		combat.addCombatant(combatant);
		mCombatRepository.save(combat);

		Resource<Combat> combatResource = new Resource<>(combat);
		return ResponseEntity.ok(combatResource);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{combatId}/remove/character/{characterName}")
	public @ResponseBody ResponseEntity<?> removeCharacter(@PathVariable String combatId, @PathVariable String characterName) {
		Combat combat = mCombatRepository.findOne(combatId);
		combat.removeCombatant(characterName);
		mCombatRepository.save(combat);

		Resource<Combat> combatResource = new Resource<>(combat);
		return ResponseEntity.ok(combatResource);
	}

	//Sort the combatants on the first call
	@RequestMapping(method = RequestMethod.GET, value = "/{combatId}")
	public @ResponseBody ResponseEntity<?> getCombat(@PathVariable String combatId) {
		return this.getRoundOrder(combatId, 1);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{combatId}/round/{roundNumber}")
	public @ResponseBody ResponseEntity<?> getRoundOrder(@PathVariable String combatId, @PathVariable Integer roundNumber) {
		if(roundNumber < 0) {
			throw new IllegalArgumentException("Rounds cannot be negative");
		}

		Combat combat = mCombatRepository.findOne(combatId);
		combat.setAllCombatants(combat.getRoundOrder(roundNumber));
		combat.setCurrentRound(roundNumber);
		mCombatRepository.save(combat);

		Resource<Combat> combatResource = new Resource<>(combat);
		return ResponseEntity.ok(combatResource);
	}
}
