import java.sql.*;

class ConnectToMySQL
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

rs=st.executeQuery("select * from accounts;");

while(rs.next())
{
System.out.print(rs.getString("accnm")+"\t");
System.out.println(rs.getDouble("balance"));
}

rs.close();
st.close();
con.close();
}
catch(ClassNotFoundException e)
{
System.out.println(e);
}
catch(SQLException e)
{
System.out.println(e);
}
}
}


