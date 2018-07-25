package domain;

import java.util.Date;

/**
 * MoneyDetail
 * create by chenshihang on 2018/6/20
 */
public class MoneyDetail {

    private  int id;

    private double income;

    private double outcome;

    private String stuName;

    private int stuId;

    private String description;

    private double detail;

    private Date createTime;

    private double restMoney;

    private String notes;

    private String recordBy;

    public MoneyDetail(int id, double income, double outcome, String stuName, int stuId, String description, double detail, Date createTime, double restMoney, String notes, String recordBy) {
        this.id = id;
        this.income = income;
        this.outcome = outcome;
        this.stuName = stuName;
        this.stuId = stuId;
        this.description = description;
        this.detail = detail;
        this.createTime = createTime;
        this.restMoney = restMoney;
        this.notes = notes;
        this.recordBy = recordBy;
    }

    public MoneyDetail(double income, double outcome, String stuName, int stuId, String description, double detail, Date createTime, double restMoney, String notes, String recordBy) {
        this.income = income;
        this.outcome = outcome;
        this.stuName = stuName;
        this.stuId = stuId;
        this.description = description;
        this.detail = detail;
        this.createTime = createTime;
        this.restMoney = restMoney;
        this.notes = notes;
        this.recordBy = recordBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getOutcome() {
        return outcome;
    }

    public void setOutcome(double outcome) {
        this.outcome = outcome;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDetail() {
        return detail;
    }

    public void setDetail(double detail) {
        this.detail = detail;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public double getRestMoney() {
        return restMoney;
    }

    public void setRestMoney(double restMoney) {
        this.restMoney = restMoney;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getRecordBy() {
        return recordBy;
    }

    public void setRecordBy(String recordBy) {
        this.recordBy = recordBy;
    }
}
