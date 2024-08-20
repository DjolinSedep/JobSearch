<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resume List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
    <style>
        body {
            background-color: #87CEEB;
            font-family: 'Roboto', sans-serif;
            padding-top: 20px;
        }

        .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        h1 {
            font-size: 2rem;
            font-weight: 700;
            margin-bottom: 20px;
            text-align: center;
        }

        .resume-list {
            list-style-type: none;
            padding: 0;
        }

        .resume-item {
            padding: 15px;
            border-bottom: 1px solid #ddd;
        }

        .resume-item:last-child {
            border-bottom: none;
        }

        .resume-item h2 {
            font-size: 1.5rem;
            font-weight: 500;
            margin: 0;
        }

        .resume-item p {
            margin: 5px 0;
            color: #666;
        }

        .resume-item a {
            color: #007bff;
            text-decoration: none;
            font-weight: 500;
        }

        .resume-item a:hover {
            text-decoration: underline;
        }

    </style>

</head>
<body>

<div class="container">
    <h1>Resume List</h1>
    <ul class="resume-list">
        <#list resumes as resume>
            <li class="resume-item">
                <h2>${resume.name}</h2>
                <p class="text">${resume.salary}</p>
                <a href="#">View Resume</a>
            </li>
        </#list>
    </ul>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
