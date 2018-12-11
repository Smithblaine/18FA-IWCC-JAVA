/*
 * Blaine Smith
 * Program 6, Due 12-12-2018
 * NONE
 * This program will make a databast connection that will allow the user to create a table
 * then insert data into the table and will then allow the user to select the data from the table to then be printed out to the screen.
*/
package bSmith_Prog6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Main 
{

	public static void main(String[] args) throws Exception
	{
		createTable();
		post();
		get();
	}
	
	
	public static ArrayList<String> get() throws Exception 
	{
		try
		{
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT firstName, lastName FROM table1");
			
			ResultSet result = statement.executeQuery();
			
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) 
			{
				System.out.println(result.getString("firstName"));
				System.out.println(result.getString(" "));
				System.out.println(result.getString("lastName"));
				
				array.add(result.getString("lastName"));
			}
			System.out.println("All records have been selected");
			return array;
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
		return null;
	}
	
	public static void post() throws Exception 
	{
		final String var1 = "john";
		final String var2 = "miller";
		
		try 
		{
			Connection con = getConnection();
			PreparedStatement posted = con.prepareStatement("INSERT INTO table1 (firstName, lastName) VALUES('"+var1+"','"+var2+"')");
			posted.executeUpdate();
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
		finally 
		{
			System.out.println("Insert Completed");
		}
	}
	
	public static void createTable() throws Exception
	{
		try 
		{
			Connection con = getConnection();
			PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS table1(id int NOT NULL AUTO_INCREMENT,"
														   +"firstName VARCHAR (255), lastName VARCHAR (255), PRIMARY KEY(id))");
			create.executeUpdate();
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
		finally
		{
			System.out.println("Function Complete");
		}
	}
	
	public static Connection getConnection() throws Exception 
	{
		
		try
		{
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://127.0.0.1:3306/";
			String username = "root";
			String password = "";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connected");
			return conn;
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
}
