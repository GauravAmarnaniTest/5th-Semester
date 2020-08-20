//Using Function to get the average of Salary of two Employees whose ID is provided by user.
//Author : Gaurav Amarnani.

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.Types;
import static java.lang.System.out;
import java.util.Scanner;

/* The following is the code for corresponding Function : 
	CREATE OR REPLACE FUNCTION GETAVG(ID1 IN NUMBER , ID2 IN NUMBER)RETURN NUMBER AS 
	SALARY1 NUMBER;
	SALARY2 NUMBER;
	BEGIN 
	SELECT SALARY INTO SALARY1 FROM EMPLOYEE WHERE ID = ID1;
	SELECT SALARY INTO SALARY2 FROM EMPLOYEE WHERE ID = ID2;
	RETURN (SALARY1+SALARY2)/2;
	END;
	/ 
*/

public class FunctionDemo 
{
	public static void main(String...args)
	{
		Scanner sc = new Scanner(System.in);
		out.println("Enter the ID of Employee 1 : ");
		int id1 = sc.nextInt();
		out.println("Enter the ID of Employee 2 : ");
		int id2 = sc.nextInt();
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "system";
		String pass = "1234";
		String className = "oracle.jdbc.OracleDriver";
		try(Connection con = DriverManager.getConnection(url,user,pass))
		{
			Class.forName(className);
			CallableStatement cst = con.prepareCall("{?= call getAvg(?,?)}");
			cst.setInt(2,id1);
			cst.setInt(3,id2);
			cst.registerOutParameter(1, Types.FLOAT);
			cst.execute();
			out.println("The Average Salary of the two Employees is : \n" + cst.getFloat(1));
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}
