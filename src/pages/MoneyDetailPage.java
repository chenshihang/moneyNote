package pages;

import utils.LayoutUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;

/**
 * MoneyDetailPage
 * create by chenshihang on 2018/6/20
 */
public class MoneyDetailPage {

    public  MoneyDetailPage moneyDetailPage=this;

    private JFrame jFrame;

    private JPanel jPanel;

    public JLabel info;

    private JScrollPane scrollpane;

    public JTable table;

    private JButton insertBtn;




    public void init(Vector<String> tablehead,Vector<Vector<String>> tableinfo){

        jFrame = new JFrame("财务详情");
        jPanel = new JPanel();

        DefaultTableModel model = new DefaultTableModel(tableinfo, tablehead);
        table = new JTable();
        table.setModel(model);

        scrollpane = new JScrollPane(table);
        int count = tableinfo.size();

        info = new JLabel("当前余额为 :"+tableinfo.get(count-1).get(3));
        insertBtn = new JButton("录入新记录");


        GridBagLayout layout = new GridBagLayout();
        jPanel.setLayout(layout);
        GridBagConstraints s = new GridBagConstraints();
        s.fill = GridBagConstraints.BOTH;

        jPanel.add(scrollpane);
        jPanel.add(info);
        jPanel.add(insertBtn);
        LayoutUtil.setConstraint(s, scrollpane, layout, 10, 0, 1, 1);
        LayoutUtil.setConstraint(s, info, layout, 10, 0, 1, 0);
        LayoutUtil.setConstraint(s, insertBtn, layout, 0, 0, 1, 0);
        jFrame.setContentPane(jPanel);
        jFrame.setSize(1300,500);
        Toolkit tk = jFrame.getToolkit();// 得到窗口工具条
        Dimension dm = tk.getScreenSize();
        jFrame.setVisible(true);
        jFrame.setLocation((int) (dm.getWidth() - 1300) / 2, (int) (dm.getHeight() - 500) / 2);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        insertBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    new AddRecordPage(moneyDetailPage).init();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}
