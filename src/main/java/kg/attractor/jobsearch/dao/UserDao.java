package kg.attractor.jobsearch.dao;

import kg.attractor.jobsearch.dto.UserDto;
import kg.attractor.jobsearch.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Struct;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserDao {
    private final JdbcTemplate jdbcTemplate;


    public List<User> getAllUsers() {
        String sql = "select * from users";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));

    }

    public User findUserByNumber(String phoneNumber) {
        String sql = "select * from users where LOWER(name)  = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), phoneNumber);
    }

    public List<User> findResumesByUserId(int userId) {
        String aql = "select * from users where id = ?";
        return jdbcTemplate.query(aql, new BeanPropertyRowMapper<>(User.class), userId);

    }

    public Optional<User> findUserByEmail(String email) {
        String sql = "select * from users where email = ?";
        return Optional.ofNullable(
                        DataAccessUtils.singleResult(
                           jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), email)
                        ));
    }

    public Optional<User> findUserByName(String name) {
        String sql = "select * from users where LOWER(name) = ?";
        return Optional.ofNullable(
                DataAccessUtils.singleResult(
                        jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), name)
                ));
    }

}
