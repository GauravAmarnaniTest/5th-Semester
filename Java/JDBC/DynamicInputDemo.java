//Author : Gaurav Amarnani.

import static java.lang.System.out;
import java.util.Scanner;

public class DynamicInputDemo 
{
	public static void main(String...args)
	{
		Scanner sc = new Scanner(System.in);
		out.println("Enter any Byte value : ");
		Byte b = sc.nextByte();
		out.println("Enter any Short value : ");
		Short sh = sc.nextShort();
		out.println("Enter any Integer value : ");
		Integer i = sc.nextInt();
		out.println("Enter any Long value : ");
		Long l = sc.nextLong();
		out.println("Enter any Double value : ");
		Double d = sc.nextDouble();
		out.println("Enter any Float value : ");
		Float f = sc.nextFloat();
		out.println("Enter any String value : ");
		String str = sc.next();
		out.println("BYTE : " + b + "\nSHORT : " + sh + "\nINTEGER : " + i + "\nLONG : " + l + "\nDOUBLE : " + d + "\nFLOAT : " + f + "\nSTRING : " + str);
	}
}
