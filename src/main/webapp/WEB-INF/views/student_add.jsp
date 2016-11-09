<%--
  Created by IntelliJ IDEA.
  User: Smith
  Date: 09.11.2016
  Time: 12:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление студента</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous">
    </script>
</head>
<body>
    <div class="panel panel-primary">
        <div class="panel-heading">Panel heading</div>
        <div class="panel-body">
            <form action="/student/add_commit" method='post' class='reg-form'>

                <div class='form-row'>
                    <label for='form_fname'>First Name: </label>
                    <input type='text' required id='form_fname' name='first_name'>
                </div>

                <div class='form-row'>
                    <label for='form_sname'>Second Name: </label>
                    <input type='text' id='form_sname' name='second_name'>
                </div>

                <div class='form-row'>
                    <label for='form_sex'>Sex: </label>
                    <select name="sex" id="form_sex">
                        <option>Male</option>
                        <option>Female</option>
                    </select>
                </div>

                <div class='form-row'>
                    <label for='form_dob'>Date Of Birth: </label>
                    <input type="date" id='form_dob' name="dob">
                </div>

                <div class="form-row">
                    <input type="submit" name='Add' value='Добавить'>
                    <input type="submit" name='Cancel' value='Отмена'>
                </div>

            </form>
        </div>
    </div>
</body>
</html>
