import java.io.*;
import java.sql.*;

class InboxCreation
{
public static void main(String args[])
{
InputStreamReader isr=new InputStreamReader(System.in);
BufferedReader br=new BufferedReader(isr);

String uid;

Connection con;
Statement st;

try
{
System.out.print("Enter userid ");
uid=br.readLine();

Class.forName("com.mysql.cj.jdbc.Driver");

con=DriverManager.getConnection("jdbc:mysql://localhost:3306/analyticsdb?user=root&password=volkswagen&useSSL=false");

st=con.createStatement();

st.execute("create table "+uid+"inbox (msgno int primary key auto_increment,msgfrm varchar(30),msgdttm datetime,subject varchar(100),msgtext varchar(1000),status varchar(15) default 'unread');");

st.execute("create table "+uid+"contacts (contid int primary key,contnm varchar(30),conttype varchar(15) default 'official',mobile varchar(10),emailid varchar(50));");

System.out.println("Inbox for "+uid+" created successfully");
con.close();
}
catch(Exception e)
{
System.out.println(e.getMessage());
}

}
}







