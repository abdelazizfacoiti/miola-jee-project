package gestionReservation.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {
	
	String url;
	String password;
	String username;
	
	public DaoFactory(String url, String username,String password ) {
		super();
		this.url = url;
		this.password = password;
		this.username = username;
	}
	
	public static DaoFactory getInstance(){
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new DaoFactory("jdbc:mysql://localhost:3306/gestion_reservation", "root", "");
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
	public UtilisateurDao getUtilisateurDao(DaoFactory dao) {
		return new UtilisateurDaoImpl(this);
	}
	
	public CategoryDao getCategoryDao(DaoFactory dao) {
		return new CategoryDaoImpl(this);
	}
	
	public ClientDao getClientDao(DaoFactory dao) {
		return new ClientDaoImpl(this);
	}
	

}
