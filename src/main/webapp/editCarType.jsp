<%@ page import="daric.vr.entities.CarType" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="html/scripts_links.html" %>
    <title>Title</title>
</head>
<body>
<%@include file="adminHeader.jsp" %>
<div class="container-fluid">
    <div class="row">
        <%
            CarType carType = (CarType) request.getAttribute("carType");
            if (request.getAttribute("error") != null) {
        %><p><%=request.getAttribute("error")%>
    </p><%
        }
    %>
        <form action="updateCarType" method="post" enctype="multipart/form-data">
            <div class="col-sm-3 col-sm-offset-4">
                <div class="form-group form-group-sm">
                    <input id="image" type="file" accept="image/*" name="image"
                           value="services/carType/fetchImg/<%=carType.getTypeId()%>">
                    <script>
                        $("#image").fileinput({
                            autoReplace: true,
                            overwriteInitial: true,
                            showUploadedThumbs: false,
                            showUpload: false,
                            maxFileCount: 1,
                            initialPreview: [
                                "<img src='services/carType/fetchImg/<%=carType.getTypeId()%>'>"
//                                "<img style='height:160px' src='http://lorempixel.com/200/150/nature/1'>"
                            ],
                            initialCaption: 'Initial-Image.jpg',
                            initialPreviewShowDelete: false,
                            showRemove: false,
                            showClose: false,
                            layoutTemplates: {actionDelete: ''}, // disable thumbnail deletion
                            allowedFileExtensions: ["jpg", "png", "gif"]
                        });
                    </script>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="form-group form-group-sm form-my-style">
                    <label for="brand">Brand</label>
                    <input type="text" class="form-control" id="brand" name="brand"
                           value="<%=carType.getBrand()%>"
                           required>
                </div>
                <div class="form-group form-group-sm">
                    <label for="model">Model</label>
                    <input type="text" class="form-control" id="model" name="model"
                           value="<%=carType.getModel()%>"
                           required>
                </div>
                <div class="form-group form-group-sm">
                    <label for="seats">Passengers</label>
                    <input type="text" class="form-control" id="seats" name="seats"
                           value="<%=carType.getSeats()%>"
                           required>
                </div>
                <div class="form-group form-group-sm">
                    <label for="transmissionType">Transmission Type</label>
                    <input type="text" class="form-control" id="transmissionType" name="transmissionType"
                           value="<%=carType.getTransmissionType()%>" required>
                </div>
                <div class="form-group form-group-sm">
                    <label for="trunkVolume">Trunk Volume</label>
                    <input type="text" class="form-control" id="trunkVolume" name="trunkVolume"
                           value="<%=carType.getTrunkVolume()%>" required>
                </div>
                <div class="form-group form-group-sm">
                    <label for="price">Price per hour</label>
                    <input type="text" class="form-control" id="price" name="price"
                           value="<%=carType.getPrice()%>"
                           required>
                </div>
                <div class="form-group form-group-sm">
                    <input type="text" class="form-control" id="carTypeId" name="carTypeId"
                           value="<%=carType.getTypeId()%>" hidden
                           required>
                </div>
                <div class="form-group form-group-sm">
                    <input type="submit" value="Update">
                </div>

                <a href="carTypes.jsp" class="btn btn-info" role="button">Cancel</a>

            </div>
        </form>
    </div>

</div>
<script>
</script>
</body>
</html>
