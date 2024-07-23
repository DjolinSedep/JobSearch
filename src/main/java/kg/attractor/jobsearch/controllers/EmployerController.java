package kg.attractor.jobsearch.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("employers")
public class EmployerController {

    @PostMapping("createVacancy")
    public String createVacancy() {
        return "Creating a Vacancy";
    }

    @PutMapping("editVacancy")
    public String editVacancy() {
        return "Editing a Vacancy";
    }

    @DeleteMapping("deleteVacancy/{id}")
    public String deleteVacancy(@PathVariable Long id) {
        return "Deleting a Vacancy" + id;
    }

    @GetMapping("searchResume")
    public String searchResume() {
        return "Searching for Resumes";
    }

    @GetMapping("searchByCategory/{category}")
    public String searchByCategory(@RequestParam String category) {
        return "Searching Resumes by Category" + category;
    }

    @GetMapping("searchResponse/{vacancyId}")
    public String searchResponse(@PathVariable Long vacancyId){
        return "Search for applicants who have responded to the vacancy" + vacancyId;
    }


    @GetMapping("searchingApplicants/{employerName}")
    public String searchApplicant(@RequestParam String employerName){
        return "Searching Applicants" + employerName;
    }
}
