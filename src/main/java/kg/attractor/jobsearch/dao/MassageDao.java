package kg.attractor.jobsearch.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MassageDao {
    private final JdbcTemplate jdbcTemplate;

    public void deletedById (long id) {
        String sql = "DELETE FROM PUBLIC.MESSAGES WHERE RESPONDED_APPLICANTS IN (SELECT id from RESPONDED_APPLICANTS WHERE RESUME_ID = ?)";
        jdbcTemplate.update(sql, id);

    }

}
