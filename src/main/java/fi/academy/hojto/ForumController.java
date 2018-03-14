package fi.academy.hojto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String jotain(Model model){
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
        model.addAttribute("topiclist", trepo.findByCategoryId(id));
        return "topic";
    }

    //Haetaan messaget topic id:n perusteella, (palauttaa tällä hetkellä vain ensimmäisen) @Olli @Heidi
    @GetMapping("/posts")
    public String specificPost(@RequestParam int topicId, Model model) {
        Topic topic = new Topic(); topic.setId(topicId);
        List<Message> postlist = mrepo.findByTopicId(topic);

            model.addAttribute("postlist", postlist);
            return "post";
        }
}







