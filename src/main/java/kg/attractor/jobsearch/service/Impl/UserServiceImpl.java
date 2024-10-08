package kg.attractor.jobsearch.service.Impl;
import io.micrometer.observation.ObservationFilter;
import kg.attractor.jobsearch.dao.UserDao;
import kg.attractor.jobsearch.dao.VacancyDao;
import kg.attractor.jobsearch.dto.UserDto;
import kg.attractor.jobsearch.dto.VacancyDto;
import kg.attractor.jobsearch.model.User;
import kg.attractor.jobsearch.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final VacancyDao vacancyDao;

    @Override
    public List<UserDto> getUsers() {
        var users = userDao.getAllUsers();
        return users.stream()
             .map(this::convertToDto)
                .toList();
    }

    private UserDto convertToDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .password(user.getPassword())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .age(user.getAge())
                .build();
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> list = userDao.getAllUsers();
        return list.stream()
                .map(e -> UserDto.builder()
                        .id(e.getId())
                        .name(e.getName())
                        .surname(e.getSurname())
                        .password(e.getPassword())
                        .email(e.getEmail())
                        .phoneNumber(e.getPhoneNumber())
                        .age(e.getAge())
                        .build())
                .collect(toList());
    }

    @Override
    public UserDto getUserByName(String name) {
        User user = userDao.findUserByName(name)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .password(user.getPassword())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .age(user.getAge())
                .build();

    }


    @Override
    public UserDto getUserByEmail(String email) {
        User user = userDao.findUserByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .password(user.getPassword())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .age(user.getAge())
                .build();

    }

    @Override
    public UserDto getUserByPhoneNumber(String phoneNumber) {
        User user = userDao.findUserByNumber(phoneNumber);
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .password(user.getPassword())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .age(user.getAge())
                .build();

    }

    @Override
    public boolean checkUserExistsByEmail(String email) {
        return false;
    }

    @Override
    public List<UserDto> getResumesByCategory(String category) {
        return List.of();
    }

    @Override
    public List<UserDto> getJobsByCategory(String category) {
        List<User> list = userDao.findVacancyByCategory(category);
        return list.stream()
                .map(e -> UserDto.builder()
                        .id(e.getId())
                        .name(e.getName())
                        .surname(e.getSurname())
                        .password(e.getPassword())
                        .email(e.getEmail())
                        .phoneNumber(e.getPhoneNumber())
                        .age(e.getAge())
                        .build())
                .toList();

    }

    @Override
    public List<VacancyDto> getVacancyByCategory(String categoryId) {
        return List.of();
    }

    @Override
    public List<UserDto> getUserResumes(int userId) {
        List<User> list = userDao.findResumesByUserId(userId);
        return list.stream()
                .map(e -> UserDto.builder()
                        .id(e.getId())
                        .name(e.getName())
                        .surname(e.getSurname())
                        .password(e.getPassword())
                        .email(e.getEmail())
                        .phoneNumber(e.getPhoneNumber())
                        .age(e.getAge())
                        .build())
                .toList();
    }


    @Override
    public List<UserDto> getUserAppliedJobs(int userId) {
        List<User> list = userDao.findResumesByUserId(userId);
        return list.stream()
                .map(e -> UserDto.builder()
                        .id(e.getId())
                        .name(e.getName())
                        .surname(e.getSurname())
                        .password(e.getPassword())
                        .email(e.getEmail())
                        .phoneNumber(e.getPhoneNumber())
                        .age(e.getAge())
                        .build())
                .toList();
    }

    @Override
    public List<UserDto> getApplicantsByJobId(int jobId) {
        return List.of();
    }

    @Override
    public void create(UserDto userDto){

        return;
    }

    @Override
    public List<UserDto> getApplicant() {
        return List.of();
    }

    @Override
    public void addUser(UserDto userDto) {

    }

    @Override
    public ObservationFilter updateUser(int id, UserDto userDto) {
        return null;
    }

}
