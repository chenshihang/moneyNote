package domain;

import java.util.Date;

/**
 * Student
 * create by chenshihang on 2018/6/20
 */
public class Student {

    private int id;

    private int stuId;

    private Date createTime;

    private String stuName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Student(int id, int stuId, Date createTime, String stuName) {
        this.id = id;
        this.stuId = stuId;
        this.createTime = createTime;
        this.stuName = stuName;
    }
}
