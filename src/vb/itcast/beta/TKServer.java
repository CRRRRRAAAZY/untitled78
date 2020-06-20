package vb.itcast.beta;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TKServer extends JFrame implements ActionListener {
    private Map<Integer, Socket> clients = new HashMap<Integer, Socket>();

    private JTextArea msg = new JTextArea("服务器消息接收器\r\n\n");
    private JTextArea input = new JTextArea();
    private JButton msgSend = new JButton("发送群消息");

    public TKServer() {
        // TODO Auto-generated constructor stub
        this.setVisible(true);
        this.setTitle("服务器");
        this.setSize(550, 750);
        this.setResizable(true);
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent arg0) {
//                // TODO Auto-generated method stub
//                super.windowClosing(arg0);
//                System.exit(0);
//            }
//        });
        msg.setEditable(false);
        input.setColumns(40);
        input.setRows(5);

        input.setAutoscrolls(true);
        msgSend.addActionListener(this);
        msgSend.setActionCommand("sendMsg");
        msg.setAutoscrolls(true);
        msg.setColumns(40);
        msg.setRows(30);

        JScrollPane spanel = new JScrollPane(msg);
        JScrollPane editpanel = new JScrollPane(input);
        this.add(spanel);
        this.add(editpanel);
        this.add(msgSend);
    }

    public static void main(String[] args) {

        new TKServer().listenClient();
    }

    public void listenClient() {

        String temp = "";
        try {
            //server尝试接收其他Socket的连接请求，server的accept方法是阻塞式的
            // 定义一个ServerSocket监听在端口8899上
            ServerSocket server = new ServerSocket(8899);
            while (true) {
                System.out.println("服务器端正在监听");
                Socket socket = server.accept();
                clients.put(socket.getPort(), socket);
                temp = "客户端" + socket.getPort() + " 连接";
                this.apppendMsg(temp);
                new mythread(socket, this).start();
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public void apppendMsg(String msg) {

        this.msg.append(msg + "\r\n");
    }

    public void sendMsgToAll(Socket fromSocket, String msg) {

        Set<Integer> keset = this.clients.keySet();
        java.util.Iterator<Integer> iter = keset.iterator();
        while (iter.hasNext()) {
            int key = iter.next();
            Socket socket = clients.get(key);

            if (socket != fromSocket) {
                try {
                    if (socket.isClosed() == false) {
                        if (socket.isOutputShutdown() == false) {

                            Writer writer = new OutputStreamWriter(socket.getOutputStream());
                            writer.write(msg);
                            writer.flush();
                        }
                    }
                } catch (SocketException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        String temp = "";
       // if ("sendMsg".equals(e.getActionCommand())) {
            if ((temp = this.input.getText()) != null) {
                System.out.println("开始向客户端群发消息");
                this.apppendMsg("服务器-->" + temp);
                Set<Integer> keset = this.clients.keySet();
                java.util.Iterator<Integer> iter = keset.iterator();
                while (iter.hasNext()) {
                    int key = iter.next();
                    Socket socket = clients.get(key);
                    try {
                        Writer writer = new OutputStreamWriter(socket.getOutputStream());
                        writer.write(temp);
                        writer.flush();
                    } catch (SocketException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                this.input.setText("");
            //}
        }
    }
}

class mythread extends Thread {

    private Socket socket = null;
    private TKServer server = null;
    private InputStreamReader reader = null;
    char chars[] = new char[64];
    int len;
    private String temp = null;

    public mythread(Socket socket, TKServer server) {
        // TODO Auto-generated constructor stub

        this.socket = socket;
        this.server = server;
        init();
    }

    private void init() {

        try {
            reader = new InputStreamReader(socket.getInputStream());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

        System.out.println("子线程开始工作");
        while (true) {
            try {
                System.out.println("服务器 线程" + this.getId() + "-->开始从客户端读取数据——>");
                while ((len = ((Reader) reader).read(chars)) != -1) {
                    temp = new String(chars, 0, len);
                    System.out.println("客户端" + socket.getPort() + "说-->" + temp);
                    server.apppendMsg("客户端" + socket.getPort() + "说-->" + temp);
                    server.sendMsgToAll(this.socket, "客户端" + socket.getPort() + "说-->" + temp);
                }
                if (socket.getKeepAlive() == false) {
                    ((Reader) reader).close();
                    temp = "客户端" + socket.getPort() + "-->退出";
                    server.apppendMsg(temp);
                    socket.close();
                    this.stop();
                }
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
                try {
                    ((Reader) reader).close();
                    socket.close();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        }
    }
}
