<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">
<h2>Edit form</h2>
  <form action="updateEmployee" method="post">
  
  <div class="form-group">
      <label>employeeID:</label>
      <input type="text" class="form-control"  name="employeeId" value="${employeeEntity.employeeId}" readonly>
    </div>
   
    <div class="form-group">
      <label>employeeName:</label>
      <input type="text" class="form-control"  name="employeeName" value="${employeeEntity.employeeName}">
    </div>
     <div class="form-group">
      <label >salary:</label>
      <input type="number" class="form-control"   name="salary"  value="${employeeEntity.salary}">
    </div>
     <div class="form-group">
      <label>emailId:</label>
      <input type="text" class="form-control"   name="emailId"  value="${employeeEntity.emailId}">
    </div>
     <div class="form-group">
      <label >Password:</label>
      <input type="password" class="form-control" name="password"  value="${employeeEntity.password}">
    </div>
   
    <button type="submit" class="btn btn-primary">EDIT</button>
  </form>
</div>
</body>
</html>