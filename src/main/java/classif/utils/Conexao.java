package classif.utils;

import org.slf4j.impl.SimpleLoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;

public final class Conexao {
    protected static Connection conn;

    public Conexao() {
        novaConexao();
    }

    public Connection getConexao() {
        if (conn == null) {
            novaConexao();
        }
        return conn;
    }

    private void novaConexao() {
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "classIF";
        String driver = "com.mysql.cj.jdbc.Driver";
        String userName = "root";
        String password = "";
        try {
            Class.forName(driver).newInstance();
            this.conn = (Connection) DriverManager.getConnection(url + dbName, userName, password);
        } catch (Exception ex) {
            ex.printStackTrace();
            new SimpleLoggerFactory().getLogger("DBConn").error("It was not possible to connect to the database. \n" + ex.getLocalizedMessage());
        }
    }
}