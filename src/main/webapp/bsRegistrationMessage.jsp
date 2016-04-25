<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="html/scripts_links.html" %>
    <title>RegistrationMessage</title>
</head>

<body>
<%@include file="bsHeader.jsp" %>
<% Object error = session.getAttribute("error");
    if (error != null) { %>
<p>Registration failed, <%= error%>
</p
<% } else {%>
<p>Registration successful, <%= session.getAttribute("mail")%>
</p>
<% }
%>
<%@include file="html/footer" %>
</body>
</html>
