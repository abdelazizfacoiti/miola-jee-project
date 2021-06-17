    <!-- MENU SIDEBAR-->
        <aside class="menu-sidebar d-none d-lg-block">
            <div class="logo" style="color: red;">
               <a href="#">
                  
                      <img  alt="" src="<%=request.getContextPath() %>/assets/images/hotel.png" width=70 height=50>
                </a>
                
            </div>
            <div class="menu-sidebar__content js-scrollbar1">
                <nav class="navbar-sidebar">
                    <ul class="list-unstyled navbar__list">
                        <li class="active has-sub">
                            <a class="js-arrow" href="#">
                                <i class="fas fa-tachometer-alt"></i>Tableau de bord</a>
    
                        </li>
                        <li>
                            <a href="<%=request.getContextPath() %>/gestionClient">
                                <i class="fas fa-calendar-alt"></i>Gestion Client</a>
                        </li>
                        <li>
                            <a href="table.html">
                                <i class="fas fa-table"></i>Gestion Chambre</a>
                        </li>
                        <li>
                            <a href="form.html">
                                <i class="far fa-check-square"></i>Gestion Reservation</a>
                        </li>
                        <li>
                            <a href="<%=request.getContextPath() %>/gestionCategory">
                                <i class="fas fa-calendar-alt"></i>Gestion Categorie</a>
                        </li>
                       
                    </ul>
                </nav>
            </div>
        </aside>
        <!-- END MENU SIDEBAR-->