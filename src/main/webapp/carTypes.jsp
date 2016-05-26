<%@ page import="daric.vr.entities.CarType" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="html/scripts_links.html" %>
    <title>Car Type</title>
</head>
<body>
<%@include file="adminHeader.jsp" %>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-sm-offset-1" id="mainPage">
            <div class="well">
                <form action="addCarType" method="post" enctype="multipart/form-data">
                    <div class="form-group form-group-sm form-my-style">
                        <label for="brand">Brand</label>
                        <input type="text" class="form-control" id="brand" name="brand" required>
                    </div>
                    <div class="form-group form-group-sm">
                        <label for="model">Model</label>
                        <input type="text" class="form-control" id="model" name="model" required>
                    </div>
                    <div class="form-group form-group-sm">
                        <label for="seats">Passengers</label>
                        <input type="text" class="form-control" id="seats" name="seats" required>
                    </div>
                    <div class="form-group form-group-sm">
                        <label for="transmissionType">Transmission Type</label>
                        <input type="text" class="form-control" id="transmissionType" name="transmissionType" required>
                    </div>
                    <div class="form-group form-group-sm">
                        <label for="trunkVolume">Trunk Volume</label>
                        <input type="text" class="form-control" id="trunkVolume" name="trunkVolume" required>
                    </div>
                    <div class="form-group form-group-sm">
                        <label for="price">Price per hour</label>
                        <input type="text" class="form-control" id="price" name="price" required>
                    </div>
                    <div class="form-group form-group-sm">
                        <label for="image">Image</label>
                        <input type="file" id="image" accept="image/*" name="image" required>
                    </div>
                    <div class="form-group form-group-sm">
                        <input type="submit" value="Add">
                    </div>
                </form>
                <%
                if(request.getParameter("error")!=null){
                    %>
                <p><%=request.getParameter("error")%></p>
                <%
                }
                %>
            </div>
        </div>
        <%
            if (request.getAttribute("carTypes") != null) {
                List<CarType> types = (List<CarType>) request.getAttribute("carTypes");
                if (types.isEmpty()) {
        %>
        <p>No car types</p>
        <%
            }%>
        <div class="col-sm-6 col-sm-offset-1 table-types">
            <table class="table table-striped">
                <thead class="thead-inverse">
                <tr>
                    <th>Brand</th>
                    <th>Model</th>
                    <th>Passengers</th>
                    <th>Transmission Type</th>
                    <th>Trunk Volume</th>
                    <th>Price per hour, $</th>
                    <th>Image</th>
                </tr>
                </thead>

                <tbody>
                <%
                    for (CarType type : types) {
                %>
                <tr onclick="addId(<%=type.getTypeId()%>)">
                    <td><%=type.getBrand()%>
                    </td>
                    <td><%=type.getModel()%>
                    </td>
                    <td><%=type.getSeats()%>
                    </td>
                    <td><%=type.getTransmissionType()%>
                    </td>
                    <td><%=type.getTrunkVolume()%>
                    </td>
                    <td><%=type.getPrice()%>
                    </td>
                    <td><img src="services/carType/fetchImg/<%=type.getTypeId()%>" class="img-responsive">
                    </td>
                </tr>
                <%}%>
                </tbody>
            </table>
            <% }else{
                %>
            <p>Error</p>
            <%
            }
            %>
        </div>
    </div>
    <form name="myForm" action="getCarType" method="get">
        <input type="text" name="carTypeId" hidden>
    </form>
</div>
<script>
    function addId(id) {
        document.myForm.carTypeId.value = id;
        document.myForm.submit();
    }
</script>
</body>
</html>
