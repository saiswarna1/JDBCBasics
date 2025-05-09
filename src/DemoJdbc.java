import java.awt.*;
import java.sql.*;
public class DemoJdbc {
    /*
    7stpes;
    1.import package
    2.load driver
    3.register Drivier
    4.create connection
    5.excute statement
    6.process results
    7.close
     */
    public static void main(String[] args) throws Exception{
Class.forName("org.postgresql.Driver");
String url="jdbc:postgresql://localhost:5432/demo";
String uname="postgres";
String pass="system";
String sql ="select *from student";
String sql1="insert into student values (25,90,'rajasab')";
String sql2="insert into student values (?,?,?)";
Connection con = DriverManager.getConnection(url,uname,pass);
        System.out.println(" Connection Establised");
Statement st= con.createStatement();
ResultSet rs = st.executeQuery(sql);
while(rs.next()){
 System.out.print("1col."+rs.getInt("sid"));
 System.out.print("2col."+rs.getInt("marks"));
 System.out.print("3col."+rs.getString("sname"));
 System.out.println();
}
Statement st1= con.createStatement();
st1.execute(sql1);
PreparedStatement st2 = con.prepareStatement(sql2);
st2.setInt(1,60);
st2.setInt(2,70);
st2.setString(3,"max");
st2.execute();
con.close();
System.out.println("connection closed");
    }
}
