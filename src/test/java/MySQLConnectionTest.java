import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnectionTest {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://my8001.gabiadb.com:3306?serverTimezone=UTC";
    private static final String USER = "shopping";
    private static final String PW = "zkdlfhs789";

    @Test
    public void testConnection() throws Exception{
        Class.forName(DRIVER);

        try(Connection con = DriverManager.getConnection(URL, USER, PW)){
            System.out.println("성공!");
            System.out.println(con);
        }catch (Exception e) {
            System.out.println("실패!");
            e.printStackTrace();
        }
    }
}
