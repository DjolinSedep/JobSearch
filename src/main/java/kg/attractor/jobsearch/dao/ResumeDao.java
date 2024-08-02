package kg.attractor.jobsearch.dao;


import kg.attractor.jobsearch.entity.Resume;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ResumeDao {
    private final JdbcTemplate jdbcTemplate;


    public List<Resume> findAll() {
        String sql = "SELECT * FROM resumes";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Resume.class));
    }


    public Optional<Resume> findByCategoryId(int categoryId) {
        String sql = "select * from resumes where category_id = ?";
        return Optional.ofNullable(
                DataAccessUtils.singleResult(
                        jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Resume.class), categoryId)
                )
        );
    }

    public List<Resume> findByApplicantId(int applicantId) {
        String sql = "select * from resumes where applicant_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Resume.class), applicantId);
    }

    public void deleteById(int resumeId) {
        String sql = "delete from resumes where id = ?";
        jdbcTemplate.update(sql, resumeId);
    }

    public void createResume(Resume resume) {
        String sql = "insert into resumes (applicant_id, name, category_id, salary, is_active, created_date, update_time) values (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                resume.getApplicantId(),
                resume.getName(),
                resume.getCategoryId(),
                resume.getSalary(),
                resume.getIsActive(),
                resume.getCreatedDate(),
                resume.getUpdatedTime());
    }

    public void editResume(Resume resume){
        String sql = "update resumes set applicant_id = ?, name = ?, category_id = ?, salary = ?, is_active = ?, created_date = ?, update_time = ? where id = ?";
        jdbcTemplate.update(sql, resume.getApplicantId(), resume.getName(), resume.getCategoryId(), resume.getSalary(), resume.getIsActive(), resume.getCreatedDate(), resume.getUpdatedTime(), resume.getId());
    }
}
