<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="html/scripts_links.html" %>
    <title>Registration</title>
</head>
<body>
<%@include file="bsHeader.jsp" %>
<form id="form" action="registration" method="post">
    <label>Name:<br>
        <input type="text" name="name" required>
    </label><br>

    <label>Surname:<br>
        <input type="text" name="surname" required>
    </label><br>

    <label>Birthday:<br>
        <input type="date" name="date" required>
    </label><br>

    <label>E-mail:<br>
        <input type="email" name="mail" required>
    </label><br>

    <label>Mobile number:<br>
        <input type="text" name="phone" required>
    </label><br>

    <label>License:<br>
        <input type="text" name="license">
    </label><br>

    <label>Password:<br>
        <input id="pass1" type="password" name="password" required>
    </label><br>

    <label>Repeat password:<br>
        <input id="pass2" type="password" name="repeat" required>
    </label><br>

    <p><input type="button" value="Register" onclick="checkPass()">
        <a href="bsHome.jsp">Cancel</a></p>
    <p id="p" style="color: red"></p>
</form>
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
