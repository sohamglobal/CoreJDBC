import java.sql.*;
import java.io.*;

class MetaDataInfo
{
public static void main(String args[])
{
Connection con;
Statement st;
ResultSet rs;
ResultSetMetaData rsmd;

InputStreamReader isr=new InputStreamReader(System.in);
BufferedReader br=new BufferedReader(isr);
String tblnm;

try
{
Class.forName("com.mysql.cj.jdbc.Driver");

con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sharayudb?user=root&password=volkswagen&useSSL=false");


st=con.createStatement();

System.out.print("Enter table name ");
tblnm=br.readLine();


rs=st.executeQuery("select * from "+tblnm+";");

rsmd=rs.getMetaData();

int cnt=rsmd.getColumnCount();
System.out.println("Number of columns: "+cnt);

for(int i=1;i<=cnt;i++)
{
System.out.print(rsmd.getColumnName(i)+"\t");
System.out.println(rsmd.getColumnTypeName(i));
}

con.close();
}
catch(Exception e)
{
System.out.println(e);
}
}
}


