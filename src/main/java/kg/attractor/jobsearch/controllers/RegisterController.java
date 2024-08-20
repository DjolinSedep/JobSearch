package kg.attractor.jobsearch.controllers;

import kg.attractor.jobsearch.model.User;
import kg.attractor.jobsearch.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class RegisterController {
    private final UserService userService;


    @PostMapping("/registerUser")
    public String registerUser
            (@RequestParam("userType") String userType,
             @RequestParam("fullName") String fullName,
             @RequestParam("email") String email,
             @RequestParam("phone") String phone,
             @RequestParam("password") String password,
             @RequestParam(value = "companyName", required = false) String companyName,
             @RequestParam(value = "contactPerson", required = false) String contactPerson) {

        User user = new User();
        user.setSurname(fullName);
        user.setEmail(email);
        user.setPhoneNumber(phone);
        user.setPassword(password);

        userService.saveUser(user);


        if ("registerUser".equals(userType)) {
            return "redirect:/profile-applicant";
        } else {
            return "redirect:/profile-employer";
        }
    }

}

