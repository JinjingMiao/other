package com.example.edu.northeastern.cs5200.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.example.edu.northeastern.cs5200.model.Address;
import com.example.edu.northeastern.cs5200.model.DatabaseConnection;
import com.example.edu.northeastern.cs5200.model.Developer;
import com.example.edu.northeastern.cs5200.model.Phone;
import com.example.edu.northeastern.cs5200.model.person;


public class DeveloperDao {
	private static DeveloperDao instance = null;
	private java.sql.Connection connection;
	private java.sql.Statement statement;
	
	private DeveloperDao(){};
	public static DeveloperDao getInstance() {
		if (instance ==null) {
			instance = new DeveloperDao();
		}
		return instance;
	}



	public int createDeveloper(Developer developer) {
		java.sql.Connection connection;
		PreparedStatement prepareStatement;
		ResultSet results = null;
		int personId = 0;

		 try {
//		Class.forName("com.mysql.jdbc.Driver");
		connection = DatabaseConnection.getInstance().getConnection();
		 
		 String Create_person =
					"INSERT INTO person (id, firstName,lastName, userName,password,email,dob) VALUES (?,?, ?, ?, ?,?,?)";
							 	 
		 prepareStatement = (PreparedStatement) connection.createStatement();
		 prepareStatement.setInt(1, developer.getId());
		 prepareStatement.setString(2, developer.getFirstName());
		 prepareStatement.setString(3, developer.getLastName());
		 prepareStatement.setString(4, developer.getUserName());
		 prepareStatement.setString(5, developer.getPassword());
		 prepareStatement.setString(6, developer.getEmail());
		 prepareStatement.setDate (7, (Date) developer.getDateOfBirth());
		
		 prepareStatement.execute();
		 results = prepareStatement.getGeneratedKeys();
		 results.next();
		
		 prepareStatement.close();
		 
		 personId = results.getInt(1);
		 String Create_Developer =
					"INSERT INTO developer (id, developerKey) VALUES (?,?)";
		 prepareStatement = (PreparedStatement) connection.prepareStatement(Create_Developer);
		 prepareStatement.setInt(1, personId);
		 prepareStatement.setString(2, developer.getDeveloperKey());
		 prepareStatement.execute();
		 prepareStatement.close();
		 
		 for(Phone phone : developer.getPhone()) {
				insertPhoneForDeveloper(personId, phone);
			}
		 for(Address address : developer.getAddress()) {
             insertAddressForDeveloper(personId, address);
		}			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 return personId;

		}
	
	private void insertPhoneForDeveloper(int developerId, Phone phone) {
		java.sql.Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet results = null;

		 try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DatabaseConnection.getInstance().getConnection();
			
			String createAddPhoneQuery = 
					"insert into phone(phone, is_primary, person_id) values(?,?,?)";
			
			prepareStatement = (PreparedStatement) connection.prepareStatement(createAddPhoneQuery);
			prepareStatement.setString(1, phone.getPhone());
			prepareStatement.setBoolean(2, phone.getPrimary());
			prepareStatement.setInt(3, developerId);
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
	}

	
	private void insertAddressForDeveloper(int developerId, Address address) {
		java.sql.Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet results = null;

		 try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DatabaseConnection.getInstance().getConnection();
			String createAddressQuery = 
					"insert into address(street1, street2, city, "
					+ "state, zip, is_primary, person_id) values"
					+ "(?, ?, ?, ?, ?, ?, ?)";
			
			prepareStatement = (PreparedStatement) connection.prepareStatement(createAddressQuery);
			prepareStatement.setString(1, address.getStreet1());
			prepareStatement.setString(2, address.getStreet2());
			prepareStatement.setString(3, address.getCity());
			prepareStatement.setString(4, address.getState());
			prepareStatement.setString(5, address.getZip());
			prepareStatement.setBoolean(6, address.getPrimary());
			prepareStatement.setInt(7, developerId);
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
	}
	
	
	
	
// ******* Collection <developer> ******************************
	public Collection<Developer> findAllDevelopers(){
		Collection<Developer> developer =
				new ArrayList<Developer>();
		java.sql.Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet results = null;

		 try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DatabaseConnection.getInstance().getConnection();
			String findAllDevelopersSql =
					"SELECT * FROM Developers";
			prepareStatement = (PreparedStatement) connection.createStatement();
			  results = prepareStatement.executeQuery(findAllDevelopersSql);
			  
				while(results.next()) {
					int id = results.getInt("id");
					String firstName = results.getString("firstName");
					String lastName = results.getString("lastName");
					String username = results.getString("username");
					String password = results.getString("password");
					String email =results.getString("email");
					Date dateOfBirth = results.getDate("dateOfBirth");
					Developer developer1 =new Developer(id, firstName, lastName,username,password,email,dateOfBirth);
					developer.add(developer1);
				}
			 
			 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

		return null;}
	
	
	
	private Collection<Address> findAddressesForPerson(int personId) {
		Collection<Address> addressList = new ArrayList<>();
		Address address=null;
		java.sql.Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet results = null;

		 try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DatabaseConnection.getInstance().getConnection();
			String sql = "select * from address where person_id = ?";
			prepareStatement = (PreparedStatement) connection.prepareStatement(sql);
			prepareStatement.setInt(1, personId);
			results = prepareStatement.executeQuery();
			while(results.next()) {
				String street1= results.getString("street1");
				String street2=		results.getString("street2");
				String city=		results.getString("city");
				String state=		results.getString("state");
				String zip=		results.getString("zip");
				Boolean is_primary=		results.getBoolean("is_primary");
				
				addressList.add(address);
				
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

		return addressList;
	}

	private Collection<Phone> findPhonesForPerson(int personId) {
		Collection<Phone> phoneList = new ArrayList<>();
		Phone phone1 = null;
		java.sql.Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet results = null;

		 try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DatabaseConnection.getInstance().getConnection();
			String sql = "select * from phone where person_id = ?";
			
			prepareStatement = (PreparedStatement) connection.prepareStatement(sql);
			prepareStatement.setInt(1, personId);
			results = prepareStatement.executeQuery();
			while(results.next()) {
				
				String phone =results.getString("phone");
				Boolean is_primary= results.getBoolean("is_primary");
				phoneList.add(phone1);
				
				
			}
			
		} catch(SQLException e) {
			
		} catch (ClassNotFoundException e) {
			
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				
			}
		}

		return phoneList;
	}
	
	//*****************FINDID***********************************
	public Developer findDeveloperById(int DeveloperId) {
		
		Developer developer1 = null;
		java.sql.Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet results = null;

		 try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DatabaseConnection.getInstance().getConnection();
			String sql = "Select person.*, developer.developer_key from person, Developer where "
					+ "person.id = developer.id and developer.id = ?";
			
			prepareStatement = (PreparedStatement) connection.prepareStatement(sql);

		    prepareStatement.setInt(1,DeveloperId);
			
			results = prepareStatement.executeQuery();
			results.next();
			
			Collection<Phone> phones = findPhonesForPerson(DeveloperId);
			Collection<Address> addresses = findAddressesForPerson(DeveloperId);			
			
			int id= results.getInt("id"); 
			String firstName=results.getString("first_name"); 
			String lastName=results.getString("last_name");
			String username=results.getString("username"); 
			String password=results.getString("password");
			String email=results.getString("email") ;
			Date dateOfBirth=results.getDate("dateOfBirth");
			String developerKey= results.getString("developer_key"); 
					 
			developer1.setId(results.getInt("id"));
			
		} catch(SQLException e) {
			
		} catch (ClassNotFoundException e) {
			
		}  finally {
			try {
				prepareStatement.close();
				connection.close();
			} catch (SQLException e) {
				
			}
		}

		return developer1;}
	
	
	
	public Developer findDeveloperByUsername(String username) {
		Developer developer1 = null;
		java.sql.Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet results = null;

		 try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DatabaseConnection.getInstance().getConnection();
			String sql = "select person.*, Developer.developer_key from person, developer where person.id = developer.id and person.username = ?";
			
			prepareStatement = (PreparedStatement) connection.prepareStatement(sql);
			prepareStatement.setString(1, username);
			results = prepareStatement.executeQuery();
			results.next();

			
			int id= results.getInt("id"); 
			String firstName=results.getString("first_name"); 
			String lastName=results.getString("last_name");
		
			String password=results.getString("password");
			String email=results.getString("email") ;
			Date dateOfBirth=results.getDate("dateOfBirth");
			String developerKey= results.getString("developer_key"); 
					 
			developer1.setId(results.getInt("id"));
					 
			developer1.setId(results.getInt("id"));
			
		} catch(SQLException e) {
			
		} catch (ClassNotFoundException e) {
			
		}  finally {
			try {
				prepareStatement.close();
				connection.close();
			} catch (SQLException e) {
				
			}
		}

		return developer1;
		
		
		}
	
	
	public Developer findDeveloperByCredentials(String username, String password) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet results = null;
		Developer developer1 = null;
		
		try {
			Class.forName("com.mysql.jdbc.DRIVER");
			connection = 
					 DriverManager.getConnection(password);	
			String sql = "Select person.*, developer.developer_key from person, "
					+ "developer where person.id = developer.id and person.username = ? and person.password = ?";
			prepareStatement = (PreparedStatement) connection.prepareStatement(sql);
			prepareStatement.setString(1, username);
			prepareStatement.setString(2, password);
			results = prepareStatement.executeQuery();
			results.next();
			
			int id= results.getInt("id"); 
			String firstName=results.getString("first_name"); 
			String lastName=results.getString("last_name");
			
			String email=results.getString("email") ;
			Date dateOfBirth=results.getDate("dateOfBirth");
			String developerKey= results.getString("developer_key"); 
					 
			developer1.setId(results.getInt("id"));   
			developer1.setId(results.getInt("id"));   
			
		} catch(SQLException e) {
			
		} catch (ClassNotFoundException e) {
			
		}  finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				
			}
		}

		return developer1;
		
		
		
		
		
		}
	
	
	public int updateDeveloper(int developerId, Developer developer){
		
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet results = null;
		
		
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = 
					 DriverManager.getConnection(null);		 
			 String sql = "update from person where id = ?";
			 statement =  connection.prepareStatement(sql);
			 prepareStatement.setInt(1, developer.getId());
			 prepareStatement.setString(2, developer.getFirstName());
			 prepareStatement.setString(3, developer.getLastName());
			 prepareStatement.setString(4, developer.getUserName());
			 prepareStatement.setString(5, developer.getPassword());
			 prepareStatement.setString(6, developer.getEmail());
			 prepareStatement.setDate (7, (Date) developer.getDateOfBirth());
			 prepareStatement.setString(8, developer.getDeveloperKey());
			 prepareStatement.executeUpdate();
			 
			 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		


		
		return developerId;}
	
	
	public int deleteDeveloper(int developerId) {
		java.sql.Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet results = null;

		 try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DatabaseConnection.getInstance().getConnection();
			String sql = "delete from person where id = ?";
			prepareStatement = (PreparedStatement) connection.prepareStatement(sql);
			prepareStatement.setInt(1, developerId);
			prepareStatement.execute();
		} catch(SQLException e) {
			
		}  catch (ClassNotFoundException e) {
			
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				
			}
		}

        
	
	return developerId;
	}

}
