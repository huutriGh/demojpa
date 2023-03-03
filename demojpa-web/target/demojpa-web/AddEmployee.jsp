<%--
  Created by IntelliJ IDEA.
  User: nguyen huu tri
  Date: 03/03/2023
  Time: 8:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 <h2>Add Employee</h2>
<form action="employee" method="POST">

    <p>
        <input name="fullName" type="text" placeholder="Full Name" >
    </p>
    <p>
        <input name="birthday" type="date" placeholder="Birthday" >
    </p>
    <p>
        <input name="street" type="text" placeholder="Street" >
    </p>
    <p>
        <input name="ward" type="text" placeholder="Ward" >
    </p>
    <p>
        <input name="district" type="text" placeholder="District" >
    </p>
    <p>
        <input name="city" type="text" placeholder="City" >
    </p>
    <p>
        <input type="submit" name="action" value="ADD">
    </p>

</form>
</body>
</html>
