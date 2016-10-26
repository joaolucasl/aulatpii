package classif.controllers;

import classif.modelos.Classificado;
import com.google.gson.Gson;
import spark.template.handlebars.HandlebarsTemplateEngine;
import java.util.HashMap;
import java.util.Map;
import static spark.Spark.*;

public class ClassificadosController {
  public ClassificadosController() {
    get("/classificados", (request, response) -> new Gson().toJson(Classificado.listarTodos()));
  }
}
