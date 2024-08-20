package kg.attractor.jobsearch.controllers;

import kg.attractor.jobsearch.dto.VacancyDto;
import kg.attractor.jobsearch.service.VacancyService;
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
public class VacancyController {
    private final VacancyService vacancyService;

    @GetMapping("vacancy")
    public String showVacancies(Model model) {
        List<VacancyDto> vacancies = vacancyService.getAllVacancies();
        model.addAttribute("vacancies", vacancies);
        return "users/vacancy";
    }

    @GetMapping("create-vacancy")
    public String createVacancy() {
        return "users/createVacancy";
    }

    @GetMapping("profile-applicant")
    public String showProfileApplicant(Principal principal, Model model) {
        return "users/profile/applicant";
    }

}
