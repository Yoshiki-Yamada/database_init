package jp.ac.chitose.dbe;

import java.util.List;
import java.util.Scanner;

public class StudentInfoDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("確認したい学生の学年は？：");
        int grade = scanner.nextInt();

        PreExamDAO preExamDAO = new PreExamDAO();
        List<StudentInfo> studentInfoList = preExamDAO.selectStudentInfo(grade);
        for (var s : studentInfoList){
            s.print();
        }
    }
}
