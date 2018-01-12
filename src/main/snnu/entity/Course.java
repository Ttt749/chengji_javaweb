package main.snnu.entity;

/**
 * Created by WT on 2017/11/29.
 */
public class Course {
    private String cId;
    private String cName;
    private String cAttr;
    private String cClassroom;

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcAttr() {
        return cAttr;
    }

    public void setcAttr(String cAttr) {
        this.cAttr = cAttr;
    }

    public String getcClassroom() {
        return cClassroom;
    }

    public void setcClassroom(String cClassroom) {
        this.cClassroom = cClassroom;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cId='" + cId + '\'' +
                ", cName='" + cName + '\'' +
                ", cAttr='" + cAttr + '\'' +
                ", cClassroom='" + cClassroom + '\'' +
                '}';
    }
}
