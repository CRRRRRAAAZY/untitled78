import vb.itcast.util.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

public class asd{

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        Connection conn=null;
        PreparedStatement pstmt=null;
        try {
       //     Class.forName("com.mysql.cj.jdbc.Driver");
            String sql="insert into websites values(null ,?,?,?,?)";
     //       conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/runnoob?&useSSL=false&serverTimezone=UTC","root","root");
            conn =JDBCUtils.getconnection();
            pstmt = conn.prepareStatement(sql);
            System.out.println("输入名称");
            pstmt.setString(1,sc.next());
            System.out.println("输入地址");
            pstmt.setString(2,sc.next());
            System.out.println("输入alexa");
            pstmt.setString(3,sc.next());
            System.out.println("输入地区");
            pstmt.setString(4,sc.next());

            int count = pstmt.executeUpdate();
            if (count>0) {
                System.out.println("添加成功");
            }
                else {
                System.out.println("添加失败");
            }

            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
//            if (stmt!=null) {
//                try {
//                    stmt.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (conn!=null){
//                try {
//                    conn.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }

           JDBCUtils.close(pstmt,conn);
        }

    }















}
//import java.sql.*;
//
//SQL:
//
//        create table student(
//
//        sno number(10) primary key,
//
//        sname varchar(20) not null,
//
//        sex char(8),
//
//        brithday date,
//
//        phone number(20),
//
//        clazz_id varchar(20) references clazz(cno)
//
//        )
//
//        insert into student values(1001,'张三','男',to_date('1996-06-06'，'yyyy-mm-dd'),1234567989,'jsj01');
//
//        insert into student values(1002,'王二','女',to_date('1997-12-03'，'yyyy-mm-dd'),9874563211,'wl02');
//
//        insert into student values(1003,'刘六','男',to_date('1997-06-18'，'yyyy-mm-dd'),4563217899,'dx03');
//
//        select * from student
//
//
//
//        create table clazz(
//
//        cno varchar(20) primary key,
//
//        cname varchar(20) unique,
//
//        teacher varchar(20) not null
//
//        )
//
//        insert into clazz values('jsj01','计算机专业','欧老师');
//
//        insert into clazz values('wl02','网络工程专业','刘老师');
//
//        insert into clazz values('dx03','电信专业','罗老师');
//
//        select * from clazz
//
//class asd {
//    static class Student {
//        private String Id;
//        private String Name;
//        private String Sex;
//        private String Age;
//
//        Student(String Name, String Sex, String Age) {
//            this.Id = null; //default
//            this.Name = Name;
//            this.Sex = Sex;
//            this.Age = Age;
//        }
//
//        public String getId() {
//            return Id;
//        }
//
//        public void setId(String Id) {
//            this.Id = Id;
//        }
//
//        public String getName() {
//            return Name;
//        }
//
//        public void setName(String Name) {
//            this.Name = Name;
//        }
//
//        public String getSex() {
//            return Sex;
//        }
//
//        public void setSex(String Sex) {
//            this.Sex = Sex;
//        }
//
//        public String getAge() {
//            return Age;
//        }
//
//        public void setage(String Age) {
//            this.Age = Age;
//        }
//    }
//    private static Connection getConn() {
//        String driver = "com.mysql.jdbc.Driver";
//        String url = "jdbc:mysql://localhost:3306/samp_db";
//        String username = "root";
//        String password = "";
//        Connection conn = null;
//        try {
//            Class.forName(driver); //classLoader,加载对应驱动
//            conn = (Connection) DriverManager.getConnection(url, username, password);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return conn;
//    }
//    private static int insert(Student student) {
//        Connection conn = getConn();
//        int i = 0;
//        String sql = "insert into students (Name,Sex,Age) values(?,?,?)";
//        PreparedStatement pstmt;
//        try {
//            pstmt = (PreparedStatement) conn.prepareStatement(sql);
//            pstmt.setString(1, student.getName());
//            pstmt.setString(2, student.getSex());
//            pstmt.setString(3, student.getAge());
//            i = pstmt.executeUpdate();
//            pstmt.close();
//            conn.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return i;
//    }
//    private static int update(Student student) {
//        Connection conn = getConn();
//        int i = 0;
//        String sql = "update students set Age='" + student.getAge() + "' where Name='" + student.getName() + "'";
//        PreparedStatement pstmt;
//        try {
//            pstmt = (PreparedStatement) conn.prepareStatement(sql);
//            i = pstmt.executeUpdate();
//            System.out.println("resutl: " + i);
//            pstmt.close();
//            conn.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return i;
//    }
//    private static Integer getAll() {
//        Connection conn = getConn();
//        String sql = "select * from students";
//        PreparedStatement pstmt;
//        try {
//            pstmt = (PreparedStatement)conn.prepareStatement(sql);
//            ResultSet rs = pstmt.executeQuery();
//            int col = rs.getMetaData().getColumnCount();
//            System.out.println("============================");
//            while (rs.next()) {
//                for (int i = 1; i <= col; i++) {
//                    System.out.print(rs.getString(i) + "\t");
//                    if ((i == 2) && (rs.getString(i).length() < 8)) {
//                        System.out.print("\t");
//                    }
//                }
//                System.out.println("");
//            }
//            System.out.println("============================");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//    private static int delete(String name) {
//        Connection conn = getConn();
//        int i = 0;
//        String sql = "delete from students where Name='" + name + "'";
//        PreparedStatement pstmt;
//        try {
//            pstmt = (PreparedStatement) conn.prepareStatement(sql);
//            i = pstmt.executeUpdate();
//            System.out.println("resutl: " + i);
//            pstmt.close();
//            conn.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return i;
//    }
//
//    public static void main(String args[]) {
//        JDBCOperation.getAll();
//        JDBCOperation.insert(new Student("Achilles", "Male", "14"));
//        JDBCOperation.getAll();
//        JDBCOperation.update(new Student("Bean", "", "7"));
//        JDBCOperation.delete("Achilles");
//        JDBCOperation.getAll();
//    }
//}

//import java.util.*;
//
//public class asd {
//    static Stu[] Stu=new Stu[100];//定义学生数组，容量为100
//    static int number=0;
//    static Scanner scanner=new Scanner(System.in);
//
//    public static void main(String args[]){
//        int choice;
//
//        System.out.println("这是一个学生信息管理系统，最大容量为100，欢迎您对本系统的使用");
//        while(true){
//            System.out.println("1.信息添加");
//            System.out.println("2.信息查看");
//            System.out.println("3.信息修改");
//            System.out.println("4.信息删除");
//            System.out.println("5.信息按成绩从低到高排序");
//            System.out.println("6.信息查询");
//            System.out.println("7.退出");
//            System.out.println("请输入你要进行的操作");
//            choice=scanner.nextInt();
//            if(choice==7)break;
//            switch(choice){
//                case 1:   add(); break;//添加学生信息
//                case 2:   show();break;//查询学生信息
//                case 3:   change();break;//修改学生信息
//                case 4:   delete();break;//删除学生信息
//                case 5:   paixu();break;//对学生信息排序
//                case 6:   query();break;//查询学生信息
//            }
//        }
//        System.out.println("感谢您对本系统的使用，欢迎下次继续使用");
//    }
//
//    static void add(){//添加学生信息
//        while(true){
//            System.out.println("点击任意键继续添加学生信息，停止添加输入0");
//            if(scanner.nextInt()==0)break;
//            System.out.println("请输入该学生的学号，姓名，性别，年龄，成绩");
//            Stu[number]=new Stu();
//            Stu[number].setStuNum(scanner.next());
//            Stu[number].setName(scanner.next());
//            Stu[number].setGender(scanner.next());
//            Stu[number].setAge(scanner.nextInt());
//            Stu[number].setScore(scanner.nextInt());
//            number++;
//            System.out.println("添加成功");
//        }
//    }
//
//
//    static void show(){//展示学生信息
//        System.out.println("*******************************************");
//        System.out.println(" 学号       姓名             性别       年龄        成绩");
//        for(int i=0;i<number;i++)
//            System.out.println(Stu[i].getStuNum()+"\t"+Stu[i].getName()+"\t"+"\t"+Stu[i].getGender()+"\t"+Stu[i].getAge()+"\t"+Stu[i].getScore());
//        System.out.println("*******************************************");
//        System.out.println();
//    }
//
//    static void paixu(){//对学生信息进行排序
//        int j;
//        Stu temp=new Stu();
//        for(int i=0;i<number;i++)
//        {
//            for(j=i+1;j<number;j++)
//                if(Stu[i].getScore()>Stu[j].getScore())
//                {temp=Stu[i];Stu[i]=Stu[j];Stu[j]=temp;}
//        }
//        System.out.println("排序完成，选择”学生信息查看“进行查看");
//    }
//
//
//    static void change(){//改变学生信息
//        System.out.println("请输入要修改信息的学生学号");
//        String Stunumber=scanner.next();
//        for(int i=0;i<number;i++)
//        {
//            if(Stunumber.equals(Stu[i].getStuNum()))
//            {System.out.println("请输入要修改的学生的信息,学号，姓名，性别，年龄，分数");
//                Stu[i].setStuNum(scanner.next());
//                Stu[i].setName(scanner.next());
//                Stu[i].setGender(scanner.next());
//                Stu[i].setAge(scanner.nextInt());
//                Stu[i].setScore(scanner.nextInt());
//                break;
//            }
//            if(number==i)System.out.println("对不起查无此人");
//        }
//    }
//
//    static void query(){//查询
//        System.out.println("请输入要查询的学生学号");
//        String Stunumber=scanner.next();
//        int i;
//        for(i=0;i<number;i++)
//        {
//            if(Stunumber.equals(Stu[i].getStuNum())){
//                System.out.println("*******************************************");
//                System.out.println(" 学号       姓名             性别       年龄        成绩");
//                System.out.println(Stu[i].getStuNum()+"\t"+Stu[i].getName()+"\t"+"\t"+Stu[i].getGender()+"\t"+Stu[i].getAge()+"\t"+Stu[i].getScore());
//                System.out.println("*******************************************");
//            }
//        }
//        if(number==i)System.out.println("对不起查无此人");
//    }
//
//
//    static void delete(){//删除学生信息
//        System.out.println("请输入要删除信息的学生学号");
//        String Stunumber=scanner.next();
//        int i;
//        for( i=0;i<number;i++)
//            if(Stunumber.equals(Stu[i].getStuNum()))break;
//        if(number==i)System.out.println("对不起查无此人");
//        for(;i<number-1;i++)
//            Stu[i]=Stu[i+1];
//        number--;
//        System.out.println("删除完成");
//    }
//}
//
//
// class Stu {
//    private String stuNum;//学号
//    private String name;//姓名
//    private String gender;//性别
//    private int age;//年龄
//    private int score;//分数
//    public Stu() {
//        super();
//    }
//    public String getStuNum() {
//        return stuNum;
//    }
//    public void setStuNum(String stuNum) {
//        this.stuNum = stuNum;
//    }
//    public String getGender() {
//        return gender;
//    }
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//    public int getAge() {
//        return age;
//    }
//    public void setAge(int age) {
//        this.age = age;
//    }
//    public int getScore() {
//        return score;
//    }
//    public void setScore(int score) {
//        this.score = score;
//    }
//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//}