import static spark.Spark.get;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;


public class Main {
  public static void main(String[] args) {
    Map variaveis = new HashMap<String, String>();
    variaveis.put("nome", "João");

    get("/", (request, response) -> "Hello World");
    get("/oi", (request, response) -> new ModelAndView(variaveis, "hello.hbs"), new HandlebarsTemplateEngine());
  }
}
