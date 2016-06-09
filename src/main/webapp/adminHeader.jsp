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
            <li class="active"><a href="adminHomePage.jsp">Home</a></li>
            <li><a href="orders">Orders</a></li>
            <li><a href="cars.jsp">Vehicles</a></li>
            <li><a href="carTypes.jsp">CarTypes</a></li>
        </ul>

        <% if (session.getAttribute("mail") != null) {%>
        <div class="nav navbar-nav navbar-right">
            <ul class="nav navbar-nav">
                <li>
                    <a href="logout">Log Out</a>
                </li>
            </ul>
        </div>
        <%
            } else {
                response.sendRedirect("admin.jsp");
            }
        %>
    </div>
</nav>
