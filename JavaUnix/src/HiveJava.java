import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import org.apache.hadoop.hive.jdbc.*; 
public class HiveJava {
  static String driverName = "org.apache.hadoop.hive.jdbc.HiveDriver";
  /**
   * @param args
   * @throws SQLException
   */
  public static void main(String[] args) throws SQLException {
      try {
      Class.forName(driverName);
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      System.exit(1);
    }
    //replace "hive" here with the name of the user the queries should run as
    Connection con = DriverManager.getConnection("..jdbc:hive2://172.16.149.158:10000/default", "hive", "");
    Statement stmt = con.createStatement();
    String tableName = "testHiveDriverTable";
    stmt.execute("drop table if exists " + tableName);
    stmt.execute("create table " + tableName + " (key int, value string)");
    // show tables
    // String sql = "show tables '" + tableName + "'";
    String sql = ("show tables");
    ResultSet res = stmt.executeQuery(sql);
    if (res.next()) {
        System.out.println(res.getString(1));
      }
  }
}