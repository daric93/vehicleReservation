<%@ page import="daric.vr.entities.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="html/scripts_links.html" %>
    <title>Title</title>
</head>
<body>
<%@include file="bsHeader.jsp" %>
<div class="container mainPage">
    <%
        User user = (User) request.getAttribute("user");
        if (request.getAttribute("error") != null) {
    %>
    <div class="alert-danger">
        <%=request.getAttribute("error")%>
    </div>
    <%
        }
    %>
    <form class="form-horizontal" action="updateUser" method="post">
        <legend>Personal Information</legend>
        <div class="form-group">
            <label class="col-sm-2 control-label">Name</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" name="name" value="<%=user.getName()%>">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Surname</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" name="surname" value="<%=user.getSurname()%>">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Birthday</label>
            <div class="col-sm-4">
                <input type="date" class="form-control" name="date" placeholder="yyyy-mm-dd"
                       value="<%=user.getDateOfBirth()%>">
                <%--TODO: add restriction to field's input, Validator Bootstrap--%>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Email</label>
            <div class="col-sm-4">
                <input type="email" class="form-control" name="mail" value="<%=user.getMail()%>">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Phone number</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" name="number" value="<%=user.getTelNumber()%>">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">License</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" name="license" value="<%=user.getLicense()%>">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-2">
                <input type="submit" class="btn-primary" value="Save">
            </div>
        </div>
    </form>
</div>
<%@include file="html/footer" %>
</body>
</html>
