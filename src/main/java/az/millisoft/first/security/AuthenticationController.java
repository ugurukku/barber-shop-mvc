package az.millisoft.first.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AuthenticationController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
