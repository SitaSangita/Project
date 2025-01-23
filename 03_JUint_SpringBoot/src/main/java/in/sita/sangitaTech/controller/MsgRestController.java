package in.sita.sangitaTech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.sita.sangitaTech.service.MsgService;

@RestController
public class MsgRestController {
	
	@Autowired
	private MsgService msgService;
	
	@GetMapping("/welcome")
	public String getWelcome() {
		String name = msgService.getClass().getName();
		String msg = msgService.getWelcomeMsg();
		
		String upperCase = msg.toUpperCase();
		return upperCase;
	}
	@GetMapping("/greet")
	public String getGreet() {
		String msg = msgService.getGreetMsg();
		String lowerCase = msg.toLowerCase();
		return lowerCase;
	}

}
