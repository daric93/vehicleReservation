<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="html/scripts_links.html" %>
    <title>Log in</title>
</head>
<body>
<%@include file="bsHeader.jsp" %>
<form name="logIn" action="login" method="post">
    <p><b>Email:</b><br>
        <input type="email" name="mail">
    </p>
    <p><b>Password:</b><br>
        <input type="password" name="password">
    </p><br>
    <input type="submit" value="Log in">
</form>
<% Object errorMes = request.getAttribute("error");
    if (errorMes != null) {
        out.println("<p>" + errorMes + "</p");
        out.println("<p><a href =\"bsRegistrationForm.jsp\"> Not registered yet?</a><p>");
    }
%>
<%@include file="html/footer" %>
</body>
</html>
