<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="html/scripts_links.html" %>
    <title>Title</title>
</head>
<body>
<%@include file="bsHeader.jsp" %>
<div class="container">
    <div class="row">
        <fieldset class="col-sm-4">
            <legend>Our Contacts</legend>
            <address>
                <strong>CarReservation</strong><br>
                Heroev Truda, 19G<br>
                Kharkiv, Ukraine<br>
                <a href="mailto:#">daric2612@gmail.com</a><br>
                <abbr title="Phone">P:</abbr> +38(096) 36-87-818
            </address>
            <form action="#" method="post">
                <div class="form-group">
                    <label class="control-label">Comments</label>
                <textarea class="form-control" rows="3" name="message"
                          placeholder="Your question or comment here"></textarea>
                </div>
                <div class="form-actions">
                    <input type="submit" class="btn btn-info" value="Send">
                </div>
            </form>
        </fieldset>
        <div id="map-container" class="col-sm-8"></div>
    </div>
</div>
<%@include file="html/footer" %>
<script src="http://maps.google.com/maps/api/js?sensor=false"></script>
<script>

    function init_map() {
        var myLocation = new google.maps.LatLng(50.024577, 36.345500);

        var mapOptions = {
            center: myLocation,
            zoom: 14
        };

        var marker = new google.maps.Marker({
            position: myLocation,
            title: "Heroev Truda, 19G, Kharkiv, Ukraine"
        });

        var map = new google.maps.Map(document.getElementById("map-container"),
                mapOptions);

        marker.setMap(map);

    }

    google.maps.event.addDomListener(window, 'load', init_map);

</script>
</body>
</html>
