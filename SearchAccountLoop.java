import java.sql.*;
import java.io.*;

class SearchAccountLoop
{
public static void main(String args[])
{
Connection con;
PreparedStatement pst;
ResultSet rs;

InputStreamReader isr=new InputStreamReader(System.in);
BufferedReader br=new BufferedReader(isr);
int no;
try
{
Class.forName("com.mysql.cj.jdbc.Driver");

con=DriverManager.getConnection("jdbc:mysql://localhost:3306/NYSEDB?user=root&password=volkswagen&useSSL=false");

pst=con.prepareStatement("select * from accounts where accno=?;");

do
{
System.out.print("Enter account number ");
no=Integer.parseInt(br.readLine());
if(no!=0)
{
pst.setInt(1,no);
rs=pst.executeQuery();

if(rs.next())
{
System.out.print(rs.getString(2));
System.out.println("\t"+rs.getString(4));
}
else
System.out.println("account does not exist");
}

}
while(no!=0);

con.close();
}
catch(Exception e)
{
System.out.println(e);
}


}
}

















