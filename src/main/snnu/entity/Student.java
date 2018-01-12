package main.snnu.entity;

/**
 * Created by WT on 2017/11/29.
 */
public class Student {
    private String sID;
    private String sName;
    private int sAge;
    private String sSex;
    private String sClass;

    public String getsID() {
        return sID;
    }

    public void setsID(String sID) {
        this.sID = sID;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int getsAge() {
        return sAge;
    }

    public void setsAge(int sAge) {
        this.sAge = sAge;
    }

    public String getsSex() {
        return sSex;
    }

    public void setsSex(String sSex) {
        this.sSex = sSex;
    }

    public String getsClass() {
        return sClass;
    }

    public void setsClass(String sClass) {
        this.sClass = sClass;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sID='" + sID + '\'' +
                ", sName='" + sName + '\'' +
                ", sAge=" + sAge +
                ", sSex='" + sSex + '\'' +
                ", sClass='" + sClass + '\'' +
                '}';
    }
}
