<%@ page import="daric.vr.entities.Order" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="html/scripts_links.html" %>
    <title>Title</title>
</head>
<body>
<%@include file="bsHeader.jsp" %>
<div class="container-fluid mainPage page-padding">
    <%
        if (request.getParameter("error") != null) {
    %>
    <div class="alert-danger">
        <%=request.getParameter("error")%>
    </div>
    <%
        }
        Order order = (Order) request.getAttribute("order");
    %>
    <div class="row">
        <div class="col-sm-4">
            <img src="services/carType/fetchImg/<%=order.getCar().getCarType().getTypeId()%>"
                 class="img-responsive">
            <p><%=order.getCar().getCarType().getBrand()%>
            </p>
            <p><%=order.getCar().getCarType().getModel()%>
            </p>
        </div>
        <div class="col-sm-4">
            <ul class="list-unstyled list-my">
                <li title="Air conditioning">
                    <img src="img/glyphicons-22-snowflake.png" class="img-icons">
                    Air conditioning
                </li>
                <li title="Passengers">
                    <img src="img/glyphicons-593-person.png" class="img-icons">
                    <%=order.getCar().getCarType().getSeats()%> passengers
                </li>
                <li title="Transmission">
                    <img src="img/294168-200.png" class="img-icons">
                    <%=order.getCar().getCarType().getTransmissionType()%> transmission
                </li>
                <li title="Trunk Volume">
                    <img src="img/glyphicons-34-luggage.png" class="img-icons">
                    <%=order.getCar().getCarType().getTrunkVolume()%> trunk capacity
                </li>
                <li title="Address">
                    <img src="img/glyphicons-243-map-marker.png" class="img-icons">
                    <%=order.getCar().getAddress()%>
                </li>
                <li title="Price">
                    <img src="img/glyphicons-228-usd.png" class="img-icons">
                    <%=order.getCar().getCarType().getPrice()%> per hour
                </li>
            </ul>
        </div>
        <div class="col-sm-4">
            <p>Start date:
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
                        format: 'YYYY-MM-DD HH:mm',
                        date: moment('<%=order.getStartDate()%>', 'YYYY-MM-DD HH:mm')
                    }).on("dp.change", function () {
                        calculatePrice();
                    });
                });
            </script>
            </p>
            <p>End date:
            <div class="form-group">
                <label for="datetimepicker2">Drop-off date:</label>
                <div class='input-group date' id='datetimepicker2'>
                    <input type='text' class="form-control" name="drop_off"
                           id="drop_off_date" required/>
            <span class="input-group-addon">
            <span class="glyphicon glyphicon-calendar"></span>
            </span>
                </div>
            </div>

            <script type="text/javascript">
                $(function () {
                    $('#datetimepicker2').datetimepicker({
                        format: 'YYYY-MM-DD HH:mm',
                        date: moment('<%=order.getEndDate()%>', 'YYYY-MM-DD HH:mm')
                    }).on("dp.change", function () {
                        calculatePrice();
                    });
                });
            </script>
            </p>
            <p id="totalPrice">Total price: <%=order.getTotalPrice()%>
            </p>
            <form onsubmit="addDates(this)" method="post" action="updateOrder">
                <input type="hidden" name="orderId" value="<%=order.getOrderId()%>">>
                <input class="btn btn-success" type="submit" value="Change">
            </form>
            <a href="orders.jsp" class="btn btn-info" role="button">Cancel</a>
        </div>
    </div>
</div>
<%@include file="html/footer" %>
<script>

    function calculatePrice() {
        var price_per_hour = <%=order.getCar().getCarType().getPrice()%>;
        var pick_up = $("#datetimepicker1").data("DateTimePicker").date();
        var drop_off = $("#datetimepicker2").data("DateTimePicker").date();
        var diff = drop_off.diff(pick_up, "minutes");
        var price = diff * (price_per_hour / 60.0);
        document.getElementById("totalPrice").innerHTML = "Total price: " + price;
    }

    function addHidden(theForm, key, value) {
        var input = document.createElement('input');
        input.type = 'hidden';
        input.name = key;
        input.value = value;
        theForm.appendChild(input);
    }
    function addDates(form) {
        addHidden(form, "pick_up", document.getElementById("pick_up_date").value);
        addHidden(form, "drop_off", document.getElementById("drop_off_date").value);
    }
</script>
</body>
</html>
