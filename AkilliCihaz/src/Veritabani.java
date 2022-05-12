import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;
import java.sql.*;

public class Veritabani {

    private Connection baglan(){

        Connection conn=null;

        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:8043/AkilliCihaz", "postgres","7757m");
            if (conn != null)
                System.out.println("DataBase Is connecting!");
            else
                System.out.println("Connection Successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public boolean login(String user,String pass){

        String sql = "SELECT 1 FROM \"public\".\"User\" WHERE \"KullaniciAdi\" = \'" + user +  "\' AND \"Parola\" = \'" + pass + "\'";
        Connection conn=this.baglan();
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            //*****the connection has end *****
            conn.close();

            if(rs.next())
            {

                rs.close();
                stmt.close();
                System.out.println("Is singing in ....");
                return true;
            }

            rs.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

}
