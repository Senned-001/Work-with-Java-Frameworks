package sweeter.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sweeter.domen.Message;
import sweeter.repos.MessageRepo;
import java.util.Map;

/**
    Task: https://www.youtube.com/watch?v=jH17YkBTpI4&list=PLU2ftbIeotGpAYRP9Iv2KLIwK36-o_qYk
    WebMVCApplication on SpringBoot with connect to DB(MySQL+JPA) and authorization(SpringSecurity)

 */

@Controller
public class MainController {
    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/")
        public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model){
        Iterable<Message> messages = messageRepo.findAll(); //get list of messages from repo
        model.put("messages", messages);                    //add them to model
        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam String text,@RequestParam String tag, Map<String, Object> model){
        Message message = new Message(text, tag);
        messageRepo.save(message);

        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model){

        Iterable<Message> messages;

        if (filter != null && !filter.isEmpty()) {
            messages = messageRepo.findByTag(filter);
        } else {
            messages = messageRepo.findAll();           //if filter empty return all list of messages
        }

        model.put("messages", messages);
        return "main";
    }
}
