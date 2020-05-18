import java.util.Scanner;
public class zxc {
     static int div(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Division by Zero");
        } else {
            return a / b;
        }
    }
    public static void main(String[]args) {



                    System.out.println( div(2,1));
        }



}
//public class SellTicketDemo {
//
//    public static void main(String[] args) {
//
//        //创建票对象
//
//        Ticket t=new Ticket();
//
//        //给票的count属性赋值为100
//
//        t.setCount(100);
//
//
//
//        SellSystem s=new SellSystem(t);
//
//
//
//        //4个线程对应4个售票窗口
//
//        Thread thread1=new Thread(s);
//        thread1.setName("窗口1");
//        Thread thread2=new Thread(s,"窗口2");
//
//        Thread thread3=new Thread(s,"窗口3");
//
//        Thread thread4=new Thread(s);
//        thread4.setName("窗口4");
//        thread1.start();
//
//        thread2.start();
//
//        thread3.start();
//
//        thread4.start();
//
//    }
//
//}
//
//
//
////卖票系统
//
//class SellSystem implements Runnable{
//
//    //定义票对象t
//
//    private Ticket t;
//
//
//
//    public SellSystem(Ticket t) {
//
//        this.t=t;
//
//    }
//
//    @Override
//
//    public void run() {
//
//        while(true){
//
//            try {
//
//                //此处让进来的线程睡一会是为了增加其他线程抢占到执行权的概率
//
//                Thread.sleep(10);
//
//            } catch (InterruptedException e) {
//
//                e.printStackTrace();
//
//            }
//
//            synchronized (t) {
//
//                if (t.getCount()>0) {
//
//                    t.setCount(t.getCount()-1);
//
//                    //Thread.currentThread()表示获取当前正在执行的线程，t.getCount()是t.setCount设置后的数量
//
//                    System.out.println(Thread.currentThread().getName()+"卖了一张票，还剩"+t.getCount());
//
//                }
//                else return ;
//
//            }
//
//        }
//
//    }
//
//}
//
//
//
////票
//
//class Ticket{
//
//    //定义票的数量属性
//
//    private int count;
//
//
//
//    public int getCount() {
//
//        return count;
//
//    }
//
//
//
//    public void setCount(int count) {
//
//        this.count = count;
//
//    }
//
//
//
//}
