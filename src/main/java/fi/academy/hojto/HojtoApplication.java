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
            createOneTopic(topicRepository);
        };

    }

    protected void luontiYksittain(UserRepository userRepository) {
        User u = new User();
        u.setName("Maija");
        userRepository.save(u);
    }

    protected void createOneTopic(TopicRepository topicRepository) {
        Topic t = new Topic();
        t.setHeader("Varakas etsii pk-seuraa");
        t.setMessage("Massii on, seuraa ei. Soittele 555-1234");
        topicRepository.save(t);
    }

}
