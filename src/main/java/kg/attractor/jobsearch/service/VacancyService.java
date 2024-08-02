package kg.attractor.jobsearch.service;

import kg.attractor.jobsearch.dto.UserDto;
import kg.attractor.jobsearch.dto.VacancyDto;

import java.util.List;

public interface VacancyService {

    List<VacancyDto> getByApplicantId(int applicantId);

    List<VacancyDto> getAllVacancies();

    List<VacancyDto> getApplicantByVacancyId(int vacancy_id);

    List<VacancyDto> getActiveVacancies();

    void applyToVacancy(int resumeId, int vacancyId);

    void edit(VacancyDto vacancyDto);

    List<VacancyDto> getByCategoryId(int categoryId);

    List<UserDto> getApplicantsByVacancyId(int vacancyId);

    void deleteById(int vacancyId);

    void create(VacancyDto vacancyDto);

    void applyVacancies(int resume_id, int vacancy_id);

    List<VacancyDto> getVacancyByCategory(String categoryId);
}
