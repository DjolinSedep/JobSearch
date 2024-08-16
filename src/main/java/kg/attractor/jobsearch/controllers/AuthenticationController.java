package kg.attractor.jobsearch.controllers;

import ch.qos.logback.core.model.Model;
import kg.attractor.jobsearch.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("authentication")
public class AuthenticationController {
    private final UserService userService;

    @GetMapping("registration")
    public String registration(){
        return "authentication/registration";
    }

    @GetMapping("login")
    public String login() {
        return "user/index";
    }
    public class UserController {
        private final UserService userService;

        public UserController(UserService userService) {
            this.userService = userService;
        }

        @GetMapping
        public String getUser(Model model) {
            var users = userService.getAllUsers();
            return "index";
        }
    }
}
