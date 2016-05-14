<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="html/scripts_links.html" %>
    <title>Registration</title>
</head>
<body>
<%@include file="bsHeader.jsp" %>
<div class="container-fluid" style=" color: darkorange; font-size: small;background-color: white">
    <form id="form" action="registration" method="post">
        <div class="form-group form-group-sm">
            <label class="control-label col-sm-1 col-sm-offset-3" for="name">Name:</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" name="name" id="name" placeholder="Enter name" required>
            </div>
        </div>

        <div class="form-group form-group-sm">
            <label class="control-label col-sm-1 col-sm-offset-3" for="surname">Surname:</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" name="surname" id="surname" placeholder="Enter surname"
                       required>
            </div>
        </div>

        <div class="form-group form-group-sm">
            <label class="control-label col-sm-1 col-sm-offset-3" for="date">Birthday:</label>
            <div class="col-sm-4">
                <input type="date" class="form-control" name="date" id="date" placeholder="yyyy-mm-dd" required>
            </div>
        </div>

        <div class="form-group form-group-sm">
            <label class="control-label col-sm-1 col-sm-offset-3" for="mail">Mail:</label>
            <div class="col-sm-4">
                <input type="email" class="form-control" name="mail" id="mail" placeholder="Enter mail" required>
            </div>
        </div>

        <div class="form-group form-group-sm">
            <label class="control-label col-sm-1 col-sm-offset-3" for="phone">Phone:</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" name="phone" id="phone" placeholder="Enter phone number"
                       required>
            </div>
        </div>

        <div class="form-group form-group-sm">
            <label class="control-label col-sm-1 col-sm-offset-3" for="license">License:</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" name="license" id="license" placeholder="Enter license"
                       required>
            </div>
        </div>

        <div class="form-group form-group-sm">
            <label class="control-label col-sm-1 col-sm-offset-3" for="pass1">Password:</label>
            <div class="col-sm-4">
                <input type="password" class="form-control" name="password" id="pass1" placeholder="Enter password"
                       required>
            </div>
        </div>

        <div class="form-group form-group-sm">
            <label class="control-label col-sm-1 col-sm-offset-3" for="pass2">Repeat password:</label>
            <div class="col-sm-4">
                <input type="password" class="form-control" name="repeat" id="pass2" placeholder="Enter password"
                       required>
            </div>
        </div>

        <div class="form-group form-group-sm col-sm-offset-6">
            <input class="btn btn-success" type="button" value="Register" onclick="checkPass()">
            <a href="bsHome.jsp" class="btn btn-default">Cancel</a>
        </div>
        <p id="p" style="color: red"></p>
    </form>
</div>
<%--<form id="form" action="registration" method="post">--%>
<%--<label>Name:<br>--%>
<%--<input type="text" name="name" required>--%>
<%--</label><br>--%>

<%--<label>Surname:<br>--%>
<%--<input type="text" name="surname" required>--%>
<%--</label><br>--%>

<%--<label>Birthday:<br>--%>
<%--<input type="date" name="date" required>--%>
<%--</label><br>--%>

<%--<label>E-mail:<br>--%>
<%--<input type="email" name="mail" required>--%>
<%--</label><br>--%>

<%--<label>Mobile number:<br>--%>
<%--<input type="text" name="phone" required>--%>
<%--</label><br>--%>

<%--<label>License:<br>--%>
<%--<input type="text" name="license">--%>
<%--</label><br>--%>

<%--<label>Password:<br>--%>
<%--<input id="pass1" type="password" name="password" required>--%>
<%--</label><br>--%>

<%--<label>Repeat password:<br>--%>
<%--<input id="pass2" type="password" name="repeat" required>--%>
<%--</label><br>--%>

<%--<p><input type="button" value="Register" onclick="checkPass()">--%>
<%--<a href="bsHome.jsp">Cancel</a></p>--%>
<%--<p id="p" style="color: red"></p>--%>
<%--</form>--%>
<script>
    function checkPass() {
        var pass1 = document.getElementById('pass1');
        var pass2 = document.getElementById('pass2');
        if (pass1.value == pass2.value) {
            document.getElementById('form').submit();
        }
        else {
            document.getElementById('p').innerHTML = "Wrong password";
            pass1.value = ''
            pass2.value = ''
        }
    }
</script>
<%@include file="html/footer" %>
</body>
</html>
