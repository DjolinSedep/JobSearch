package kg.attractor.jobsearch.controllers;

import kg.attractor.jobsearch.dto.ResumeDto;
import kg.attractor.jobsearch.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

//    @PostMapping("/save-resume")
//    public String saveResume(@RequestParam String name,
//                             @RequestParam String Category_id,
//                             @RequestParam int salary,
//                             Principal principal) {
//
//        resumeService.saveResume(name, Category_id , salary, principal.getName());
//        return "redirect:/profile";
//    }

    @GetMapping("create-resume")
    public String createResume() {
        return "users/createResume";
    }

    @GetMapping("profile-employer")
     public String showProfileEmployeer(Model model, Principal principal) {
        return "users/profile/mployer";
    }

}


