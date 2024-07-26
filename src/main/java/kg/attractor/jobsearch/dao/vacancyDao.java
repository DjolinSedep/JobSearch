package kg.attractor.jobsearch.dao;

import kg.attractor.jobsearch.model.Vacancy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class vacancyDao {
    private Connection connection;

    public vacancyDao (Connection connection) {
        this.connection = connection;
    }

    public List<Vacancy> findVacanciesByCategory(String category) throws SQLException {
        List<Vacancy> vacancies = new ArrayList<>();
        String sql = "SELECT * FROM vacancies WHERE category = ?";
        return vacancies;
    }
}
