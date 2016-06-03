<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="html/scripts_links.html" %>
    <title>Registration</title>
</head>
<body>
<%@include file="bsHeader.jsp" %>
<div class="container-fluid" style=" color: darkorange; font-size: small;background-color: white">
    <form class="form-horizontal" id="form" action="registration" method="post">
        <div class="form-group form-group-sm form-group-my">
            <label class="control-label col-sm-1 col-sm-offset-3">Name:</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" name="name" id="name" placeholder="Enter name" required>
                <small class="text-muted">Use name from your license</small>
            </div>
        </div>

        <div class="form-group form-group-sm form-group-my">
            <label class="control-label col-sm-1 col-sm-offset-3">Surname:</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" name="surname" placeholder="Enter surname"
                       required>
                <small class="text-muted">Use surname from your license</small>
            </div>
        </div>

        <div class="form-group form-group-sm form-group-my">
            <label class="control-label col-sm-1 col-sm-offset-3">Birthday:</label>
            <div class="col-sm-4">
                <input type="date" class="form-control" name="date" id="date" placeholder="yyyy-mm-dd" required>
            </div>
        </div>

        <div class="form-group form-group-sm form-group-my">
            <label class="control-label col-sm-1 col-sm-offset-3">Mail:</label>
            <div class="col-sm-4">
                <input type="email" class="form-control" name="mail" id="mail" placeholder="Enter mail" required>
            </div>
        </div>

        <div class="form-group form-group-sm form-group-my">
            <label class="control-label col-sm-1 col-sm-offset-3">Phone:</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" name="phone" id="phone" placeholder="Enter phone number"
                       required>
            </div>
        </div>

        <div class="form-group form-group-sm form-group-my">
            <label class="control-label col-sm-1 col-sm-offset-3">License:</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" name="license" id="license" placeholder="Enter license"
                       required>
            </div>
        </div>

        <div class="form-group form-group-sm form-group-my">
            <label class="control-label col-sm-1 col-sm-offset-3">Password:</label>
            <div class="col-sm-4">
                <input type="password" class="form-control" name="password" id="pass1" placeholder="Enter password"
                       required>
            </div>
        </div>

        <div class="form-group form-group-sm form-group-my">
            <label class="control-label col-sm-1 col-sm-offset-3">Repeat password:</label>
            <div class="col-sm-4">
                <input type="password" class="form-control" name="repeat" id="pass2" placeholder="Enter password"
                       required>
            </div>
        </div>

        <div class="form-group form-group-sm col-sm-offset-6 form-group-my">
            <input class="btn btn-success" type="button" value="Register" onclick="checkPass()">
            <a href="bsHome.jsp" class="btn btn-default">Cancel</a>
        </div>
        <p id="p" style="color: red"></p>
    </form>
</div>
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
