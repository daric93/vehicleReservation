<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="page-header">
    <div class="container text-right">
        <h1 style="font-weight: bold;">CarReservation.com</h1>
        <p>Book cars fast and easy</p>
    </div>
</div>
<nav class="navbar">
    <div class="collapse navbar-collapse" id="myNavbar">
        <ul class="nav navbar-nav">
            <li class="nav-item active">
                <a href="bsHome.jsp">Home</a>
            </li>
            <li class="nav-item">
                <a href="rentalInformation.jsp">Rental Information</a>
            </li>
            <li class="nav-item">
                <a href="#">Vehicles</a>
            </li>
            <li class="nav-item">
                <a href="contacts.jsp">Contacts</a>
            </li>
        </ul>

        <% if (session.getAttribute("mail") != null) {%>
        <div class="nav navbar-nav navbar-right">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button class="btn btn-default dropdown-toggle navbar-brand" type="button" data-toggle="dropdown">
                        <span class="glyphicon glyphicon-user"></span></button>
                    <ul class="dropdown-menu">
                        <li><a href="profile.jsp">Profile</a></li>
                        <%--TODO: don't put balance to session--%>
                        <li><a href="orders.jsp">Orders</a></li>
                        <li><a href="logout">Log Out</a></li>
                    </ul>
                </div>
            </div>
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
