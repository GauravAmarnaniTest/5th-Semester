//Stored Procedure to Add two user provided numbers.
package com.jdbc.byGaurav;

import java.sql.DriverManager;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.util.Scanner;
import java.sql.Types;

/* The following is the code for the corresponding procedure :
  
  
  CREATE OR REPLACE PROCEDURE ADD_PROCEDURE(X IN NUMBER , Y IN NUMBER , Z OUT NUMBER)AS
  BEGIN 
  Z := X + Y; 
  END;
  / 
  commit;  
    
 */

public class ProcedureDemo1 
{
	public static void main(String...args)
	{
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "system";
		String pass = "1234";
		String className = "oracle.jdbc.OracleDriver";
		Scanner sc = new Scanner(System.in);
		out.println("Enter no. one : ");
		int no1 = sc.nextInt();
		out.println("Enter no. two : ");
		int no2 = sc.nextInt();
		try(Connection con = DriverManager.getConnection(url,user,pass))
		{
			Class.forName(className);
			CallableStatement cst = con.prepareCall("{call add_procedure(?,?,?)}");
			cst.setInt(1 , no1);
			cst.setInt(2 , no2);
			cst.registerOutParameter(3,java.sql.Types.INTEGER);
			cst.execute();
			int result = cst.getInt(3);
			out.println("Result : " + result);			
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}
