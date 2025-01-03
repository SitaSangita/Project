package in.sashokit.controll;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class Welcome {
	@GetMapping("/welcome")

	public String getMap() {
		log.info("**************Log started***********");
		log.info("*******Log end************");
		return "Welcome To Sangita World";
		
	}

}
