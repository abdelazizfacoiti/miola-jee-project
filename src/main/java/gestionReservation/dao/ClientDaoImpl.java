package gestionReservation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gestionReservation.beans.Category;
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
			stm=cnx.prepareStatement("SELECT * FROM `client`");
			result=stm.executeQuery();	
			while(result.next())
				list.add(new Client(result.getInt("client_id"),result.getString("cin"),result.getString("nom"),result.getString("prenom"),result.getString("date_naissance"),result.getString("lieu_naissance"),result.getString("addresse"),result.getString("etat_civil"),result.getString("nationalite")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getStackTrace();
		}
		return list;
	}

	public Client getClient(int id) {
		Connection cnx=null;
		PreparedStatement stm;
		ResultSet result = null;
		Client client = null;
	
		try {
			cnx=dao.getConnection();
			stm=cnx.prepareStatement("select * from client where client_id="+id);
			result=stm.executeQuery();	
			if(result.next())
				client=new Client(result.getInt("client_id"),result.getString("cin"),result.getString("nom"),result.getString("prenom"),result.getString("date_naissance"),result.getString("lieu_naissance"),result.getString("addresse"),result.getString("etat_civil"),result.getString("nationalite"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getStackTrace();
		}
		return client;
	}

	@Override
	public boolean modifier(Client c) {
		Connection cnx=null;
		PreparedStatement stm;
		int result = 0;
		try {
			cnx=dao.getConnection();
			stm=cnx.prepareStatement("UPDATE `client` SET `cin`="+c.getCin()+",`nom`="+c.getNom()+",`prenom`=c."+c.getPrenom()+",`date_naissance`=[value-5],`lieu_naissance`="+c.getLieu_naissance()+",`addresse`="+c.getAddresse()+",`etat_civil`="+c.getEtat_civil()+",`nationalite`="+c.getNationalite()+" WHERE 1"+c.getId());
			result=stm.executeUpdate();		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getStackTrace();
		}
		System.out.println("modified"+(result>0));
		return result>0;
	}

	@Override
	public boolean supprimer(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
