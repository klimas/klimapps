package klimapps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestJdbc {

    public static void main(String[] args) {

//        String jdbcUrl = "jdbc:mysql://localhost:3306/klimapps?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
//        String user = "root";
//        String pass = "abc123";
//
        String jdbcUrl = "jdbc:mysql://mysql-286762.vipserv.org/jetpack_klimapps?serverTimezone=UTC";
        String user = "jetpack_klimapps";
        String pass = "aogGWezIBi6gLjTRuFtn51LNmWaV5N5f";

        try {
            System.out.println("Connecting to : " + jdbcUrl);

            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);

            ResultSet resultSet = myConn.prepareStatement("SELECT * FROM ").executeQuery();

            System.out.println(resultSet.getObject(0));
            System.out.println("Connection succesfull!");


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
