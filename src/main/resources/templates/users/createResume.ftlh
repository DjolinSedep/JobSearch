<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Registration and Resume Creation</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
    <style>
        body {
            background-color: #87CEEB;
            font-family: 'Roboto', sans-serif;
        }
        .navbar, .card {
            background-color: #ffffff;
        }
        .card {
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .container {
            max-width: 1200px;
        }
        .user-type-group {
            display: flex;
            justify-content: space-around;
            margin-bottom: 20px;
        }
        .user-type-group .form-check {
            width: 45%;
        }
        .resume-section, .vacancies-section {
            padding: 20px;
        }
        .vacancies-section {
            background-color: #f8f9fa;
            border-left: 2px solid #dee2e6;
        }
    </style>
</head>
<body>

<!-- Навигационная панель -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Job Portal</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link" href="index.html">Home</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container mt-5">
    <div class="row">
        <!-- Левая часть - Создание резюме -->
        <div class="col-md-8">
            <div class="card resume-section">
                <div class="card-body">
                    <h2 class="card-title text-center">Create Your Resume</h2>
                    <form action="/createResume" method="post">

                        <div class="mb-3">
                            <label for="firstName" class="form-label">First Name</label>
                            <input type="text" class="form-control" id="firstName" name="firstName" required>
                        </div>

                        <div class="mb-3">
                            <label for="lastName" class="form-label">Last Name</label>
                            <input type="text" class="form-control" id="lastName" name="lastName" required>
                        </div>

                        <div class="mb-3">
                            <label for="phoneNumber" class="form-label">Phone Number</label>
                            <input type="tel" class="form-control" id="phoneNumber" name="phoneNumber" required>
                        </div>

                        <div class="mb-3">
                            <label for="email" class="form-label">Email Address</label>
                            <input type="email" class="form-control" id="email" name="email" required>
                        </div>

                        <div class="mb-3">
                            <label for="desiredJob" class="form-label">Desired Job</label>
                            <input type="text" class="form-control" id="desiredJob" name="desiredJob" required>
                        </div>

                        <div class="mb-3">
                            <label for="desiredSalary" class="form-label">Desired Salary</label>
                            <input type="number" class="form-control" id="desiredSalary" name="desiredSalary" required>
                        </div>

                        <button type="submit" class="btn btn-primary w-100">Create Resume</button>
                    </form>
                </div>
            </div>
        </div>

        <!-- Правая часть - Просмотр вакансий -->
        <div class="col-md-4">
            <div class="card vacancies-section">
                <div class="card-body">
                    <h3 class="card-title">View Job Vacancies</h3>
                    <p>Explore available job opportunities tailored to your skills and interests.</p>
                    <a href="/vacancy" class="btn btn-secondary w-100">Browse Vacancies</a>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
