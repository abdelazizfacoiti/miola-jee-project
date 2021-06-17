package gestionReservation.dao;

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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Client> lister() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
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
