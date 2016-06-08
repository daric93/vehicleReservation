<%@ page import="daric.vr.entities.Car" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="html/scripts_links.html" %>
    <title>Search</title>
</head>
<body>
<%@include file="bsHeader.jsp" %>
<div class="container-fluid mainPage page-padding" id="searchDiv">
    <div class="row">
        <div>
            <div class="wrapper col-sm-offset-1" id="cont">
                <%@include file="html/searchBox.html" %>
            </div>
        </div>
        <div class="col-sm-7">
            <%
                String error = (String) request.getParameter("error");
                if (error != null) {
            %>
            <div class="alert-warning alert-dismissable">
                <%=error%>
            </div>
            <%
                }
                if (request.getAttribute("cars") != null) {
                    List<Car> cars = (List<Car>) request.getAttribute("cars");
                    if (cars.isEmpty()) {
            %>No available cars<%
        } else {
            for (Car car : cars) {
        %>
            <div class="well wellColor">
                <div class="row">
                    <div class="col-sm-3 font-li-my">
                        <ul class="list-unstyled list-my">
                            <li title="Air conditioning">
                                <img src="img/glyphicons-22-snowflake.png" class="img-icons">
                                Air conditioning
                            </li>
                            <li title="Passengers">
                                <img src="img/glyphicons-593-person.png" class="img-icons">
                                <%=car.getCarType().getSeats()%> passengers
                            </li>
                            <li title="Transmission">
                                <img src="img/294168-200.png" class="img-icons">
                                <%=car.getCarType().getTransmissionType()%> transmission
                            </li>
                            <li title="Trunk Volume">
                                <img src="img/glyphicons-34-luggage.png" class="img-icons">
                                <%=car.getCarType().getTrunkVolume()%> trunk capacity
                            </li>
                        </ul>
                    </div>
                    <div class="col-sm-2 font-li-my">
                        <ul class="list-unstyled list-my">
                            <li title="Address">
                                <img src="img/glyphicons-243-map-marker.png" class="img-icons">
                                <%=car.getAddress()%>
                            </li>
                            <li title="Price">
                                <img src="img/glyphicons-228-usd.png" class="img-icons">
                                <%=car.getCarType().getPrice()%> per hour
                            </li>
                        </ul>
                    </div>
                    <div class="col-sm-3 text-center car-brand">
                        <p><%=car.getCarType().getBrand()%>
                        </p>
                        <p><%=car.getCarType().getModel()%>
                        </p>
                    </div>
                    <div class="col-sm-4">
                        <img src="services/carType/fetchImg/<%=car.getCarType().getTypeId()%>"
                             class="img-responsive">
                    </div>
                </div>
                <div class="text-left">
                    <form onsubmit="bookCar(this)" name="car" method="post" action="reserve">
                        <input type="hidden" name="id" value="<%=car.getCarId()%>">
                        <input type="hidden" name="price" value="<%=car.getCarType().getPrice()%>">
                        <input class="btn btn-success" type="submit" value="Reserve">
                    </form>
                </div>
            </div>
            <%
                        }
                    }
                }
            %>
        </div>
    </div>
</div>
<%@include file="html/footer" %>
<script>
    document.getElementById("city_up").value = "<%=request.getParameter("city_up")%>";
    document.getElementById("pick_up_date").value = "<%=request.getParameter("pick_up")%>";
    document.getElementById("drop_off_date").value = "<%=request.getParameter("drop_off")%>";

    function addHidden(theForm, key, value) {
        var input = document.createElement('input');
        input.type = 'hidden';
        input.name = key;
        input.value = value;
        theForm.appendChild(input);
    }

    function bookCar(form) {
        addHidden(form, 'city_up', document.getElementById("city_up").value);
        addHidden(form, 'pick_up', document.getElementById("pick_up_date").value);
        addHidden(form, 'drop_off', document.getElementById("drop_off_date").value);
    }
</script>
</body>
</html>
