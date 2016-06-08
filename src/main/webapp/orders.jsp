<%@ page import="daric.vr.entities.Order" %>
<%@ page import="daric.vr.entities.User" %>
<%@ page import="static daric.vr.servlets.FormatUtil.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="html/scripts_links.html" %>
    <title>Orders</title>
</head>
<body>
<%@include file="bsHeader.jsp" %>
<div class="container-fluid mainPage page-padding">
    <%
        User user = (User) request.getAttribute("user");
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
            for (Order order : user.getOrders()) {
        %>
        <tr onclick="getElements(this)">
            <td id="id"><%=order.getOrderId()%>
            </td>
            <td><%=formatDate(order.getStartDate())%>
            </td>
            <td><%=formatDate(order.getEndDate())%>
            </td>
            <td><%=formatMoney(order.getTotalPrice())%>
            </td>
            <td><%
                if (order.isPaymentReceived()) { %>Received
                <%
                } else {%>Unpaid<%}%>
            </td>
        </tr>
        <%
            }
            ;
        %>
        </tbody>
    </table>
    <form name="myForm" action="showOrder.jsp" method="post">
        <input type="text" name="orderId" hidden>
    </form>
</div>
<%@include file="html/footer" %>
</body>
<script>
    function getElements(row) {
        document.myForm.orderId.value = row.cells[0].innerText;
        document.myForm.submit();
    }
</script>
</html>
