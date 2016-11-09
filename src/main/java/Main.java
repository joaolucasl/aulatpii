import classif.controllers.ClassificadosController;
import classif.controllers.LoginController;
import classif.controllers.MainController;


public class Main {
  public static void main(String[] args) {
    new MainController();
    new ClassificadosController();
    new LoginController();
  }
}
