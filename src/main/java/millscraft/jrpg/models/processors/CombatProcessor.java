package millscraft.jrpg.models.processors;

import millscraft.jrpg.controllers.CombatController;
import millscraft.jrpg.models.Combat;
import millscraft.jrpg.models.Combatant;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * @author Grant Mills
 * @since 11/6/17
 */
@Component
public class CombatProcessor implements ResourceProcessor<Resource<Combat>> {

	@Override
	public Resource<Combat> process(Resource<Combat> resource) {
		//On each combat add a remove from combat link for each character
		List<Combatant> registeredCombatants = resource.getContent().getAllCombatants();
		if(registeredCombatants != null && !registeredCombatants.isEmpty()) {
			for (Combatant combatant : registeredCombatants) {
				resource.add(linkTo(methodOn(CombatController.class).removeCharacter(resource.getContent().getId(), combatant.getName())).withRel("edit-combat"));
			}
		}

		resource.add(linkTo(methodOn(CombatController.class).addCharacter(resource.getContent().getId(), null)).withRel("edit-combat"));
		resource.add(linkTo(methodOn(CombatController.class).addMonster(resource.getContent().getId(), null)).withRel("edit-combat"));
		return resource;
	}
}
