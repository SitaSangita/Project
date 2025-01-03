package in.sangita;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.sangita.repo.ReportService;
import in.sangita.service.LoggingService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = 
				SpringApplication.run(Application.class, args);
		LoggingService bean = context.getBean(LoggingService.class);
		//System.out.println(bean);
	//	bean.saveUser();
	ReportService reportService =
			context.getBean(ReportService.class);
	reportService.generateReport();
	}

}
