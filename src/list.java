
import java.util.Scanner;

class student{

    private String a_name;
    private int a_xuehao;
    private String sex;
    private int age;

    public String getA_name() {
        return a_name;
    }

    public void setA_name(String a_name) {
        this.a_name = a_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public int getA_xuehao(){
        return a_xuehao;
    }
    public void setA_xuehao(int a_xuehao){
        this.a_xuehao=a_xuehao;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex){
        this.sex=sex;
    }

}
public class list {
   static Scanner sc = new Scanner(System.in);
   static student []a=new student[100];
   static int i=0;
   public static void menu() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("按1添加信息");
        System.out.println("按2删除信息");
        System.out.println("按3修改信息");
        System.out.println("按4查找信息");
        System.out.println("按5排序信息");
        System.out.println("按6打印所有");
        System.out.println("----------------------------------------------------------------");
    }
   public static void add(){


       a[i]=new student();
       System.out.println("输入姓名");
        a[i].setA_name(sc.next());
       System.out.println("输入学号");
        a[i].setA_xuehao(sc.nextInt());
       System.out.println("输入年龄");
        a[i].setAge(sc.nextInt());
       System.out.println("输入性别");
        a[i].setSex(sc.next());

      System.out.println("输入成功");
        i++;



//       String a_xuehao=sc.next();
//       String a_name=sc.next();
//       int age=sc.nextInt();
     // a[i]=new a();


    }
    static void delete(){
    int j;
    System.out.println("请输入要删除那人的学号");
    int snum=sc.nextInt();
    for (j=0;j<i;j++)
        if (snum == a[j].getA_xuehao())
            break;
        if (i == j)

        System.out.println("对不起查无此人");
     if(i!=j) {
         for (; j < i - 1; j++)
             a[j] = a[j + 1];
         i--;
     }
    }
    static void change(){
        int j;
        System.out.println("输入要改的那人学号");
        int snum=sc.nextInt();
        for (j=0;j<i;j++)
            if (snum==a[j].getA_xuehao() ){
                System.out.println("输入姓名");
                a[j].setA_name(sc.next());
                System.out.println("输入性别");
                a[j].setSex(sc.next());
                System.out.println("输入年龄");
                a[j].setAge(sc.nextInt());
                System.out.println("输入学号");
                a[j].setA_xuehao(sc.nextInt());
            break;

            }
        if (i==j)
            System.out.println("没这人");
    }
    static void find(){
        int j;
        System.out.println("输入要找那人的学号");
        int snum=sc.nextInt();
        System.out.println("姓名          性别      年龄          学号");
        for (j=0;j<i;j++)
          if (snum==a[j].getA_xuehao() )
              System.out.println(a[j].getA_name()+"\t\t\t\t"+a[j].getSex()+"\t\t "+a[j].getAge()+"\t\t\t\t"+a[j].getA_xuehao());
    }
    static void sort(){
        int j,k;
        student stu=new student();
        for (j=0;j<i;j++)
            for (k=j+1;k<i;k++)
                if (a[j].getA_xuehao()>a[k].getA_xuehao()) {
                    stu = a[j];
                    a[j] = a[k];
                    a[k] = stu;
                }
        System.out.println("排序完成（学号从小到大）");
                }
    static void print() {
        System.out.println("姓名          性别      年龄          学号");
       int j;
       for (j=0;j<i;j++)
            System.out.println(a[j].getA_name()+"\t\t\t\t"+a[j].getSex()+"\t\t "+a[j].getAge()+"\t\t\t\t"+a[j].getA_xuehao());

   }
    public static void main(String[] args) {


        int zhi = 1;
        while (zhi!=0) {
            menu();

            int ch=sc.nextInt();
            switch(ch){
                case 1:
                    add();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    change();
                    break;
                case 4:
                    find();
                    break;
                case 5:
                    sort();
                    break;
                case 6:
                    print();
                    break;
                case 0:
                    zhi=0;
                System.out.println("感谢使用");
                    break;
                default :
                    System.out.println("输入错误");





            }

        }
    }
}
