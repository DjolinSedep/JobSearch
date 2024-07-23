package kg.attractor.jobsearch.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("applicants")
public class ApplicantController {

    @PostMapping("createResume")
    public String createResume() {
        return "Creating a Resume";
    }

    @PutMapping("editResume/{id}")
    public String editResume(@PathVariable Long id) {
        return "Editing Resume with ID: ";
    }

    @DeleteMapping("deleteResume/{id}")
    public String deleteResume(@PathVariable Long id) {
        return "Deleting Resume with ID: " + id;
    }

    @GetMapping("searchActiveVacancies")
    public String searchActiveVacancies() {
        return "Searching for all active Vacancies";
    }

    @GetMapping("searchVacancyByCategory")
    public String searchVacancyByCategory(@RequestParam String category) {
        return "Searching Vacancies in Category: " + category;
    }

    @PostMapping("applyForVacancy/{vacancyId}")
    public String applyForVacancy(@PathVariable Long vacancyId) {
        return "Applying for Vacancy with ID: " + vacancyId;
    }

    @GetMapping("searchEmployer")
    public String searchEmployer(@RequestParam String employerName) {
        return "Searching Employer with name: " + employerName;
    }

}
