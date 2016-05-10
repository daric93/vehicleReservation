<%@ page import="daric.vr.entities.User" %>
<%@ page import="daric.vr.entities.Order" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="html/scripts_links.html" %>
    <title>Orders</title>
</head>
<body>
<%@include file="bsHeader.jsp" %>
<div class="container-fluid">
    <%
        User user = (User) request.getAttribute("orders");
        if (user.getOrders().isEmpty()) {
    %>
    <p>No orders</p>
    <%
        }%>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Order Id</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Price</th>
            <th>Payment</th>
        </tr>
        </thead>
        <tbody>
        <%
            for(Order order: user.getOrders()){
        %>
        <tr>
            <th><%=order.getOrderId()%>
            </th>
            <th><%=order.getStartDate()%>
            </th>
            <th><%=order.getEndDate()%>
            </th>
            <th><%=order.getTotalPrice()%>
            </th>
            <th><%
                if (order.isPaymentReceived()) { %>Received
                <%
                } else {%>Unpaid<%}%>
            </th>
        </tr>
        <%
                            };
        %>
        </tbody>
    </table>
</div>
<%@include file="html/footer" %>
</body>
</html>
