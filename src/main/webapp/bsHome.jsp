<%@ page import="java.util.Locale" %>
<%@ page import="java.util.ResourceBundle" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="html/scripts_links.html" %>
    <title>BS</title>
</head>
<body>
<%
    Locale locale = request.getLocale();
    System.out.println(locale);
    ResourceBundle resourceBundle = ResourceBundle.getBundle("data", locale);
    System.out.println(resourceBundle.getString("home"));
%>
<%@include file='bsHeader.jsp' %>
<%@include file='html/body' %>
<%@include file='html/footer' %>
</body>
</html>

