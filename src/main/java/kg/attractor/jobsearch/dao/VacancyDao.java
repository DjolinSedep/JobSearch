package kg.attractor.jobsearch.dao;

import kg.attractor.jobsearch.model.Vacancy;
import kg.attractor.jobsearch.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class VacancyDao {
    private final JdbcTemplate jdbcTemplate;

    public List<Vacancy> findByApplicantId(int applicantId) {
        String sql = "select v.*\n" +
                "from vacancies v\n" +
                "join responded_applicants ra on v.id = ra.vacancy_id\n" +
                "join resumes r on ra.resume_id = r.id\n" +
                "where r.applicant_id = ?;\n";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Vacancy.class), applicantId);
    }

    public List<Vacancy> findAll() {
        String sql = "select * from vacancies";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Vacancy.class));
    }

    public List<Vacancy> findByCategoryId(int categoryId) {
        String sql = "select * from vacancies where category_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Vacancy.class), categoryId);
    }

    public List<User> findApplicantsByVacancyId(int vacancyId) {
        String sql = "select u.* " +
                "from users u " +
                "join resumes r on u.id = r.applicant_id " +
                "join responded_applicants ra on r.id = ra.resume_id " +
                "where ra.vacancy_id = ?";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), vacancyId);
    }

    public void deleteById(int vacancyId) {
        String sql = "delete from vacancies where id = ?";
        jdbcTemplate.update(sql, vacancyId);
    }

    public void createVacancy(Vacancy vacancy) {
        String sql = "insert into vacancies(name, description, category_id, salary, exp_from, exp_to, is_active, author_id, created_date, update_time) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                vacancy.getName(),
                vacancy.getDescription(),
                vacancy.getCategoryId(),
                vacancy.getSalary(),
                vacancy.getExpFrom(),
                vacancy.getExpTo(),
                vacancy.isActive(),
                vacancy.getAuthorId());
    }

    public List<Vacancy> findActiveVacancies() {
        String sql = "select * from vacancies where is_active = true";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Vacancy.class));
    }

    public void applyToVacancy(int resumeId, int vacancyId) {
        String sql = "insert into responded_applicants (resume_id, vacancy_id, confirmation) values (?, ?, false)";
        jdbcTemplate.update(sql, resumeId, vacancyId);
    }

    public void editVacancy(Vacancy vacancy) {
        String sql = "update vacancies set name = ?, description = ?, category_id = ?, salary = ?, exp_from = ?, exp_to = ?, is_active = ?, author_id = ?, created_date = ?, update_time = ? where id = ?";
        jdbcTemplate.update(sql, vacancy.getName(), vacancy.getDescription(), vacancy.getCategoryId(), vacancy.getSalary(),
                vacancy.getExpFrom(), vacancy.getExpTo(), vacancy.isActive(), vacancy.getAuthorId(), vacancy.getCreatedDate(), vacancy.getUpdatedTime(), vacancy.getId());
    }

    public List <Vacancy> findVacancyByCategory(String categoryId) {
        String sql = "select * from vacancies where category_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Vacancy.class), categoryId);

    }
}
