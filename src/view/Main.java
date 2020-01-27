package src.view;

import java.util.List;
import java.util.Scanner;
import src.controller.*;

public class Main {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    MainController controller = new MainController();

    System.out.println("**************************************************");
    System.out.println("");
    System.out.println("Seja bem vindo à consulta de permissões de usuários");
    System.out.println("Digite o caminho do arquivo que deseja fazer upload");
    System.out.println("ou aperte enter para continuar");

    String userAction = input.nextLine();
    try {
      System.out.println("**************************************************");
      System.out.println("");
      controller.loadData(userAction);
      System.out.println("Sistema inicializado!");
      controller.getData();
      System.out.println("");
      System.out.println("**************************************************");
      System.out.println("");
      System.out.println("Digite o email do usuario que deseja consultar");
      String email = input.nextLine();
      try {
        List<String> result = controller.searchUser(email);

        result.forEach(resultLine -> System.out.println(resultLine));
      } catch (Exception e) {

      }
    } catch (Exception e) {
      System.err.println("Falha ao carregar o arquivo: " + e.getMessage());
    }
    input.close();
  }
}