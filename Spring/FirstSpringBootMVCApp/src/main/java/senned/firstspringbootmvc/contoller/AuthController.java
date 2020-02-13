package senned.firstspringbootmvc.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
public class AuthController {
    @RequestMapping(value = "/auth")
    public String AuthController(@RequestParam(name = "login", required = false, defaultValue = "none") String login,
                                 @RequestParam(name = "password", required = false, defaultValue = "none") String password,
                                 Model model){
        HashMap<String,String>usersData = new HashMap<>();
        usersData.put("Audry","asdfg");
        usersData.put("Jim","qwerty");

        if(login.equals("none")||password.equals("none")||!usersData.containsKey(login)||!usersData.get(login).equals(password))
            return "noauth";
        model.addAttribute("login", login);
        return "auth";
    }
}
