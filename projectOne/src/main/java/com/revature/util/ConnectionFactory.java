package com.revature.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//factory design pattern?
//factory is an object that builds other objects -> based on provided configuration
public class ConnectionFactory {
	
	//turn the factory into a singleton so everyone can only get a connection from our factory
	//make a private static reference to our self -> the one and only copy
	//public static ConnectionFactory cf = new ConnectionFactory();
	
	//provide a single point of access to the connection factory
	//public static ConnectionFactory getConnectionFactory() {
		//return cf;
	//}
	
	
	//this holds all of our connections
	//we could potential implement this as a connection pool
	//public Connection [] conn;
	
	//this is a very basic factory
	//only a single param for configuration
	//if we are making a singleton
	//all of our constructors must be private
	//otherwise others could make new instances
	//public ConnectionFactory(int numberOfConnections) throws IOException, ClassNotFoundException {
		//try {
	//		DriverManager.registerDriver(new org.postgresql.Driver());
		//	FileReader rdr = new FileReader("mydb.properties");
		//	Properties properties = new Properties();
	//		properties.load(rdr);
	//		String driver = properties.getProperty("driver");
	//		String url = properties.getProperty("url");
	//		String username = properties.getProperty("username");
	//		String password = properties.getProperty("password");
	//		
	//		Class.forName("org.postgresql.Driver");
			
	//	} catch (SQLException e1) {
	//		// TODO Auto-generated catch block
	//		e1.printStackTrace();
	//	}
		/*String url = System.getenv("DB_URL");
		String user = System.getenv("DB_USER");
		String password = System.getenv("DB_PASSWORD");*/
		//try {
			//this.conn = new Connection[numberOfConnections];
			//for(int i = 0; i< this.conn.length; i++) {
				//Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","toonmai23");
				//this.conn[i] = conn;
			//}
		//} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
//		}
		
		
		
	//}
	
	//public ConnectionFactory() {
		// TODO Auto-generated constructor stub
//	}

	//if we were gonna implement for real
	//we would want to synchronize for multiple threads
	//add locks and .wait and .notify
	//I'm going to pretend only thread exists
	//and we will only ever need a single connection
	//public Connection getConnection() {
		//TODO
		//return this.conn[0];
	//}
	
	//public void releaseConnection(Connection conn) {
		//TODO
	//}
	

//}
public static Connection getConnection() 
{
	Connection con = null;
	try 
	{
		FileReader rdr = new FileReader("mydb.properties");
		Properties properties = new Properties();
		properties.load(rdr);
		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		
		
		
		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","toonmai23");
	} 
	catch (ClassNotFoundException e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    catch (SQLException e) 
    {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
    return con;
}//end of getConnection Method

}//end of class