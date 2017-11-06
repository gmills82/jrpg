package millscraft.jrpg.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Grant Mills
 * @since 3/12/17
 */
@Controller
public class HTMLController {

	@RequestMapping(value = "/", produces = "text/html")
	public String homePage() {
		return "index.html";
	}
}
