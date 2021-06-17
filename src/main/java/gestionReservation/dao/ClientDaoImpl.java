package gestionReservation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gestionReservation.beans.Client;

public class ClientDaoImpl implements ClientDao {
	private DaoFactory dao;

	public ClientDaoImpl(DaoFactory dao) {
		super();
		this.dao = dao;
	}

	@Override
	public boolean ajouter(Client c) {
		Connection cnx=null;
		PreparedStatement stm;
		int result = 0;
		try {
			cnx=dao.getConnection();
			stm=cnx.prepareStatement("INSERT INTO `client`(`client_id`, `cin`, `nom`, `prenom`, `date_naissance`, `lieu_naissance`, `addresse`, `etat_civil`, `nationalite`) VALUES ("+c.getId()+","+c.getCin()+","+c.getNom()+","+c.getPrenom()+","+c.getDate_naissance()+","+c.getLieu_naissance()+","+c.getAddresse()+","+c.getEtat_civil()+","+c.getNationalite()+")");
			result=stm.executeUpdate();		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getStackTrace();
		}
		
		return result>0;
	}

	@Override
	public List<Client> lister() {
		Connection cnx=null;
		PreparedStatement stm;
		ResultSet result = null;
		List<Client> list = new ArrayList<Client>();
		try {
			cnx=dao.getConnection();
			stm=cnx.prepareStatement("select * from client");
			result=stm.executeQuery();	
			while(result.next())
				list.add(new Client(result.getInt("id"),result.getString("nom"),result.getString("cin"),result.getString("prenom"),result.getString("date_naissance"),result.getString("lieu_naissance"),result.getString("addresse"),result.getString("etat_civil"),result.getString("nationalite")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getStackTrace();
		}
		
		
		return list;
	}

	public Client getClient(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modifier(Client c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supprimer(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
