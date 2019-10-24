package com.example.edu.northeastern.cs5200.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.example.edu.northeastern.cs5200.model.DatabaseConnection;
import com.example.edu.northeastern.cs5200.model.HeadingWidget;
import com.example.edu.northeastern.cs5200.model.HtmlWidget;
import com.example.edu.northeastern.cs5200.model.ImageWidget;
import com.example.edu.northeastern.cs5200.model.Website;
import com.example.edu.northeastern.cs5200.model.Widget;
import com.example.edu.northeastern.cs5200.model.YoutubeWidget;

public class WidgetDao {
	private static WidgetDao instance = null;
	private WidgetDao(){};
	public static WidgetDao getInstance() {
		if (instance ==null) {
			instance = new WidgetDao();
		}
		return instance;

}
	
	private static String Create_Widget =
			"INSERT INTO Widget (id, name,width, height,cssClass,cssStyle,text,order) VALUES (?,?, ?, ?, ?,?,?,?)";

//	private final String DatabaseCONNECTION_STRING ="jdbc:mysql://cs5200-jinjingmiao-fall2019.c6zuuyi0sch9.us-east-2.rds.amazonaws.com/cs5200_jinjingmiao_fall2019";
//	private static final String USER = "master";
//	private static final String PASSWORD = "Mjj111111";
	
	public int createWidgetForPage(int pageID, Widget widget) {
		java.sql.Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet results = null;

		 try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DatabaseConnection.getInstance().getConnection();
							 	 
		 prepareStatement = (PreparedStatement) connection.createStatement();
		 
		 prepareStatement.setInt(1, widget.getId());
		 prepareStatement.setString(2, widget.getName());
		 prepareStatement.setInt(3, widget.getHeight());
		 prepareStatement.setInt(4, widget.getWidth());
		 prepareStatement.setString(5, widget.getCssClass());
		 prepareStatement.setString(6, widget.getCssStyle());
		 prepareStatement.setString(7, widget.getText());
		 prepareStatement.setInt(8, widget.getOrder());
		 prepareStatement.execute();
		 
		 
		 
			 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

		}
	
	
	
	public Collection<Widget> findAllWidgets() {
		Collection<Widget> widgetList = new ArrayList<>();
		
		java.sql.Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet results = null;

		 try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DatabaseConnection.getInstance().getConnection();
								 	 
			
			

			String widgetIdsQuery = "SELECT widget.id from widget";
			prepareStatement = (PreparedStatement) connection.prepareStatement(widgetIdsQuery);
			results = prepareStatement.executeQuery();
			
			while (results.next()) {
				widgetList.add(findWidgetById(results.getInt("id")));
				widgetList.add(findWidgetById(results.getInt("size")));
			}
			prepareStatement.close();
			
			
		} catch(SQLException e) {
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

		return widgetList;
	}
		
		public Widget findWidgetById(int widgetId) {
			Widget widget1 = null;
			java.sql.Connection connection = null;
			PreparedStatement prepareStatement = null;
			ResultSet results = null;

			 try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DatabaseConnection.getInstance().getConnection();
				
				

				String type = findWidgetType(widgetId);
				
				if(type.equals("HEADING")) {
					String widgetFetchQuery = "SELECT widget.*, heading.size from widget, heading where widget.id = heading.id and widget.id = ?";
					prepareStatement = (PreparedStatement) connection.prepareStatement(type);
					prepareStatement.setInt(1, widgetId);
					results = prepareStatement.executeQuery();
					if(results.next()) {
					
						String name= results.getString("name");
						int heught= results.getInt("height");
						int width= results.getInt("width"); 
						String cssClass= results.getString("css_class"); 
						String cssStyle= results.getString("css_style"); 
						String text=		results.getString("text");
						int order=		results.getInt("widget_order"); 
						int szie=		results.getInt("size");
						widget1.setId(widgetId);
					}

				} else if (type.equals("YOUTUBE")) {
					String widgetFetchQuery = "SELECT widget.*, youtube.url, youtube.shareable, youtube.expandable from widget, youtube where widget.id = youtube.id and widget.id = ?";
					prepareStatement = (PreparedStatement) connection.prepareStatement(widgetFetchQuery);
					prepareStatement.setInt(1, widgetId);
					results = prepareStatement.executeQuery();
					if(results.next()) {
						String name= results.getString("name");
						int heught= results.getInt("height");
						int width= results.getInt("width"); 
						String cssClass= results.getString("css_class"); 
						String cssStyle= results.getString("css_style"); 
						String text=		results.getString("text");
						int order=		results.getInt("widget_order"); 
						String url=		results.getString("url");
						Boolean shareable=		results.getBoolean("shareable");
						Boolean expandable=		results.getBoolean("expandable");
						widget1.setId(widgetId);
						
					}
					
				} else if (type.equals("HTML")) {
					String widgetFetchQuery = "SELECT widget.*, html.html from widget, html where widget.id = html.id and widget.id = ?";
					prepareStatement = (PreparedStatement) connection.prepareStatement(widgetFetchQuery);
					prepareStatement.setInt(1, widgetId);
					results = prepareStatement.executeQuery();
					if(results.next()) {
						String name= results.getString("name");
						int heught= results.getInt("height");
						int width= results.getInt("width"); 
						String cssClass= results.getString("css_class"); 
						String cssStyle= results.getString("css_style"); 
						
						String text=		results.getString("text");
						int widget_order=		results.getInt("widget_order");
						String html= results.getString("html");
								widget1.setId(widgetId);
								
								widget1.setId(widgetId);
					}
					
				} else if (type.equals("IMAGE")) {
					String widgetFetchQuery = "SELECT widget.*, image.src from widget, image where widget.id = image.id and widget.id = ?";
					prepareStatement = (PreparedStatement) connection.prepareStatement(widgetFetchQuery);
					prepareStatement.setInt(1, widgetId);
					results = prepareStatement.executeQuery();
					if(results.next()) {
						String name= results.getString("name");
						int heught= results.getInt("height");
						int width= results.getInt("width"); 
						String cssClass= results.getString("css_class"); 
						String cssStyle= results.getString("css_style"); 
						String text=		results.getString("text");
						int widget_order=		results.getInt("widget_order");
						String src=		results.getString("src");
						widget1.setId(widgetId);
					}
				}
				
				return widget1;
				
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

			return null;
		}
		private String findWidgetType(int widgetId) {
			Widget widget1 = null;

			java.sql.Connection connection = null;
			PreparedStatement prepareStatement = null;
			ResultSet results = null;

			 try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DatabaseConnection.getInstance().getConnection();
				

				String typeQuery = "SELECT widget.type from widget where id = ?";
				prepareStatement = (PreparedStatement) connection.prepareStatement(typeQuery);
				prepareStatement.setInt(1, widgetId);
					results = prepareStatement.executeQuery();
					if (results.next()) {
						return results.getString("type").toUpperCase();
					}
				
			} catch(SQLException e) {
				
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return null;
		}
		
		public Collection<Widget> findWidgetsForPage(int pageId) {
				Collection<Widget> widgetList = new ArrayList<>();
				java.sql.Connection connection = null;
				PreparedStatement prepareStatement = null;
				ResultSet results = null;

				 try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DatabaseConnection.getInstance().getConnection();
				
				

				String widgetIdsQuery = "SELECT widget.id from widget where page_id = ?";
				prepareStatement = (PreparedStatement) connection.prepareStatement(widgetIdsQuery);
				prepareStatement.setInt(1, pageId);
				results = prepareStatement.executeQuery();
				while (results.next()) {
					widgetList.add(findWidgetById(results.getInt("id")));
				}
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
			
			return widgetList;
		}
		
		public int updateWidget(int widgetId, Widget widget) {
			java.sql.Connection connection = null;
			PreparedStatement prepareStatement = null;
			ResultSet results = null;

			 try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DatabaseConnection.getInstance().getConnection();
				
				String updateWebsite = "update website set name = ? , description = ?, created = ?, updated = ?, views = ?  where id = ?";
				
				prepareStatement = (PreparedStatement) connection.prepareStatement(updateWebsite);
				prepareStatement.setString(1, widget.getName());
				prepareStatement.setInt(2, widget.getWidth());
				prepareStatement.setInt(3,  widget.getHeight());
				prepareStatement.setString(4,  widget.getCssClass());
				prepareStatement.setString(5, widget.getCssStyle());
				prepareStatement.setString(6, widget.getText());
				prepareStatement.setInt(7, widget.getOrder());
				
				prepareStatement.setInt(8, widgetId);
				prepareStatement.executeUpdate();
				return widgetId;
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

			return 0;
		}
		
		
		public int deleteWidget(int widgetId) {
			java.sql.Connection connection = null;
			PreparedStatement prepareStatement = null;
			ResultSet results = null;

			 try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DatabaseConnection.getInstance().getConnection();
				String sql = "delete from widgets where id = ?";
				prepareStatement = (PreparedStatement) connection.prepareStatement(sql);
				prepareStatement.setInt(1, widgetId);
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

	        return widgetId;
		}
		
		
	}
	
	
	
	
	
	
	
	

