package vb.itcast.demo;

import vb.itcast.beta.TKClient;
import vb.itcast.beta.TKServer;
import vb.itcast.util.JDBCUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChatReceiver {
    public ChatReceiver(){
        JFrame frame=new JFrame("滑稽pp");
        frame.setBounds(600,300,440,330);
        //frame.getContentPane().setBackground(Color.white);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label1=new JLabel(new ImageIcon(ChatReceiver.class.getResource("3.gif")));
        //  label1.setBounds(0,0,800,800);
        frame.setResizable(false);

        frame.add(label1,"North");
        JPanel panel=new JPanel();
        panel.setLayout(null);
        frame.add(panel);
        JLabel label2=new JLabel(new ImageIcon(ChatReceiver.class.getResource("2.png")));
        label2.setBounds(25,10,80,80);
        panel.add(label2);

        JTextField field1=new JTextField();
        field1.setBounds(110,10,180,30);
        panel.add(field1);
        JPasswordField field2=new JPasswordField();
        field2.setBounds(110,35,180,30);
        panel.add(field2);

        JCheckBox box1=new JCheckBox("记住密码");
        box1.setBounds(110,75,80,15);
        panel.add(box1);
        JCheckBox box2=new JCheckBox("自动登录");
        box2.setBounds(210,75,80,15);
        panel.add(box2);

        JLabel label3=new JLabel(new ImageIcon(ChatReceiver.class.getResource("4.png")));
        label3.setBounds(110,100,180,30);
        panel.add(label3);
        frame.setVisible(true);

        JButton button=new JButton("注册");
        button.setBounds(0,110,100,20);
        panel.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==button) {
                    String text1 = field1.getText().trim();
                    String text2 = String.valueOf(field2.getPassword());
                    if (text1.isEmpty() && text2.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "用户名或密码不能为空");
                    } else {
                        Connection conn = null;
                        PreparedStatement pstmt = null;

                        try {
                            String sql = "insert into user values (null ,?,?)";
                            conn = JDBCUtils.getconnection();
                            pstmt = conn.prepareStatement(sql);
                            System.out.println("输入账号");
                            pstmt.setString(1, text1);
                            System.out.println("输入密码");
                            pstmt.setString(2, text2);
                            int count = pstmt.executeUpdate();
                            if (count > 0) {
                                System.out.println("注册成功");
                            } else
                                System.out.println("注册失败");


                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        } finally {
                            JDBCUtils.close(pstmt, conn);
                        }

                        JOptionPane.showMessageDialog(null, "用户名或密码不能为空");

                    }
                }
                    }

                });
                label3.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        super.mousePressed(e);
                        if (e.getSource()==label3) {
                            String text1 = field1.getText();
                            String text2 = String.valueOf(field2.getPassword());
                            if (text1.isEmpty()&&text2.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "用户名或密码不能为空");
                            } else if (login(text1,text2)){
                                frame.dispose();

                                new TKClient();

//
                            }
                        }

            }
        });

    }
    public boolean login(String username, String password) {
        if (username == null && password == null) {
            return false;
        }
        String sql = "select * from user where username=? and password=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getconnection();

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            rs = pstmt.executeQuery();

            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        return false;
    }




    public static void main(String[] args) {

        new ChatReceiver();



    }
}