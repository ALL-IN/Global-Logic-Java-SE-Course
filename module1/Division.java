package module1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Division {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int a = inputData();
		int b = inputData();
		division(a,b);
		
		
	}
	
	public static int inputData() throws NumberFormatException, IOException
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(bf.readLine());
		return a;
	}
	
	public static void division(int a, int b)
	{
		int z = a;
		String s = "  ";
		while (z / 10 != 0)
		{
			s+=" ";
			z /= 10;
		}
		System.out.println("  " + a + "|" + b);
		System.out.println("¯" + s + "¯¯¯¯¯¯¯¯¯¯");
		
		ArrayList<Integer> array = new ArrayList<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		int x = a;
		int y = 1;
		
//		while (b / 10 != 0)
//		{
//			y *= 10;
//			b /= 10;
//		}
		do 
		{
			array.add(0, x%10);
			x /= 10;
			if (x / 10 == 0 & x % 10 != 0)
				array.add(0, x%10);
		} while (x / 10 != 0);
		int c, d, e;
		if(x >= b)
		{
			
			
			c = array.get(0) / b;
			d = c * b;
			result.add(c);
			e = array.get(0) - d;
			System.out.println("  " + d);
			System.out.println("  ¯¯¯");
			for (int i = 1; i < array.size(); i++)
				if(e == 0)
				{
					System.out.println("  " + array.get(i));
					c = array.get(i) / b;
					result.add(c);
					d = c * b;
					System.out.println("-");
					System.out.println("   " + d);
					System.out.println("  ¯¯¯");
					e = array.get(i) - d;
					
				}
				else
				{
					System.out.println("  " + e + array.get(i));
					c = (e * 10 + array.get(i)) / b;
					result.add(c);
					d = c * b;
					System.out.println("-");
					System.out.println("   " + d);
					System.out.println("  ¯¯¯");
					e = (e * 10 + array.get(i)) -  d;
				}
			
			System.out.println("   " + e);
		}
		
		else
		{
			int i = 0;
			c = array.get(0);
			while (c < b)
			{
				i++;
				if( i > array.size()-1)
					System.out.println("ne delitsa na celo");
				c = c * 10 + array.get(i);
			}
			
			result.add(c / b);
			d = c / b * b;
//			System.out.println("-");
			System.out.println("  " + d);
			System.out.println("  ¯¯¯");
			e = c -  d;
			
			for (int f = i+1; f < array.size(); f++)
				if(e == 0)
				{
					System.out.println("  " + array.get(f));
					c = array.get(f) / b;
					result.add(c);
					d = c * b;
					System.out.println("-");
					System.out.println("  " + d);
					System.out.println("  ¯¯¯");
					e = array.get(f) - d;
					
				}
				else
				{
					System.out.println("  " + e + array.get(f));
					c = (e * 10 + array.get(f)) / b;
					result.add(c);
					d = c * b;
					System.out.println("-");
					System.out.println("  " + d);
					System.out.println("  ¯¯¯");
					e = (e * 10 + array.get(f)) -  d;
				}
			
			System.out.println("   " + e);
		}
		
		
		
		
		
		
		System.out.println(array);
		System.out.println(s.length());
		System.out.println("y= " + y);
	}
	
	

}
