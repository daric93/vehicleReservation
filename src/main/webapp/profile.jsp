<%@ page import="daric.vr.entities.User" %>
<%@ page import="static daric.vr.servlets.FormatUtil.formatMoney" %>
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
    %>
    <form class="form-horizontal col-sm-offset-3" action="editProfile.jsp" method="get" >
        <div class="form-group">
            <label class="col-sm-2 control-label">Balance</label>
            <div class="col-sm-4">
                <p class="form-control-static"><%=formatMoney(user.getBalance())%>
                </p>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-2">
                <input type="submit" class="btn btn-info" value="Top Up">
            </div>
        </div>
        <legend>Personal Information</legend>
        <div class="form-group">
            <label class="col-sm-2 control-label">Name</label>
            <div class="col-sm-4">
                <p class="form-control-static"><%=user.getName()%>
                </p>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Surname</label>
            <div class="col-sm-4">
                <p class="form-control-static"><%=user.getSurname()%>
                </p>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Birthday</label>
            <div class="col-sm-4">
                <p class="form-control-static"><%=user.getDateOfBirth()%>
                </p>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Email</label>
            <div class="col-sm-4">
                <p class="form-control-static"><%=user.getMail()%>
                </p>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Phone number</label>
            <div class="col-sm-4">
                <p class="form-control-static"><%=user.getTelNumber()%>
                </p>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">License</label>
            <div class="col-sm-4">
                <p class="form-control-static"><%=user.getLicense()%>
                </p>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-2">
                <input type="submit" class="btn btn-info" value="Edit Profile">
            </div>
        </div>
    </form>
</div>
<%@include file="html/footer" %>
</body>
</html>
