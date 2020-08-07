package jp.ac.chitose.dbe;

import java.util.Scanner;

public class DeleteDemo {
    public static void main(String[] args) {
        System.out.print("中間テストの点数を削除する学生コードは？：");
        Scanner scanner = new Scanner(System.in);
        String student_code = scanner.nextLine();

        PreExamDAO preExamDAO = new PreExamDAO();
        var n = preExamDAO.deletePreExam(student_code);
        System.out.println(n);

    }
}
