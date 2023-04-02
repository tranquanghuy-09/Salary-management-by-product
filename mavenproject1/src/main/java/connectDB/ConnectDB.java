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

    private static ConnectDB instance = new ConnectDB();
    private Connection con;

    private ConnectDB() {
        String dbURL = "jdbc:sqlserver://localhost:1434;encrypt=true;databaseName=QuanLy_LuongSanPham;user=sa;password=quanghuy09;"
                +  "encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2";
        try {
            con = DriverManager.getConnection(dbURL);
            con.setAutoCommit(false);
            System.out.println("DA KET NOI THANH CONG VAO CSDL");
        } catch (SQLException e) {
            System.out.println("KET NOI KHONG THANH CONG");
            e.printStackTrace();
        }
    }

    public synchronized static ConnectDB getInstance() {
        if (instance == null) {
            instance = new ConnectDB();
        }
        return instance;
    }

    public Connection getConnection() {
        return con;
    }

    public void disconnect() throws SQLException {
        con.close();
    }

//    public static void main(String[] args) {
//        Connection con = ConnectDB.getInstance().getConnection();
//    }
}
