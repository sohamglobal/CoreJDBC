import java.sql.*;

class SelectExample
{
public static void main(String args[])
{
Connection con;
Statement st;
ResultSet rs;

try
{
Class.forName("com.mysql.cj.jdbc.Driver");

con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sharayudb?user=root&password=crosspolo&useSSL=false");

st=con.createStatement();

rs=st.executeQuery("select accnm,balance from accounts;");

while(rs.next())
{
System.out.print(rs.getString(1)+"\t");
System.out.println(rs.getDouble(2));
}

con.close();
}
catch(Exception e)
{
System.out.println(e);
}
}
}


