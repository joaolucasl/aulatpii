package classif.controllers;

import static spark.Spark.*;

public class MainController{
  public MainController() {
    get("/", (request, response) -> "Hello World");
  }
}
