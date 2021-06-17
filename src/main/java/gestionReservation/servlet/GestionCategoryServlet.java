package gestionReservation.servlet;

import java.io.IOException;
import java.util.List;

import gestionReservation.beans.Category;
import gestionReservation.dao.CategoryDao;
import gestionReservation.dao.DaoFactory;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class GestionChambreServlet
 */

public class GestionCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoryDao categoryDao;
    /**
     * Default constructor. 
     */
    public GestionCategoryServlet() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	DaoFactory daoFactory=DaoFactory.getInstance();
    	categoryDao=daoFactory.getCategoryDao(daoFactory);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		
		
		
	    Category category=null;
	    if(request.getParameter("id")!=null) {
	    	   category=categoryDao.getCategory(Integer.parseInt(request.getParameter("id")));
	  	     request.setAttribute("category", category); 
	  	     if(request.getParameter("action")!=null) {
	    	if(request.getParameter("action").equals("delete")) {
	    		boolean b=categoryDao.supprimer(Integer.parseInt(request.getParameter("id")));
	    		request.setAttribute("success", b);
	    		request.setAttribute("action", "delete");
	    	}
	  	     }
	  
	    }
	    List<Category> list=categoryDao.lister();
	    request.setAttribute("categories", list);
	    request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Category c=new Category();
		boolean b;
		c.setDescription(request.getParameter("description"));
		if(request.getParameter("id")!=null) {
		c.setId(Integer.parseInt(request.getParameter("id")));
		b=categoryDao.modifier(c);
		}
		else
		b=categoryDao.ajouter(c);
		request.setAttribute("success", b);
		doGet(request, response);
		
	}

}
