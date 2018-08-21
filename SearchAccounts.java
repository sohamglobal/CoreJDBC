import java.sql.*;
import java.io.*;

class SearchAccounts
{
public static void main(String args[])
{
InputStreamReader isr=new InputStreamReader(System.in);
BufferedReader br=new BufferedReader(isr);

int no;

Connection con;
PreparedStatement pst;
ResultSet rs;

try
{
Class.forName("com.mysql.cj.jdbc.Driver");

con=DriverManager.getConnection("jdbc:mysql://localhost:3306/visadb0645?user=root&password=crosspolo&useSSL=false");

pst=con.prepareStatement("select accnm,balance from accounts where accno=?;");

do
{
System.out.print("Enter account number ");
no=Integer.parseInt(br.readLine());

if(no>0)
{
pst.setInt(1,no);
rs=pst.executeQuery();
if(rs.next())
{
System.out.print(rs.getString("accnm")+"\t");
System.out.println(rs.getString("balance"));
}
else
System.out.println("account does not exist");
}

}
while(no>0);

con.close();
}
catch(Exception e)
{
System.out.println(e);
}

}
}
