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
<div class="container">
<h2 style="background-color:#008000; background-size:300px; width: 1000px; height: 90px;font-size:30px; text-align: center;">
CUSTOMER RELATIONSHIP MANAGEMENT
</h2>
</head>
<body>
<h4> Save Customer</h4>

            <form action="save" method="POST">
                <input type="hidden" name="customerId" value="${customer.customerid}" />
                <label style="margin-left:20px;" for="firstName">First name:</label>&nbsp
                <input style="margin-left:20px;" type="text" id="firstName" name="firstName" value="${customer.firstname}" placeholder="First Name" ><br><br>
                <label style="margin-left:20px;" for="lastName">Last name:</label>
                <input style="margin-left:20px;" type="text" id="lastName" name="lastName" value="${customer.lastname}" placeholder="Last Name" ><br><br>
                <label style="margin-left:20px;" for="email">Email:</label>
                <input style="margin-left:20px;" type="text" id="email" name="email" value="${customer.email}" placeholder="Email" ><br><br>
                <button type="submit" class="btn btn-info col-2">Save</button>
            </form>
            <br><br><a href="list" >Back to List</a>

</div>
</body>

</html>