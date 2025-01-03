package in.sangita.repo;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ReportService {
	public void generateReport() {
		log.info("Logg started");
		try {
			int i=10/0;
		}
		catch(Exception e){
			log.error(e.getMessage());
		}
		log.info("Logger end");
	}

}
