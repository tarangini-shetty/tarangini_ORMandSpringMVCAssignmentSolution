<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
    integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
    crossorigin="anonymous">
<title>Student Directory</title>
</head>
<body>
<div class="container">
<h3 style="background-color:#008000; background-size:300px; width: 1000px; height: 90px;font-size:30px; text-align: center;" >
CUSTOMER RELATIONSHIP MANAGEMENT
</h3>
<a href="showFormForAdd" class="btn btn-primary btn-sm mb-3">Add Customer</a>
<table class="table table-bordered table-striped">
        <thead style="background-color:#008000">
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Action</th>
            </tr>
        </thead>
<tbody>
          <c:forEach items="${customers}" var="customer" >
			<tr>
                <td>${customer.firstname}</td>
                <td>${customer.lastname}</td>
                <td>${customer.email}</td>
                <td><a href="showFormForUpdate?customerId=${customer.customerid}" class="btn btn-info btn-sm">Update</a>
                    <a href="delete?customerId=${customer.customerid}" class="btn btn-danger btn-sm" onclick="if (!(confirm('Are you sure you want to delete this Customer?'))) return false">Delete</a></td>
            </tr>
          </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>