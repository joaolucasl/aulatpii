import com.mysql.jdbc.Connection;
import java.sql.*;
import java.sql.DriverManager;

public final class Conexao {
    public Connection conn;
    private Statement statement;
    public static Conexao db;
    private Conexao() {
        String url= "jdbc:mysql://localhost:3306/";
        String dbName = "classif";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "";
        try {
            Class.forName(driver).newInstance();
            this.conn = (Connection)DriverManager.getConnection(url+dbName,userName,password);
        }
        catch (Exception sqle) {
            sqle.printStackTrace();
        }
    }

    public static synchronized Conexao getDbCon() {
        if ( db == null ) {
            db = new Conexao();
        }
        return db;
    }    
}