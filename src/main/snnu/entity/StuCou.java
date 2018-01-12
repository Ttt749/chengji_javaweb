package main.snnu.entity;

/**
 * Created by WT on 2017/11/29.
 */
public class StuCou {
    private String sId;
    private String cId;
    private int scScore;

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public int getScScore() {
        return scScore;
    }

    public void setScScore(int scScore) {
        this.scScore = scScore;
    }

    @Override
    public String toString() {
        return "StuCou{" +
                "sId='" + sId + '\'' +
                ", cId='" + cId + '\'' +
                ", scScore=" + scScore +
                '}';
    }
}
