package fi.academy.hojto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ForumController {

    @Autowired
    MessageRepository mrepo;
    @Autowired
    TopicRepository trepo;
    @Autowired
    UserRepository urepo;

    @GetMapping("/frontpage")
    public String jotain(Model model) {
        return "frontpage";
    }

    // Haetaan kaikki topicit tietystä kategoriasta @Olli,Outi,Heidi,Juuso
    // Muutettu hakua niin, että käytetään samaa mappingiä kaikissa linkeissä,
    // id määrittää minkä category id:n topicit haetaan. @Olli
    @GetMapping("/topics")
    public String specificTopic2(@RequestParam int id, Model model) {
        Topic topic = new Topic(); topic.setCategoryId(id);
        model.addAttribute("topiclist", trepo.findByCategoryId(id));
        model.addAttribute("topic", topic);
        return "topic";
    }

    //Uuden topicin luominen @Outi @Heidi @Juuso
    @PostMapping("/newtopics")
    public String newTopic(Model model, Topic topic) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
        String formatDateTime = now.format(formatter);
        topic.setTtimestamp(formatDateTime);
        //Tehdään uusi topic
        trepo.save(topic);
        //Haetaan tämän jälkeen sisältö
        model.addAttribute("topic", topic);
        model.addAttribute("topiclist", trepo.findByCategoryId(topic.getCategoryId()));

        return "topic";
    }

    //Haetaan messaget topic id:n perusteella, (palauttaa tällä hetkellä vain ensimmäisen) @Olli @Heidi
    //Uusi postaus @Outi @Heidi
    @GetMapping("/posts")
    public String specificPost(@RequestParam int topicId, Model model) {
        Topic topic = new Topic(); topic.setId(topicId);
        List<Message> postlist = mrepo.findByTopicId(topic);
        model.addAttribute("topicstarter", trepo.findById(topic.getId()));
        model.addAttribute("postlist", postlist);
        //Alla message-olioon paketoidaan id
        Message msg = new Message();
        msg.setTopicId(topic);
        model.addAttribute("message", msg);
        return "post";
    }

    //Uuden viestin postittaminen @Heidi @Outi
    @PostMapping("/newposts")
    public String postSubmit(Model model, Message message) {
        Optional<Topic> topic = trepo.findById(message.getTopicId().getId());
        message.setTopicId(topic.get());
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
        String formatDateTime = now.format(formatter);
        message.setMtimestamp(formatDateTime);
        mrepo.save(message);
        model.addAttribute("topicstarter", topic);
        List<Message> postlist = mrepo.findByTopicId(topic.get());
        model.addAttribute("postlist", postlist);
        return "post";
    }


}







