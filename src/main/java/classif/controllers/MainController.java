package classif.controllers;

import classif.data_access.ClassificadoDAO;
import classif.modelos.Classificado;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class MainController{
  private Map<String, Object> viewData;
  public MainController() {
    //  GET "/" Route
    get("/", (request, response) -> {
      viewData = new HashMap<>();
      List<Classificado> destaques = new ClassificadoDAO().listarTodos(4);
      viewData.put("destaques", destaques);

      return new ModelAndView(viewData, "index.hbs");
    }, new HandlebarsTemplateEngine());

  }
}
