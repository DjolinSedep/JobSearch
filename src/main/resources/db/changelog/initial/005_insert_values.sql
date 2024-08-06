INSERT INTO users (name, surname, age, email, password, phone_number, avatar, account_type, enabled, authority_id)
VALUES
    ('Naruto', 'Uzumaki', 17, 'naruto@konoha.com', '$2a$12$5N.omt94dD2tZzhMBKKxLuhFatbEaV.HOisHBQ8HuLFV9KLYQHdQi', '0500111222', 'naruto.png', 'APPLICANT', true, 2),
    ('Sasuke', 'Uchiha', 18, 'sasuke@konoha.com', '$2a$12$D6KtZCwLAdKS0Yd0fLXiGuFa06RKNr6XVrTHu4jPwj9xMBKImiaia', '0500222333', 'sasuke.png', 'APPLICANT', true, 2),
    ('Madara', 'Uchiha', 90, 'madara@uchiha.com', '$2a$12$qabR.0pa5HmVv/GaUNW5iunKTJfqk4YbXxTmxgvTzv3Bm.FyKI4j2', '0500333444', 'madara.png', 'EMPLOYER', true, 1);

INSERT INTO categories (name, parent_id)
VALUES ('Ninja Arts', NULL);

INSERT INTO vacancies (name, description, category_id, salary, exp_from, exp_to, is_active, author_id, created_date, update_time)
VALUES
    ('Ninja Developer', 'Develop and maintain ninja techniques',
     (SELECT id FROM categories WHERE name = 'Ninja Arts'),
     70000, 5, 10, TRUE,
     (SELECT id FROM users WHERE name = 'Madara'), NOW(), NOW()),
    ('Chakra Analyst', 'Analyze chakra patterns and flows',
     (SELECT id FROM categories WHERE name = 'Ninja Arts'),
     60000, 3, 6, TRUE,
     (SELECT id FROM users WHERE name = 'Madara'), NOW(), NOW()),
    ('Jutsu Specialist', 'Specialize in advanced jutsu development',
     (SELECT id FROM categories WHERE name = 'Ninja Arts'),
     80000, 7, 12, TRUE,
     (SELECT id FROM users WHERE name = 'Madara'), NOW(), NOW());

INSERT INTO resumes (applicant_id, name, category_id, salary, is_active, created_date, update_time)
VALUES
    ((SELECT id FROM users WHERE name = 'Naruto'), 'Ninja Specialist Resume',
     (SELECT id FROM categories WHERE name = 'Ninja Arts'),
     75000, TRUE, NOW(), NOW()),
    ((SELECT id FROM users WHERE name = 'Sasuke'), 'Chakra Control Resume',
     (SELECT id FROM categories WHERE name = 'Ninja Arts'),
     72000, TRUE, NOW(), NOW());

INSERT INTO responded_applicants (resume_id, vacancy_id, confirmation)
VALUES
    ((SELECT id FROM resumes WHERE name = 'Ninja Specialist Resume'),
     (SELECT id FROM vacancies WHERE name = 'Ninja Developer'), TRUE),
    ((SELECT id FROM resumes WHERE name = 'Chakra Control Resume'),
     (SELECT id FROM vacancies WHERE name = 'Chakra Analyst'), TRUE);

INSERT INTO messages (responded_applicants, content, timestamp)
VALUES
    ((SELECT id FROM responded_applicants WHERE resume_id =
                                                (SELECT id FROM resumes WHERE name = 'Ninja Specialist Resume')
                                            AND vacancy_id =
                                                (SELECT id FROM vacancies WHERE name = 'Ninja Developer')),
     'We would like to invite you for an interview.', NOW()),
    ((SELECT id FROM responded_applicants WHERE resume_id =
                                                (SELECT id FROM resumes WHERE name = 'Chakra Control Resume')
                                            AND vacancy_id =
                                                (SELECT id FROM vacancies WHERE name = 'Chakra Analyst')),
     'Please provide further details on your chakra analysis techniques.', NOW());

INSERT INTO education_info (resume_id, institution, program, start_date, end_date, degree)
VALUES
    ((SELECT id FROM resumes WHERE name = 'Ninja Specialist Resume'), 'Konoha Academy', 'Ninjutsu', '2008-09-01', '2012-06-30', 1),
    ((SELECT id FROM resumes WHERE name = 'Chakra Control Resume'), 'Konoha Academy', 'Chakra Studies', '2008-09-01', '2012-06-30', 1);

INSERT INTO work_experience_info (resume_id, years, company_name, position, responsibilities)
VALUES
    ((SELECT id FROM resumes WHERE name = 'Ninja Specialist Resume'), 5, 'Konoha', 'Genin', 'Perform ninja missions'),
    ((SELECT id FROM resumes WHERE name = 'Chakra Control Resume'), 4, 'Konoha', 'Chunin', 'Chakra control and mission support');

INSERT INTO contact_types (type)
VALUES ('Konoha Network'), ('Shinobi Social');

INSERT INTO contacts_info (type_id, resume_id, "value")
VALUES
    ((SELECT id FROM contact_types WHERE type = 'Konoha Network'),
     (SELECT id FROM resumes WHERE name = 'Ninja Specialist Resume'),
     'naruto.konoha.net'),
    ((SELECT id FROM contact_types WHERE type = 'Shinobi Social'),
     (SELECT id FROM resumes WHERE name = 'Chakra Control Resume'),
     'sasuke.shinobisocial.com');
