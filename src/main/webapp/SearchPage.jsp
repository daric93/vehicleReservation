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
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-4">
            <form role="form" method="get" action="search">
                <div class="row-fluid">
                    <div class="col-sm-6">
                        <label for="city_up">Pick-up:</label>
                        <select class="form-control" id="city_up" name="city_up" required>
                            <option>Kharkiv</option>
                            <option>Kiev</option>
                            <option>Lvov</option>
                            <option>Odessa</option>
                        </select>
                        <br>
                        <div class="form-group">
                            <label for="datetimepicker1">Pick-up date:</label>
                            <div class='input-group date' id='datetimepicker1'>
                                <input type='text' class="form-control" name="pick_up" id="pick_up_date" required/>
            <span class="input-group-addon">
            <span class="glyphicon glyphicon-calendar"></span>
            </span>
                            </div>
                        </div>

                        <script type="text/javascript">
                            $(function () {
                                $('#datetimepicker1').datetimepicker({
                                    format: 'YYYY-MM-DD HH:mm'
                                });
                            });
                        </script>
                    </div>
                    <div class="col-sm-6">
                        <label for="city_off">Drop-off:</label>
                        <select class="form-control" id="city_off" name="city_off">
                            <option>Kharkiv</option>
                            <option>Kiev</option>
                            <option>Lvov</option>
                            <option>Odessa</option>
                        </select>
                        <br>
                        <div class="form-group">
                            <label for="datetimepicker2">Drop-off date:</label>
                            <div class='input-group date' id='datetimepicker2'>
                                <input type='text' class="form-control" name="drop_off" id="drop_off_date" required/>
            <span class="input-group-addon">
            <span class="glyphicon glyphicon-calendar"></span>
            </span>
                            </div>
                        </div>

                        <script type="text/javascript">
                            $(function () {
                                $('#datetimepicker2').datetimepicker({
                                    format: 'YYYY-MM-DD HH:mm'
                                });
                            });
                        </script>
                    </div>
                </div>
                <p>Advanced options</p>
                <div class="container-fluid">
                    <label for="type">Car type:</label>
                    <select class="form-control" id="type" required>
                        <option>None</option>
                        <option>Compact</option>
                        <option>Standard</option>
                        <option>Minivan</option>
                    </select>
                </div>
                <button type="submit" name="submit">Search</button>
            </form>
        </div>
        <div class="col-sm-8">
            <% if (request.getAttribute("cars") != null) {
                List<Car> cars = (List<Car>) request.getAttribute("cars");
                if (cars.isEmpty()) {
            %>No available cars<%
        } else {
            for (Car car : cars) {
        %>
            <div class="well">
                <p>
                    <img src="services/carType/fetchImg/<%=car.getCarType().getTypeId()%>">
                </p>
                <p>
                    Brand <%=car.getCarType().getBrand()%>
                    Model <%=car.getCarType().getModel()%>
                </p>
                <p>
                    Seats <%=car.getCarType().getSeats()%>
                    TrunkVolume <%=car.getCarType().getTrunkVolume()%>
                </p>
                <p>
                    Color <%=car.getColor()%>   TransmissionType <%=car.getCarType().getTransmissionType()%>
                </p>
                <p>
                    Address <%=car.getAddress()%>
                </p>
                <input type="button" id="book" value="Book">
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
    document.getElementById("city_off").value = "<%=request.getParameter("city_off")%>";
    document.getElementById("pick_up_date").value = "<%=request.getParameter("pick_up")%>";
    document.getElementById("drop_off_date").value = "<%=request.getParameter("drop_off")%>";
</script>
</body>
</html>
