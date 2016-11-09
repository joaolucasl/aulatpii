package classif.controllers;

import classif.modelos.Usuario;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.*;

public class LoginController {
  public LoginController() {
    get("/login", (request, response) -> new ModelAndView(null, "login.hbs"), new HandlebarsTemplateEngine());
    post("/login", (request, response) -> {
      String email = request.queryParams("email");
      String senha = request.queryParams("senha");

      Usuario possivelUsuario = Usuario.buscarPorEmail(email);

      System.out.println(possivelUsuario.toString());

      if(possivelUsuario.id() == null || possivelUsuario.id() < 1 || !possivelUsuario.senha().equals(senha)) {
        return new ModelAndView(null, "loginError.hbs");
      }

      return new ModelAndView(null, "dashboard/index.hbs");
    }, new HandlebarsTemplateEngine());
  }
}
