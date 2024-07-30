package kg.attractor.jobsearch.dao;

import kg.attractor.jobsearch.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserProfileDao {
    private final JdbcTemplate jdbcTemplate;

    // Поиск пользователя по Id
    public Optional<User> findById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id));
    }

    // Редактирование профиля пользователя
    public void updateUserProfile(User user) {
        String sql = "UPDATE users SET name = ?, email = ?, phone_number = ? WHERE id = ?";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getPhoneNumber(), user.getId());
    }
}
