/*
delimiter //
create procedure transferamt(sourceacc int,destacc int,amount float)
begin
declare cnt int;
select count(accnm) into cnt from accounts
where accno=sourceacc;
if cnt>0 then
    update accounts set balance=balance-amount
    where accno=sourceacc;
    update accounts set balance=balance+amount
    where accno=destacc;
end if;
end//
delimiter ;
*/

import java.sql.*;
import java.io.*;

class PayBillsCS
{
public static void main(String args[])
{
Connection con;
CallableStatement cst;
InputStreamReader isr=new InputStreamReader(System.in);
BufferedReader br=new BufferedReader(isr);
int sno,dno;
double amt;

try
{
Class.forName("com.mysql.cj.jdbc.Driver");

con=DriverManager.getConnection("jdbc:mysql://localhost:3306/analyticsdb?user=root&password=volkswagen&useSSL=false");

System.out.print("enter source account number ");
sno=Integer.parseInt(br.readLine());
System.out.print("enter account number to transfer ");
dno=Integer.parseInt(br.readLine());
System.out.print("enter amount to be transferred ");
amt=Double.parseDouble(br.readLine());

cst=con.prepareCall("{call transferamt(?,?,?)}");
cst.setInt(1,sno);
cst.setInt(2,dno);
cst.setDouble(3,amt);

cst.execute();
System.out.println("Amount transferred successfully");
con.close();
}
catch(Exception e)
{
System.out.println(e);
}

}
}