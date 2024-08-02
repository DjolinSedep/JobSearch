package kg.attractor.jobsearch.service.Impl;

import kg.attractor.jobsearch.dao.VacancyDao;
import kg.attractor.jobsearch.dto.UserDto;
import kg.attractor.jobsearch.dto.VacancyDto;
import kg.attractor.jobsearch.entity.Vacancy;
import kg.attractor.jobsearch.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VacancyServiceImpl implements VacancyService {
    private final VacancyDao vacancyDao;

    @Override
    public List<VacancyDto> getByApplicantId(int applicantId) {
        var list = vacancyDao.findByApplicantId(applicantId);

        return list.stream()
                .map(e -> VacancyDto.builder()
                        .id(e.getId())
                        .Name(e.getName())
                        .description(e.getDescription())
                        .categoryId(e.getCategoryId())
                        .salary(e.getSalary())
                        .expFrom(e.getExpFrom())
                        .expTo(e.getExpTo())
                        .isActive(e.getIsActive())
                        .authorId(e.getAuthorId())
                        .build())
                .toList();
    }

    @Override
    public List<VacancyDto> getAllVacancies(){
        var list = vacancyDao.findAll();

        return list.stream()
                .map(e -> VacancyDto.builder()
                        .id(e.getId())
                        .Name(e.getName())
                        .description(e.getDescription())
                        .categoryId(e.getCategoryId())
                        .salary(e.getSalary())
                        .expFrom(e.getExpFrom())
                        .expTo(e.getExpTo())
                        .isActive(e.getIsActive())
                        .authorId(e.getAuthorId())
                        .build())
                .toList();
    }

    @Override
    public List<VacancyDto> getApplicantByVacancyId(int vacancy_id) {
        return List.of();
    }


    @Override
    public List<VacancyDto> getByCategoryId(int categoryId){
        var list = vacancyDao.findByCategoryId(categoryId);

        return list.stream()
                .map(e -> VacancyDto.builder()
                        .id(e.getId())
                        .Name(e.getName())
                        .description(e.getDescription())
                        .categoryId(e.getCategoryId())
                        .salary(e.getSalary())
                        .expFrom(e.getExpFrom())
                        .expTo(e.getExpTo())
                        .isActive(e.getIsActive())
                        .authorId(e.getAuthorId())
                        .build())
                .toList();
    }

    @Override
    public List<UserDto> getApplicantsByVacancyId(int vacancyId){
        var list = vacancyDao.findApplicantsByVacancyId(vacancyId);

        return list.stream()
                .map(e -> UserDto.builder()
                        .id(e.getId())
                        .name(e.getName())
                        .surname(e.getSurname())
                        .email(e.getEmail())
                        .age(e.getAge())
                        .phoneNumber(e.getPhoneNumber())
                        .password(e.getPassword())
                        .build())
                .toList();
    }

    @Override
    public void deleteById(int vacancyId){
        vacancyDao.deleteById(vacancyId);
    }

    @Override
    public void create(VacancyDto vacancyDto){
        Vacancy vacancy = Vacancy.builder()
                .name(vacancyDto.getName())
                .description(vacancyDto.getDescription())
                .categoryId(vacancyDto.getCategoryId())
                .salary(vacancyDto.getSalary())
                .expFrom(vacancyDto.getExpFrom())
                .expTo(vacancyDto.getExpTo())
                .isActive(vacancyDto.isActive())
                .authorId(vacancyDto.getAuthorId())
                .createdDate(LocalDate.now())
                .updateDate(LocalDate.now())
                .build();
        vacancyDao.createVacancy(vacancy);
    }

    @Override
    public void applyVacancies(int resume_id, int vacancy_id) {
    }

    @Override
    public List<VacancyDto> getActiveVacancies(){
        var list = vacancyDao.findActiveVacancies();

        return list.stream()
                .map(e -> VacancyDto.builder()
                        .id(e.getId())
                        .Name(e.getName())
                        .description(e.getDescription())
                        .categoryId(e.getCategoryId())
                        .salary(e.getSalary())
                        .expFrom(e.getExpFrom())
                        .expTo(e.getExpTo())
                        .isActive(e.getIsActive())
                        .authorId(e.getAuthorId())
                        .build())
                .toList();
    }

    @Override
    public void applyToVacancy(int resumeId, int vacancyId) {
        vacancyDao.applyToVacancy(resumeId, vacancyId);
    }

    @Override
    public void edit(VacancyDto vacancyDto){
        Vacancy vacancy = Vacancy.builder()
                .id(vacancyDto.getId())
                .name(vacancyDto.getName())
                .description(vacancyDto.getDescription())
                .categoryId(vacancyDto.getCategoryId())
                .salary(vacancyDto.getSalary())
                .expFrom(vacancyDto.getExpFrom())
                .expTo(vacancyDto.getExpTo())
                .isActive(vacancyDto.isActive())
                .authorId(vacancyDto.getAuthorId())
                .updateDate(LocalDate.now())
                .build();
        vacancyDao.editVacancy(vacancy);
    }

    @Override
    public List<VacancyDto> getVacancyByCategory(String categoryId) {
        List<Vacancy> list = vacancyDao.findVacancyByCategory(categoryId);
        return list.stream()
                .map(e -> VacancyDto.builder()
                        .id(e.getId())
                        .Name(e.getName())
                        .description(e.getDescription())
                        .categoryId(e.getCategoryId())
                        .salary(e.getSalary())
                        .expFrom(e.getExpFrom())
                        .expTo(e.getExpTo())
                        .isActive(e.getIsActive())
                        .authorId(e.getAuthorId())
                        .build())
                .collect(Collectors.toList());
    }
}
