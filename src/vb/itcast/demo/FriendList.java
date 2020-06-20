package vb.itcast.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FriendList extends JFrame implements MouseListener {

 private JPanel jPanel1 ;
 private JScrollPane scrollPane;
 private JButton button;

    public static void main(String[] args) {
        new FriendList();
    }

   public FriendList(){

        jPanel1 =new JPanel();
        scrollPane  =new JScrollPane();
        jPanel1=new JPanel(new GridLayout(50,1,4,4));
        JLabel []jbls=new JLabel[50];
//        for (int i=0;i<jbls.length;i++){
//               // jbls[i]=new JPanel(i+1+"",new ImageIcon("image/2.png"),JLabel.LEFT);
//                jbls[i].addMouseListener(this);
//                jPanel1.add(jbls[i]);
//        }
        this.setTitle("我的好友");
        this.setBounds(350,350,250,450);
       // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(scrollPane,BorderLayout.CENTER);
        this.setVisible(true);
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
