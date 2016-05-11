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
        if (order != null) {
    %>
    <div class="row">
        <div class="col-sm-6">
            <p><%=order.getCar().getCarType().getImg()%>
            </p>
            <p>Model: <%=order.getCar().getCarType().getModel()%>
            </p>
            <p>Brand: <%=order.getCar().getCarType().getBrand()%>
            </p>
            <p>Seats: <%=order.getCar().getCarType().getSeats()%>
            </p>
            <p>Transmission Type: <%=order.getCar().getCarType().getTransmissionType()%>
            </p>
            <p>Trunk Volume: <%=order.getCar().getCarType().getTrunkVolume()%>
            </p>
            <p>Price per hour: <%=order.getCar().getCarType().getPrice()%>
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
            <form action="" method="">
                <input type="submit" value="Pay">
            </form>
            <form action="" method="">
                <input type="submit" value="Change dates">
            </form>
            <form action="" method="">
                <input type="submit" value="Cancel reservation">
            </form>
            <%
                }
            } else {
            %><p><%=request.getAttribute("error")%>
        </p><%
            }
        %>

        </div>
    </div>
</div>
<%@include file="html/footer" %>
</body>
</html>
