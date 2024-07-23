package kg.attractor.jobsearch.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("images")
@RestController
public class ImageController {

     @GetMapping("upload")
    public String uploadImage(){
        return "Uploading a user's avatar";
    }
}
