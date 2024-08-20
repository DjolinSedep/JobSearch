package kg.attractor.jobsearch.controllers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class UserController {

    @GetMapping("/")
    public String home(Model model, Principal principal) {
        if (principal == null) {
            return "index";
        } else {
            return "home";
        }

    }
}
