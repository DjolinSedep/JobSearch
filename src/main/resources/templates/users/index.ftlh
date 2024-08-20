<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Главная Страница</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
    <style>
        body {
            background-color: #87CEEB;
            font-family: 'Roboto', sans-serif;
        }
        .navbar {
            background-color: #ffffff;
        }
        .content {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 80vh;
        }
        .register-link {
            text-decoration: none;
            font-size: 1.5rem;
            color: #007bff;
        }
        .register-link:hover {
            text-decoration: underline;
        }
        .card {
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>


<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Job Portal</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/">Главная</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/registration">Зарегистрироваться</a>
                </li>
            </ul>
        </div>
    </div>
</nav>


<div class="container content">

    <div <#if ${#authentication.principal == null}">
        <div>
            <h1 class="text-center">Добро пожаловать на Job Portal!</h1>
            <p class="text-center"><a href="/registration" class="register-link">Зарегистрируйтесь сейчас</a></p>
        </div>
    </div>

     Блок для авторизованных пользователей
    <div th:if="${#authentication.principal != null}">
        <div class="container mt-5">
            <div class="row justify-content-center">
                <div class="col-md-4 mb-4">
                    <div class="card">
                        <div class="card-body text-center">
                            <h5 class="card-title">Создать Вакансию</h5>
                            <p class="card-text">Добавьте новую вакансию в вашу компанию.</p>
                            <a href="/create-vacancy" class="btn btn-primary">Создать Вакансию</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 mb-4">
                    <div class="card">
                        <div class="card-body text-center">
                            <h5 class="card-title">Создать Резюме</h5>
                            <p class="card-text">Создайте резюме, чтобы найти работу.</p>
                            <a href="/create-resume" class="btn btn-primary">Создать Резюме</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
