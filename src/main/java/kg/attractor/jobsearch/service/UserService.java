package kg.attractor.jobsearch.service;

import kg.attractor.jobsearch.dto.UserDto;

import java.util.List;

public abstract class UserService {
    public abstract List<UserDto> getAllUser();

    public abstract List<UserDto> getAllUsers();

    public abstract UserDto getUserByName(String name);

    public abstract  UserDto getUserByEmail(String email);

    public abstract UserDto getUserByPhoneNumber(String phoneNumber);

   public abstract boolean checkUserExistsByEmail(String email);

    public abstract UserDto getUserByPhoneNumber(int phoneNumber);

    public abstract List<UserDto> getResumesByCategory(String category);

   public abstract List<UserDto> getJobsByCategory(String category);

   public abstract List<UserDto> getUserResumes(int userId);

    public abstract List<UserDto> getUserAppliedJobs(int userId);

   public abstract List<UserDto> getApplicantsByJobId(int jobId);
}
