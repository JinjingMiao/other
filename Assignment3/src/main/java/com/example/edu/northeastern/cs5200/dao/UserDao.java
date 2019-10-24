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
import com.example.edu.northeastern.cs5200.model.User;
import com.example.edu.northeastern.cs5200.model.person;


public class UserDao {
	private static UserDao instance = null;
	private java.sql.Connection connection;
	private java.sql.Statement statement;
	
	private UserDao(){};
	public static UserDao getInstance() {
		if (instance ==null) {
			instance = new UserDao();
		}
		return instance;
	}
	

	public int createUser(User user) {
		java.sql.Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet results = null;

		 try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DatabaseConnection.getInstance().getConnection();	
		 
		 String Create_user =
					"INSERT INTO user (id, firstName,lastName, userName,password,email,dob) VALUES (?,?, ?, ?, ?,?,?)";
							 	 
		 prepareStatement = (PreparedStatement) connection.createStatement();
		 prepareStatement.setInt(1, user.getId());
		 prepareStatement.setString(2, user.getFirstName());
		 prepareStatement.setString(3, user.getLastName());
		 prepareStatement.setString(4, user.getUserName());
		 prepareStatement.setString(5, user.getPassword());
		 prepareStatement.setString(6, user.getEmail());
		 prepareStatement.setDate (7, (Date) user.getDateOfBirth());
		
		 prepareStatement.execute();
		 results = prepareStatement.getGeneratedKeys();
		 results.next();
		
		 prepareStatement.close();
		 
		 int personId = results.getInt(1);
		 String Create_Developer =
					"INSERT INTO developer (id, developerKey) VALUES (?,?)";
		 prepareStatement = (PreparedStatement) connection.prepareStatement(Create_Developer);
		 prepareStatement.setInt(1, personId);
		 prepareStatement.setBoolean(2, user.getUserAgreement());
		 prepareStatement.execute();
		 prepareStatement.close();
		 
		 for(Phone phone : user.getPhone()) {
				insertPhoneForUser(personId, phone);
			}
		 for(Address address : user.getAddress()) {
             insertAddressForUser(personId, address);
		}
		 return personId;
		 
		 

			 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		return 0 ;
	
		}
	
	private void insertPhoneForUser(int userId, Phone phone) {
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
			prepareStatement.setInt(3, userId);
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

	
	private void insertAddressForUser(int userId, Address address) {
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
			prepareStatement.setInt(7, userId);
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
	public Collection<User> findAllUsers(){
		Collection<User> user =
				new ArrayList<User>();
		java.sql.Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet results = null;

		 try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DatabaseConnection.getInstance().getConnection();
			String findAllDevelopersSql =
					"SELECT * FROM Developers";
			statement = connection.createStatement();
			  results = statement.executeQuery(findAllDevelopersSql);
			  
				while(results.next()) {
					int id = results.getInt("id");
					String firstName = results.getString("firstName");
					String lastName = results.getString("lastName");
					String username = results.getString("username");
					String password = results.getString("password");
					String email =results.getString("email");
					Date dateOfBirth = results.getDate("dateOfBirth");
					Boolean userAgreement =results.getBoolean ("userAgreement");
					User user1 =new User(id, firstName, lastName,username,password,email, dateOfBirth, userAgreement);
					user.add(user1);
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

		return phoneList;
	}
	
	//*****************FINDID***********************************
	public User findUserById(int UserId) {
		User user1 = null;
		java.sql.Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet results = null;

		 try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DatabaseConnection.getInstance().getConnection();
			String sql = "Select person.*, user.user_agreement from person, User where "
					+ "person.id = user.id and user.id = ?";
			
			prepareStatement = (PreparedStatement) connection.prepareStatement(sql);

		    prepareStatement.setInt(1,UserId);
			
			results = prepareStatement.executeQuery();
			results.next();
			
			Collection<Phone> phones = findPhonesForPerson(UserId);
			Collection<Address> addresses = findAddressesForPerson(UserId);			
			
			int id= results.getInt("id"); 
			String firstName=results.getString("first_name"); 
			String lastName=results.getString("last_name");
			String username=results.getString("username"); 
			String password=results.getString("password");
			String email=results.getString("email") ;
			Date dateOfBirth=results.getDate("dateOfBirth");
			String developerKey= results.getString("developer_key"); 
					 
			user1.setId(results.getInt("id"));
			
		} catch(SQLException e) {
			
		} catch (ClassNotFoundException e) {
			
		}  finally {
			try {
				prepareStatement.close();
				connection.close();
			} catch (SQLException e) {
				
			}
		}

		return user1;}
	
	
	
	public User findUserByUsername(String username) {
		User user1 = null;
		java.sql.Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet results = null;

		 try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DatabaseConnection.getInstance().getConnection();
			String sql = "select person.*, user.user_agreement from person, user where person.id = user.id and person.username = ?";
			
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
					 
			user1.setId(results.getInt("id"));
					 
			user1.setId(results.getInt("id"));
			
		} catch(SQLException e) {
			
		} catch (ClassNotFoundException e) {
			
		}  finally {
			try {
				prepareStatement.close();
				connection.close();
			} catch (SQLException e) {
				
			}
		}

		return user1;
		
		
		}
	
	
	
		
		
		
		
		
		
	
	
	public int updateUser(int userId, User user){
		
		java.sql.Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet results = null;

		 try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DatabaseConnection.getInstance().getConnection(); 
			 String sql = "update from person where id = ?";
			 statement =  connection.prepareStatement(sql);
			 prepareStatement.setInt(1, user.getId());
			 prepareStatement.setString(2, user.getFirstName());
			 prepareStatement.setString(3, user.getLastName());
			 prepareStatement.setString(4, user.getUserName());
			 prepareStatement.setString(5, user.getPassword());
			 prepareStatement.setString(6, user.getEmail());
			 prepareStatement.setDate (7, (Date) user.getDateOfBirth());
			 prepareStatement.setBoolean(8, user.getUserAgreement());
			 prepareStatement.executeUpdate();
			 
			 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		


		
		return userId;}
	
	
	public int deleteUser(int userId) {
		java.sql.Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet results = null;

		 try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DatabaseConnection.getInstance().getConnection();	
			String sql = "delete from person where id = ?";
			prepareStatement = (PreparedStatement) connection.prepareStatement(sql);
			prepareStatement.setInt(1, userId);
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

        
	
	return userId;
	}

}

