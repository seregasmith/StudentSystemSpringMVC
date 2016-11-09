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
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Список студентов</title>
</head>
<body>

    <h3>Список студентов</h3>
    <form action="formproc.jsp" method="post">
        <table>
            <tr>
                <td colspan="2"><h3>Design a Cake</h3></td>
            </tr>
            <tr>
                <td>Cake shape:</td>
                <td>
                    <select name="shape">
                        <option>round</option>
                        <option>square</option>
                        <option>heart</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td valign="top">Toppings</td>
                <td>
                    <input type="checkbox" name="topping" value="choc">Chocolate</input><br/>
                    <input type="checkbox" name="topping" value="cane">Candy Cane</input><br/>
                    <input type="checkbox" name="topping" value="flower">Flower</input><br/>
                </td>

            </tr>

            <tr>
                <td colspan="2">
                    <center><input type="submit" value="Send"/></center>
                </td>
            </tr>
        </table>
    </form>

    <form name="myform" action="/student/edit" method="POST">
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
                    <td><input type="checkbox" name="student_id" value="${student.id}"></td>
                    <td>${student.surname}</td>
                    <td>${student.name}</td>
                    <td>${student.sex}</td>
                    <td>${student.dateOfBirth}</td>
                </tr>
            </c:forEach>
        </table>
        <input type="submit" name="Add" value="Добавить"/>
        <input type="submit" name="Delete" value="Удалить"/>
    </form>
</body>
</html>
