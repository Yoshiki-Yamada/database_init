package jp.ac.chitose.dbe;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PreExamDAO {

    // ↓学籍番号（XXXXXXXX）は、Part.01で設定したあなたの学籍番号の値に書き換えること
    private static final String URL = "jdbc:h2:~/h2db/dbe;AUTO_SERVER=true";
    private static final String USER_NAME = "b2172010";
    private static final String USER_PASS = "b2172010";

    public List<PreExam> selectPreExam(int lessThan) throws SQLException {
        List<PreExam> returning = new ArrayList<>();
        String sql = "SELECT * FROM MIDTERM_TEST where SCORE < ?";

        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, USER_PASS);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, lessThan);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String col1 = resultSet.getString("student_code");
                int col2 = resultSet.getInt("score");
                PreExam preExam = new PreExam(col1, col2);
                returning.add(preExam);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returning;
    }

    public int deletePreExam(String student_code) {
        int n = 0;
        String sql = "DELETE FROM MIDTERM_TEST WHERE STUDENT_CODE = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, USER_PASS);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, student_code);
            n = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    public int insertPreExam(String student_code, int point) {
        int n = 0;
        String sql = "INSERT INTO MIDTERM_TEST VALUES (?, ?)";
        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, USER_PASS);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, student_code);
            preparedStatement.setInt(2, point);
            n = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    public List<StudentInfo> selectStudentInfo(int grade) {
        String sql = "SELECT last_name, first_name, score FROM STUDENT_INFO LEFT OUTER JOIN MIDTERM_TEST on STUDENT_INFO.CODE = MIDTERM_TEST.STUDENT_CODE WHERE GRADE = ?";
        List<StudentInfo> studentInfoList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, USER_PASS);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, grade);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String col1 = resultSet.getString(1);
                String col2 = resultSet.getString(2);
                int col3 = resultSet.getInt(3);
                StudentInfo studentInfo = new StudentInfo(col1,col2,col3);
                studentInfoList.add(studentInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentInfoList;
    }

}
