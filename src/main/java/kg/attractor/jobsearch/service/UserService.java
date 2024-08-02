package kg.attractor.jobsearch.service;

import io.micrometer.observation.ObservationFilter;
import kg.attractor.jobsearch.dto.UserDto;
import kg.attractor.jobsearch.dto.VacancyDto;

import java.util.List;

public interface UserService {
    public abstract List<UserDto> getAllUser();

    public abstract List<UserDto> getAllUsers();

    public abstract UserDto getUserByName(String name);

    public abstract  UserDto getUserByEmail(String email);

    public abstract UserDto getUserByPhoneNumber(String phoneNumber);

   public abstract boolean checkUserExistsByEmail(String email);

    List<UserDto> getResumesByCategory(String category);

    List<UserDto> getJobsByCategory(String category);

    List<VacancyDto> getVacancyByCategory(String categoryId);

    public abstract List<UserDto> getUserResumes(int userId);


    List<UserDto> getUserAppliedJobs(int userId);

    public abstract List<UserDto> getApplicantsByJobId(int jobId);

    void create(UserDto userDto);

    List<UserDto> getApplicant();

    void addUser(UserDto userDto);

    ObservationFilter updateUser(int id, UserDto userDto);
}
