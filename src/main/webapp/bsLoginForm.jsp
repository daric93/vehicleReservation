<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="html/scripts_links.html" %>
    <title>Log in</title>
</head>
<body>
<%@include file="bsHeader.jsp" %>
<div class="container-fluid" id="mainPage">
    <div class="row">
        <div class="col-sm-4 col-sm-offset-4">
            <form name="logIn" action="login" method="post">
                <h4 style="color: darkorange; font-weight: bold">Please enter your login data here</h4>
                <div class="input-group input-group-sm">
  <span class="input-group-addon">
    <span class="glyphicon glyphicon-envelope"></span>
  </span>
                    <input class="form-control" type="email" name="mail" placeholder="Email address">
                </div>
                <br>
                <div class="input-group input-group-sm">
  <span class="input-group-addon">
    <span class="glyphicon glyphicon-lock"></span>
  </span>
                    <input class="form-control" type="password" name="password" placeholder="Password">
                </div><br>
                <div class="input-group">
                <input class="btn btn-success" type="submit" value="Log in">
                </div>
            </form>
        </div>
    </div>
</div>
<% Object errorMes = request.getAttribute("error");
    if (errorMes != null) {
        out.println("<p>" + errorMes + "</p");
        out.println("<p><a href =\"bsRegistrationForm.jsp\"> Not registered yet?</a><p>");
    }
%>
<%@include file="html/footer" %>
</body>
</html>
