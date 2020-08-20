//Using Function to delete all the employees with a particular Salary range provided by user and
//display the number of Employee data deleted using SQL%ROWCOUNT.

//Author : Gaurav Amarnani.

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.Types;
import java.sql.ResultSet;
import java.util.Scanner;
import oracle.jdbc.*;
import static java.lang.System.out;

/* The following is the code for corresponding Function : 
	CREATE OR REPLACE FUNCTION GETDELETEDEMPLOYEEINFO(LIMIT IN NUMBER , COUNT OUT NUMBER)RETURN SYS_REFCURSOR AS 
	EMPS SYS_REFCURSOR;
	BEGIN 
	OPEN EMPS FOR SELECT * FROM EMPLOYEE WHERE SALARY > LIMIT;
	DELETE FROM EMPLOYEE WHERE SALARY > LIMIT;
	COUNT := SQL%ROWCOUNT;
	RETURN EMPS;
	END;
	/ 
*/

public class FunctionUsingCursorDemo
{
	public static void main(String...args)
	{
		Scanner sc = new Scanner(System.in);
		out.println("Enter the Salary Limit : ");
		int limit = sc.nextInt();
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "system";
		String pass = "1234";
		String className = "oracle.jdbc.OracleDriver";
		try(Connection con = DriverManager.getConnection(url,user,pass))
		{
			Class.forName(className);
			CallableStatement cst = con.prepareCall("{?= call getDeletedEmployeeInfo(?,?)}");
			cst.setInt(2,limit);
			cst.registerOutParameter(1, OracleTypes.CURSOR);
			cst.registerOutParameter(3, Types.INTEGER);
			cst.execute();
			int count = cst.getInt(3);
			out.println("Total number of Employee whose data got deleted : " + count);
			out.println("Their details are described as follows : ");
			out.println("ID\tNAME\tSALARY\tADDRESS");
			ResultSet rs = (ResultSet)cst.getObject(1);
			while(rs.next())
			{
				out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getString(4));
			}
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}
