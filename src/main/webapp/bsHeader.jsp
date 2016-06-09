<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="data"/>
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
                <a href="bsHome.jsp"><fmt:message key="home"/></a>
            </li>
            <li class="nav-item">
                <a href="rentalInformation.jsp"><fmt:message key="rental"/></a>
            </li>
            <li class="nav-item">
                <a href="#"><fmt:message key="vehicle"/></a>
            </li>
            <li class="nav-item">
                <a href="contacts.jsp"><fmt:message key="contact"/></a>
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
            <li><a href="bsLoginForm.jsp"><span class="glyphicon glyphicon-log-in"></span> <fmt:message key="log"/></a>
            </li>
            <li><a href="bsRegistrationForm.jsp"><span class="glyphicon glyphicon-registration-mark"></span>
                <fmt:message key="sign"/></a>
            </li>
            <li>
                <form>
                    <select name="language" onchange="submit()">
                        <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
                        <option value="ru" ${language == 'ru' ? 'selected' : ''}><%="\u0420\u0443\u0441\u0441\u043a\u0438\u0439"%></option>
                        <%--<option value="uk" ${language == 'uk' ? 'selected' : ''}><%="\u0423\u043a\u0440\u0430\u0457\u043d\u0441\u044c\u043a\u0430"%></option>--%>
                    </select>
                </form>
            </li>
        </ul>
        <%}%>
    </div>
</nav>
