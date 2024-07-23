package kg.attractor.jobsearch.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("userAvatar")
@RestController
public class UserController {

     @GetMapping("/upload")
    public String uploadImage(){
        return "Uploading a user's avatar";
    }
}
