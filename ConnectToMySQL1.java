import java.sql.*;

class ConnectToMySQL1
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

rs=st.executeQuery("select custnm,prodid from customers;");

while(rs.next())
{
System.out.print(rs.getString(1));
System.out.println("\t"+rs.getString(2));
}

con.close();
}
catch(Exception e)
{
System.out.println(e);
}

}
}











