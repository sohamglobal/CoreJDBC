import java.io.*;
import java.sql.*;

class OpenNewAccountPS
{
public static void main(String args[])
{
InputStreamReader isr=new InputStreamReader(System.in);
BufferedReader br=new BufferedReader(isr);

int no;
String nm,typ;
double bal;

Connection con;
PreparedStatement pst;

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

con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sharayudb?user=root&password=volkswagen&useSSL=false");

//initialization
pst=con.prepareStatement("insert into accounts values(?,?,?,?);");

//parameter substitution
pst.setInt(1,no);
pst.setString(2,nm);
pst.setString(3,typ);
pst.setDouble(4,bal);

//query execution
pst.executeUpdate();

System.out.println("Account opened successfully");
con.close();
}
catch(Exception e)
{
System.out.println(e);
}
}
}








