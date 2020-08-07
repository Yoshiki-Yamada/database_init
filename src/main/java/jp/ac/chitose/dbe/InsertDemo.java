package jp.ac.chitose.dbe;

import java.util.Scanner;

public class InsertDemo {
    public static void main(String[] args) {
        System.out.print("中間テストの得点を追加する学生コードは？：");
        Scanner scanner = new Scanner(System.in);
        String student_code = scanner.nextLine();
        System.out.print(student_code + "の得点は？：");
        int point = scanner.nextInt();

        PreExamDAO preExamDAO = new PreExamDAO();
        int n = preExamDAO.insertPreExam(student_code,point);
        System.out.println(n);
    }
}
