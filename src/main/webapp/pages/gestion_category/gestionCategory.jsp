 
                              
                                   <%  if(request.getAttribute("success")!=null){
                                	   if(Boolean.parseBoolean(request.getAttribute("success").toString())==true){
                                	   %>
                                	   <div style="padding: 25px;">
                                       <div class="sufee-alert alert with-close alert-success alert-dismissible fade show" role="alert">
											categorie ${request.getAttribute("action").toString()!=null ?"supprimèe":"enregistrèe" } avec succès 
										</div> 
										</div>     
										<% }else{%>
										 <div style="padding: 25px;">
                                       <div class="alert alert-danger" role="alert">
											un probleme est survenu,veuillez reessayer plus tard
										</div> 
										</div> 
										<% }}%>             
                      <div class="row" style="padding: 15px;">
                              <div class="col-lg-5">
                                <div class="card">
                                    <div class="card-header">
                                        <strong>${category!=null ?"Modifier":"Ajouter"}</strong> Une categorie  <c:if test="${category!=null}">
                                        <a href="<%=request.getContextPath() %>/gestionCategory"  class="btn btn-outline-success btn-sm">Ajouter</a>
                                        </c:if>
                                   
                                    </div>
                                    <div class="card-body card-block">
                                         <div class="card-body card-block">
                                         <c:choose>
                                         <c:when test="${category==null }">
                                        <form action="<%=request.getContextPath() %>/gestionCategory" method="post" class="form-horizontal">
                                        </c:when>
                                            <c:otherwise>
                                             <form action="<%=request.getContextPath() %>/gestionCategory?id=${category.getId()}" method="post" class="form-horizontal">
                                            </c:otherwise>
                                            </c:choose> 
                                             <div class="row form-group">
                                              
                                                <div class="col-12 col-md-12">
                                                    <textarea name="description" id="textarea-input" rows="9" placeholder="Description" class="form-control"><c:if test="${category!=null}"> <c:out value = "${category.getDescription()}"/></c:if></textarea>
                                                </div>
                                            </div>
                               
                                             <button class="au-btn au-btn--block au-btn--green m-b-20" type="submit">Enregistrer</button>
                                        </form>
                                    </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-7">
                                <!-- USER DATA-->
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
                                  

                                    <div class="table-responsive table-data">
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
                                                    <td>Description</td>
                                                    <td>Actions</td>
                                                   
                                                    
                                                </tr>
                                            </thead>
                                            <tbody>
                                         <c:forEach items="${categories }" var="category">
                                                <tr>
                                                    <td>
                                                        <label class="au-checkbox">
                                                            <input type="checkbox">
                                                            <span class="au-checkmark"></span>
                                                        </label>
                                                    </td>
                                                  
                                                    <td>
                                                        ${category.getId()}
                                                    </td>
                                                    <td>
                                                     ${category.getDescription()}
                                                    </td>
                                                    <td>
                                                       <div class="table-data-feature">
                                                      
                                                        <a class="item" data-toggle="tooltip" data-placement="top" title="Edit" href="<%=request.getContextPath()%>/gestionCategory?id=${category.getId()}">
                                                            <i class="zmdi zmdi-edit"></i>
                                                        </a>
                                                        <a href="<%=request.getContextPath()%>/gestionCategory?id=${category.getId()}&action=delete" class="item" data-toggle="tooltip" data-placement="top" title="Delete">
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
                                <!-- END USER DATA-->
                            </div>
</div>
                           
                       
                     
                        