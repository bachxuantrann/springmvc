<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Update user </title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
<div class="container mt-5">
    <div class="row">
        <div class="col-md-6 col-12 mx-auto">
            <h3>Update a user</h3>
            <hr>
            <%--@elvariable id="user" type=""--%>
            <form:form method="post" action="/admin/user/update/${user.id}" modelAttribute="user">
                <div class="mb-3">
                    <label class="form-label">Email:</label>
                    <form:input path="email" type="email" class="form-control" value="${user.email}"/>
                </div>
                <div class="mb-3">
                    <label class="form-label">Phone:</label>
                    <form:input path="phone" type="text" class="form-control" value="${user.phone}"/>
                </div>
                <div class="mb-3">
                    <label class="form-label">Fullname:</label>
                    <form:input path="fullName" type="text" class="form-control" value="${user.fullName}"/>
                </div>
                <div class="mb-3">
                    <label class="form-label">Address:</label>
                    <form:input path="address" type="text" class="form-control" value="${user.address}"/>
                </div>
                <div class="mb-3">
                    <form:input path="id" type="text" class="form-control d-none" value="${user.id}"/>
                </div>
                <button type="submit" class="btn btn-primary">Update</button>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>