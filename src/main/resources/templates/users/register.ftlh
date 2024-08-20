<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Registration</title>
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
            max-width: 800px;
        }
        .user-type-group {
            display: flex;
            justify-content: space-around;
            margin-bottom: 20px;
        }
        .user-type-group .form-check {
            width: 45%;
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
    <div class="card">
        <div class="card-body">
            <h2 class="card-title text-center">User Registration</h2>
            <form action="/registerUser" method="post">

                <!-- Выбор типа пользователя -->
                <div class="user-type-group">
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="userType" id="jobSeeker" value="jobSeeker" checked>
                        <label class="form-check-label" for="jobSeeker">
                            Job Seeker
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="userType" id="employer" value="employer">
                        <label class="form-check-label" for="employer">
                            Employer
                        </label>
                    </div>
                </div>

                <!-- Поля, общие для всех пользователей -->
                <div class="mb-3">
                    <label for="fullName" class="form-label">Full Name</label>
                    <input type="text" class="form-control" id="fullName" name="fullName" required>
                </div>

                <div class="mb-3">
                    <label for="email" class="form-label">Email Address</label>
                    <input type="email" class="form-control" id="email" name="email" required>
                </div>

                <div class="mb-3">
                    <label for="phone" class="form-label">Phone Number</label>
                    <input type="tel" class="form-control" id="phone" name="phone" required>
                </div>

                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" class="form-control" id="password" name="password" required>
                </div>

                <div class="mb-3">
                    <label for="confirmPassword" class="form-label">Confirm Password</label>
                    <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" required>
                </div>

                <div id="employerFields" style="display:none;">
                    <div class="mb-3">
                        <label for="companyName" class="form-label">Company Name</label>
                        <input type="text" class="form-control" id="companyName" name="companyName">
                    </div>

                    <div class="mb-3">
                        <label for="contactPerson" class="form-label">Contact Person</label>
                        <input type="text" class="form-control" id="contactPerson" name="contactPerson">
                    </div>
                </div>

                <button type="submit" class="btn btn-primary w-100">Register</button>
            </form>

            <div class="mt-4 text-center">
                <a href="/create-vacancy" class="btn btn-secondary">Create Vacancy</a>
            </div>

        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script>
    document.addEventListener('DOMContentLoaded', function() {
        const jobSeekerRadio = document.getElementById('jobSeeker');
        const employerRadio = document.getElementById('employer');
        const employerFields = document.getElementById('employerFields');

        function toggleEmployerFields() {
            if (employerRadio.checked) {
                employerFields.style.display = 'block';
            } else {
                employerFields.style.display = 'none';
            }
        }

        jobSeekerRadio.addEventListener('change', toggleEmployerFields);
        employerRadio.addEventListener('change', toggleEmployerFields);

        toggleEmployerFields();
    });
</script>
</body>
</html>
