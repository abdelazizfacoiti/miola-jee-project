package gestionReservation.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gestionReservation.beans.Category;
import gestionReservation.beans.Client;
import gestionReservation.dao.ClientDao;
import gestionReservation.dao.DaoFactory;

/**
 * Servlet implementation class GestionUtilisateur
 */
@WebServlet("/GestionUtilisateur")
public class GestionClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClientDao clientDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionClient() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	DaoFactory daoFactory=DaoFactory.getInstance();
    	clientDao=daoFactory.getClientDao(daoFactory);
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/pages/gestion_client/gestionClient.jsp").forward(request,response);
		
	    Client client=null;
	    if(request.getParameter("id")!=null) {
	    	   client=clientDao.getClient(Integer.parseInt(request.getParameter("id")));
	  	     request.setAttribute("client", client); 
	  	     if(request.getParameter("action")!=null) {
			    	if(request.getParameter("action").equals("delete")) {
			    		boolean b=clientDao.supprimer(Integer.parseInt(request.getParameter("id")));
			    		request.setAttribute("success", b);
			    		request.setAttribute("action", "delete");
			    	}
	  	     }
	  
	    }
	    List<Client> list=clientDao.lister();
	    request.setAttribute("client", list);
	    request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
