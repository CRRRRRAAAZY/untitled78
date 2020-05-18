public class itemList {
    /*
    *---------------------------------------------------------------
    *书名                 作者      出版社             单价      库存
    * Java基础案例教程   黑马程序员    人民邮电出版社     54.0    290
    * Java程序设计       伟大奉献者    中国铁道出版社     32.0    10
    *---------------------------------------------------------------
    * 总量
    * 总价格
     */
    public static void main(String[]args){
        String bName="Java基础案例教程";
        String bAuthor="黑马程序员";
        String bPubliction="人民邮电出版社";
        float bPrice=54.0f;
        short bCount=290;


        String bName2="Java程序设计";
        String bAuthor2="伟大奉献者";
        String bPubliction2="中国铁道出版社";
        float bPrice2=32.0f;
        short bCount2=10;
        int totlal=bCount+bCount2;
        float totalPrice=bPrice*bCount+bPrice2*bCount2;
        System.out.println("----------------------------------------------------------------");
        System.out.println("书名                 作者      出版社             单价      库存");
        System.out.println(bName+"   "+bAuthor+"    "+bPubliction+"     "+bPrice+"    "+bCount);
        System.out.println(bName2+"       "+bAuthor2+"    "+bPubliction2+"     "+bPrice2+"    "+bCount2);
        System.out.println("总量："+totlal);
        System.out.println("总价："+totalPrice);
        System.out.println("----------------------------------------------------------------");



    }




}
