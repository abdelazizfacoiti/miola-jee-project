<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Se connecter ici</title>
<%@ include file="/includes/css.jsp" %>
</head>
<body class="animsition">
    <div class="page-wrapper">
        <div class="page-content--bge5">
            <div class="container">
                <div class="login-wrap">
                    <div class="login-content">
                        <div class="login-logo">
                         
                            <a href="#">
                      <img alt="" src="<%=request.getContextPath() %>/assets/images/hotel.png" width=100 height=100>
                            </a>
                           
                        </div>
                         
                        <div class="login-form">
                            <form action="<%=request.getContextPath() %>/login" method="post">
                                <div class="form-group">
                                    <label>Nom d'utilisateur</label>
                                    <input class="au-input au-input--full" type="text" name="username" placeholder="Nom d'utilisateur">
                                </div>
                                <div class="form-group">
                                    <label>Mot de passe</label>
                                    <input class="au-input au-input--full" type="password" name="password" placeholder="Mot de passe">
                                </div>
                                
                                <button class="au-btn au-btn--block au-btn--green m-b-20" type="submit">se connecter</button>
                                
                      
                            </form>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
<%@ include file="/includes/js.jsp" %>
<script type="text/javascript">

</script>
</body>

</html>