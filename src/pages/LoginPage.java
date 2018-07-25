package pages;

import utils.JDBCtools;
import utils.LayoutUtil;

import javax.swing.*;
import java.awt.*;

/**
 * LoginPage
 * create by chenshihang on 2018/6/20
 */
public class LoginPage extends JFrame {


    private JPanel panel;


    private JLabel nameLab;

    private JLabel passwordLab;

    private JPasswordField passwordText;

    private  JTextField nameText;

    private JButton loginBtn;


    public LoginPage(){
        this.setTitle("acm协会账本");
    }

    public void showPage(){
        panel = new JPanel();
        nameLab = new JLabel("name");
        passwordLab = new JLabel("password");
        passwordText = new JPasswordField(20);
        nameText = new JTextField(20);
        loginBtn = new JButton("login");

        panel.add(nameLab);
        panel.add(nameText);
        panel.add(passwordLab);
        panel.add(passwordText);
        panel.add(loginBtn);
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints s = new GridBagConstraints();
        s.fill = GridBagConstraints.CENTER;
        LayoutUtil.setConstraint(s, nameLab, layout, 10, 1, 1, 0);
        LayoutUtil.setConstraint(s, nameText, layout, 10, 0, 0, 0);
        LayoutUtil.setConstraint(s, passwordLab, layout, 0, 1, 0, 0);
        LayoutUtil.setConstraint(s, passwordText, layout, 10, 0, 0, 0);
        LayoutUtil.setConstraint(s, loginBtn, layout, 0, 0, 0, 0);

        this.setSize(400,300);
        this.setContentPane(panel);
        this.setVisible(true);

    }

}
