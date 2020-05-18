import vb.itcast.util.JDBCUtils;

import java.util.*;

//
//    class AA {
//       public void xxx()
//
//        {
//            System.out.println("dada");
//        }
//    }
//        class BB extends AA{
//       public void xxx (){
//            System.out.println("456");
//            }
// }
//
//        class CC extends AA{
//        public void xxx(){
//            System.out.println("789");
//        }
// }
//    public class MyJavaClass{
//    public static void main(String[]args) {
//        AA b = new BB();
//        AA c = new CC();
//
//  b.xxx();
//  c.xxx();
//
//    }
//
//
//}


//    public class  MyJavaClass{
//        public void start(){
//            System.out.println("123");
//        }
//        public static void main(String[] args) {
//            MyJavaClass c = new MyJavaClass() {
//                @Override public void start() {
//                    System.out.println("Wooooo");
//                }
//            };
//            c.start();
//        }
//    }

//
//import java.sql.*;
//
//
//public class  MyJavaClass{
//    public static void main(String[]args) {
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            System.out.println("驱动加载成功");
//        } catch (ClassNotFoundException e) {
//            System.out.println("找不到驱动程序类 ，加载驱动失败哦！");
//            e.printStackTrace();
//        }
//        String url = "jdbc:mysql://localhost:3306/runnoob?&useSSL=false&serverTimezone=UTC" ;
//        String username = "root" ;
//        String password = "root" ;
//        try{
//            Connection conn = DriverManager.getConnection(url ,username , password ) ;
//            Statement stmt = conn.createStatement() ;
//            ResultSet rs = stmt.executeQuery("SELECT * FROM websites") ;
//            while(rs.next()){
//                int id=rs.getInt("id");
//                String name = rs.getString("name") ;
//                String pass = rs.getString("url") ; // 此方法比较高效
//                String country=rs.getString("country");
//                int alexa = rs.getInt("alexa");
//                System.out.println(id+" "+name+pass+" "+country+" "+alexa);
//            }
//           JDBCUtils.close(rs,stmt,conn);
//

//            if(rs !=null){   // 关闭记录集
//                try {
//                    rs.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if(stmt !=null){   // 关闭声明
//                try {
//                    stmt.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if(conn !=null){  // 关闭连接对象
//                try {
//                    conn.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }catch(SQLException se){
//            System.out.println("数据库连接失败！");
//            se.printStackTrace() ;
//        }
//
//    }
//}


public class MyJavaClass implements Runnable {
    Integer p = 100;

    @Override
    public  void run() {
        Thread c = Thread.currentThread();
        String name = c.getName();
        while(true) {
            try {
                Thread.sleep(10);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (p) {


                if (p > 0) {

                    System.out.println(name + "卖了第" + p + "张票");
                    p--;
                } else {
                    System.out.println("卖完了");
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {

        MyJavaClass t = new MyJavaClass();

      //  for (int i = 0; i <= 20; i++) {
            Thread z1 = new Thread(t,"sd");
            z1.setName("窗口一");
            Thread z2 = new Thread(t);
            z2.setName("窗口二");
            Thread z3 = new Thread(t);
            z3.setName("窗口三");
            Thread z4 = new Thread(t);
            z4.setName("窗口四");
            Thread z5 = new Thread(t);
            z5.setName("窗口五");
            z1.start();
            z2.start();
            z3.start();
            z4.start();
            z5.start();
        }

   // }

}
//package Demo01;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class MyJavaClass extends JDialog{
//
//    public MyJavaClass(JFrame frame) {
//
//        /*
//
//         *第一个参数：父窗体对象
//
//         *第二个参数：对话框标题
//
//         * 第三个参数：是否阻塞父窗体
//
//         */
//
//        super(frame,"对话框",true);
//
//        //获取对话框窗体容器
//
//        Container c = getContentPane();
//
//        //添加一个对话框
//
//        c.add(new JLabel("这是一个对话框"));
//
//        //设置对话框窗体的坐标和大小
//
//        setBounds(100,100,100,100);
//
//
//
//    }
//
//
//
//    public static void main(String[] args) {
//
//        //创建一个窗体
//
//        JFrame f = new JFrame("父窗体");
//
//        //设置窗体的坐标和大小
//
//        f.setBounds(50,50,300,300);
//
//        //获取窗体f的容器
//
//        Container c = f.getContentPane();
//
//        //创建一个按钮
//
//        JButton btn = new JButton("弹出对话框");
//
//        //使用流布局设置布局
//
//        c.setLayout(new FlowLayout());
//
//        //将按钮添加到窗体中
//
//        c.add(btn);
//
//        //设置窗体可见
//
//        f.setVisible(true);
//
//        //设置窗体点击x号关闭程序
//
//        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
//
//        //对按钮添加监听事件
//
//        btn.addActionListener(new ActionListener() {
//
//            @Override
//
//            public void actionPerformed(ActionEvent e) {
//
//                Demo01.MyJavaClass dialog = new Demo01.MyJavaClass(f);
//
//                dialog.setVisible(true);
//
//            }
//
//        });
//
//    }
//
//public class MyJavaClass {
//   public static void main(String[]args){
//      try {
//         int a[]=new int[2];
//         System.out.println(a[3]);
//      }catch (Exception E){
//         System.out.println("BAGAYALU");
//      }
//
//
//
//   }
//}
//class MyJavaClass {
//   static int div(int a, int b) throws ArithmeticException {
//      if (b == 0) {
//         throw new ArithmeticException("Division by Zero");
//      } else {
//         return a / b;
//      }
//   }
//
//   public static void main(String args[]) {
//
//
//      System.out.println( div(4, 1));
//   }
//}

//public class MyJavaClass{
//    public static void main(String args[]) {
//    StringBuffer ch1=new StringBuffer("hello world");
//    ch1.append("im ojbk");
//    System.out.println(ch1);
//    ch1.insert(12,"You are ok");
//    System.out.println(ch1);
//
//    }}
//import java.util.Calendar;
//public class MyJavaClass{
//    public static void main(String []args){
//        Calendar calendar=Calendar.getInstance();
//        int year=calendar.get(Calendar.YEAR);
//        int month=Calendar.MONTH+1;
//        int day=calendar.get(Calendar.HOUR_OF_DAY);
//
//
//
//            System.out.println(year+"年"+month+"月"+day+"日");
//
//    }
//
//}
//import java.util.Calendar;
//public class MyJavaClass{
//
//    public static void main(String args[]) {
//
//    Calendar c1=Calendar.getInstance();
//// 获得年份
//        int year = c1.get(Calendar.YEAR);
//// 获得月份
//        int month = c1.get(Calendar.MONTH) + 1;
//// 获得日期
//        int date = c1.get(Calendar.DATE);
//// 获得小时
//        int hour = c1.get(Calendar.HOUR_OF_DAY);
//// 获得分钟
//        int minute = c1.get(Calendar.MINUTE);
//// 获得秒
//        int second = c1.get(Calendar.SECOND);
//// 获得星期几（注意（这个与Date类是不同的）：1代表星期日、2代表星期1、3代表星期二，以此类推）
//        int day = c1.get(Calendar.DAY_OF_WEEK);
//        System.out.println(year+"年"+month+"月"+ date+"日");
//
//
//    }
//}


//import java.util.*;
//import java.text.*;
//
//public class MyJavaClass {
//    public static void main(String args[]) {
//
//        Date dNow = new Date( );
//        SimpleDateFormat ft =
//                new SimpleDateFormat (" yyyy.MM.dd 'at' hh:mm:ss E a zzz");
//
//        System.out.println("Current Date: " + ft.format(dNow));
//    }
//}




//import java.io.File;
//import java.util.Scanner;
//import java.util.Random;
//import java.util.LinkedList;
//
//public class MyJavaClass{
//
//    public  static void main(String[]args){
//        int rrr=new Random().nextInt(10);
//        Scanner scanner=new Scanner(System.in);
//        int numble=scanner.nextInt();
//        LinkedList<String> c=new LinkedList<String>();
//        c.add("red");
//        c.add("red");
//        c.add("red");
//        c.add("red");
//        c.add("red");
//        c.add("red");
//        c.add("blue");
//        c.remove("blue");
////    System.out.println(rrr);
//        for (String s:c){
//            System.out.println(s);
//        }
//    }
//
//
//}

//public class MyJavaClass {
//  public static void main(String[] args) {
//     File file=new File("D:\\input-file.txt");
//      File x = new File("D:\\edong\\w3cschool.txt");
//      if(x.exists()) {
//         System.out.println(x.getName() +  "exists!");
//      }
//      else {
//         System.out.println("The file does not exist");
//      }
//   }
//}
//import java.util.ArrayList;
//public class MyJavaClass{
//   public static void main(String[]args){
//      ArrayList Colors=new ArrayList();
//      ArrayList<Integer> num=new ArrayList<Integer>(5);
//      Colors.add("Red");
//      Colors.add("blue");
//      Colors.add("yellow");
//      System.out.println(Colors);
//   }
//
//
//
//}
//public class MyJavaClass{
//   public static void main(String[]args){
//
//      try{
//         Thread.sleep(1000);
//      }catch (InterruptedException E){
//
//      }
//   }
//
//}

//class Loader implements Runnable{
//    private   int tickets=30;
//   public  void run() {
//       while (tickets>0){
//
//
//        String name=Thread.currentThread().getName();
//       System.out.println(name+"售出"+  tickets--  +"张票");
//           try {
//            Thread.sleep(200);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//   }
//}
//}
//class MyJavaClass {
//   public static void main(String[] args) {
//     Loader sale=new Loader();
//      Thread t1=new Thread(sale,"win1");
//       Thread t2=new Thread(sale,"win2");
//       Thread t3=new Thread(sale,"win3");
//       Thread t4=new Thread(sale,"win4");
//       t1.start();
//       t2.start();
//       t3.start();
//       t4.start();
//   }
//}

//class Loader extends Thread{
//    private  static int tickets=30;
//    public void run(){while (tickets>0){
//
//        String name=Thread.currentThread().getName();
//        System.out.println(name+"售出第"+  tickets--  +"张票");
//        try {
//            Thread.sleep(200);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//    }
//
//    }
//}
//class MyJavaClass {
//   public static void main(String[] args) {
//      Loader obj=new Loader();
//       Loader obm=new Loader();
//       Loader obl=new Loader();
//
//       obl.start();
//       obm.start();
//      obj.start();
//   System.out.println("程序中活动线程数"+Thread.activeCount());
//   }}

// class MyJavaClass {
//
//    public static int sun=0;
//     MyJavaClass(){
//        sun++;
//    }
//
//   public static final double PI=3.14;
//    public static void main(String[] args) {
//    MyJavaClass d=new MyJavaClass();
//    MyJavaClass e=new MyJavaClass();
//    System.out.println(MyJavaClass.sun);
//    System.out.println(PI);
//    }
//
//}


 //int a=Math.abs(-5);
//    int b=Math.max(4,500);
//    double c=Math.ceil(5.3335);
//    double f=Math.floor(5.33);
//    double p=Math.pow(2,5);
//    System.out.println(f);