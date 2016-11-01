package classif.modelos;


import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class Usuario {
  private Integer id;
  private String username;
  private String senha;
  private String email;
  private String telefone;
  private Integer id_cidade;
  private String permissao;

  public Usuario() {
  }

  public Usuario(Integer id, String username, String senha, String email, String telefone, Integer id_cidade, String permissao) {
    this.id = id;
    this.username = username;
    this.senha = senha;
    this.email = email;
    this.telefone = telefone;
    this.id_cidade = id_cidade;
    this.permissao = permissao;
  }

  public Integer id() {
    return id;
  }

  public Usuario setId(Integer id) {
    this.id = id;
    return this;
  }

  public String username() {
    return username;
  }

  public Usuario setUsername(String username) {
    this.username = username;
    return this;
  }

  public String senha() {
    return senha;
  }

  public Usuario setSenha(String senha) {
    this.senha = senha;
    return this;
  }

  public String email() {
    return email;
  }

  public Usuario setEmail(String email) {
    this.email = email;
    return this;
  }

  public String telefone() {
    return telefone;
  }

  public Usuario setTelefone(String telefone) {
    this.telefone = telefone;
    return this;
  }

  public Integer idCidade() {
    return id_cidade;
  }

  public Usuario setIdCidade(Integer id_cidade) {
    this.id_cidade = id_cidade;
    return this;
  }

  public String permissao() {
    return permissao;
  }

  public static Usuario fromResultSet(ResultSet rs) {
    Usuario novoUsuario = new Usuario();
    try {
      novoUsuario
        .setId(rs.getInt("id_classificado"))
        .setUsername(rs.getString("titulo"))
        .setEmail(rs.getString("email"))
        .setTelefone(rs.getString("telefone"))
        .setIdCidade(rs.getInt("cidade"))
        .setPermissao(rs.getString("permissao"));
    } catch (SQLException ex) {
      Logger.getLogger("Usuario").warn(ex.getLocalizedMessage());
    }
    return novoUsuario;
  }

  public Usuario setPermissao(String permissao) {
    List<String> permissoesPossiveis = Arrays.asList("usuario", "admin");

    if(!permissoesPossiveis.contains(permissao) || permissao == null) {
      this.permissao = permissoesPossiveis.get(0);
    } else {
      this.permissao = permissao;
    }

    return this;
  }
}
