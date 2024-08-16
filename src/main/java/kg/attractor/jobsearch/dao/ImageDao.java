package kg.attractor.jobsearch.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ImageDao {
    private JdbcTemplate jdbcTemplate;

    public void updateAvatar(long user, String avatarPath) {
        String sql = " update USERS set avatar = ? where id = ? ";
        jdbcTemplate.update(sql, user, avatarPath);
    }
}