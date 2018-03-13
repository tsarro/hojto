package fi.academy.hojto;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HojtoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HojtoApplication.class, args);
	}

	@Bean
	CommandLineRunner luoTestiKayttaja(UserRepository userRepository) {
		return args -> {

			luontiYksittain(userRepository);
		};

	}

	protected void luontiYksittain(UserRepository userRepository) {
		User u = new User();
		u.setName("Maija");
		userRepository.save(u);
	}

}
