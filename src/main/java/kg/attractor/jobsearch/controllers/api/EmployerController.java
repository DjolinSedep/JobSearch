package kg.attractor.jobsearch.controllers.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("employers")
public class EmployerController {

    @PostMapping("createVacancy")
    public String createVacancy() {
        return "CreatingVacancy";
    }

    @PutMapping("editVacancy")
    public String editVacancy() {
        return "EditingVacancy";
    }

    @DeleteMapping("deleteVacancy/{id}")
    public String deleteVacancy(@PathVariable Long id) {
        return "DeletingVacancy" + id;
    }

    @GetMapping("searchResume")
    public String searchResume() {
        return "SearchingResumes";
    }

    @GetMapping("searchByCategory/{category}")
    public String searchByCategory(@RequestParam String category) {
        return "SearchingResumesCategory" + category;
    }

    @GetMapping("searchResponse/{vacancyId}")
    public String searchResponse(@PathVariable Long vacancyId){
        return "Search for applicants who have responded to the vacancy" + vacancyId;
    }

}
