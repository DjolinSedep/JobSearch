package kg.attractor.jobsearch.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("authentication")
public class AuthenticationController {

    @GetMapping("registration")
    public String registration(){
        return "users/register";
    }

    @GetMapping("login")
    public String login() {
        return "users/index";
    }

//    @PostMapping("/register/employer")
//    public String registerEmployer(@ModelAttribute EmployerForm form) {
//        // Логика регистрации работодателя
//        return "redirect:/";
//    }

}
