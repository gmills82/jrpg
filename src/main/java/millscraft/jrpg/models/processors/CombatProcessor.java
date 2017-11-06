package millscraft.jrpg.models.processors;

import millscraft.jrpg.controllers.CombatController;
import millscraft.jrpg.models.Combat;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;

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
		resource.add(linkTo(methodOn(CombatController.class).addCombatant(resource.getContent().getId(), null)).withRel("edit"));
		return resource;
	}
}
