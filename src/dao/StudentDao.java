package dao;

import domain.Student;
import utils.JDBCtools;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * StudentDao
 * create by chenshihang on 2018/6/20
 */
public class StudentDao {

    private static String getAllStuSql = "SELECT * FROM student";



    public List<Student> getAllStu() throws SQLException, IOException, ClassNotFoundException {
        Connection connection = new JDBCtools().getconnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(getAllStuSql);
        List<Student> result = new ArrayList<>();
        while(rs.next()){
            int id = rs.getInt(1);
            String stuName = rs.getString(2);
            int stuId = rs.getInt(3);
            Date createTime = rs.getDate(4);
            Student student = new Student(id,stuId,createTime,stuName);
            result.add(student);
        }
        JDBCtools.relese(rs,statement,connection);
        return result;
    }

    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        StudentDao studentDao = new StudentDao();
        List<Student> students = studentDao.getAllStu();

        for(Student item: students){
            System.out.println("name = "+ item.getStuName()+"  createTime = "+ item.getCreateTime());
        }

    }

}
