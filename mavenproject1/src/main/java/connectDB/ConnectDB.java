/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author duy19
 */
public class ConnectDB {

     private static ConnectDB instance;

	private Connection connection;

	private ConnectDB() {
		try {
			String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLy_LuongSanPham;trustServerCertificate=true";
			connection = DriverManager.getConnection(url , "sa", "sapassword");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}
	
	public synchronized static ConnectDB getInstance() {
		if(instance == null)
			instance = new ConnectDB();
		return instance;
	}

	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
