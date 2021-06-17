package gestionReservation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gestionReservation.beans.Category;

public class CategoryDaoImpl implements CategoryDao{

	private DaoFactory dao;

	public CategoryDaoImpl(DaoFactory dao) {
		super();
		this.dao = dao;
	}

	
	@Override
	public boolean ajouter(Category c) {
		
		Connection cnx=null;
		PreparedStatement stm;
		int result = 0;
		try {
			cnx=dao.getConnection();
			stm=cnx.prepareStatement("insert into category(description) values('"+c.getDescription()+"')");
			result=stm.executeUpdate();		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getStackTrace();
		}
		
		return result>0;
	}


	@Override
	public List<Category> lister() {
		Connection cnx=null;
		PreparedStatement stm;
		ResultSet result = null;
		List<Category> list = new ArrayList<Category>();
		try {
			cnx=dao.getConnection();
			stm=cnx.prepareStatement("select * from category");
			result=stm.executeQuery();	
			while(result.next())
				list.add(new Category(result.getInt("cat_id"),result.getString("description")));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getStackTrace();
		}
		
		
		return list;
	}


	@Override
	public Category getCategory(int id) {
		Connection cnx=null;
		PreparedStatement stm;
		ResultSet result = null;
		Category category = null;
	
		try {
			cnx=dao.getConnection();
			stm=cnx.prepareStatement("select * from category where cat_id="+id);
			result=stm.executeQuery();	
			if(result.next())
				category=new Category(result.getInt("cat_id"),result.getString("description"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getStackTrace();
		}
		
		
		return category;
	}


	@Override
	public boolean modifier(Category c) {
		
		Connection cnx=null;
		PreparedStatement stm;
		int result = 0;
		try {
			cnx=dao.getConnection();
			stm=cnx.prepareStatement("update category set description='"+c.getDescription()+"' where cat_id="+c.getId());
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
		Connection cnx=null;
		PreparedStatement stm;
		int result = 0;
		try {
			cnx=dao.getConnection();
			stm=cnx.prepareStatement("delete from category where cat_id="+id);
			result=stm.executeUpdate();		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getStackTrace();
		}
		System.out.println("deleted"+(result>0));
		return result>0;
		
	}
		
		
		
		
		
		
	

}
