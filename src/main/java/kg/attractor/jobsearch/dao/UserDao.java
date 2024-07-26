package kg.attractor.jobsearch.dao;

import kg.attractor.jobsearch.model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDao {


    public List<User> getAllUsers() {
            String sql = "SELECT * FROM users";
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        }
    }

