//Stored Procedure to find Employee Salary and Name by passing Employee ID.
package com.jdbc.byGaurav;

import java.sql.DriverManager;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.util.Scanner;
import java.sql.Types;

/* The following is the code for the corresponding procedure :
  
  
  CREATE OR REPLACE PROCEDURE GETEMPINFO(EID IN NUMBER , ENAME OUT VARCHAR , ESALARY OUT NUMBER)AS
  BEGIN
  SELECT SALARY,NAME INTO ESALARY,ENAME FROM EMPLOYEE WHERE ID = EID;
  END;
  /
  COMMIT;  
    
*/

public class ProcedureDemo3 
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
			CallableStatement cst = con.prepareCall("{call getempinfo(?,?,?)}");
			cst.setInt(1 , id);
			cst.registerOutParameter(2, Types.VARCHAR);
			cst.registerOutParameter(3, Types.INTEGER);
			cst.execute();
			String name = cst.getString(2);
			out.println("Name : " + name);
			int salary = cst.getInt(3);
			out.println("Salary : " + salary);			
		}
		catch(Exception e)
		{
			out.println(e);
			out.println("Please enter proper ID.");
		}
	}
}
