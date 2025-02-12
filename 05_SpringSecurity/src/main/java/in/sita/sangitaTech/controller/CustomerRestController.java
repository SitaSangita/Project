package in.sita.sangitaTech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.sita.sangitaTech.entity.Customer;
import in.sita.sangitaTech.service.CustomerService;

@RestController
public class CustomerRestController {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody Customer c){
		UsernamePasswordAuthenticationToken token=
				new UsernamePasswordAuthenticationToken(c.getEmail(),c.getPwd());
		Authentication authenticate = 
				authenticationManager.authenticate(token);
		boolean status = authenticate.isAuthenticated();
		if(status) {
			return new ResponseEntity<>("success",HttpStatus.OK);
		}
		else {
			return  new ResponseEntity<>("failed",HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/register")
	public ResponseEntity<String > register(@RequestBody Customer customer){
		boolean status = customerService.saveCustomer(customer);
		if(status) {
			return new ResponseEntity<>("success",HttpStatus.CREATED);
		}
		else {
			return  new ResponseEntity<>("failed",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
