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
	CommandLineRunner luoTestiKayttaja(UserRepository userRepository, TopicRepository topicRepository) {
		return args -> {

			luontiYksittain(userRepository);
			luoTestiTopic(topicRepository);
		};

	}

	protected void luontiYksittain(UserRepository userRepository) {
		User u = new User();
		u.setName("Maija");
		userRepository.save(u);
	}

	protected void luoTestiTopic(TopicRepository topicRepository) {
		Topic t = new Topic(1, "moi", "moi", "moi");
		topicRepository.save(t);
	}



    protected void createOneTopic(TopicRepository topicRepository) {
        Topic t = new Topic();
        t.setHeader("Varakas etsii pk-seuraa");
        t.setFirstmessage("Massii on, seuraa ei. Soittele 555-1234");
        topicRepository.save(t);
    }


}
