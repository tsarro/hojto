package fi.academy.hojto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ForumController {

    @Autowired MessageRepository mrepo;
    @Autowired TopicRepository trepo;
    @Autowired UserRepository urepo;

    //haetaan kaikki topicit @Juuso
    /*@GetMapping("/topics")
    public String allTopics(Model model) {
        model.addAttribute("topiclist", trepo.findAll());
        return "topic";
    }*/

    // Haetaan kaikki topicit tietystä kategoriasta @Olli,Outi,Heidi,Juuso
    @GetMapping("/topics")
    public String specificTopic (Model model){
        model.addAttribute("topiclist", trepo.findByCategoryId(2));
        return "topic";
    }




}
