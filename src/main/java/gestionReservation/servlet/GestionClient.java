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

/**
 * Servlet implementation class GestionUtilisateur
 */
@WebServlet("/GestionUtilisateur")
public class GestionClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/pages/gestion_client/gestionClient.jsp").forward(request,response);
		
	    Client client=null;
	    if(request.getParameter("id")!=null) {
	    	   client=ClientDao.getClient(Integer.parseInt(request.getParameter("id")));
	  	     request.setAttribute("client", client); 
	  	     if(request.getParameter("action")!=null) {
			    	if(request.getParameter("action").equals("delete")) {
			    		boolean b=ClientDao.supprimer(Integer.parseInt(request.getParameter("id")));
			    		request.setAttribute("success", b);
			    		request.setAttribute("action", "delete");
			    	}
	  	     }
	  
	    }
	    List<Client> list=ClientDao.lister();
	    request.setAttribute("categories", list);
	    request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		Client c=new Client();
		boolean b;
		c.setCin(request.getParameter("cin"));
		if(request.getParameter("id")!=null) {
		c.setId(Integer.parseInt(request.getParameter("id")));
		b=ClientDao.modifier(c);
		}
		else
		b=ClientDao.ajouter(c);
		request.setAttribute("success", b);
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
