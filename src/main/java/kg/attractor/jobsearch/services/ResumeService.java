package kg.attractor.jobsearch.services;

import kg.attractor.jobsearch.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

public class ResumeService {
    @Component
    @RequiredArgsConstructor
    public class UserDao {
        private final JdbcTemplate jdbcTemplate;

        public List<User> getAllUsers() {
            String sql = "SELECT * FROM users";
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        }
    }
}
