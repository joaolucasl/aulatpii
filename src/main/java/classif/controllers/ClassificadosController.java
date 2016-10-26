package classif.controllers;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;

public class ClassificadosController {
  public ClassificadosController() {
    Map variaveis = new HashMap<String, String>();
    variaveis.put("nome", "João");

    get("/classificados", (request, response) -> new ModelAndView(variaveis, "hello.hbs"), new HandlebarsTemplateEngine());
  }
}
