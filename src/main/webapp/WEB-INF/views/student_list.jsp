<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Smith
  Date: 01.11.2016
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Список студентов</title>
</head>
<body>

    <h3>Список студентов</h3>

    <form name="myform" action="/test/delete" method="POST">
        <table border="1" cellspacing="0" cellpadding="2">
            <tr>
                <td></td>
                <td>Фамилия</td>
                <td>Имя</td>
                <td>Пол</td>
                <td>Дата рождения</td>
            </tr>

            <c:forEach items="${user_list}" var="student">
                <tr>
                    <td><input type="checkbox" name=${student.id}></td>
                    <td>${student.surname}</td>
                    <td>${student.name}</td>
                    <td>${student.sex}</td>
                    <td>${student.dateOfBirth}</td>
                </tr>
            </c:forEach>
        </table>
        <input type="submit" name="Edit" value="Редактировать"/>
        <input type="submit" name="Delete" value="Удалять"/>
    </form>
</body>
</html>
