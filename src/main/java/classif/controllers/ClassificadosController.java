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
    get("/classificados/:id", (request, response) -> {
      Integer idClassificado;
      try {
        idClassificado = Integer.parseInt(request.params(":id"));
      } catch(NumberFormatException e) {
        response.status(404);
        return new Gson().toJson("ID inválido");
      }
      return new Gson().toJson(Classificado.buscarPorId(idClassificado));
     });
  }
}
