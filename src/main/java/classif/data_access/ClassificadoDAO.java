package classif.data_access;

import java.sql.Connection;
import classif.utils.Conexao;
import classif.modelos.Classificado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *33
 * @author Murilo
 */
public class ClassificadoDAO {
  Connection dbConn;
    
  public ClassificadoDAO(){
      dbConn = new Conexao().getConexao();
  }

  public void salvar(Classificado c){
      try {
          PreparedStatement ppStmt = dbConn.prepareStatement("INSERT INTO classificado(modelo, marca, placa, ano) values(?,?,?,?)");
          /* ppStmt.setString(1, c.getModelo());
          ppStmt.setString(2, c.getMarca());
          ppStmt.setString(3, c.getPlaca());
          ppStmt.setInt(4, c.getAno());
          ppStmt.executeQuery(); */

      } catch (SQLException e) {
      }
  }
  public List<Classificado> listarTodos(){
    List<Classificado> lstA = new LinkedList<>();
    ResultSet rs;
    try{
        PreparedStatement ppStmt = dbConn.prepareStatement("SELECT * FROM classificado");
        rs = ppStmt.executeQuery();
        while(rs.next()){
            lstA.add(Classificado.fromResultSet(rs));
        }
    } catch (SQLException ex){
      ex.printStackTrace();
    }
    return lstA;
  }

  public Classificado buscarPorId(Integer id){
    Classificado novoClassificado = null;
    try {
      PreparedStatement query = dbConn.prepareStatement("SELECT * FROM classificado WHERE id_classificado = ?");
      query.setInt(1, id);
      ResultSet rs = query.executeQuery();
      if(rs.first()) {
        novoClassificado = Classificado.fromResultSet(rs);
      }
    } catch (SQLException ex){
      ex.printStackTrace();
    }
    return (novoClassificado == null ? new Classificado() : novoClassificado);
  }
}
