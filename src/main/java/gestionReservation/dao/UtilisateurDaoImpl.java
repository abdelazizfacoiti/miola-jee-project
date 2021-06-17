package gestionReservation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import gestionReservation.beans.Utilisateur;

public class UtilisateurDaoImpl implements UtilisateurDao{
	
	private DaoFactory dao;

	public UtilisateurDaoImpl(DaoFactory dao) {
		super();
		this.dao = dao;
	}

	@Override
	public boolean authentication(Utilisateur u) {
		Connection cnx=null;
		PreparedStatement stm;
		boolean result = false;
		
		try {
			cnx=dao.getConnection();
			stm=cnx.prepareStatement("select * from utilisateur where login='"+u.getUsername()+"' and password='"+u.getPassword()+"'");
			ResultSet res=stm.executeQuery();
			result=res.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getStackTrace();
		}
		return result;
	}

}
