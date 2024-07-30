package kg.attractor.jobsearch.dao;

import kg.attractor.jobsearch.model.Resume;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ResumeDao<Experience, Education> {
    private final JdbcTemplate jdbcTemplate;


    public Optional<Resume> findById(int resumeId) {
        String sql = "SELECT * FROM resumes WHERE id = ?";
        return Optional.ofNullable(jdbcTemplate.queryForObject(
                sql, new BeanPropertyRowMapper<>(Resume.class), resumeId));
    }


    public List<Resume> findAllByUserId(int userId) {
        String sql = "SELECT * FROM resumes WHERE user_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Resume.class), userId);
    }


    public <Education> void addResume(Resume resume) {
        String sql = "INSERT INTO resumes (user_id, title, category, summary) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, resume.getUserId(), resume.getTitle(), resume.getCategory(), resume.getSummary());


        for (Education education : resume.getEducations()) {
            addEducation(resume.getId(), education);
        }


        for (Experience experience : resume.getExperiences()) {
            addExperience(resume.getId(), experience);
        }
    }


    public void updateResume(Resume resume) {
        String sql = "UPDATE resumes SET title = ?, category = ?, summary = ? WHERE id = ?";
        jdbcTemplate.update(sql, resume.getTitle(), resume.getCategory(), resume.getSummary(), resume.getId());

        deleteEducationsByResumeId(resume.getId());
        for (Education education : resume.getEducations()) {
            addEducation(resume.getId(), education);
        }


        deleteExperiencesByResumeId(resume.getId());
        for (Experience experience : resume.getExperiences()) {
            addExperience(resume.getId(), experience);
        }
    }

    public void deleteResume(int resumeId) {

        deleteEducationsByResumeId(resumeId);
        deleteExperiencesByResumeId(resumeId);

        String sql = "DELETE FROM resumes WHERE id = ?";
        jdbcTemplate.update(sql, resumeId);
    }


    private void addEducation(int resumeId, Education education) {
        String sql = "INSERT INTO education (resume_id, institution, degree, start_date, end_date) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, resumeId, education.getInstitution(), education.getDegree(), education.getStartDate(), education.getEndDate());
    }


    private void addExperience(int resumeId, Experience experience) {
        String sql = "INSERT INTO experience (resume_id, company, position, start_date, end_date) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, resumeId, experience.getCompany(), experience.getPosition(), experience.getStartDate(), experience.getEndDate());
    }


    private void deleteEducationsByResumeId(int resumeId) {
        String sql = "DELETE FROM education WHERE resume_id = ?";
        jdbcTemplate.update(sql, resumeId);
    }


    private void deleteExperiencesByResumeId(int resumeId) {
        String sql = "DELETE FROM experience WHERE resume_id = ?";
        jdbcTemplate.update(sql, resumeId);
    }

}
