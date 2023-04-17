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
public class ConnectDB1 {

     public static Connection opConnection() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost:1434;encrypt=true;database=QuanLy_LuongSanPham;"
                + "encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2";
        String user = "sa";
        String pass = "quanghuy09";

        Connection con = DriverManager.getConnection(connectionUrl, user, pass);
        return con;
    }
    @SuppressWarnings("InfiniteRecursion")
    public void close(){
        close();
    }

}
