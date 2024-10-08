package kg.attractor.jobsearch.controllers.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import kg.attractor.jobsearch.dto.UserDto;
import kg.attractor.jobsearch.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("restProfile")
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }


    @GetMapping("/name/{name}")
    public ResponseEntity<UserDto> getUserByName(@PathVariable @NotBlank String name) {
        return ResponseEntity.ok(userService.getUserByName(name));
    }


    @GetMapping("/email/{email}")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable @Email String email) {
        UserDto user = userService.getUserByEmail(email);
        return new ResponseEntity<>(user, HttpStatus.OK);

    }


    @GetMapping("/phone/{phone}")
    public ResponseEntity<UserDto> getUserByPhoneNumber(@PathVariable @NotNull String phone) {
        return ResponseEntity.ok(userService.getUserByPhoneNumber(phone));
    }


    @GetMapping("/exists/{email}")
    public ResponseEntity<Boolean> checkUserExistsByEmail(@PathVariable @Email String email) {
        return ResponseEntity.ok(userService.checkUserExistsByEmail(email));
    }


    @GetMapping("/resumes/category/{category}")
    public ResponseEntity<List<UserDto>> getResumesByCategory(@PathVariable @NotBlank String category) {
        return ResponseEntity.ok(userService.getResumesByCategory(category));
    }


    @GetMapping("/jobs/category/{category}")
    public ResponseEntity<List<UserDto>> getJobsByCategory(@PathVariable @NotBlank String category) {
        return ResponseEntity.ok(userService.getJobsByCategory(category));
    }


    @GetMapping("/{userId}/resumes")
    public ResponseEntity<List<UserDto>> getUserResumes(@PathVariable @NotNull int userId) {
        return ResponseEntity.ok(userService.getUserResumes(userId));
    }


    @GetMapping("/{userId}/applied-jobs")
    public ResponseEntity<List<UserDto>> getUserAppliedJobs(@PathVariable @NotNull int userId) {
        return ResponseEntity.ok(userService.getUserAppliedJobs(userId));
    }


    @GetMapping("/applicants/{jobId}")
    public ResponseEntity<List<UserDto>> getApplicantsByJobId(@PathVariable @NotNull int jobId) {
        return ResponseEntity.ok(userService.getApplicantsByJobId(jobId));
    }


    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto userDto) {
        userService.addUser(userDto);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }
}
