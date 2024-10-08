package kg.attractor.jobsearch.controllers.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("account")
@RestController
public class AccountController {

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestParam String name,
                                               @RequestParam String password,
                                               @RequestParam String role) {

        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
    }
}
