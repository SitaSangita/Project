package in.sita.sangitaTech.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

	@GetMapping("/")
	public String getWelcome() {
		return "Good Morning";
	}
}
