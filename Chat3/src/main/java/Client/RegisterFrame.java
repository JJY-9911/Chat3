package Client;

import Dao.Register;
import Dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RegisterFrame extends JFrame{

    public void createRegisterFrame() {
        this.setSize(400, 300);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setTitle("注册界面");
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setResizable(false);

        JPanel registerPanel = new JPanel();
        registerPanel.setLayout(new GridLayout(4, 1));
        JLabel account = new JLabel("用户名");

        JLabel password = new JLabel("密 码");
        JTextField accountfield = new JTextField(13);
        JTextField passwordfield = new JTextField(13);
        JButton save = new JButton("保存");

        JPanel accountPanel = new JPanel();
        accountPanel.add(account);
        accountPanel.add(accountfield);

        JPanel passwordPanel = new JPanel();
        passwordPanel.add(password);
        passwordPanel.add(passwordfield);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(save);

        registerPanel.add(accountPanel);
        registerPanel.add(passwordPanel);
        registerPanel.add(buttonPanel);
        this.add(registerPanel);
        this.setVisible(true);

        save.addActionListener(e -> {
            String userName = accountfield.getText();
            String passWord = passwordfield.getText();
            if (userName.equals("") || passWord.equals("")) {
                JOptionPane.showMessageDialog(null, "请输入完整信息", "提示", JOptionPane.QUESTION_MESSAGE);
            }

            ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
            UserDao userDao = (UserDao) context.getBean("check");
            User user = userDao.check(userName);

            int result = user.getId();
            if(result > 0){
                JOptionPane.showMessageDialog(null,"用户已存在");
            }else{
                UserDao userDao1 = (UserDao)context.getBean("add");
                userDao1.add(userName,passWord);
                JOptionPane.showMessageDialog(null,"注册成功，请登录");
            }
        });

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                new Start();
            }
        });
    }
}
