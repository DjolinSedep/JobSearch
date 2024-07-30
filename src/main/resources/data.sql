CREATE TABLE users (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       email VARCHAR(100) NOT NULL UNIQUE,
                       name VARCHAR(50) NOT NULL,
                       role ENUM('applicant', 'employer') NOT NULL
);
CREATE TABLE resumes (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         user_id INT NOT NULL,
                         title VARCHAR(100) NOT NULL,
                         content TEXT NOT NULL,
                         FOREIGN KEY (user_id) REFERENCES users(id)
);
CREATE TABLE vacancies (
                           id INT PRIMARY KEY AUTO_INCREMENT,
                           user_id INT NOT NULL,
                           title VARCHAR(100) NOT NULL,
                           description TEXT NOT NULL,
                           FOREIGN KEY (user_id) REFERENCES users(id)
);
CREATE TABLE applications (
                              id INT PRIMARY KEY AUTO_INCREMENT,
                              resume_id INT NOT NULL,
                              vacancy_id INT NOT NULL,
                              FOREIGN KEY (resume_id) REFERENCES resumes(id),
                              FOREIGN KEY (vacancy_id) REFERENCES vacancies(id)
);

INSERT INTO users (email, name, role) VALUES
('applicant1@example.com', 'Иван Петров', 'applicant'),
('employer1@example.com', 'ООО "Техно"', 'employer');

INSERT INTO resumes (user_id, title, content) VALUES
 (1, 'Java Developer', 'Резюме разработчика Java с опытом работы в IT-индустрии.'),
 (1, 'Data Analyst', 'Резюме аналитика данных с навыками работы с большими данными.');

INSERT INTO vacancies (user_id, title, description) VALUES
 (2, 'Java Developer Position', 'Ищем опытного Java разработчика для работы в команде.'),
 (2, 'Data Analyst Position', 'Требуется аналитик данных для обработки и анализа больших объемов данных.');

INSERT INTO applications (resume_id, vacancy_id) VALUES
 (1, 1),
(2, 2);