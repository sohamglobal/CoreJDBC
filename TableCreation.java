import java.sql.*;
import java.io.*;

class TableCreation
{
public static void main(String args[])
{
InputStreamReader isr=new InputStreamReader(System.in);
BufferedReader br=new BufferedReader(isr);
String sid;

Connection con;
Statement st;

try
{
System.out.print("enter student ID : ");
sid=br.readLine();

Class.forName("com.mysql.cj.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/analyticsdb?user=root&password=volkswagen&useSSL=false");
st=con.createStatement();

st.execute("create table "+sid+" (srno int primary key auto_increment,testdate datetime,testtype varchar(20) default 'test',totmarks int,score int,remarks varchar(100));");

System.out.println("Done..table created successfully");
con.close();
}
catch(Exception e)
{
System.out.println(e);
}


}
}