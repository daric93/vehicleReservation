<%@ page import="daric.vr.entities.Order" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="html/scripts_links.html" %>
    <title>payPage</title>
</head>
<body>
<%@include file="bsHeader.jsp" %>
<div class="container-fluid">
    <%
        Order order = (Order) request.getAttribute("order");
    %>
    <div class="row">
        <div class="col-sm-6">
            <p><%=order.getCarId().getCarType().getImg()%>
            </p>
            <p>Model: <%=order.getCarId().getCarType().getModel()%>
            </p>
            <p>Brand: <%=order.getCarId().getCarType().getBrand()%>
            </p>
            <p>Seats: <%=order.getCarId().getCarType().getSeats()%>
            </p>
            <p>Transmission Type: <%=order.getCarId().getCarType().getTransmissionType()%>
            </p>
            <p>Trunk Volume: <%=order.getCarId().getCarType().getTrunkVolume()%>
            </p>
            <p>Price per hour: <%=order.getCarId().getCarType().getPrice()%>
            </p>
        </div>
        <div class="col-sm-6">
            <p>Order: <%=order.getOrderId()%>
            </p>
            <p>Start date: <%=order.getStartDate()%>
            </p>
            <p>End date:<%=order.getEndDate()%>
            </p>
            <p>Total price: <%=order.getTotalPrice()%>
            </p>
            <p>Payment: <%=order.isPaymentReceived()%>
            </p>

            <%
                if (!order.isPaymentReceived()) {
            %>
            <form action="">
                <input type="submit" value="Pay">
            </form>
            <%
                }
            %>

        </div>
    </div>
</div>
<%@include file="html/footer" %>
</body>
</html>
