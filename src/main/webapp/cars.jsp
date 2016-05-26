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
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-sm-offset-1" id="mainPage">
            <div class="well">
                <form action="addCar" method="post">
                    <%
                        List<CarType> carTypes = (List<CarType>) request.getAttribute("carTypes");
                    %>
                    <div class="form-group form-group-sm">
                        <label for="carType">Select Car Type</label>
                        <select class="form-control" id="carType" name="carType">
                            <%
                                for (CarType carType : carTypes) {
                            %>
                            <option value="<%=carType.getTypeId()%>"><%=carType.getBrand()%>, <%=carType.getModel()%>
                            </option>
                            <%
                                }
                            %>
                        </select>
                    </div>
                    <div class="form-group form-group-sm">
                        <label for="address">Address</label>
                        <input type="text" class="form-control" id="address" name="address" required>
                    </div>
                    <div class="form-group form-group-sm">
                        <label for="color">Color</label>
                        <input type="text" class="form-control" id="color" name="color" required>
                    </div>
                    <div class="form-group form-group-sm">
                        <label for="number">Number</label>
                        <input type="text" class="form-control" id="number" name="number" required>
                    </div>
                    <div class="form-group form-group-sm">
                        <label for="active">Active</label>
                        <input type="checkbox" class="form-control" id="active" name="active" value="true">
                    </div>
                    <div class="form-group form-group-sm">
                        <input type="submit" value="Add">
                    </div>
                </form>
            </div>
        </div>
        <%
            if (request.getAttribute("cars") != null) {
                List<Car> cars = (List<Car>) request.getAttribute("cars");
                if (cars.isEmpty()) {
        %>
        <p>No car types</p>
        <%
            }%>
        <div class="col-sm-6 col-sm-offset-1 table-types">
            <table class="table table-striped">
                <thead class="thead-inverse">
                <tr>
                    <th>Car Type</th>
                    <th>Address</th>
                    <th>Number</th>
                    <th>Color</th>
                    <th>Active</th>
                </tr>
                </thead>

                <tbody>
                <%
                    for (Car car : cars) {
                %>
                <tr onclick="addId(<%=car.getCarId()%>)">
                    <td><%=car.getCarType().getTypeId()%>
                    </td>
                    <td><%=car.getAddress()%>
                    </td>
                    <td><%=car.getLicenseNumber()%>
                    </td>
                    <td><%=car.getColor()%>
                    </td>
                    <td><%=car.isActive()%>
                    </td>

                    <%--<td><img src="services/carType/fetchImg/<%=car.getTypeId()%>" class="img-responsive">--%>
                    <%--</td>--%>
                </tr>
                <%}%>
                </tbody>
            </table>
            <% }
            %>
        </div>
    </div>
    <form name="myForm" action="getCarType" method="get">
        <input type="text" name="carTypeId" hidden>
    </form>
</div>
<script>
    function addId(id) {
        document.myForm.carTypeId.value = id;
        document.myForm.submit();
    }
</script>
</body>
</html>
