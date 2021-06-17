package gestionReservation.dao;

import java.util.List;

import gestionReservation.beans.Category;

public interface CategoryDao {
	public boolean ajouter(Category c);
	public List<Category> lister();
	public Category getCategory(int id);
	public boolean modifier(Category c);
	public boolean supprimer(int id);
}
