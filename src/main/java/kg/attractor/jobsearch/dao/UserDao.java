package kg.attractor.jobsearch.dao;

import kg.attractor.jobsearch.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserDao {
    private final JdbcTemplate jdbcTemplate;


    public List<User> findByName(String name) {
        String sql = "SELECT * FROM users WHERE name LIKE = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), "%" + name + "%");
    }


    public Optional<User> findByPhoneNumber(String phoneNumber) {
        String sql = "SELECT * FROM  User WHERE phone_number = ?";
        return Optional.ofNullable(DataAccessUtils.singleResult(jdbcTemplate.query(
                sql, new BeanPropertyRowMapper<>(User.class), phoneNumber
        )));
    }

    public Optional<User> findByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        return Optional.ofNullable(DataAccessUtils.singleResult(jdbcTemplate.query(
                sql, new BeanPropertyRowMapper<>(User.class), email
        )));
    }


    public boolean existsByEmail(String email) {
        String sql = "SELECT COUNT(*) FROM users WHERE email = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, email);
        return count != null && count > 0;
    }


    public List<User> findResumesByCategory(String category) {
        String sql = "SELECT * FROM resumes WHERE category = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), category);
    }


    public List<User> getAllJobs() {
        String sql = "SELECT * FROM jobs";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }


    public List<User> findJobsByCategory(String category) {
        String sql = "SELECT * FROM jobs WHERE category = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), category);
    }


    public List<User> findResumesByUserId(int userId) {
        String sql = "SELECT * FROM resumes WHERE user_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), userId);
    }


    public List<User> findAppliedJobsByUserId(int userId) {
        String sql = "SELECT Vacancy .* FROM jobs INNER JOIN applications ON jobs.id = applications.job_id WHERE applications.resume_id IN (SELECT id FROM resumes WHERE user_id = ?)";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), userId);
    }


    public List<User> findApplicantsByJobId(int jobId) {
        String sql = "SELECT users.* FROM users INNER JOIN resumes ON users.id = resumes.user_id INNER JOIN applications ON resumes.id = applications.resume_id WHERE applications.job_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), jobId);
    }



}
