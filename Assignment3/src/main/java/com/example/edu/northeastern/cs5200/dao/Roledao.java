package com.example.edu.northeastern.cs5200.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.edu.northeastern.cs5200.model.DatabaseConnection;

public class Roledao {
private static Roledao instance = null;
	
	public static Roledao getInstance() {
		if (instance == null) {
			instance = new Roledao();
		}
		return instance;}
	
//	private final String DatabaseCONNECTION_STRING ="jdbc:mysql://cs5200-jinjingmiao-fall2019.c6zuuyi0sch9.us-east-2.rds.amazonaws.com/cs5200_jinjingmiao_fall2019";
//	private static final String USER = "master";
//	private static final String PASSWORD = "Mjj111111";
	
	
	private Roledao() {
	}
	public void assignWebsiteRole(int developerId, int websiteId, int roleId) {
		java.sql.Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet results = null;

		 try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DatabaseConnection.getInstance().getConnection();
			
			String mappingInsert = "INSERT INTO user_website_role_mapping(user_id, website_id, role_id) values(?, ?, ?)";
			prepareStatement = (PreparedStatement) connection.prepareStatement(mappingInsert);
			prepareStatement.setInt(1, developerId);
			prepareStatement.setInt(2, websiteId);
			prepareStatement.setInt(3, roleId);
			prepareStatement.execute();
			prepareStatement.close();
			
		} catch(SQLException e) {
			System.out.println("FAILED!!!! SQLException. " + e.getMessage());
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void assignPageRole(int developerId, int pageId, int roleId) {
		java.sql.Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet results = null;

		 try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DatabaseConnection.getInstance().getConnection();	
			
			String mappingInsert = "INSERT INTO user_page_role_mapping(user_id, page_id, role_id) values(?, ?, ?)";
			prepareStatement = (PreparedStatement) connection.prepareStatement(mappingInsert);
			prepareStatement.setInt(1, developerId);
			prepareStatement.setInt(2, pageId);
			prepareStatement.setInt(3, roleId);
			prepareStatement.execute();
			prepareStatement.close();
			
		} catch(SQLException e) {
			System.out.println("FAILED!!!! SQLException. " + e.getMessage());
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
			
			
			
			public void deleteWebsiteRole(int developerId, int websiteId, int roleId) {
				java.sql.Connection connection = null;
				PreparedStatement prepareStatement = null;
				ResultSet results = null;

				 try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DatabaseConnection.getInstance().getConnection();
					
					
					String mappingDelete = "delete from user_website_role_mapping where user_id = ? and website_id = ? and role_id = ?";
					prepareStatement = (PreparedStatement) connection.prepareStatement(mappingDelete);
					prepareStatement.setInt(1, developerId);
					prepareStatement.setInt(2, websiteId);
					prepareStatement.setInt(3, roleId);
					prepareStatement.execute();
					prepareStatement.close();
					
				} catch(SQLException e) {
					System.out.println("FAILED!!!! SQLException. " + e.getMessage());
					
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} finally {
					try {
						connection.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			
			public void deletePageRole(int developerId, int websiteId, int roleId) {
				java.sql.Connection connection = null;
				PreparedStatement prepareStatement = null;
				ResultSet results = null;

				 try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DatabaseConnection.getInstance().getConnection();
					
					String mappingDelete = "delete from user_website_role_mapping where user_id = ? and website_id = ? and role_id = ?";
					prepareStatement = (PreparedStatement) connection.prepareStatement(mappingDelete);
					prepareStatement.setInt(1, developerId);
					prepareStatement.setInt(2, websiteId);
					prepareStatement.setInt(3, roleId);
					prepareStatement.execute();
					prepareStatement.close();
					
				} catch(SQLException e) {
					System.out.println("FAILED!!!! SQLException. " + e.getMessage());
					
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} finally {
					try {
						connection.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			
		

}
