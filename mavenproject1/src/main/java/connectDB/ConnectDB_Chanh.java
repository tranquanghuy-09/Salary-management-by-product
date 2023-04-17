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
public class ConnectDB_Chanh {

     private static ConnectDB_Chanh instance;

	private Connection connection;

	private ConnectDB_Chanh() {
		try {
			String url = "jdbc:sqlserver://localhost:1434;databaseName=QuanLy_LuongSanPham;trustServerCertificate=true";
			connection = DriverManager.getConnection(url , "sa", "quanghuy09");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}
	
	public synchronized static ConnectDB_Chanh getInstance() {
		if(instance == null)
			instance = new ConnectDB_Chanh();
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
