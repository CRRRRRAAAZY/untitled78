public class SellTicketDemo implements Runnable {
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
                    System.exit(0);
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
//public class SellTicketDemo extends Thread {
//    public static void main(String[] args) {
//        SellTicketDemo obj1=new SellTicketDemo();
//        SellTicketDemo obj2=new SellTicketDemo();
//        SellTicketDemo obj3=new SellTicketDemo();
//        obj1.setName("窗口一");obj2.setName("窗口二");obj3.setName("窗口三");
//        obj1.start();
//        obj2.start();
//        obj3.start();
//    }
//     private static int ticket=100;
//    private static Object object=new Object();
//    public void run(){
//        while(true){
//
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            synchronized (object) {
//                if (ticket > 0) {
//                    System.out.println(Thread.currentThread().getName() + "卖了第" + ticket + "票");
//                    ticket--;
//                } else {
//                    System.out.println("卖完了");
//                    System.exit(0);
//                }
//
//            }
//
//        }
//
//
//
//    }
//}

