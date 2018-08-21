import java.sql.*;

class TryViews
{
public static void main(String args[])
{
Connection con;
Statement st;
ResultSet rs;

try
{
Class.forName("com.mysql.cj.jdbc.Driver");

con=DriverManager.getConnection("jdbc:mysql://sohamglobal:3306/skodadb?user=root&password=volkswagen&useSSL=false");

st=con.createStatement();

rs=st.executeQuery("select * from v2;");

while(rs.next())
{
System.out.print(rs.getString("accnm"));
System.out.print("\t"+rs.getString("balance"));
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











