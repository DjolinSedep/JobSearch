<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Job Vacancy Creation and Resume View</title>
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
        .vacancy-section, .resumes-section {
            padding: 20px;
        }
        .resumes-section {
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

        <div class="col-md-8">
            <div class="card vacancy-section">
                <div class="card-body">
                    <h2 class="card-title text-center">Create a Job Vacancy</h2>
                    <form action="/createVacancy" method="post">

                        <div class="mb-3">
                            <label for="jobTitle" class="form-label">Job Title</label>
                            <input type="text" class="form-control" id="jobTitle" name="jobTitle" required>
                        </div>

                        <div class="mb-3">
                            <label for="companyName" class="form-label">Company Name</label>
                            <input type="text" class="form-control" id="companyName" name="companyName" required>
                        </div>

                        <div class="mb-3">
                            <label for="location" class="form-label">Location</label>
                            <input type="text" class="form-control" id="location" name="location" required>
                        </div>

                        <div class="mb-3">
                            <label for="salary" class="form-label">Salary</label>
                            <input type="number" class="form-control" id="salary" name="salary" required>
                        </div>

                        <div class="mb-3">
                            <label for="jobDescription" class="form-label">Job Description</label>
                            <textarea class="form-control" id="jobDescription" name="jobDescription" rows="5" required></textarea>
                        </div>

                        <button type="submit" class="btn btn-primary w-100">Create Vacancy</button>
                    </form>
                </div>
            </div>
        </div>

        <div class="col-md-4">
            <div class="card resumes-section">
                <div class="card-body">
                    <h3 class="card-title">View Resumes</h3>
                    <p>Browse through the resumes of job seekers to find the best candidates for your job vacancy.</p>
                    <a href="/resume" class="btn btn-secondary w-100">Browse Resumes</a>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
