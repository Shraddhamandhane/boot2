<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<h1>welcome..All employees details are as follows..</h1>
<div class="container">
  <h2>All Employee Record</h2>
              
  <table class="table">
    <thead>
      <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>EMAIL</th>
         <th>PASSWORD</th>
          <th>SALARY</th>
          <th>ACTION</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${listOfEmployees}" var="employee">
      <tr>
        <td>${employee.employeeId }</td>
        <td>${employee.employeeName }</td>
        <td>${employee.emailId }</td>
         <td>${employee.password }</td>
          <td>${employee.salary }</td>
          <td>  <a href="deleteEmployee?employeeId=${employee.employeeId}"> <button type="button" class="btn btn-danger">DELETE</button></a> </td>
           <td>  <a href="editEmployee?employeeId=${employee.employeeId}"> <button type="button" class="btn btn-danger">EDIT</button></a> </td>
      </tr>
      </c:forEach>
     
    </tbody>
  </table>
</div>




</body>
</html>