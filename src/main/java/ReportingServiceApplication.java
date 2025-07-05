

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;




@SpringBootApplication(scanBasePackages = {
	    "org.openapitools.client.controller", // wherever your service + controller live
	    "org.openapitools.client.service",
	    "org.openapitools.client.api",
	    "org.openapitools.client.dto"
	   
	})




public class ReportingServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReportingServiceApplication.class, args);
    }
}
