package fi.academy.hojto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    MessageRepository mrepo;
    @Autowired
    TopicRepository trepo;
    @Autowired
    UserRepository urepo;

    @GetMapping("/search")
    public String jotain(Model model) {
        return "seach";
    }

    @PostMapping("/searchResult")
    public String searchMessageContainingWord(Message message, Model model) {
        List<Message> ce = mrepo.findByContentContains(message.getContent());
        model.addAttribute("messages", ce);
        return "posts";
    }
}
