package com.jdbc.byGaurav;

import java.sql.*;
import java.util.*;
import static java.lang.System.out;

public class DatabaseTrial 
{
	Scanner sc = new Scanner(System.in);
	public static void main(String...ar2gs)throws Exception 
	{
		DatabaseTrial dt = new DatabaseTrial();
		GetOracleConnection goc = new GetOracleConnection();
		String url = goc.getUrl();
		String user = goc.getUser();
		String pass = goc.getPass();
		try(Connection con = DriverManager.getConnection(url,user,pass))
		{
			Scanner sc1 = new Scanner(System.in);
			out.println("Enter 1 For Creating a new account.\n2 For Signing into an already existing account.");
			int choice = sc1.nextInt();
			switch(choice)
			{
				case 1: 
					dt.logIn(con);
					break;
				case 2:
					dt.signIn(con);
					break;
				default:
					out.println("Enter proper number please.");
					main();
			}
		}
		catch(InputMismatchException ime)
		{
			out.println("Enter proper number : ");
			main();			
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
	
	public void logIn(Connection con) throws Exception
	{
		boolean loop = true;
		while(loop)
		{
			out.println("Enter name for your account : ");
			String id = sc.next();
			String sqlQuery = String.format("select * from login where id = '%s'",id);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sqlQuery);
			int count = 0;
			while(rs.next())
			{
				count++;
			}
			if(count==0)
			{
				out.println("Enter password for your account : ");
				String pass = sc.next();
				out.println("Enter your address : ");
				String address = sc.next();
				out.println("Enter your Phone no. ");
				long phone_no = sc.nextLong();
				out.println("Enter your Gender : ");
				String gender = sc.next();
				sqlQuery = String.format("insert into login values('%s' , '%s' , %d , '%s' ,'%s')",id,pass,phone_no,address,gender);
				st.executeUpdate(sqlQuery);
				out.println("Data added successfully!");
				loop = false;
			}
			else
			{
				out.println("Username already in use. \nPlease enter another Username : ");
			}
		}
	}
	
	public void signIn(Connection con) throws Exception
	{
		int pass_time = 0;
		String pass = null;
		out.println("Enter ID of the account : ");
		String id = sc.next();
		String sqlQuery = String.format("select * from login where id = '%s'",id);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sqlQuery);
		if(rs.next())
		{
			pass = rs.getString(2);
			boolean flag = true;
			while(flag && pass_time<5)
			{
				out.println("Enter password of the account : ");
				if(pass.contentEquals(sc.next()))
				{
					out.println("Login Successful : ");
					getData(con,id);
					flag = false;
				}
				else
				{
					pass_time++;
					out.println("Incorrect Password.\nDO you want to retry? (Yes/No).");
					String choice = sc.next();
					if(choice.equalsIgnoreCase("No"))
					{
						flag = false;
					}
				}
			}
		}
		else
		{
			out.println("Incorrect ID.\nDO you want to continue? (Yes/No).");
			String choice = sc.next();
			if(choice.equalsIgnoreCase("No"))
			{
				System.exit(0);
			}
			else
			{
				signIn(con);
			}
		}
	}
	
	public void getData(Connection con , String id) throws Exception
	{
		boolean loop = true;
		while(loop)
		{
			String sqlQuery = String.format("select * from login where id = '%s'",id);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sqlQuery);
			int count = 0;
			while(rs.next())
			{
				count++;
			}
			if(count==1)
			{
				try
				{
					String query = String.format("select * from login where id = '%s'",id);
					ResultSet jrs = st.executeQuery(query);
					if(jrs.next())
					{
						out.println("\n---------------------------------------------------\n");
						out.println("ACCOUNT NO : " + jrs.getRow() + "\nID: " + jrs.getString(1) + "\nPASSWORD : " + jrs.getString(2) + "\nPHONE NO : " + jrs.getLong(3) + "\nADDRESS : " + jrs.getString(4) + "\nGENDER : " + jrs.getString(5));
						out.println("\n---------------------------------------------------\n");
						loop = false;
					}
					else 
					{
						out.println("Some error occured during retrieving data.\nPlease try again.");
						getData(con,id);
					}
				}
				catch(Exception e)
				{
					out.println(e);
				}
			}
			else
			{
				out.println("Incorrect ID.\nPlease try again.");
				getData(con,id);
			}
		}
	}
}
