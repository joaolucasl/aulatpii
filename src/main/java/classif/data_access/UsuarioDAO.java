package classif.data_access;

import classif.modelos.Usuario;
import classif.utils.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UsuarioDAO {
  Connection dbConn;

  public UsuarioDAO(){
    dbConn = new Conexao().getConexao();
  }

  public List<Usuario> listarTodos(){
    List<Usuario> lstA = new LinkedList<>();
    ResultSet rs;
    try{
      PreparedStatement ppStmt = dbConn.prepareStatement("SELECT * FROM Usuario");
      rs = ppStmt.executeQuery();
      while(rs.next()){
        lstA.add(Usuario.fromResultSet(rs));
      }
    } catch (SQLException ex){
      ex.printStackTrace();
    }
    return lstA;
  }

  public Usuario buscarPorId(Integer id){
    Usuario novoUsuario = null;
    try {
      PreparedStatement query = dbConn.prepareStatement("SELECT * FROM usuario WHERE id_usuario = ?");
      query.setInt(1, id);
      ResultSet rs = query.executeQuery();
      if(rs.first()) {
        novoUsuario = Usuario.fromResultSet(rs);
      }
    } catch (SQLException ex){
      ex.printStackTrace();
    }
    return (novoUsuario == null ? new Usuario() : novoUsuario);
  }
}
