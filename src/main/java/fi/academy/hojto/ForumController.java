package fi.academy.hojto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    //haetaan kaikki topicit @Juuso
    /*@GetMapping("/topics")
    public String allTopics(Model model) {
        model.addAttribute("topiclist", trepo.findAll());
        return "topic";
    }*/

    @GetMapping("/frontpage")
    public String jotain(Model model) {
        return "frontpage";
    }

    /*@GetMapping("/topics1")
    public String specificTopic1(Model model) {
        model.addAttribute("topiclist", trepo.findByCategoryId(1));
        return "topic";
    }*/


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

    @PostMapping("/newtopics")
    public String newTopic(Model model, Topic topic) {
        Iterable<Topic> topic1 = trepo.findByCategoryId(topic.getCategoryId());
        topic.setCategoryId(topic.getCategoryId());
        trepo.save(topic);
        model.addAttribute("topic", topic);
        model.addAttribute("topics", trepo.findByCategoryId(topic.getCategoryId()));
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
        mrepo.save(message);
        model.addAttribute("topicstarter", topic);
        List<Message> postlist = mrepo.findByTopicId(topic.get());
        model.addAttribute("postlist", postlist);
        return "post";
    }


}







