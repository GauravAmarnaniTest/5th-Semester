package com.jdbc.byGaurav;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ParameterMetaData;
import static java.lang.System.out;

public class ParameterMetaDataDemo 
{
	public static void main(String...args)throws Exception 
	{
		GetOracleConnection goc = new GetOracleConnection();
		String url = goc.getUrl();
		String user = goc.getUser();
		String pass = goc.getPass();
		try(Connection con = DriverManager.getConnection(url, user, pass))
		{
			PreparedStatement pst = con.prepareStatement("insert into employee values(?,?,?,?)");
			ParameterMetaData pmd = pst.getParameterMetaData();
			int count = pmd.getParameterCount();
			for(int i = 1; i<=count ; i++)
			{
				out.println("Parameter : " + i);
				out.println("Mode : " + pmd.getParameterMode(i));
				out.println("Type : " + pmd.getParameterType(i));
				out.println("Type Name : " + pmd.getParameterTypeName(i));
				out.println("Precision : " + pmd.getPrecision(i));
				out.println("Scale : " + pmd.getScale(i));
				out.println("Null : " + pmd.isNullable(i));
				out.println("Signed : " + pmd.isSigned(i));
				out.println("-------------------------------");
			}
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}
