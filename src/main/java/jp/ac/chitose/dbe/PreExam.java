package jp.ac.chitose.dbe;

public class PreExam {

    private String gakusekiCode;
    private int point;

    public PreExam(String gakusekiCode, int point) {
        this.gakusekiCode = gakusekiCode;
        this.point = point;
    }

    public void print() {
        System.out.println(gakusekiCode + "さんは" + point + "点");
    }

    public String getGakusekiCode() {
        return gakusekiCode;
    }

    public int getPoint() {
        return point;
    }

}