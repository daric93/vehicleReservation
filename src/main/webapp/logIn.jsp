<%--
  Created by IntelliJ IDEA.
  User: darya
  Date: 26.03.16
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log in</title>
</head>
<body>
<form name="logIn" action="login" method="post">
    <p>
        <label>
            <b>Username:</b><br>
            <input type="email" name="mail">
        </label>
    </p>
    <p>
        <label>
            <b>Password:</b><br>
            <input id="pass" type="password" name="password">
        </label>
    </p><br>
    <input type="submit" value="Log in">
</form>
<% Object errorMes = request.getAttribute("error");
    if (errorMes != null) {
        out.println("<p>" + errorMes + "</p");
    }
%>
</body>
</html>
