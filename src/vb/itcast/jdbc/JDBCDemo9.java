package vb.itcast.jdbc;

import vb.itcast.util.JDBCUtils;

import java.sql.*;
import java.util.Scanner;



public class JDBCDemo9 {
    public static void main(String[] args) {

        System.out.println("是否注册Y/N");
        Scanner sc = new Scanner(System.in);
       ;
        if (sc.nextLine().equals("Y")) {
            registered();
        }
        System.out.println("登录");
        System.out.println("请输入用户名");
        String username = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();

        boolean flag = new JDBCDemo9().login(username, password);
        if (flag) {

            System.out.println("登录成功");
        } else {
            System.out.println("用户名或密码错误");
        }

        while (flag) {
            System.out.println("---------------------------------------------------------------");
            System.out.println("按1添加信息");
            System.out.println("按2删除信息");
            System.out.println("按3查找信息");
            System.out.println("按4修改信息");
            System.out.println("按5分组排序");
            System.out.println("按6分页查询");
            System.out.println("按0退出");
            System.out.println("---------------------------------------------------------------");

            int ch = sc.nextInt();
            switch (ch) {

                case 1:
                    insert();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    select();
                    break;
                case 4:
                    update();
                    break;
                case 5:
                    order();
                    break;
                case 6:
                    limit();
                    break;
                case 0:
                    flag=false;
                    System.out.println("bye bye");
                    break;
            default:
                System.out.println("无此选项请重新输入");
            }


        }
    }

    public boolean login(String username, String password) {
        if (username == null && password == null) {
            return false;
        }
        String sql = "select * from user where username=? and password=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getconnection();

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            rs = pstmt.executeQuery();

            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        return false;
    }

    static void registered() {
        Scanner sc = new Scanner(System.in);
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "insert into user values (null ,?,?)";
            conn = JDBCUtils.getconnection();
            pstmt = conn.prepareStatement(sql);
            System.out.println("输入账号");
            pstmt.setString(1, sc.next());
            System.out.println("输入密码");
            pstmt.setString(2, sc.next());
            int count = pstmt.executeUpdate();
            if (count > 0) {
                System.out.println("注册成功");
            } else
                System.out.println("注册失败");


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt, conn);
        }

    }

    static void insert() {
        Scanner sc = new Scanner(System.in);

        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "insert into websites values (null ,?,?,?,?)";
        try {
            conn = JDBCUtils.getconnection();

            pstmt = conn.prepareStatement(sql);
            System.out.println("输入名称");
            pstmt.setString(1, sc.next());
            System.out.println("输入地址");
            pstmt.setString(2, sc.next());
            System.out.println("输入alexa");
            pstmt.setString(3, sc.next());
            System.out.println("输入地区");
            pstmt.setString(4, sc.next());
            int count = pstmt.executeUpdate();
            if (count > 0) {
                System.out.println("添加成功");
            } else {
                System.out.println("添加失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt, conn);
        }


    }

    static void delete() {
        Scanner sc = new Scanner(System.in);

        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "delete from websites where id=?";
        try {
            conn = JDBCUtils.getconnection();
            pstmt = conn.prepareStatement(sql);
            System.out.println("请输入要删除的ID");
            pstmt.setString(1, sc.next());
            int count = pstmt.executeUpdate();
            if (count > 0) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt, conn);

        }
    }
    static void select(){
        Scanner sc = new Scanner(System.in);

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs=null;
        String sql = "select *from websites where id=?";
        try {
            conn = JDBCUtils.getconnection();
            pstmt = conn.prepareStatement(sql);

            System.out.println("请输入要查询的ID");
            pstmt.setString(1, sc.next());
            rs=pstmt.executeQuery();
            while (rs.next()){
                int id=rs.getInt("id");
                String name = rs.getString("name") ;
                String pass = rs.getString("url") ;
                String country=rs.getString("country");
                int alexa = rs.getInt("alexa");

                System.out.println(id+" "+name+" "+pass+" "+country+" "+alexa);
            }

//           if (rs.next()) {
//                System.out.println("查询成功");
//            } else {
//                System.out.println("查询失败");
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close( rs,pstmt, conn);
        }
    }
    static void update(){
        Scanner sc = new Scanner(System.in);

        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "update  websites set name =?,url=?,alexa=?,country=? where id=?";
        try {
            conn = JDBCUtils.getconnection();
            pstmt = conn.prepareStatement(sql);
            System.out.println("请输入要修改的ID");
            pstmt.setString(5,sc.next());
            System.out.println("输入名称");
            pstmt.setString(1, sc.next());
            System.out.println("输入地址");
            pstmt.setString(2, sc.next());
            System.out.println("输入alexa");
            pstmt.setString(3, sc.next());
            System.out.println("输入地区");
            pstmt.setString(4, sc.next());
            int count = pstmt.executeUpdate();
            if (count > 0) {
                System.out.println("修改成功");
            } else {
                System.out.println("修改失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt, conn);

        }


    }

    static void order(){

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs=null;
        String sql = "select  country,SUM(alexa) FROM websites group by country order by SUM(alexa) desc  ";
        try {
            conn = JDBCUtils.getconnection();
            pstmt = conn.prepareStatement(sql);



            rs=pstmt.executeQuery();
            while (rs.next()){
                String country=rs.getString("country");
                int alexa = rs.getInt(2);

                System.out.println(country+" "+alexa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close( rs,pstmt, conn);
        }
    }static int page=1;
    static void limit(){

        Scanner sc = new Scanner(System.in);

        Connection conn =null;
        PreparedStatement pstmt =null;
        ResultSet  rs=null;
        String sql="select *from websites limit ?,?";
        try {System.out.println("请输入每页显示条数");
            int size=sc.nextInt();
          conn = JDBCUtils.getconnection();
          pstmt = conn.prepareStatement(sql);
           // System.out.println("请输入起始号");
            pstmt.setInt(1,(page-1)*size);

            pstmt.setInt(2,size);
            rs=pstmt.executeQuery();
            while (rs.next()){
                int id=rs.getInt("id");
                String name = rs.getString("name") ;
                String pass = rs.getString("url") ;
                String country=rs.getString("country");
                int alexa = rs.getInt("alexa");

                System.out.println(id+" "+name+" "+pass+" "+country+" "+alexa);
            }
                page++;



        } catch (SQLException e) {
            e.printStackTrace();
        }
            finally {
            JDBCUtils.close(rs,pstmt,conn);
        }

    }


    }











