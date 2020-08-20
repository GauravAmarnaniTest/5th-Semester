package com.jdbc.byGaurav;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;
import static java.lang.System.out;

public class TransactionDemo 
{
	public static void main(String...args) throws Exception
	{
		GetOracleConnection goc = new GetOracleConnection();
		String url = goc.getUrl();
		String user = goc.getUser();
		String pass = goc.getPass();
		String sqlQuery = null;
		int amount;
		Connection con = null;
		try
		{
			con = DriverManager.getConnection(url,user,pass);
			con.setAutoCommit(false);
			Scanner sc = new Scanner(System.in);
			Statement st = con.createStatement();
			out.println("Before Transaction : ");
			out.println("NAME:\tBALANCE:");
			out.println("--------------------");
			ResultSet rs = st.executeQuery("select * from accounts");
			while(rs.next())
			{
				out.println(rs.getString(1) + "\t" + rs.getInt(2));
			}
			out.println("Enter the Account Name of the sender : ");
			String sname = sc.next();
			out.println("Enter the Account Name of the reciever : ");
			String rname = sc.next();
			out.println("Enter the amount of money you want to withdraw : ");
			amount = sc.nextInt();
			if(sname==null)
			{
				out.println("Provide proper Account Name for sender please : ");
				main();
			}
			else if(rname==null)
			{
				out.println("Provide proper Account Name for reciever please : ");
				main();
			}
			else 
			{
				sqlQuery = String.format("select * from accounts where name = '%s'",sname);
				int scount = st.executeUpdate(sqlQuery);
				ResultSet rs1 = st.executeQuery(sqlQuery);
				if(scount==0)
				{
					out.println("No Senders Account found with name : " + sname);
					main();
				}
				else
				{
					if(rs1.next())
					{
						int balance = rs1.getInt(2);
						if(balance<amount)
						{
							balance = balance - amount;
							sqlQuery = String.format("update accounts set balance = %d where name = '%s'",balance,sname);
							st.executeUpdate(sqlQuery);
						}
						else
						{
							out.println("Insufficient balance.");
							main();
						}
					}
				}
				sqlQuery = String.format("select * from accounts where name = '%s'",rname);
				int rcount = st.executeUpdate(sqlQuery);
				ResultSet rs2 = st.executeQuery(sqlQuery);
				if(rcount==0)
				{
					out.println("No Recievers Account found with name : " + rname);
					main();
				}
				else
				{
					if(rs2.next())
					{
						int credit = rs2.getInt(2);
						credit = credit + amount;
						sqlQuery = String.format("update accounts set balance = %d where name = '%s'",credit,rname);
						if(st.executeUpdate(sqlQuery)!=0)
						{
							con.commit();
							out.println("Transfer Successful");
						}
						else
						{
							out.println("Transfer Unsuccessful");
						}
					}
				}
			}
			out.println("After Transaction : ");
			out.println("NAME:\tBALANCE:");
			out.println("--------------------");
			ResultSet rs4 = st.executeQuery("select * from accounts");
			while(rs4.next())
			{
				out.println(rs4.getString(1) + "\t" + rs4.getInt(2));
			}
			sc.close();
		}
		catch(InputMismatchException ime)
		{
			out.println("Enter proper amount : ");
			con.rollback();
			main();
		}
		catch(Exception e)
		{
			out.println(e);
			con.rollback();
		}
	}
}
