package kg.attractor.jobsearch.service.Impl;

import kg.attractor.jobsearch.dao.UserDao;
import kg.attractor.jobsearch.dto.UserDto;
import kg.attractor.jobsearch.model.User;
import kg.attractor.jobsearch.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Override
    public List<UserDto> getAllUser() {
        return List.of();
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> list = userDao.getAllUsers();
        return list.stream()
                .map(e -> UserDto.builder()
                        .id(e.getId())
                        .name(e.getName())
                        .email(e.getEmail())
                        .number(e.getPhoneNumber())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getUserByName(String name) {
        User user = userDao.findUserByName(name)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return UserDto.builder()
                .name(user.getName())
                .number(user.getPhoneNumber())
                .email(user.getEmail())
                .build();
    }


    @Override
    public UserDto getUserByEmail(String email) {
        User user = userDao.findUserByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .number(user.getPhoneNumber())
                .email(user.getEmail())
                .build();
    }

    @Override
    public UserDto getUserByPhoneNumber(String phoneNumber) {
        return null;
    }

    @Override
    public UserDto getUserByPhoneNumber(int phoneNumber) {
        User user = userDao.findUserByNumber(phoneNumber)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .number(user.getPhoneNumber())
                .email(user.getEmail())
                .build();
    }

    @Override
    public List<UserDto> getResumesByCategory(String category) {
        List<User> list = userDao.findResumesByCategory(category);
        return list.stream()
                .map(e -> UserDto.builder()
                        .id(e.getId())
                        .name(e.getName())
                        .email(e.getEmail())
                        .number(e.getPhoneNumber())
                        .build())
                .collect(Collectors.toList());
    }
    @Override
    public List<UserDto> getJobsByCategory(String category) {
        List<User> list = userDao.findJobsByCategory(category);
        return list.stream()
                .map(e -> UserDto.builder()
                        .id(e.getId())
                        .name(e.getName())
                        .email(e.getEmail())
                        .number(e.getPhoneNumber())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> getUserResumes(int userId) {
        List<User> list = userDao.findResumesByUserId(userId);
        return list.stream()
                .map(e -> UserDto.builder()
                        .id(e.getId())
                        .name(e.getName())
                        .email(e.getEmail())
                        .number(e.getPhoneNumber())
                        .build())
                .collect(Collectors.toList());
    }
    @Override
    public List<UserDto> getUserAppliedJobs(int userId) {
        List<User> list = userDao.findAppliedJobsByUserId(userId);
        return list.stream()
                .map(e -> UserDto.builder()
                        .id(e.getId())
                        .name(e.getName())
                        .email(e.getEmail())
                        .number(e.getPhoneNumber())
                        .build())
                .collect(Collectors.toList());
    }
    @Override
    public boolean checkUserExistsByEmail(String email) {
        return userDao.existsByEmail(email);
    }
    @Override
    public List<UserDto> getApplicantsByJobId(int jobId) {
        List<User> list = userDao.findApplicantsByJobId(jobId);
        return list.stream()
                .map(e -> UserDto.builder()
                        .id(e.getId())
                        .name(e.getName())
                        .email(e.getEmail())
                        .number(e.getPhoneNumber())
                        .build())
                .collect(Collectors.toList());
    }
}
