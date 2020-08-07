package jp.ac.chitose.dbe;


public class StudentInfo {
    private String lastName;
    private String firstName;
    private int point;

    public StudentInfo(String lastName, String firstName, int point){
        this.lastName = lastName;
        this.firstName = firstName;
        this.point = point;
    }

    public void print(){
        System.out.println(lastName + firstName + "さんの中間テストの点数は" + point + "点です");
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getPoint() {
        return point;
    }
}
