package gestionReservation.servlet;

import java.io.IOException;

import gestionReservation.beans.Utilisateur;
import gestionReservation.dao.DaoFactory;
import gestionReservation.dao.UtilisateurDao;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class UtilisateurServlet
 */

public class UtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurDao utilisateurDao;
	private DaoFactory daoFactory;

    /**
     * Default constructor. 
     */
    public UtilisateurServlet() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	daoFactory=DaoFactory.getInstance();
    	utilisateurDao=daoFactory.getUtilisateurDao(daoFactory);
    }
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//request.setAttribute("data",utilisateurDao.authentication("anas", "anas") );
		request.getRequestDispatcher("/pages/login.jsp").forward(request,response);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		Utilisateur u=new Utilisateur();
		u.setUsername(req.getParameter("username"));
		u.setPassword(req.getParameter("password"));
		boolean b=utilisateurDao.authentication(u);
		System.out.print("auth"+b);
		if(b)
			//req.getRequestDispatcher("/pages/dashboard.jsp").forward(req,resp);
			resp.sendRedirect(req.getContextPath() + "/dashboard");
		else
			resp.sendRedirect(req.getContextPath() + "/login");
		
	}

	

}
