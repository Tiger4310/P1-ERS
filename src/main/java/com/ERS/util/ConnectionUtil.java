package com.ERS.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.postgresql.Driver;

public class ConnectionUtil {

	/*private ConnectionUtil() {
		super();
	}

	public static Connection getConnection() throws FileNotFoundException, IOException, ClassNotFoundException {

		Connection connection = null;
		String url = "jdbc:postgresql://javareactdb.czjlwtharwjz.us-east-2.rds.amazonaws.com/test";
		String usr = "daniel";
		String psw = "12345";

		try {
			if (connection == null || connection.isClosed()) {
				connection = DriverManager.getConnection(url, usr, psw);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return connection;
	}
	*/
    private ConnectionUtil(){}

    public static Connection getConnection() throws SQLException {

        Driver driver = new Driver();
        DriverManager.registerDriver(driver);

        String url = "jdbc:postgresql://javareactdb.czjlwtharwjz.us-east-2.rds.amazonaws.com/test";
		String usr = "daniel";
		String psw = "12345";

        Connection connection = DriverManager.getConnection(url, usr, psw);

        return connection;
    }
	
/*	public static void main(String[] args) {
		
	try {
		Connection conn = getConnection();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			
		System.out.println("yay");
	}*/
}


