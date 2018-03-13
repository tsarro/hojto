package fi.academy.hojto;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HojtoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HojtoApplication.class, args);
	}

	@Bean
	CommandLineRunner luoTestiKayttaja(UserRepository userRepository, TopicRepository topicRepository, MessageRepository messageRepository) {
		return args -> {

			luontiYksittain(userRepository);
			luoTestiTopic(topicRepository);
			luontiJoukolla(messageRepository, topicRepository);
		};

	}

	protected void luontiYksittain(UserRepository userRepository) {
		User u = new User();
		u.setName("Maija");
		userRepository.save(u);
	}

	protected void luoTestiTopic(TopicRepository topicRepository) {
		Topic t = new Topic(1, "Olen hellyydenkipeä", "moi", "moi");
		topicRepository.save(t);
		Topic e = new Topic(1, "Java-koodaria etsitään", "moi", "terve");
		topicRepository.save(e);
		Topic k = new Topic(2, "Kaipaan hellyyttä", "Olli", "terve");
		topicRepository.save(k);
	}

    private void luontiJoukolla(MessageRepository messageRepository, TopicRepository topicRepository) {
        List<Message> messages = new ArrayList<>();
        Message o = new Message("Turo", "Moilanen");
        Topic t = new Topic(2, "Testitopicci", "Olli", "moikka kaikki");
        o.setTopicId(t);
        messages.add(o);
        Message m = new Message("Moikka", "Olli");
        m.setTopicId(t);
        messages.add(m);
        messageRepository.saveAll(messages);

    }




    protected void createOneTopic(TopicRepository topicRepository) {
        Topic t = new Topic();
        t.setHeader("Varakas etsii pk-seuraa");
        t.setFirstmessage("Massii on, seuraa ei. Soittele 555-1234");
        topicRepository.save(t);
    }


}
