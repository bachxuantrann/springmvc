<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Detail User ${user.id}</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
<div class="container mt-5">
    <div class="row">
        <div class="col-12 mx-auto">
            <div class="d-flex justify-content-between">
                <h3>User detail with id = ${user.id}</h3>
            </div>
            <hr>
            <div class="card" style="width: 60%">
                <div class="card-header">
                    Information
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">ID: ${user.id}</li>
                    <li class="list-group-item">Full Name: ${user.fullName}</li>
                    <li class="list-group-item">Email: ${user.email}</li>
                    <li class="list-group-item">Phone: ${user.phone}</li>
                    <li class="list-group-item">Address: ${user.address}</li>
                </ul>
            </div>
            <a href="/admin/user" class="btn btn-success">Back</a>
        </div>
    </div>
</div>
</body>
</html>