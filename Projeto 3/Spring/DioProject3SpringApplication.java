package rodrigo.bc.dio_project3_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DioProject3SpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(DioProject3SpringApplication.class, args);
	}

}
