package kag.glo4.getmyticket_backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GetmyticketBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GetmyticketBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Application started");
	}

}
