package vb.itcast.beta;



import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.*;

public class TKClient extends JFrame implements ActionListener {

    // 为了简单起见，所有的异常都直接往外抛
    String host = "127.0.0.1"; // 要连接的服务端IP地址
    int port = 8899; // 要连接的服务端对应的监听端口
    mythreadClient thread = null;
    Socket client = null;
    Writer writer = null;

    private JTextArea msg = new JTextArea("客户端消息接收器\r\n\n");
    private JTextArea input = new JTextArea();
    private JButton msgSend = new JButton("发送群消息");

    public TKClient() {
        // TODO Auto-generated constructor stub

        initSocket();
        this.setVisible(true);
        this.setTitle("客户端");
        this.setSize(550, 750);
        this.setResizable(true);
        this.setLayout(new FlowLayout());
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent arg0) {
                // TODO Auto-generated method stub
                super.windowClosing(arg0);
                try {
                    if (client != null) {
                        client.close();
                    }
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                if (thread != null) {
                    thread.stop();
                }
                System.exit(0);
            }
        });
        input.setColumns(40);
        input.setRows(10);
        input.setAutoscrolls(true);
        msgSend.addActionListener(this);
        msgSend.setActionCommand("sendMsg");
        msg.setAutoscrolls(true);
        msg.setColumns(40);
        msg.setRows(25);
        JScrollPane spanel = new JScrollPane(msg);
        JScrollPane editpanel = new JScrollPane(input);
        this.add(spanel);
        this.add(editpanel);
        this.add(msgSend);
    }

    /**
     * @param args
     */
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        new TKClient();
    }

    public void initSocket() {

        try {
            client = new Socket(this.host, this.port);
            writer = new OutputStreamWriter(client.getOutputStream());
            // 建立连接后就可以往服务端写数据了
            thread = new mythreadClient(client, this);
            thread.start();
            this.appendMsg("已连上服务器");
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            this.appendMsg("不能连接上服务器");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            this.appendMsg("不能连接上服务器");
        }
    }

    public void appendMsg(String msg) {

        this.msg.append(msg + "\r\n");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        String temp = "";
        try {
            if ("sendMsg".equals(e.getActionCommand())) {
                if ((temp = this.input.getText()) != null) {
                    writer.write(temp);
                    writer.flush();
                    this.appendMsg("我(" + this.client.getLocalPort() + ")说——>" + temp);
                    this.input.setText("");
                }
            }
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}

class mythreadClient extends Thread {

    private Socket socket = null;
    private Reader reader = null;
    private int len = 0;
    char chars[] = new char[64];
    private TKClient client = null;
    private String temp = "";

    //参数分别是：serverSocket，clientSocket
    public mythreadClient(Socket socket, TKClient client) {
        // TODO Auto-generated constructor stub

        this.socket = socket;
        this.client = client;
        try {
            reader = new InputStreamReader(socket.getInputStream());
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

        super.run();
        System.out.println("客户端 子线程" + this.getId() + "-->开始工作");
        while (true) {
            try {
                if (socket.isClosed() == false) {
                    if (socket.isInputShutdown() == false) {
                        while ((len = ((Reader) reader).read(chars)) != -1) {
                            temp = "服务器说——>" + new String(chars, 0, len);
                            client.appendMsg(temp);
                            System.out.println();
                        }
                    }
                } else {
                    if (socket.getKeepAlive() == false) {
                        reader.close();
                        socket.close();
                        this.stop();
                    }
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

