package pages;

import common.CommonUtil;
import dao.MoneyDetailDao;
import dao.StudentDao;
import domain.MoneyDetail;
import domain.Student;
import utils.LayoutUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Vector;

/**
 * AddRecordPage
 * create by chenshihang on 2018/6/20
 */
public class AddRecordPage {



    private JLabel l1;
    private JLabel l2;
//    private JLabel l3;
    private JLabel l5;
    private JLabel l6;
    private JLabel l8;

    private JTextField income;
    private JTextField outcome;
//    private JTextField detail;
    private JTextField description;
    private JComboBox<String> stuName;
    private JTextField notes;

    public StudentDao studentDao;

    public List<Student> studentList;

    private JButton submit;
    private JButton cancel;

    private JFrame frame;
    private JPanel panel;

    private MoneyDetailPage moneyDetailPage;

    public AddRecordPage(MoneyDetailPage moneyDetailPage) {
        this.moneyDetailPage = moneyDetailPage;
    }

    public void init() throws SQLException, IOException, ClassNotFoundException {

        frame = new JFrame("记账");
        panel = new JPanel();
        income = new JTextField(20);
        outcome = new JTextField(20);
//        detail = new JTextField(20);
        description = new JTextField(20);
        stuName = new JComboBox<>();
        studentDao = new StudentDao();
        studentList = studentDao.getAllStu();
        for(Student item: studentList){
            stuName.addItem(item.getStuName());
        }

        notes = new JTextField(20);
        l1 = new JLabel("收入");
        l2 = new JLabel("支出");
//        l3 = new JLabel("明细");
        l5 = new JLabel("描述");
        l6 = new JLabel("姓名");
        l8 = new JLabel("备注");

        submit = new JButton("提交");
        cancel = new JButton("关闭");


        panel.add(l1);
        panel.add(income);
        panel.add(l2);
        panel.add(outcome);
//        panel.add(l3);
//        panel.add(detail);
        panel.add(l5);
        panel.add(description);
        panel.add(l6);
        panel.add(stuName);
        panel.add(l8);
        panel.add(notes);
        panel.add(submit);
        panel.add(cancel);
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints s = new GridBagConstraints();
        s.fill = GridBagConstraints.BOTH;

        LayoutUtil.setConstraint(s, l1, layout, 10, 1, 1, 0);
        LayoutUtil.setConstraint(s, income, layout, 10, 0, 1, 0);
        LayoutUtil.setConstraint(s, l2, layout, 10, 1, 1, 0);
        LayoutUtil.setConstraint(s, outcome, layout, 10, 0, 1, 0);
//        LayoutUtil.setConstraint(s, l3, layout, 10, 1, 1, 0);
//        LayoutUtil.setConstraint(s, detail, layout, 10, 0, 1, 0);
        LayoutUtil.setConstraint(s, l5, layout, 10, 1, 1, 0);
        LayoutUtil.setConstraint(s, description, layout, 10, 0, 1, 0);
        LayoutUtil.setConstraint(s, l6, layout, 10, 1, 1, 0);
        LayoutUtil.setConstraint(s, stuName, layout, 10, 0, 1, 0);
        LayoutUtil.setConstraint(s, l8, layout, 10, 1, 1, 0);
        LayoutUtil.setConstraint(s, notes, layout, 10, 0, 1, 0);
        LayoutUtil.setConstraint(s, submit, layout, 10, 0, 1, 0);
        LayoutUtil.setConstraint(s, cancel, layout, 10, 0, 1, 0);

        frame.setContentPane(panel);

        Toolkit tk = frame.getToolkit();// 得到窗口工具条
        Dimension dm = tk.getScreenSize();
        frame.setVisible(true);
        frame.setLocation((int) (dm.getWidth() - 450) / 2, (int) (dm.getHeight() - 450) / 2);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(450,450);
        frame.setVisible(true);


        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MoneyDetailDao moneyDetailDao = new MoneyDetailDao();
                double lastMoney = 0;
                try {
                    List<MoneyDetail> moneyDetails = moneyDetailDao.getAllMoneyDetail();

                    MoneyDetail last = moneyDetails.get(moneyDetails.size()-1);
                    lastMoney = last.getRestMoney();

                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }

                int stuid = 0;
                for(Student item: studentList){
                    if(item.getStuName().equals(stuName.getSelectedItem().toString())){
                        stuid = item.getStuId();
                        break;
                    }
                }
                double incomeVal = income.getText().length()==0? 0:Double.valueOf(income.getText());
                double outcomeVal = outcome.getText().length()==0? 0:Double.valueOf(outcome.getText());
                String stuNameVal = stuName.getSelectedItem().toString();
                String descriptionVal = description.getText();
                double detailVal = incomeVal - outcomeVal;
                double restMoney = lastMoney+detailVal;
                String notesVal = notes.getText();
                MoneyDetail moneyDetail = new MoneyDetail(incomeVal,outcomeVal,stuNameVal,stuid,descriptionVal,detailVal,new Date(),restMoney,notesVal,"陈世航");
                int result = 0;
                try {
                    result = moneyDetailDao.insert(moneyDetail);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
                if(result<=0){
                    System.out.println("增加记录失败");
                }else {
                    frame.dispose();
                    List<MoneyDetail> moneyDetailList = null;
                    try {
                        moneyDetailList = moneyDetailDao.getAllMoneyDetail();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    } catch (ClassNotFoundException e1) {
                        e1.printStackTrace();
                    }
                    Vector<Vector<String>> tabledatas = CommonUtil.listToVector(moneyDetailList);
                    Vector<String> tableHeads = CommonUtil.initTableHead();
                    DefaultTableModel model = new DefaultTableModel(tabledatas, tableHeads);
                    moneyDetailPage.table.setModel(model);
                    moneyDetailPage.info.setText("当前余额为:"+restMoney);
                }
            }
        });

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

    }



}
