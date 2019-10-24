package com.example.edu.northeastern.cs5200.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;

import com.example.edu.northeastern.cs5200.model.DatabaseConnection;
import com.example.edu.northeastern.cs5200.model.Developer;
import com.example.edu.northeastern.cs5200.model.Page;
import com.example.edu.northeastern.cs5200.model.Website;

public class PageDao {
	
	private static PageDao instance = null;
	private java.sql.Connection connection;
	private java.sql.Statement statement;
	private Object results;
	private PageDao(){};
	public static PageDao getInstance() {
		if (instance ==null) {
			instance = new PageDao();
		}
		return instance;

}
	
	private static String Create_Page =
			"INSERT INTO Developer (id, title,description, created,updated,views) VALUES (?,?, ?, ?, ?,?)";

//	private final String DatabaseCONNECTION_STRING ="jdbc:mysql://cs5200-jinjingmiao-fall2019.c6zuuyi0sch9.us-east-2.rds.amazonaws.com/cs5200_jinjingmiao_fall2019";
//	private static final String USER = "master";
//	private static final String PASSWORD = "Mjj111111";


	public int createPageForWebsite (int websiteID, Page page) {
		java.sql.Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet results = null;

		 try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DatabaseConnection.getInstance().getConnection();
							 	 
		 prepareStatement = (PreparedStatement) connection.createStatement();
		 prepareStatement.setInt(1, websiteID());
		 prepareStatement.setString(2, page.getTitle());
		 prepareStatement.setString(3, page.getDescription());
		 prepareStatement.setDate(4, (Date) page.getCreated());
		 prepareStatement.setDate(5, (Date) page.getUpdated());
		 prepareStatement.setInt(6, page.getViews());
		 
		 prepareStatement.execute();
			results = prepareStatement.getGeneratedKeys();
			results.next();
			int pageId = results.getInt(1);
			prepareStatement.close();
			 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0 ;
	
		}
	
	
	private int websiteID() {
		// TODO Auto-generated method stub
		return 0;
	}
	public Collection<Page> findAllPages() {
		Collection<Page> pageList = new ArrayList<>();
		java.sql.Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet results = null;

		 try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DatabaseConnection.getInstance().getConnection();
			
			 prepareStatement = (PreparedStatement) connection.createStatement();
			
			results = statement.executeQuery("select * from page");
			
			while(results.next()) {
				int id = results.getInt("id");
				String title = results.getString("title");
				String description = results.getString("description");
				Date created = results.getDate("created");
				Date updated = results.getDate("updated");
				int views =results.getInt("views");
				
				Page page1 = new Page(id,title,description,created,updated,views, null);
				pageList.add(page1);
			}
			
		} catch(SQLException e) {
			
		} catch (ClassNotFoundException e) {
			
		} finally {
			try {
				prepareStatement.close();
				connection.close();
			} catch (SQLException e) {
				
			}
		}
			return pageList;
			
			
		}
		
		
		public Page findPageById(int pageId) {
			Collection<Page> pageList = new ArrayList<>();
			Page page1= null;
			java.sql.Connection connection = null;
			PreparedStatement prepareStatement = null;
			ResultSet results = null;

			 try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DatabaseConnection.getInstance().getConnection();
				String sql = "select * from page id = ?";
				prepareStatement = (PreparedStatement) connection.prepareStatement(sql);
				prepareStatement.setInt(1, pageId);
				
				results = prepareStatement.executeQuery();
				results.next();
				int id = results.getInt("id");
				String title = results.getString("title");
				String description= results.getString("description");
				Date created = results.getDate("created");
				Date updated = results.getDate("updated");
				int views =results.getInt("views");
			    
				
				WidgetDao.getInstance().findWidgetsForPage(pageId);
			    page1.setID(results.getInt("id"));
			    
			
			} catch(SQLException e) {
				
			} catch (ClassNotFoundException e) {
				
			} finally {
				try {
					prepareStatement.close();
					connection.close();
				} catch (SQLException e) {
					;
				}
			}	

			return page1;
		}
		
		public Collection<Page> findPagesForWebsite(int websiteId) {
			Collection<Page> pageList = new ArrayList<>();
			Page page1= null;
			java.sql.Connection connection = null;
			PreparedStatement prepareStatement = null;
			ResultSet results = null;

			 try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DatabaseConnection.getInstance().getConnection();
				String sql = "Select * from page where website_id = ?";
				prepareStatement = (PreparedStatement) connection.prepareStatement(sql);
				prepareStatement.setInt(1, websiteId);
				
				results = statement.executeQuery(sql);
				while(results.next()) {
					int pageId = results.getInt("id");
					int id = results.getInt("id");
					String title = results.getString("title");
					String description= results.getString("description");
					Date created = results.getDate("created");
					Date updated = results.getDate("updated");
					int views =results.getInt("views");
					page1.setID(pageId);
					pageList.add(page1);
				}
				
			} catch(SQLException e) {
				System.out.println("Caught SQLException. " + e.getMessage());
			} catch (ClassNotFoundException e) {
				System.out.println("Could not load driver class." + e.getMessage());
			} finally {
				try {
					statement.close();
					connection.close();
				} catch (SQLException e) {
					System.out.println("Failed to close the connection. " + e.getMessage());
				}
			}	

			return pageList;
		}
		
		public int updatePage(int pageId, Page page) {
			java.sql.Connection connection = null;
			PreparedStatement prepareStatement = null;
			ResultSet results = null;

			 try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DatabaseConnection.getInstance().getConnection();
				
				String updateWebsite = "update page set title = ? , description = ?, created = ?, updated = ?, views = ?  where id = ?";
				
				prepareStatement = (PreparedStatement) connection.prepareStatement(updateWebsite);
				prepareStatement.setString(1, page.getTitle());
				prepareStatement.setString(2, page.getDescription());
				prepareStatement.setDate(3, (Date) page.getCreated());
				prepareStatement.setDate(4, (Date) page.getUpdated());
				prepareStatement.setInt(5, page.getViews());
				prepareStatement.setInt(6, pageId);
				prepareStatement.executeUpdate();
				
			} catch(SQLException e) {
				System.out.println("FAILED!!!! SQLException. " + e.getMessage());
				
			} catch (ClassNotFoundException e) {
				System.out.println("Could not load driver class." + e.getMessage());
			} finally {
				try {
					statement.close();
					connection.close();
				} catch (SQLException e) {
					System.out.println("Failed to close the connection. " + e.getMessage());
				}
			}

			return 0;

		}
		
		public int deletePage(int pageId) {
			java.sql.Connection connection = null;
			PreparedStatement prepareStatement = null;
			ResultSet results = null;

			 try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DatabaseConnection.getInstance().getConnection();
				String sql = "delete from page where id = ?";
				prepareStatement = (PreparedStatement) connection.prepareStatement(sql);
				prepareStatement.setInt(1, pageId);
				prepareStatement.execute();
			} catch(SQLException e) {
					
			} catch (ClassNotFoundException e) {
				
			} finally {
				try {
					prepareStatement.close();
					connection.close();
				} catch (SQLException e) {
					
				}
			}

	        return pageId;
		}
		
	}
	

		
		

