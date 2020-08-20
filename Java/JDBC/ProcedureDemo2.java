//Stored Procedure to find Employee Salary by passing Employee ID.
package com.jdbc.byGaurav;

import java.sql.DriverManager;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.util.Scanner;
import java.sql.Types;

/* The following is the code for the corresponding procedure :
  
  
  CREATE OR REPLACE PROCEDURE GETSAL(EID IN NUMBER , ESALARY OUT NUMBER)AS
  BEGIN
  SELECT SALARY INTO ESALARY FROM EMPLOYEE WHERE ID = EID;
  END;
  /
  COMMIT;  
    
*/

public class ProcedureDemo2 
{
	public static void main(String...args)
	{
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "system";
		String pass = "1234";
		String className = "oracle.jdbc.OracleDriver";
		Scanner sc = new Scanner(System.in);
		out.println("Enter ID : ");
		int id = sc.nextInt();
		try(Connection con = DriverManager.getConnection(url,user,pass))
		{
			Class.forName(className);
			CallableStatement cst = con.prepareCall("{call getsal(?,?)}");
			cst.setInt(1 , id);
			cst.registerOutParameter(2,java.sql.Types.INTEGER);
			cst.execute();
			int result = cst.getInt(2);
			out.println("Result : " + result);			
		}
		catch(Exception e)
		{
			out.println(e);
			out.println("Please enter proper ID.");
		}
	}
}
