package Sarthak_clinic;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
import java.sql.*;
//import packages
//load & register driver
//establish connection
//create statements
//execute query
//process result
//close connection
public class Jdbc_conn {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		String url="jdbc:mysql://localhost:3306/student";
		String user="root";
		String password="root";
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection(url,user,password);
		System.out.println("Connection created");
		//create statement
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("Select * from st");
		System.out.println("roll\t name\t per \t age");
		while(rs.next())
		{
			int roll=rs.getInt("roll");
			String name=rs.getString("name");
			float per=rs.getInt("per");
			int age=rs.getInt("age");
			System.out.println(roll+"\t"+ name+"\t"+ per+"\t	"+age);
			//System.out.println("ID:"+id+"\tName:"+ name+"Salary:"+ salary);
		}
		rs.close();
		stmt.close();
		con.close();
		
		

	}

}
