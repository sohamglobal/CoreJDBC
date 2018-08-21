import java.io.*;
import java.sql.*;

class OpenNewAccountCS
{
public static void main(String args[])
{
InputStreamReader isr=new InputStreamReader(System.in);
BufferedReader br=new BufferedReader(isr);

int no;
String nm,typ;
double bal;

Connection con;
CallableStatement cst;

try
{
System.out.print("Enter account number ");
no=Integer.parseInt(br.readLine());
System.out.print("Enter name ");
nm=br.readLine();
System.out.print("Enter account type ");
typ=br.readLine();
System.out.print("Enter balance ");
bal=Double.parseDouble(br.readLine());

Class.forName("com.mysql.cj.jdbc.Driver");

con=DriverManager.getConnection("jdbc:mysql://localhost:3306/analyticsdb?user=root&password=volkswagen&useSSL=false");

cst=con.prepareCall("{call openaccount(?,?,?,?)}");
cst.setInt(1,no);
cst.setString(2,nm);
cst.setString(3,typ);
cst.setDouble(4,bal);
cst.execute();

System.out.println("Account opened successfully by CST");
con.close();

}
catch(Exception e)
{
System.out.println(e);
}

}
}
