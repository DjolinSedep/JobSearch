package kg.attractor.jobsearch.controllers;

import kg.attractor.jobsearch.dto.ResumeDto;
import kg.attractor.jobsearch.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class ResumeController {
    private final ResumeService resumeService;

    @GetMapping("resume")
    public String showResume(Model model) {
        List<ResumeDto> resumes = resumeService.getAllResumes();
        model.addAttribute("resumes", resumes);
        return "users/resume";
    }

    @GetMapping("create-resume")
    public String createResume() {
        return "users/createResume";
    }

    @GetMapping("profile-employer")
     public String showProfileEmployeer(Model model, Principal principal) {
        return "users/profileEmployer";
    }

    @GetMapping("profile-employer")
    public String employerProfile(@SessionAttribute("userFullName") String fullName,
                                  @SessionAttribute("userEmail") String email,
                                  @SessionAttribute("userPhone") String phone,
                                  Model model) {
        model.addAttribute("fullName", fullName);
        model.addAttribute("email", email);
        model.addAttribute("phone", phone);
        return "users/profile-employer";
    }
}


