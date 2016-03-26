<%--
  Created by IntelliJ IDEA.
  User: darya
  Date: 26.03.16
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<% Object error = session.getAttribute("error");
    if (error != null) {
        out.println("Registration successful, " + session.getAttribute("mail"));
    } else {
        out.println("Registration failed, " + error);
    }
%>

</body>
</html>
