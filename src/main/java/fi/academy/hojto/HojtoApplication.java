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
			luoTestiTopic(topicRepository, messageRepository);
			luontiJoukolla(messageRepository, topicRepository);
		};

	}

	protected void luontiYksittain(UserRepository userRepository) {
		User u = new User();

		u.setNickname("Maija");
		userRepository.save(u);
	}

	protected void luoTestiTopic(TopicRepository topicRepository, MessageRepository messageRepository) {
		Topic t = new Topic(2, "Olen hellyydenkipeä", "Aimo", "Aimo Pohjanmaalta etsii tosi tarkoituksella omaa neitä X:äänsä. Plussaa jos olet javaguru, sillä minä olen scrum master ja haluan perustaa oman devaajatiimin. Vapaa-aika menee hamsteria ulkoiluttaessa ja tanhun parissa.","08:45 23-12-2017");
		topicRepository.save(t);
		Topic e = new Topic(1, "Java-koodaria etsitään", "Pupu", "Etsin javakoodaria. Mielellään joku joka ei ole kauhean hyvä, sillä tykkään naureskella bugiselle koodille. Voit koodata vaikka Skypen välityksellä, joten sijainnillasi ei ole väliä.", "10:15 14-02-2015");
		Message o = new Message("Minä typotan todalla pajon aamuisn enenn kuin olen sanut ekai kahvikuppostz. Lisää skybessä. Oma nikki on Pumpatta.","Tuomo", "15:36 05-12-2017");


		o.setTopicId(e);
		messageRepository.save(o);
		topicRepository.save(e);

//		e = new Topic(2, "Kaipaan hellyyttä", "Olli", "Elämä on kovaa sillä teen työkseni betonia. Kaipaan hellyyttä ja pehmoleluja. Etenkin Care Bears -pehmolelut ovat kivoja. Itse tuunailen niitä paljon vapaa-ajalla ja lisäisen esim. Tonilta saaduilta konekivääreiltä. Voit tutustua kokoelmaani LinkedIn-profiilissani. Muista tykätä 5 kertaa ja kommentoida 3.");
//		topicRepository.save(e);

		Topic l = new Topic(1, "Haetaan Cobol-osaajaa", "Janna", "Nuori nainen etsii kokenutta Cobol-osaajaa. Olethan koodaillut pankkien mainframeja jo ainakin 30 vuotta. Varma paikka tarjolla parhaalle.","15:30 28-12-2017");
		Message n = new Message("Heippatirallaa. Tuomo täällä taas terve. Minähän olen keksinyt Cobol-kielen, joten uskon olevani sangen pätevä mihin ikinä meitä vanhoja herrota tarvitsetkin. Mutta Cobolia vain iltapäivinä.","Tuomo","16:30 28-12-2017");
		Message b = new Message("Tässä etsittiin Cobol-taitoista miestä, mutta jos tarvitaan paras osaaja niin minä opiskelin cobolin eilen illalla samalla kun katsoin Sohvaperunoita. Kävin jo hackaamassa OP:n kaikki palvelimet ja nyt on massii.","Heidi","07:56 05-01-2018");
		n.setTopicId(l);
		b.setTopicId(l);
		messageRepository.save(n);
	//	messageRepository.save(b);
		topicRepository.save(l);


	}

    private void luontiJoukolla(MessageRepository messageRepository, TopicRepository topicRepository) {
        List<Message> messages = new ArrayList<>();
        Message o = new Message("Turo on kadottanut Akin. Taas se aikoo syödä kaikki hedelmäkarkit. Missä tuo vintti on???", "Turo","15:35 02-02-2018");
        Topic t = new Topic(4, "Olen piilostta", "Aki", "Älkää kertoko Turolle missä olen. Ostin juuri ison karkkipussin ja Turo haluaa vain syödä kaikki karkit. Menin vintin komeroon syömään hedelmäkarkit ennen kuin loppuvat.","15:36 02-02-2018");
        o.setTopicId(t);
        messages.add(o);
        o = new Message("Turo on mennyt Ollin vintille. On ehtinyt syödä hedelmäkarkit, mutta jäi kiinni betoniin. Käypä Aki hakemassa Turo pois.", "Toni","15:37 02-02-2018");
        o.setTopicId(t);
        messages.add(o);
        messageRepository.saveAll(messages);

    }



}
