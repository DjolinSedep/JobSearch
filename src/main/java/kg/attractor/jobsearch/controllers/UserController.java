package kg.attractor.jobsearch.controllers;

import kg.attractor.jobsearch.dto.UserDto;
import kg.attractor.jobsearch.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }


    @GetMapping("/name/{name}")
    public ResponseEntity<UserDto> getUserByName(@PathVariable String name) {
        return ResponseEntity.ok(userService.getUserByName(name));
    }


    @GetMapping("/email/{email}")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable String email) {
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }


    @GetMapping("/phone/{phone}")
    public ResponseEntity<UserDto> getUserByPhoneNumber(@PathVariable String phone) {
        return ResponseEntity.ok(userService.getUserByPhoneNumber(phone));
    }


    @GetMapping("/exists/{email}")
    public ResponseEntity<Boolean> checkUserExistsByEmail(@PathVariable String email) {
        return ResponseEntity.ok(userService.checkUserExistsByEmail(email));
    }


    @GetMapping("/resumes/category/{category}")
    public ResponseEntity<List<UserDto>> getResumesByCategory(@PathVariable String category) {
        return ResponseEntity.ok(userService.getResumesByCategory(category));
    }


    @GetMapping("/jobs/category/{category}")
    public ResponseEntity<List<UserDto>> getJobsByCategory(@PathVariable String category) {
        return ResponseEntity.ok(userService.getJobsByCategory(category));
    }


    @GetMapping("/{userId}/resumes")
    public ResponseEntity<List<UserDto>> getUserResumes(@PathVariable int userId) {
        return ResponseEntity.ok(userService.getUserResumes(userId));
    }


    @GetMapping("/{userId}/applied-jobs")
    public ResponseEntity<List<UserDto>> getUserAppliedJobs(@PathVariable int userId) {
        return ResponseEntity.ok(userService.getUserAppliedJobs(userId));
    }


    @GetMapping("/applicants/{jobId}")
    public ResponseEntity<List<UserDto>> getApplicantsByJobId(@PathVariable int jobId) {
        return ResponseEntity.ok(userService.getApplicantsByJobId(jobId));
    }

}
