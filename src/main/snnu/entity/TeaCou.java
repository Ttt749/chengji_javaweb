package main.snnu.entity;

/**
 * Created by WT on 2017/12/1.
 */
public class TeaCou {
    private String tId;
    private String cId;

    @Override
    public String toString() {
        return "TeaCou{" +
                "tId='" + tId + '\'' +
                ", cId='" + cId + '\'' +
                '}';
    }

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }
}
