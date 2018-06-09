package dao.vo;

public class Step {
    private String id;
    private String curDate;
    private String totalSteps;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCurDate() {
        return curDate;
    }

    public void setCurDate(String curDate) {
        this.curDate = curDate;
    }

    public String getTotalSteps() {
        return totalSteps;
    }

    public void setTotalSteps(String totalSteps) {
        this.totalSteps = totalSteps;
    }

    @Override
    public String toString() {
        return "dao.vo.Step[id="+id+",curDate="+curDate+",totalSteps="+totalSteps+"]";
}
}
