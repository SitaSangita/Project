package in.sangita.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LoggingService {
	
	public void saveUser() {
		log.trace("This is trace msg");
		log.debug("This is debug msg");
		log.info("This is info msg");
		log.warn("This is warn msg");
		log.error("This is error msg");
	}


}
