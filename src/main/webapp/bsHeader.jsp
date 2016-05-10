<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="page-header">
    <div class="container text-center">
        <h1>My Portfolio</h1>
        <p>Some text that represents "Me"...</p>
    </div>
</div>
<nav class="navbar navbar-inverse">
    <div class="collapse navbar-collapse" id="myNavbar">
        <ul class="nav navbar-nav">
            <li class="active"><a href="bsHome.jsp">Home</a></li>
            <li><a href="#">About</a></li>
            <li><a href="search">Gallery</a></li>
            <li><a href="#">Contact</a></li>
        </ul>

        <% if (session.getAttribute("mail") != null) {%>
        <div class="nav navbar-nav navbar-right">
            <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">
                <span class="glyphicon glyphicon-user"></span></button>
            <ul class="dropdown-menu">
                <li><a href="orders">Orders</a></li>
                <li><a href="logout">Log Out</a></li>
            </ul>
        </div>
        <%} else {%>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="bsLoginForm.jsp"><span class="glyphicon glyphicon-log-in"></span> Log In</a></li>
            <li><a href="bsRegistrationForm.jsp"><span class="glyphicon glyphicon-registration-mark"></span>
                Sign In</a></li>
        </ul>
        <%}%>
    </div>
</nav>
