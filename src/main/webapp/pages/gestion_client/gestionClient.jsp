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
            	<div class="row">
                <div class="col-md-6">
                    <div id="gestion_clien" class="container-fluid">
                                <div class="card">
                                    <div class="card-header">Ajouter un client</div>
                                    <div class="card-body">
                                        <div class="card-title">
                                        </div>
                                        <hr>
                                        <%  if(request.getAttribute("success")!=null){
                                	   if(Boolean.parseBoolean(request.getAttribute("success").toString())==true){
                                	   %>
                                	   <div style="padding: 25px;">
                                       <div class="sufee-alert alert with-close alert-success alert-dismissible fade show" role="alert">
											client${request.getAttribute("action").toString()!=null ?"supprimèe":"enregistrèe" } avec succès 
										</div> 
										</div>     
										<% }else{%>
										 <div style="padding: 25px;">
                                       <div class="alert alert-danger" role="alert">
											un probleme est survenu,veuillez reessayer plus tard
										</div> 
										</div> 
										<% }}%>   
                                         <c:choose>
                                         <c:when test="${client==null}">
                                        <form action="<%=request.getContextPath() %>/gestionClient?id=${client.getId()}" method="post" class="form-horizontal">
                                        </c:when>
                                            <c:otherwise>
                                             <form action="<%=request.getContextPath() %>/gestionClient?id=${client.getId()}" method="post" class="form-horizontal">
                                            </c:otherwise>
                                            </c:choose> 
                                         <div class="row">
                                                <div class="col-6">
		                                            <div class="form-group">
		                                                <label for="cc-payment" class="control-label mb-1">CIN</label>
		                                                <input value="<c:if test="${client!=null}"> <c:out value = "${client.getCin()}"/></c:if>" id="cc-cin" name="cc-payment" type="text" class="form-control" aria-required="true" aria-invalid="false">
		                                            </div>
		                                    	</div>
		                                    	<div class="col-6">
		                                            <div class="form-group">
		                                                <label for="cc-payment" class="control-label mb-1">Etat civile</label>
		                                                <select id="cc-etat-civil" name="cc-etat-civil" class="form-control" aria-required="true" aria-invalid="false">
		                                                	<option>Celibataire</option>
		                                                	<option>Marié</option>
		                                                	<option>Veuve</option>
		                                                </select>
		                                            </div>
		                                    	</div>
		                                    </div>
                                            <div class="row">
                                                <div class="col-6">
		                                            <div class="form-group has-success">
		                                                <label for="cc-name" class="control-label mb-1">Nom</label>
		                                                <input value="<c:if test="${client!=null}"> <c:out value = "${client.getNom()}"/></c:if>" id="cc-name" name="cc-name" type="text" class="form-control cc-name valid" data-val="true" data-val-required="Please enter the name on card" autocomplete="cc-name" aria-required="true" aria-invalid="false" aria-describedby="cc-name-error">
		                                                <span class="help-block field-validation-valid" data-valmsg-for="cc-name" data-valmsg-replace="true"></span>
		                                            </div>
		                                        </div>
		                                        <div class="col-6">
		                                            <div class="form-group">
		                                                <label for="cc-number" class="control-label mb-1">Prenom</label>
		                                                <input value="<c:if test="${client!=null}"> <c:out value = "${client.getPrenom()}"/></c:if>" id="cc-number" name="cc-prenom" type="text" class="form-control cc-prenom identified visa" value="" data-val="true" data-val-required="Please enter the card number" data-val-cc-number="Please enter a valid card number" autocomplete="cc-number">
		                                                <span class="help-block" data-valmsg-for="cc-number" data-valmsg-replace="true"></span>
		                                            </div>
		                                         </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-6">
                                                    <div class="form-group">
                                                        <label for="cc-date-naissance" class="control-label mb-1">Date de naissance</label>
                                                        <input value="<c:if test="${client!=null}"> <c:out value = "${client.getDate_naissance()}"/></c:if>" id="cc-exp" name="cc-date-naissance" type="text" class="form-control cc-exp" value="" data-val="true" data-val-required="Please enter the card expiration" data-val-cc-exp="Please enter a valid month and year" placeholder="MM / YY" autocomplete="cc-exp">
                                                        <span class="help-block" data-valmsg-for="cc-exp" data-valmsg-replace="true"></span>
                                                    </div>
                                                </div>
                                                <div class="col-6">
                                                    <label for="cc-lieux-naissance" class="control-label mb-1">Lieux de naisssance</label>
                                                    <div class="input-group">
                                                        <input value="<c:if test="${client!=null}"> <c:out value = "${client.getLieu_naissance()}"/></c:if>" id="cc-lieux-naissance" name="lieux_naissance" type="tel" class="form-control cc-lieux-naissance" value="" data-val="true" data-val-required="SVP entrer votre lieux de naissance" data-val-cc-lieux-naissance="Please enter a valid security code" autocomplete="off">
                                                    </div>
                                                </div>
                                            </div>
                                         <div class="row">
                                                <div class="col-6">
                                                    <div class="form-group">
                                                        <label for="cc-date-naissance" class="control-label mb-1">Nationalite</label>
                                                        <input value="<c:if test="${client!=null}"> <c:out value = "${client.getNationalite()}"/></c:if>" id="cc-nationalite" name="cc-date-naissance" type="text" class="form-control cc-nationalite"  data-val="true" data-val-required="Please enter the card expiration" data-val-cc-exp="Please enter a valid month and year" placeholder="MM / YY" autocomplete="cc-exp">
                                                        <span class="help-block" data-valmsg-for="cc-exp" data-valmsg-replace="true"></span>
                                                    </div>
                                                </div>
                                                <div class="col-6">
                                                    <label for="cc-lieux-adress" class="control-label mb-1">Adresse</label>
                                                    <div class="input-group">
                                                        <input value="<c:if test="${client!=null}"> <c:out value = "${client.getAddresse()}"/></c:if>" id="cc-adress" name="lieux_naissance" type="text" class="form-control cc-adress" value="" data-val="true" data-val-required="SVP entrer votre lieux de naissance" data-val-cc-lieux-naissance="Please enter a valid security code" autocomplete="off">
                                                    </div>
                                                </div>
                                            </div>
                                            <div>
                                                <button id="payment-button" type="submit" class="btn btn-lg btn-info btn-block">
                                                    <span id="payment-button-amount">Ajouter</span>
                                                    <span id="payment-button-sending" style="display:none;">Sending…</span>
                                                </button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                      
                            <div class="col-md-12">
                                <div class="copyright">
                                    <p>Copyright © 2018 Colorlib. All rights reserved. Template by <a href="https://colorlib.com">Colorlib</a>.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                <div class="col-md-6">
                    <div id="gestion_clien" class="container-fluid">
                                <div class="card">
                                    <div class="card-header">Clients Valable</div>
                                    <div class="card-body">
                                        <div class="card-title">
                                        </div>
                                        <hr>
                                        <div class="user-data m-b-30">
                                  
                                    <div class="filters m-b-45">
                                        <div class="rs-select2--dark rs-select2--md m-r-10 rs-select2--border">
                                            <select class="js-select2" name="property">
                                                <option selected="selected">All Properties</option>
                                                <option value="">Products</option>
                                                <option value="">Services</option>
                                            </select>
                                            <div class="dropDownSelect2"></div>
                                        </div>
                                        <div class="rs-select2--dark rs-select2--sm rs-select2--border">
                                            <select class="js-select2 au-select-dark" name="time">
                                                <option selected="selected">All Time</option>
                                                <option value="">By Month</option>
                                                <option value="">By Day</option>
                                            </select>
                                            <div class="dropDownSelect2"></div>
                                        </div>
                                    </div>
                                  

                                    <div class="table-data">
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <td>
                                                        <label class="au-checkbox">
                                                            <input type="checkbox">
                                                            <span class="au-checkmark"></span>
                                                        </label>
                                                    </td>
                                                    <td>ID</td>
                                                    <td>Cin</td>
                                                    <td>Nom</td>
                                                    <td>Prenom</td>
                                                    
                                                </tr>
                                            </thead>
                                            <tbody>
                                         <c:forEach items="${clients}" var="client">
                                                <tr>
                                                    <td>
                                                        <label class="au-checkbox">
                                                            <input type="checkbox">
                                                            <span class="au-checkmark"></span>
                                                        </label>
                                                    </td>
                                                  
                                                    <td>
                                                        ${client.getId()}
                                                    </td>
                                                    <td>
                                                    	${client.getCin()}
                                                    </td>
                                                    <td>
                                                    	${client.getNom()}
                                                    </td>
                                                    <td>
                                                    	${client.getPrenom()}
                                                    </td>
                                                    <td>
                                                       <div class="table-data-feature">
                                                      
                                                        <a class="item" data-toggle="tooltip" data-placement="top" title="Edit" href="<%=request.getContextPath()%>/gestionClient?id=${client.getId()}">
                                                            <i class="zmdi zmdi-edit"></i>
                                                        </a>
                                                        <a href="<%=request.getContextPath()%>/gestionClient?id=${client.getId()}&action=delete" class="item" data-toggle="tooltip" data-placement="top" title="Delete">
                                                            <i class="zmdi zmdi-delete"></i>
                                                        </a>
                                                     
                                                    </div>
                                                    </td>
                                               </tr>
                                              </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                    
                                </div>
                                    </div>
                                </div>
                         
                        </div>
                    </div>
                
                </div>
                </div>
            </div>
            <!-- END MAIN CONTENT-->
            <!-- END PAGE CONTAINER-->
        </div>


<%@ include file="/includes/js.jsp" %>

</body>

</html>
<!-- end document-->
