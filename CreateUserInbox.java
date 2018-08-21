import java.sql.*;
import java.io.*;

class CreateUserInbox
{
public static void main(String args[])
{
String userid;

Connection con;
Statement st;

InputStreamReader isr=new InputStreamReader(System.in);
BufferedReader br=new BufferedReader(isr);
try
{
System.out.print("Enter userID ");
userid=br.readLine();

Class.forName("com.mysql.cj.jdbc.Driver");

con=DriverManager.getConnection("jdbc:mysql://localhost:3306/analyticsdb?user=root&password=volkswagen&useSSL=false");

st=con.createStatement();

st.execute("create table "+userid+"inbox (msgno int primary key,msgfrm varchar(30),msgdt date,subject varchar(100),msgtext varchar(1000),msgstatus varchar(10) default 'unread');");

st.execute("create table "+userid+"contacts (contid int primary key,contnm varchar(30),mobile varchar(12),email varchar(50));");


System.out.println("Inbox for "+userid+" created successfully");
con.close();
}
catch(Exception e)
{
System.out.println(e);
}

}
}









