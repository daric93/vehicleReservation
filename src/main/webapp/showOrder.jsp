<%@ page import="daric.vr.entities.Order" %>
<%@ page import="static daric.vr.servlets.FormatUtil.formatDate" %>
<%@ page import="static daric.vr.servlets.FormatUtil.formatMoney" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="html/scripts_links.html" %>
    <title>payPage</title>
</head>
<body>
<%@include file="bsHeader.jsp" %>
<div class="container-fluid mainPage page-padding">
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
            <p>Price per hour: <%=formatMoney(order.getCar().getCarType().getPrice())%>
            </p>
        </div>
        <div class="col-sm-6">
            <p>Order: <%=order.getOrderId()%>
            </p>
            <p>Start date: <%=formatDate(order.getStartDate())%>
            </p>
            <p>End date:<%=formatDate(order.getEndDate())%>
            </p>
            <p>Total price: <%=formatMoney(order.getTotalPrice())%>
            </p>
            <p>Payment: <%=order.isPaymentReceived()%>
            </p>

            <%
                if (!order.isPaymentReceived()) {
            %>
            <a href="pay?orderId=<%=order.getOrderId()%>" class="btn btn-info" role="button">Pay</a>
            <%
                }
            %>
            <a href="editOrder.jsp?orderId=<%=order.getOrderId()%>" class="btn btn-info" role="button">Edit</a>
            <a href="cancelReservation?orderId=<%=order.getOrderId()%>" class="btn btn-info" role="button">Cancel
                Reservation</a>
            <%
            } else {
            %><p><%=request.getParameter("error")%>
        </p><%
            }
        %>

        </div>
    </div>
</div>
<%@include file="html/footer" %>
</body>
</html>
