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

    @GetMapping("/topics1")
    public String specificTopic1(Model model) {
        model.addAttribute("topiclist", trepo.findByCategoryId(1));
        return "topic";
    }


    // Haetaan kaikki topicit tietystä kategoriasta @Olli,Outi,Heidi,Juuso
    @GetMapping("/topics2")
    public String specificTopic2(Model model) {
        model.addAttribute("topiclist", trepo.findByCategoryId(2));
        return "topic";
    }

    @GetMapping("/posts")
    public String specificPost(@RequestParam(name = "topicId") int topicId, Model model) {
        List<Message> postlist = mrepo.messagesByTopics(topicId);
            model.addAttribute("postlist", postlist);
            return "post";
        }
}







