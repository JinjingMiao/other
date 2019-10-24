package com.example.edu.northeastern.cs5200.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.example.edu.northeastern.cs5200.model.DatabaseConnection;
import com.example.edu.northeastern.cs5200.model.Website;

public class WebsiteDao {
	private static WebsiteDao instance = null;
	private WebsiteDao(){};
	public static WebsiteDao getInstance() {
		if (instance ==null) {
			instance = new WebsiteDao();
		}
		return instance;
		
		
		
	}
	
	
	private static String Create_Website =
			"INSERT INTO Website (id, name,description, created,updated,visits) VALUES (?,?, ?, ?, ?,?)";

	//private final String DatabaseCONNECTION_STRING ="jdbc:mysql://cs5200-jinjingmiao-fall2019.c6zuuyi0sch9.us-east-2.rds.amazonaws.com/cs5200_jinjingmiao_fall2019";
	//private static final String USER = "master";
	//private static final String PASSWORD = "Mjj111111";
	
	
	
	
	
	public int createWebsiteForDeveloper(int developerId, Website website) {
		java.sql.Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet results = null;

		 try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DatabaseConnection.getInstance().getConnection();
							 	 
		 prepareStatement = (PreparedStatement) connection.createStatement();
		 
		 prepareStatement.setInt(1, developerId());
		 prepareStatement.setString(2, website.getName());
		 prepareStatement.setString(3, website.getDescription());
		 prepareStatement.setDate(4, (Date) website.getCreated());
		 prepareStatement.setDate(5, (Date) website.getUpdated());
		 prepareStatement.setInt(6, website.getVisits());
		 prepareStatement.execute();
		 results = prepareStatement.getGeneratedKeys();
			results.next();
			int websiteId = results.getInt(1);
			prepareStatement.close();
			 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
		 
		

		return 0;
	
		}
	private int developerId() {
		// TODO Auto-generated method stub
		return 0;
	}


	String findAllWebsitesSql =
			"SELECT * FROM Websites";
	
	public Collection<Website> findAllWebsites(){
			
		Website website1= null;
		Collection<Website> websiteList =
				new ArrayList<>();
		java.sql.Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet results = null;

		 try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DatabaseConnection.getInstance().getConnection();		 
			prepareStatement = (PreparedStatement) connection.createStatement();
			results = prepareStatement.executeQuery("select * from website");
			 
			while(results.next()) {
				
				String name = results.getString("name");
				String description = results.getString("description");
				Date created = results.getDate("created");
				Date updated = results.getDate("updated");
				int visit =results.getInt("visit");
				
				
				websiteList.add(website1);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return websiteList;}
	
	
	
	@SuppressWarnings("finally")
	public Website findWebsiteById(int websiteId) {
		Website website1 = null;
		java.sql.Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet results = null;

		 try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DatabaseConnection.getInstance().getConnection();
			String sql = "Select website.* from website id = ?";
			prepareStatement = (PreparedStatement) connection.prepareStatement(sql);
			prepareStatement.setInt(1, websiteId);
			
			results = prepareStatement.executeQuery();
			
			while(results.next()) {
			
			String name= results.getString("name");
		    String description=		results.getString("description"); 
		    Date created=		results.getDate("created");
		    Date updated=		results.getDate("updated"); 
		    int views=		results.getInt("views");
		    
		    PageDao.getInstance().findPagesForWebsite(websiteId);
		    website1.setId(websiteId);}
		    		
			
		} catch(SQLException e) {
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		} finally {
			try {
				prepareStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
			return website1;
		}
	}
		
		public int updateWebsite(int websiteId, Website website) {
			java.sql.Connection connection = null;
			PreparedStatement prepareStatement = null;
			ResultSet results = null;

			 try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DatabaseConnection.getInstance().getConnection();
				
				String updateWebsite = "update website set name = ? , description = ?, created = ?, updated = ?, views = ?  where id = ?";
				
				prepareStatement = (PreparedStatement) connection.prepareStatement(updateWebsite);
				prepareStatement.setString(1, website.getName());
				prepareStatement.setString(2, website.getDescription());
				prepareStatement.setDate(3, (Date) website.getCreated());
				prepareStatement.setDate(4, (Date) website.getUpdated());
				prepareStatement.setInt(5, website.getVisits());
				prepareStatement.setInt(6, websiteId);
				prepareStatement.executeUpdate();
				return websiteId;
			} catch(SQLException e) {
				System.out.println("FAILED!!!! SQLException. " + e.getMessage());
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				try {
					prepareStatement.close();
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			return 0;
		}
		
		
		public int deleteWebsite(int websiteId) {
			java.sql.Connection connection = null;
			PreparedStatement prepareStatement = null;
			

			 try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DatabaseConnection.getInstance().getConnection();
				String sql = "delete from website where id = ?";
				prepareStatement = (PreparedStatement) connection.prepareStatement(sql);
				prepareStatement.setInt(1, websiteId);
				prepareStatement.execute();
			} catch(SQLException e) {
					
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				try {
					prepareStatement.close();
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

	        return websiteId;
		}
}





