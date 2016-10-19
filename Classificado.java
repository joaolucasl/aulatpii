package ClassesDAO;

import java.sql.Connection;
import Utilitarios.Conexao;
import ClassesTO.Classificado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author Murilo
 */
public class ClassificadoDAO {
    Connection conn;
    
    
    public ClassificadoDAO(){
        conn = new Conexao().conectar();
    }
    
    public void salvar(Classificado c){
        try {
            PreparedStatement ppStmt = conn.prepareStatement("INSERT INTO classificado(modelo, marca, placa, ano) values(?,?,?,?)");
            ppStmt.setString(1, c.getModelo());
            ppStmt.setString(2, c.getMarca());
            ppStmt.setString(3, c.getPlaca());
            ppStmt.setInt(4, c.getAno());
            ppStmt.executeQuery();

        } catch (SQLException e) {
        }
    }
    public List<Classificado> consultar(){   
      List<Classificado> lstA = new LinkedList<>();
      ResultSet rs;
      try{
          PreparedStatement ppStmt = conn.prepareStatement("SELECT * FROM classificado");
          rs = ppStmt.executeQuery();
          while(rs.next()){
              lstA.add(getClassificado(rs));
          }
      }
      catch(SQLException ex){
      }
      return lstA;
    }
    
    private Classificado getClassificado(ResultSet rs) throws SQLException{
        Classificado c = new Classificado();
        c.setModelo(rs.getString("modelo"));
        c.setMarca(rs.getString("marca"));
        c.setAno(rs.getInt("ano"));
        c.setPlaca(rs.getString("placa"));

        return c;
    } 
    
}
