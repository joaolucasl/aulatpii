
package ClassesDAO;

import java.sql.Connection;
import Utilitarios.Conexao;
import ClassesTO.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author Murilo
 */
public class UsuarioDAO {
    Connection conn;
    
    
    public UsuarioDAO(){
        conn = new Conexao().conectar();
    }
    
    public void salvar(Usuario c){
        try {
            PreparedStatement ppStmt = conn.prepareStatement("INSERT INTO Usuario(modelo, marca, placa, ano) values(?,?,?,?)");
            ppStmt.setString(1, c.getModelo());
            ppStmt.setString(2, c.getMarca());
            ppStmt.setString(3, c.getPlaca());
            ppStmt.setInt(4, c.getAno());
            ppStmt.executeQuery();

        } catch (SQLException e) {
        }
    }
    public List<Usuario> consultar(){   
      List<Usuario> lstA = new LinkedList<>();
      ResultSet rs;
      try{
          PreparedStatement ppStmt = conn.prepareStatement("SELECT * FROM Usuario");
          rs = ppStmt.executeQuery();
          while(rs.next()){
              lstA.add(getUsuario(rs));
          }
      }
      catch(SQLException ex){
      }
      return lstA;
    }
    
    private Usuario getUsuario(ResultSet rs) throws SQLException{
        Usuario c = new Usuario();
        c.setModelo(rs.getString("modelo"));
        c.setMarca(rs.getString("marca"));
        c.setAno(rs.getInt("ano"));
        c.setPlaca(rs.getString("placa"));

        return c;
    } 
    
}
