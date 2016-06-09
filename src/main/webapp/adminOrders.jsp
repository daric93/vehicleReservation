<%@ page import="daric.vr.entities.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="static daric.vr.servlets.FormatUtil.formatDate" %>
<%@ page import="static daric.vr.servlets.FormatUtil.formatMoney" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="html/scripts_links.html" %>
    <title>Title</title>
</head>
<body>
<%@include file="adminHeader.jsp" %>
<div class="container-fluid mainPage">
    <div class="container page-padding">
        <div class="table-types">
            <table class="table table-striped">
                <thead class="thead-inverse">
                <tr>
                    <th>ID</th>
                    <th>Old ID</th>
                    <th>Start Date</th>
                    <th>End Date</th>
                    <th>Order Date</th>
                    <th>Payment</th>
                    <th>Total Price</th>
                    <th>Car</th>
                    <th>License</th>
                    <th>Address</th>
                    <th>Active</th>
                    <th>User</th>
                    <th>Mail</th>
                    <th>Number</th>
                </tr>
                </thead>

                <tbody>
                <%
                    List<Order> orders = (List<Order>) request.getAttribute("orders");
                    for (Order order : orders) {
                %>
                <tr onclick="addId(<%=order.getOrderId()%>)">
                    <td><%=order.getOrderId()%>
                    </td>
                    <td><%=order.getOldOrderId()%>
                    </td>
                    <td><%=formatDate(order.getStartDate())%>
                    </td>
                    <td><%=formatDate(order.getEndDate())%>
                    </td>
                    <td><%=formatDate(order.getOrderDate())%>
                    </td>
                    <%
                        if (order.isPaymentReceived()) {
                    %>
                    <td>Received</td>
                    <%
                    } else {
                    %>
                    <td>Unpaid</td>
                    <%
                        }
                    %>
                    <td><%=formatMoney(order.getTotalPrice())%>
                    </td>
                    <td><%=order.getCar().getCarType().getBrand()%> <%=order.getCar().getCarType().getModel()%>
                    </td>
                    <td><%=order.getCar().getLicenseNumber()%>
                    </td>
                    <td><%=order.getCar().getAddress()%>
                    </td>
                    <td><%=order.getCar().isActive()%>
                    </td>
                    <td><%=order.getUser().getName()%> <%=order.getUser().getSurname()%>
                    </td>
                    <td><%=order.getUser().getMail()%>
                    </td>
                    <td><%=order.getUser().getTelNumber()%>
                    </td>
                    <td>
                        <a class="hyperlink" href="deleteOrder?orderId=<%=order.getOrderId()%>">Delete</a>
                    </td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
