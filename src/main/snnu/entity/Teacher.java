package main.snnu.entity;

/**
 * Created by WT on 2017/12/1.
 */
public class Teacher {
    private String tId;
    private String tName;
    private int tAge;
    private String tSex;
    private String tSchool;
    private String tGraduate;
    private String tText;

    @Override
    public String toString() {
        return "Teacher{" +
                "tId='" + tId + '\'' +
                ", tName='" + tName + '\'' +
                ", tAge=" + tAge +
                ", tSex='" + tSex + '\'' +
                ", tSchool='" + tSchool + '\'' +
                ", tGraduate='" + tGraduate + '\'' +
                ", tText='" + tText + '\'' +
                '}';
    }

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public int gettAge() {
        return tAge;
    }

    public void settAge(int tAge) {
        this.tAge = tAge;
    }

    public String gettSex() {
        return tSex;
    }

    public void settSex(String tSex) {
        this.tSex = tSex;
    }

    public String gettSchool() {
        return tSchool;
    }

    public void settSchool(String tSchool) {
        this.tSchool = tSchool;
    }

    public String gettGraduate() {
        return tGraduate;
    }

    public void settGraduate(String tGraduate) {
        this.tGraduate = tGraduate;
    }

    public String gettText() {
        return tText;
    }

    public void settText(String tText) {
        this.tText = tText;
    }
}
