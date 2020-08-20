//Using CURSOR with Stored Procedure to get all Employee info.
package com.jdbc.byGaurav;

import java.sql.DriverManager;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;

import oracle.jdbc.OracleTypes;

/* The following is the code for the corresponding procedure :
  
  
  CREATE OR REPLACE PROCEDURE GETALLEMPINFO(EMPS OUT SYS_REFCURSOR)AS
  BEGIN
  OPEN EMPS FOR SELECT * FROM EMPLOYEE;
  END;
  /
  COMMIT;  
    
*/

public class ProcedureUsingCursorDemo1 
{
	public static void main(String...args)
	{
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "system";
		String pass = "1234";
		String className = "oracle.jdbc.OracleDriver";
		try(Connection con = DriverManager.getConnection(url,user,pass))
		{
			Boolean flag = false;
			Class.forName(className);
			CallableStatement cst = con.prepareCall("{call getallempinfo(?)}");
			cst.registerOutParameter(1 , OracleTypes.CURSOR);
			cst.execute();
			ResultSet rs = (ResultSet)cst.getObject(1);
			out.println("ID\tNAME\tSALARY\tADDRESS");
			while(rs.next())
			{
				flag = true;
				out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getString(4));
			}
			if(flag==false)
			{
				out.println("No records available.");
			}
			else 
			{
				out.println("All records displayed successfully.");
			}
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}
