import java.sql.*;

class ReportFromView
{
public static void main(String args[])
{
Connection con;
Statement st;
ResultSet rs;

try
{
Class.forName("com.mysql.cj.jdbc.Driver");

con=DriverManager.getConnection("jdbc:mysql://localhost:3306/analyticsdb?user=root&password=volkswagen&useSSL=false");

st=con.createStatement();

rs=st.executeQuery("select * from fdlist where deposit>25000;");

while(rs.next())
{
System.out.print(rs.getString("name")+"\t");
System.out.print(rs.getString("deposit")+"\t");
System.out.println(rs.getString("futurevalue"));
}
con.close();
}
catch(Exception e)
{
System.out.println(e.getMessage());
}
}
}
