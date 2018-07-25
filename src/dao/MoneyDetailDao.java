package dao;

import domain.MoneyDetail;
import utils.JDBCtools;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * MoneyDetailDao
 * create by chenshihang on 2018/6/20
 */
public class MoneyDetailDao {

    private static String selectAllSql="SELECT * from moneydetail";

    private static String insertSal = "INSERT INTO moneydetail(income,student_name,description,outcome,detail,create_time,rest_money,notes,student_id,record_by) VALUES(?,?,?,?,?,?,?,?,?,?)";

    public List<MoneyDetail> getAllMoneyDetail() throws SQLException, IOException, ClassNotFoundException {
        Connection connection = new JDBCtools().getconnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(selectAllSql);
        List<MoneyDetail> result = new ArrayList<>();
        while(rs.next()){
            int id = rs.getInt(1);
            double income = rs.getDouble(2);
            String stuName = rs.getString(3);
            String description = rs.getString(4);
            double outcome = rs.getDouble(5);
            double detail = rs.getDouble(6);
            Date createTime = rs.getDate(7);
            double restMoney  = rs.getDouble(8);
            String notes  = rs.getString(9);
            int stuId  = rs.getInt(10);
            String recordBy  = rs.getString(11);
            MoneyDetail moneyDetail = new MoneyDetail(id,income,outcome,stuName,stuId,description,detail,createTime,restMoney,notes,recordBy);
            result.add(moneyDetail);
        }
        JDBCtools.relese(rs,statement,connection);
        return result;
    }

    public int insert(MoneyDetail moneyDetail) throws SQLException, IOException, ClassNotFoundException {
        Connection connection = new JDBCtools().getconnection();
        PreparedStatement preparedStatement = connection.prepareStatement(insertSal);
        preparedStatement.setDouble(1,moneyDetail.getIncome());
        preparedStatement.setString(2,moneyDetail.getStuName());
        preparedStatement.setString(3,moneyDetail.getDescription());
        preparedStatement.setDouble(4,moneyDetail.getOutcome());
        preparedStatement.setDouble(5,moneyDetail.getDetail());
        preparedStatement.setDate(6,new java.sql.Date(moneyDetail.getCreateTime().getTime()));
        preparedStatement.setDouble(7,moneyDetail.getRestMoney());
        preparedStatement.setString(8,moneyDetail.getNotes());
        preparedStatement.setInt(9, moneyDetail.getStuId());
        preparedStatement.setString(10,moneyDetail.getRecordBy());
        int result = preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        return result;
    }

    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        MoneyDetail moneyDetail = new MoneyDetail(10,0,"chen",201604045,"description",-20,new Date(),20,"notes","chenshihang");

        MoneyDetailDao moneyDetailDao = new MoneyDetailDao();

        List<MoneyDetail> moneyDetails = moneyDetailDao.getAllMoneyDetail();

        for (MoneyDetail item : moneyDetails){
            System.out.println(item.getRecordBy());
        }

//        int result = moneyDetailDao.insert(moneyDetail);

//        System.out.println(result);

    }
}
