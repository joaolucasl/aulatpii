package classif.modelos;

import java.math.BigDecimal;
import java.util.Date;

public class Classificado {
  private int id;
  private String titulo;
  private String descricao;
  private BigDecimal valor;
  private boolean novo;
  private Date criado_em;
  private int id_usuario;

  public Classificado() {
  }

  public Classificado(String titulo, String descricao, BigDecimal valor, boolean novo, Date criado_em, int id_usuario) {
    this.titulo = titulo;
    this.descricao = descricao;
    this.valor = valor;
    this.novo = novo;
    this.criado_em = criado_em;
    this.id_usuario = id_usuario;
  }

  public int id() {
    return id;
  }

  public Classificado setId(int id) {
    this.id = id;
    return this;
  }

  public String titulo() {
    return titulo;
  }

  public Classificado setTitulo(String titulo) {
    this.titulo = titulo;
    return this;
  }

  public String descricao() {
    return descricao;
  }

  public Classificado setDescricao(String descricao) {
    this.descricao = descricao;
    return this;
  }

  public BigDecimal valor() {
    return valor;
  }

  public Classificado setValor(BigDecimal valor) {
    this.valor = valor;
    return this;
  }

  public boolean novo() {
    return novo;
  }

  public Classificado setNovo(boolean novo) {
    this.novo = novo;
    return this;
  }

  public Date criado_em() {
    return criado_em;
  }

  public Classificado setCriadoEm(Date criado_em) {
    this.criado_em = criado_em;
    return this;
  }

  public int id_usuario() {
    return id_usuario;
  }

  public Classificado setIdUsuario(int id_usuario) {
    this.id_usuario = id_usuario;
    return this;
  }
}
