package jp.ac.chitose.dbe;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class SelectDemo {

  public static void main(String[] args) {
    System.out.print("点数を入力してください：");
    Scanner scanner = new Scanner(System.in);
    int lessThan = Integer.parseInt(scanner.nextLine());

    PreExamDAO preExamDAO = new PreExamDAO();
    try {
      List<PreExam> preExamList = preExamDAO.selectPreExam(lessThan);
      for (PreExam preExam : preExamList){
        preExam.print();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}