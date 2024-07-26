package kg.attractor.jobsearch.dao;
import kg.attractor.jobsearch.model.Resume;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResumeDao{
    private Connection connection;

    public ResumeDao(Connection connection) {
        this.connection = connection;
    }

    public List<Resume> findResumesByCategory(String category) throws SQLException {
        List<Resume> resumes = new ArrayList<>();
        String sql = "SELECT * FROM resumes WHERE category = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, category);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
            }
        }
        return resumes;
    }
}
