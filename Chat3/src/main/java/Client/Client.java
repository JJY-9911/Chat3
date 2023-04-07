package Client;

import Dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.User;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class Client extends JFrame{

        public void LoginFrame(){
            this.setSize(400,300);//窗口设置
            this.setTitle("登陆");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLocationRelativeTo(null);
            this.setResizable(true);

            JPanel mainPanel = new JPanel();

            JPanel clientSocketPanel = new JPanel();//用户名
            JLabel clientSocketLabel = new JLabel();
            JTextField clientSocketTxF = new JTextField(20);

            JPanel passWordPanel = new JPanel();//密码
            JLabel passWordLabel = new JLabel();
            JTextField passWordTxF = new JTextField(20);

            JPanel loginPanel = new JPanel();//登陆
            JButton loginButton = new JButton();

            JPanel registerPanel = new JPanel();//注册
            JButton registerButton = new JButton();

            mainPanel.setLayout(new GridLayout(4,1));

            clientSocketLabel.setText("用户名");
            clientSocketPanel.add(clientSocketLabel);
            clientSocketPanel.add(clientSocketTxF);

            passWordLabel.setText("密码");
            passWordPanel.add(passWordLabel);
            passWordPanel.add(passWordTxF);

            loginButton.setText("登陆");
            loginPanel.add(loginButton);

            registerButton.setText("注册");
            registerPanel.add(registerButton);

            mainPanel.add(clientSocketPanel);
            mainPanel.add(passWordPanel);
            mainPanel.add(loginPanel);
            mainPanel.add(registerPanel);
            this.add(mainPanel);
            setVisible(true);

            //点登陆
            loginButton.addActionListener(e -> {
                String userName = clientSocketTxF.getText();
                String passWord = passWordTxF.getText();
                if (userName.equals("") || passWord.equals("")) {
                    JOptionPane.showMessageDialog(null, "不能为空");
                } else {
                    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
                    UserDao userDao = (UserDao) context.getBean("login");
                    User user = userDao.logIn(userName,passWord);

                    try {
                        int result = user.getId();
                        if(result > 0){
                            ChatFrame myChatFrame = new ChatFrame();
                            myChatFrame.creatChatFrame(userName);
                            setVisible(false);
                            dispose();
                        }else{
                            JOptionPane.showMessageDialog(null, "用户名或密码错误");
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            });

            //点击注册
            registerButton.addActionListener(e -> {
                dispose();
                RegisterFrame Register = new RegisterFrame();
                Register.createRegisterFrame();
            });
        }
}