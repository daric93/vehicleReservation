<%@ page import="daric.vr.entities.Car" %>
<%@ page import="daric.vr.entities.CarType" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="html/scripts_links.html" %>
    <title>Title</title>
</head>
<body>
<%@include file="adminHeader.jsp" %>
<div class="container-fluid mainPage">
    <div class="container page-padding col-sm-offset-4 col-sm-4">
        <%
            Car car = (Car) request.getAttribute("car");
            if (car == null)
                car = (Car) request.getSession().getAttribute("car");
            List<CarType> carTypes = (List<CarType>) request.getAttribute("carTypes");
            if (request.getParameter("error") != null) {
        %>
        <div class="alert-danger">
            <p><%=request.getParameter("error")%>
            </p>
        </div>
        <%
            }
            if (request.getParameter("success") != null) {
        %>
        <div class="alert-danger">
            <p><%=request.getParameter("success")%>
            </p>
        </div>
        <%
            }
        %>
        <form action="updateCar" method="post">
            <div class="form-group form-group-sm form-my-style">
                <label for="carType">Car Type</label>
                <select class="form-control" id="carType" name="carType">
                    <option value="<%=car.getCarType().getTypeId()%>" selected>
                        <%=car.getCarType().getBrand()%>, <%=car.getCarType().getModel()%>
                    </option>
                    <%
                        for (CarType carType : carTypes) {
                    %>
                    <option value="<%=carType.getTypeId()%>"><%=carType.getBrand()%>,
                        <%=carType.getModel()%>
                    </option>
                    <%
                        }
                    %>
                </select>
            </div>
            <div class="form-group form-group-sm">
                <label for="address">Address</label>
                <input type="text" class="form-control" id="address" name="address"
                       value="<%=car.getAddress()%>"
                       required>
            </div>
            <div class="form-group form-group-sm">
                <label for="number">Number</label>
                <input type="text" class="form-control" id="number" name="number"
                       value="<%=car.getLicenseNumber()%>"
                       required>
            </div>
            <div class="form-group form-group-sm">
                <label for="color">Color</label>
                <input type="text" class="form-control" id="color" name="color"
                       value="<%=car.getColor()%>" required>
            </div>
            <div class="form-group form-group-sm">
                <label for="active">Active</label>
                <input type="checkbox" class="form-control" id="active" name="active"
                       value="<%=car.isActive()%>">
            </div>
            <input type="text" name="carId"
                   value="<%=car.getCarId()%>" hidden>
            <div class="form-group">
                <input class="btn btn-success" type="submit" value="Update">
                <a href="cars.jsp" class="btn btn-info" role="button">Cancel</a>
            </div>
        </form>
    </div>
</div>
<%
    request.getSession().removeAttribute("car");
%>
<%@include file="html/footer" %>
</body>
</html>
