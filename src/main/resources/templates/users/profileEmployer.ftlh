<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Личный кабинет работодателя</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f0f8ff;
            font-family: Arial, sans-serif;
            padding-top: 20px;
        }

        .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            max-width: 800px;
            margin: auto;
        }

        .profile-header {
            text-align: center;
            margin-bottom: 20px;
        }

        .profile-header h1 {
            font-size: 2rem;
            font-weight: bold;
        }

        .edit-profile {
            text-align: right;
            margin-bottom: 20px;
        }

        .vacancy-list {
            list-style-type: none;
            padding: 0;
        }

        .vacancy-item {
            padding: 15px;
            border: 1px solid #ddd;
            border-radius: 5px;
            margin-bottom: 10px;
            background-color: #f9f9f9;
        }

        .vacancy-item h2 {
            font-size: 1.5rem;
            margin: 0 0 10px 0;
        }

        .vacancy-item p {
            margin: 0;
            color: #666;
        }

        .vacancy-item .btn {
            margin-top: 10px;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="profile-header">
        <h1>Личный кабинет работодателя</h1>
    </div>

    <div class="edit-profile">
        <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#editProfileModal">Редактировать профиль</button>
    </div>

    <h3>Мои вакансии</h3>
    <ul class="vacancy-list">
        <li class="vacancy-item">
            <h2>Название вакансии</h2>
            <p>Дата обновления: 20.08.2024</p>
            <button class="btn btn-secondary">Обновить</button>
            <button class="btn btn-warning">Редактировать</button>
        </li>

    </ul>
</div>


<div class="modal fade" id="editProfileModal" tabindex="-1" aria-labelledby="editProfileModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="editProfileModalLabel">Редактировать профиль</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="mb-3">
                        <label for="companyName" class="form-label">Название компании</label>
                        <input type="text" class="form-control" id="companyName">
                    </div>
                    <div class="mb-3">
                        <label for="email" class="form-label">Email</label>
                        <input type="email" class="form-control" id="email">
                    </div>
                    <div class="mb-3">
                        <label for="phone" class="form-label">Телефон</label>
                        <input type="text" class="form-control" id="phone">
                    </div>
                    <button type="submit" class="btn btn-primary">Сохранить изменения</button>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
