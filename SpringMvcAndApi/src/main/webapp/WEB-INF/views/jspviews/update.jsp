<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css" />
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Update page</title>
</head>
<body>
<h1 class="text-center align-middle">Update Employee</h1>
<div class="container align-middle p-3 mb-2 bg-secondary text-white">
<form method="post" action="${pageContext.request.contextPath}/update">



    <div class="form-group row">
      <label for="firstName" class="col-sm-2 col-form-label">First Name</label>
      <div class="col-sm-10">
        <input type="text" class="form-control-plaintext" name="firstName" value="${emp.firstName}"  required>
      </div>
    </div>

    <div class="form-group row">
        <label for="middleName" class="col-sm-2 col-form-label">Middle Name</label>
        <div class="col-sm-10">
          <input type="text" class="form-control-plaintext" name="middleName" value="${emp.middleName}">
        </div>
      </div>

      <div class="form-group row">
        <label for="lastName" class="col-sm-2 col-form-label">Last Name</label>
        <div class="col-sm-10">
          <input type="text" class="form-control-plaintext" name="lastName" value="${emp.lastName}"  required>
        </div>
      </div>

      <div class="form-group row">
        <label for="email" class="col-sm-2 col-form-label">Email Id</label>
        <div class="col-sm-10">
          <input type="text" readonly class="form-control-plaintext" name="emailId" value="${emp.emailId}">
        </div>
      </div>

      <div class="form-group row">
        <label for="dateOfJoining" class="col-sm-2 col-form-label">Date of Joining</label>
        <div class="col-sm-10">
          <input type="text" readonly class="form-control-plaintext" name="DOB" value="${emp.DOB}">
        </div>
      </div>
      <div class="text-center">
        <button type="submit" class="btn btn-warning">Update</button> <a class="btn btn-primary" href="${pageContext.request.contextPath}/update" role="button">Home</a>
      </div>

</form>
</div>




<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>