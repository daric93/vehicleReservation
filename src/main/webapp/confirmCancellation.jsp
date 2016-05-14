<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="html/scripts_links.html"%>
    <title>Confirm Cancellation</title>
</head>
<body>
<%@include file="bsHeader.jsp"%>
<div class="container-fluid">
    <p>Order: <%=request.getAttribute("orderId")%></p>
    <p>Total price: <%=request.getAttribute("total")%></p>
    <p>Reservation price: <%=request.getAttribute("reservation_price")%></p>
    <form></form>
</div>
<%@include file="html/footer"%>
</body>
</html>
