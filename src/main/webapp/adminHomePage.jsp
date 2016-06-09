<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="html/scripts_links.html" %>
    <title>Home Page</title>
</head>
<body>
<%@include file="adminHeader.jsp" %>
<div class="container-fluid mainPage">
    <div class="container page-padding">
        <h3>Car types</h3>
        <p>To work with the types of machines must select CarTypes tab from the menu. Then a window listing all machine
            types in the database and the form to add a new type. To add a new type you must enter all fields and click
            Add. If one of the form fields not entered or entered incorrectly, it displays a message. If introduced make
            and model car already present in the database, it displays a warning about an existing record. If
            successful, the addition of such it appears in the list on the page.
        <h3>Editing type</h3>
        <p>To edit the type of machine you must click on the selected entry, and then opens for editing. Administrator
            can change the required fields. To confirm the changes press the button Update. If one of the form fields
            not entered or entered incorrectly, it displays a message. If introduced make and model car already present
            in the database, it displays a warning about an existing record and change happens. A successful change
            manager returned to the types. To complete the editing without changes must click Cancel.
        <h3>Remove type</h3>
        <p>To remove such machines must click on the selected entry, and then opens for editing, where removal is
            necessary to click on Remove. If this type of machine is not used in the description of the machine, the
            account will be deleted, or displayed warning and recording is not deleted.
        <h3>Cars</h3>
        <p>To work with the machines need to select the menu tab Vehicles. Then a window with a list of all machines in
            a database and to add a new form. To add a new machine must enter all fields and click Add. If one of the
            form fields not entered or entered incorrectly, it displays a message. If the number of machines already
            present in the database, it displays a warning about an existing record. Upon successful adding machine is
            shown in the list on the page.
        <h3>Editing car</h3>
        <p>To edit machine must click on the selected entry, and then opens for editing. Administrator can change the
            required fields. To confirm the changes press the button Update. If one of the form fields not entered or
            entered incorrectly, it displays a message. If the number entered machines already present in the database,
            it displays a warning about an existing record and change happens. A successful change manager returns to
            the machines. To complete the editing without changes must click Cancel.
        <h3>Removing the car</h3>
        <p>To remove the machine must click on the selected entry, and then opens for editing, where removal is
            necessary to click on Remove. If this machine has no orders, the account will be deleted, or displayed
            warning and recording is not deleted.
        <h3>Order</h3>
        <p>To work with orders Orders must select a tab from the menu. Then a window with a list of all orders in the
            database. For removal order must click on the selected entry, then a window with details of the order where
            you need to click Remove.
        <h3>End of session</h3>
        <p>To end the session must click on the icon in the right corner of the user menu and choose Log Out.
    </div>
</div>
</body>
</html>
