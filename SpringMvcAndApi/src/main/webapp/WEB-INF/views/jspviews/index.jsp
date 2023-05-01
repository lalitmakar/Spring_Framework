<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Employee Management</title>
</head>
<body>
<h1 class="text-center align-middle">Home page</h1>

<div class="container align-middle">
<table class="table table-striped table-dark container">
    <thead>
    <tr>
        <th scope="col text-center">First Name <small><a href="${pageContext.request.contextPath}?sortBy=firstName&desc=0">asc</a></small> | <small><a href="${pageContext.request.contextPath}?sortBy=firstName&desc=1">desc</a></small></th>
        <th scope="col text-center">Middle Name <small><a href="${pageContext.request.contextPath}?sortBy=middleName&desc=0">asc</a></small> | <small><a href="${pageContext.request.contextPath}?sortBy=middleName&desc=1">desc</a></small></th>
        <th scope="col text-center">Last Name <small><a href="${pageContext.request.contextPath}?sortBy=lastName&desc=0">asc</a></small> | <small><a href="${pageContext.request.contextPath}?sortBy=lastName&desc=1">desc</a></small></th>
        <th scope="col text-center">Email Id <small><a href="${pageContext.request.contextPath}?sortBy=emailId&desc=0">asc</a></small> | <small><a href="${pageContext.request.contextPath}?sortBy=emailId&desc=1">desc</a></small></th>
        <th scope="col text-center">Date Of Birth <small><a href="${pageContext.request.contextPath}?sortBy=DOB&desc=0">asc</a></small> | <small><a href="${pageContext.request.contextPath}?sortBy=DOB&desc=1">desc</a></small></th>
        <th scope="col text-center">Actions</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var = "emp" items = "${empList}">
             <tr>
                 <td scope="row text-center">${emp.firstName}</td>
                 <th scope="row text-center">${emp.middleName}</th>
                 <td scope="row text-center">${emp.lastName}</td>
                 <td scope="row text-center">${emp.emailId}</td>
                 <td scope="row text-center">${emp.DOB}</td>
                 <td scope="row text-center"><a class="btn btn-primary fa fa-pencil-square-o" href="updateEmployee/${emp.emailId}" role="button"></a> | <a class="btn btn-danger fa fa-trash-o" href="deleteEmployee/${emp.emailId}" role="button"></a></td>
             </tr>
    </c:forEach>
    </tbody>
</table>
<hr/>
<div class="text-center"><a class="btn btn-primary text-center" href="addEmployee" role="button">Add Employee Data</a></div>

</div>



<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>