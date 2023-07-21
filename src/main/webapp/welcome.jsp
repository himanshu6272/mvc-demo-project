<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="model.User, java.util.*, dao.UserDao, utils.ConnectionProvider, java.sql.*" %>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" >
</head>
<body>
<div class="container border border-solid bg-secondary text-center text-light">
<h2>Registration Detail</h2>
</div>
<%
    UserDao userDao = new UserDao(ConnectionProvider.getConnection());
    List<User> users = userDao.getAllUsers();
    request.setAttribute("users", users);
    System.out.println(users);
%>
<div class="container p-0">
<table class="table table-bordered text-center">
    <tr>
    <th>Id</th>
    <th>Firstname</th>
    <th>Lastname</th>
    <th>Email</th>
    <th>Mobile</th>
    <th>Address</th>
    <th>DOB</th>
    <th>Gender</th>
    <th>City</th>
    <th>Password</th>

    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
        <td><c:out value="${user.getId()}" /></td>
        <td><c:out value="${user.getFirstName()}" /></td>
        <td><c:out value="${user.getLastName()}" /></td>
        <td><c:out value="${user.getEmail()}" /></td>
        <td><c:out value="${user.getMobile()}" /></td>
        <td><c:out value="${user.getAddress()}" /></td>
        <td><c:out value="${user.getDob()}" /></td>
        <td><c:out value="${user.getGender()}" /></td>
        <td><c:out value="${user.getCity()}" /></td>
        <td><c:out value="${user.getPassword()}" /></td>

        </tr>
    </c:forEach>
</table>
<a href="index.html">Register user</a>
</div>
</body>
</html>