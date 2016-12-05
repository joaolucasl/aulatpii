import classif.controllers.ClassificadosController;
import classif.controllers.LoginController;
import classif.controllers.MainController;
import spark.Spark;


public class Main {
  public static void main(String[] args) {
    Spark.staticFileLocation("/public");
    new MainController();
    new ClassificadosController();
    new LoginController();
  }
}
