package jdbc_servlet_person_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonCRUD {

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_servlet_person_practice","root","root");
	}
	
	public int signUp(Person person) throws ClassNotFoundException, SQLException {
		Connection connection=getConnection();
		
		PreparedStatement preparedStatement=connection.prepareStatement("insert into person values(?,?,?,?,?,?)");
		preparedStatement.setInt(1, person.getId());
		preparedStatement.setString(2, person.getName());
		preparedStatement.setLong(3, person.getPhone());
		preparedStatement.setString(4, person.getEmail());
		preparedStatement.setString(5, person.getPassword());
		preparedStatement.setString(6, person.getAddress());
		
		int result=preparedStatement.executeUpdate();
		connection.close();
		
		return result;
	}
	
	public String getPassword(String email) throws ClassNotFoundException, SQLException {
		Connection connection=getConnection();
		
		PreparedStatement preparedStatement=connection.prepareStatement("select password from person where email like ?");
		preparedStatement.setString(1, email);
		
		ResultSet resultSet=preparedStatement.executeQuery();
		String password=null;
		
		while(resultSet.next())
		{
			password=resultSet.getString("password");
		}
		
		return password;
	}
}
