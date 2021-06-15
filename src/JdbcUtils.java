import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils {
    private static String driver=null;
    private static String url=null;
    private static String username=null;
    private static String password=null;
    static {
            InputStream in=JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
            //the method to read info from the properties file
            Properties properties=new Properties();
            //establish a new properties class to receive the input stream
            try {
                properties.load(in);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //load into properties
        //检查半天原来是资源文件写错了。。。。。
            driver=properties.getProperty("driver");
            url=properties.getProperty("url");
            username=properties.getProperty("username");
            password=properties.getProperty("password");
            //this is the method to get the info from the properties class
            //using the Properties method "getProperties" is ok
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
        /*how to get connection ?
        step1: load driver to make preparation to connect to the db
        step2: use class DriverManager 's method getConnection is ok
        then you will get a new connection to the required database
        * */
    }
    //an inner class ,which can return a Connection object
    public static void release(Connection conn, Statement st, ResultSet rs){
        //close sequence ResultSet,Statement,Connection
        if(rs!=null){
            try {
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if (st!=null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn!=null) {
            try{
                conn.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}
