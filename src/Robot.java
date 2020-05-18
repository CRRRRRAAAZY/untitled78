
import java.util.Scanner;

        public class Robot {  enum Rank {
            BRONZE,
            SILVER,
            GOLD
        }


            public static void main(String[]args) {
        Rank a = Rank.BRONZE;
        switch (a) {
            case BRONZE:

                System.out.println("第一名！");
                break;
            case SILVER:
                System.out.println("第二名!");
                break;
            case GOLD:
                System.out.println("第一名!");
                break;

        }
   System.out.println(a.toString());
    }
}
//    public String getName() {
//        return name;
//    }
//    public void setName(String name){
//        this.name=name;
//    }
//

//
//    void barking (){
//        System.out.println("moen-moen");
//    }
//    public static void main(String[] args) {
//
//    }
//}

// Scanner sc = new Scanner(System.in);
// System.out.println(sc.nextLine());
// for (String b: myList){
//    System.out.println(b);