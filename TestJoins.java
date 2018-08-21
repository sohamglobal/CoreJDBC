import java.sql.*;

class TestJoins
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

rs=st.executeQuery("select c.custnm,p.prodnm,p.company,p.price from customers c inner join products p on c.prodid=p.prodid;");

while(rs.next())
{
System.out.print(rs.getString("custnm")+"\t");
System.out.print(rs.getString(2)+"\t");
System.out.print(rs.getString(3)+"\t");
System.out.println(rs.getString(4));
}
con.close();
}
catch(Exception e)
{
System.out.println(e.getMessage());
}
}
}
