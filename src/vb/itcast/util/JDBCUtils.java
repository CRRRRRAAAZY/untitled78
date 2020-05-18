package vb.itcast.util;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static  String url;
    private static  String username;
    private static  String password;
    private static  String driver;
    static {
        try {
        Properties pro =new Properties();
        //类加载器
        ClassLoader classLoader = JDBCUtils.class.getClassLoader();
        URL res = classLoader.getResource("jdbc.properties");
        String path = res.getPath();
        System.out.println(res);


        //    pro.load(new FileReader("src/jdbc.properties"));
          pro.load(new FileReader(path));
            url=pro.getProperty("url");
            username=pro.getProperty("username");
            password=pro.getProperty("password");
            driver=pro.getProperty("driver");
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


    public static Connection getconnection() throws SQLException {





        return DriverManager.getConnection(url,username,password);
    }
//    Class.forName("com.mysql.cj.jdbc.Driver");
//    String url = "jdbc:mysql://localhost:3306/runnoob?&useSSL=false&serverTimezone=UTC" ;
//    String username = "root" ;
//    String password = "root" ;


public static void close(ResultSet rs, Statement stmt,Connection conn){
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt!=null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
}
    public static void close(Statement stmt,Connection conn){
        if( stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if( conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

public class zxc{
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getAlexa() {
        return alexa;
    }

    public void setAlexa(int alexa) {
        this.alexa = alexa;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    private int id;
    private String name;
    private String url;
    private int alexa;
    private String country;

    @Override
    public String toString() {
        return "zxc{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", alexa=" + alexa +
                ", country='" + country + '\'' +
                '}';
    }
}



}
