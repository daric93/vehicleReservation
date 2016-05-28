<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="page-header">
    <div class="container text-right">
        <h1 style="font-weight: bold;">CarReservation.com</h1>
        <p>Book cars fast and easy</p>
    </div>
</div>
<nav class="navbar navbar-inverse">
    <div class="collapse navbar-collapse" id="myNavbar">
        <ul class="nav navbar-nav">
            <li class="active"><a href="bsHome.jsp">Home</a></li>
            <li><a href="rentalInformation.jsp">Rental Information</a></li>
            <li><a href="#">Vehicles</a></li>
            <li><a href="#">Contacts</a></li>
        </ul>

        <% if (session.getAttribute("mail") != null) {%>
        <div class="nav navbar-nav navbar-right">
            <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">
                <span class="glyphicon glyphicon-user"></span></button>
            <ul class="dropdown-menu">
                <li>Balance: <%=session.getAttribute("balance")%>
                </li>
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
