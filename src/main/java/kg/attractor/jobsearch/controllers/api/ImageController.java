package kg.attractor.jobsearch.controllers.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("images")
@RestController
public class ImageController {

     @GetMapping("upload")
    public String uploadImage(@RequestParam("file") MultipartFile file){
        return "Uploading a user's avatar";
    }
}
