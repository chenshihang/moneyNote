package utils;

import javax.swing.*;
import java.awt.*;

/**
 * LayoutUtil
 * create by chenshihang on 2018/6/20
 */
public class LayoutUtil {

    //网格包布局方法
    public static void setConstraint(GridBagConstraints s, JComponent c, GridBagLayout layout, int ipady, int gridwidth, int weightx, int weighty)
    {
        s.ipady = ipady;
        s.gridwidth = gridwidth;
        s.weightx = weightx;
        s.weighty = weighty;
        layout.setConstraints(c, s);
    }

    //设置列宽方法
    public static void setColumnWidth(JTable table)
    {
        table.getColumnModel().getColumn(0).setPreferredWidth(150);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
    }
}
