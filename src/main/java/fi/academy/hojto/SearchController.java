package fi.academy.hojto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class SearchController {

    @Autowired
    MessageRepository mrepo;
    @Autowired
    TopicRepository trepo;
    @Autowired
    UserRepository urepo;

    @GetMapping("/search")
    @Transactional
    public String hakulomake(Model model) {
        Message msg = new Message();
        model.addAttribute("msg", msg);
        return "search";
    }


    @PostMapping("/searchResult")
    public String searchMessageContainingWord(Message message, Model model) {
        List<Message> m = mrepo.findByContentContains(message.getContent());
        model.addAttribute("postlist", m);
        return "searchresult";
    }

    //sivuille lisätty nappi päävalikkoon, joka löytää alkuun maååingin ja palauttaa etusivun
    @GetMapping("/alkuun")
    public String takasAalkuun () {
        return "frontpage";

    }
}
