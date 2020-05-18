import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.ServerSocket;
public class TCPServers{
        public static void main(String[]args)throws IOException{

    ServerSocket serverSocket=new ServerSocket(3456);
    System.out.println("准备接收客户端请求");
    Socket socket=serverSocket.accept();
    OutputStream os=socket.getOutputStream();
    os.write("javaTPC网络编程".getBytes());
    os.close();
    socket.close();
    System.out.println("结束用户通信");
    serverSocket.close();



        }
}