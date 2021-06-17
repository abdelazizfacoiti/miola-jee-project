package gestionReservation.dao;

import java.util.List;
import gestionReservation.beans.Client;

public interface ClientDao {
	public boolean ajouter(Client c);
	public List<Client> lister();
	public Client getClient(int id);
	public boolean modifier(Client c);
	public boolean supprimer(int id);
}
