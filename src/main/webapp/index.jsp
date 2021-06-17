
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="au theme template">
    <meta name="author" content="Hau Nguyen">
    <meta name="keywords" content="au theme template">

    <!-- Title Page-->
    <title>Gestion reservation</title>
<%@ include file="/includes/css.jsp" %>
  

</head>

<body class="animsition">
    <div class="page-wrapper">
        <%@ include file="/includes/header_mobile.jsp" %>

        <%@ include file="/includes/sidebar.jsp" %>

        <!-- PAGE CONTAINER-->
        <div class="page-container">
        <%@ include file="/includes/header_desktop.jsp" %>
          

            <!-- MAIN CONTENT-->
            <div class="main-content">
            
            <%@ include file="/pages/gestion_category/gestionCategory.jsp" %>
            </div>
            <!-- END MAIN CONTENT-->
            <!-- END PAGE CONTAINER-->
        </div>

    </div>

<%@ include file="/includes/js.jsp" %>

</body>

</html>
<!-- end document-->
