<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="common/navigation.jspf"%>

<html>
<head>
    <title>Users</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Phone Number</th>
        <th>Email</th>
        <th>Address</th>
        <th>Password</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.surname}</td>
            <td>${user.phoneNumber}</td>
            <td>${user.email}</td>
            <td>${user.address}</td>
            <td>${user.password}</td>
            <td><a type="button" href="/update-user/${user.id}">UPDATE</a></td>
            <td><a type="button" href="/delete-user/${user.id}">DELETE</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div>
    <a href="add-user">ADD USER</a>
</div>
</body>
</html>