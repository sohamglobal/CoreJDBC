import java.sql.*;

class TryJoins
{
public static void main(String args[])
{
Connection con;
Statement st;
ResultSet rs;

try
{
Class.forName("com.mysql.cj.jdbc.Driver");

con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nysedb8?user=root&password=crosspolo&useSSL=false");

st=con.createStatement();

rs=st.executeQuery("select c.custnm,p.prodnm,p.company from customers c inner join products p on c.prodid=p.prodid;");

while(rs.next())
{
System.out.print(rs.getString("custnm"));
System.out.print("\t"+rs.getString(2));
System.out.println("\t"+rs.getString(3));
}

con.close();
}
catch(Exception e)
{
System.out.println(e);
}
}
}









