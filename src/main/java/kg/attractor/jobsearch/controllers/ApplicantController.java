package kg.attractor.jobsearch.controllers;

import jakarta.validation.Valid;
import kg.attractor.jobsearch.dto.ResumeDto;
import kg.attractor.jobsearch.dto.UserDto;
import kg.attractor.jobsearch.dto.VacancyDto;
import kg.attractor.jobsearch.service.ResumeService;
import kg.attractor.jobsearch.service.UserService;
import kg.attractor.jobsearch.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("applicants")
@RequiredArgsConstructor
public class ApplicantController {
    private final ResumeService resumeService;
    private final VacancyService vacancyService;
    private final UserService userService;

    @PostMapping("create/resume")
    public ResponseEntity<?> createResume(@RequestBody @Valid ResumeDto resumeDto){
        resumeService.create(resumeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Resume is created");
    }

    @PutMapping("edit/resume/{id}")
    public ResponseEntity<?> editResume(@PathVariable int id, @RequestBody ResumeDto resumeDto) {
        resumeDto.setId(id);
        resumeService.edit(resumeDto);
        return ResponseEntity.ok("Vacancy is updated");
    }

    @DeleteMapping("delete/resume")
    public ResponseEntity<?> deleteResume(@RequestParam int resumeId){
        resumeService.deleteById(resumeId);
        return ResponseEntity.ok("resume is deleted with id " + resumeId);
    }


    @GetMapping("search/active-vacancies")
    public ResponseEntity<List<VacancyDto>> searchActiveVacancies(){
        return ResponseEntity.ok(vacancyService.getActiveVacancies());
    }

    @GetMapping("search/vacancies/category-id")
    public ResponseEntity<List<VacancyDto>> searchVacancyByCategory(@RequestParam int categoryId){
        return ResponseEntity.ok(vacancyService.getByCategoryId(categoryId));
    }

    @PostMapping("vacancy/apply")
    public ResponseEntity<?> responseVacancy(@RequestParam int resumeId, @RequestParam int vacancyId){
        vacancyService.applyToVacancy(resumeId, vacancyId);
        return ResponseEntity.status(HttpStatus.OK).body("Successful applied to vacancy with id " + vacancyId);
    }

    @GetMapping("search/Applicant")
    public ResponseEntity<List<UserDto>> searchCompany(){
        return ResponseEntity.ok(userService.getApplicant());
    }

    @GetMapping("get-all-vacancies")
    public ResponseEntity<List<VacancyDto>> getAllVacancies(){
        return ResponseEntity.ok(vacancyService.getAllVacancies());
    }

    @GetMapping("search-vacancies-by-applicant-id")
    public ResponseEntity<List<VacancyDto>> searchVacancies(@RequestParam int applicantId){
        return ResponseEntity.ok(vacancyService.getByApplicantId(applicantId));
    }

}
