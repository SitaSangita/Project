package in.sita.sangitaTech.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.sita.sangitaTech.dto.User;
import in.sita.sangitaTech.service.UserService;

@RestController
public class UserRestController {
	@Autowired
	private UserService service;
	
	@PostMapping("/user")
	public ResponseEntity<String> saveUser(@RequestBody User user){
		
		boolean saveUser = service.saveUser(user);
		
		if(saveUser) {
			sendEmail();
			return new ResponseEntity<>("User saved",HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<String>("Not saved",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	 private void sendEmail() {
		 
		 
	 }
}
