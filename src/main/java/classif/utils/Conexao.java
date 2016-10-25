package classif.utils;

import org.apache.log4j.Logger;

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
        String dbName = "classif";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "";
        try {
            Class.forName(driver).newInstance();
            this.conn = (Connection) DriverManager.getConnection(url + dbName, userName, password);
        } catch (Exception ex) {
            Logger.getLogger("DBConn").fatal("It was not possible to connect to the database. \n" + ex.getLocalizedMessage());
        }
    }
}