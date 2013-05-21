package ua.kpi_java_training.alekseenko.module1;

import java.io.*;
import java.util.ArrayList;

public class Palindrome {

	/**
	 * Ќаписать программу, котора€ находит все подстроки (длиной больше 2) данной строки, €вл€ющиес€ палиндромами. 
	 * ѕалиндромом считают строку, котора€ симметрична относительно ее середины. 
	 * ѕрограмма должна принимать строку из консоли и выводить соответствующие подстроки на экран.
	 */
	public static void main(String[] args) throws IOException{
		String s = input();
		output(findAllPalindromes(s));
	}
	
	private static String input() throws IOException{
		BufferedReader b = new BufferedReader( new InputStreamReader(System.in));
		String s = b.readLine();
		return s;
	}
	
	private static ArrayList<String> findAllPalindromes(String s){
		char [] string = s.toCharArray();
		ArrayList <String> allPalindromes = new ArrayList <String>();
		for (int i = 1; i < string.length-2; i++){
			ArrayList <String> palindromesForEachI = new ArrayList <String>();
			
			
			palindromesForEachI.addAll(findPalindromes(string, i, i+1));
			palindromesForEachI.addAll(findPalindromes(string, i, i+2));
			if(palindromesForEachI.size() > 0){
				palindromesForEachI.remove(0);
				allPalindromes.addAll(palindromesForEachI);
			}
		}
		return allPalindromes;
	}
	
	private static  ArrayList<String> findPalindromes (char [] string, int n, int k){
		ArrayList <String> palindromesForEachI = new ArrayList <String>();
		String palindrome = "";	
		if ((k - n) == 2){
			palindrome += string[k-1];
		}
				
		while (string[n] == string[k]){
			palindrome = string[n] + palindrome + string[k];
			palindromesForEachI.add(palindrome);
			n--;
			k++;
			if(n < 0 || k >= string.length){
				break;
			}
		}
		return palindromesForEachI;
	}
	
	private static void output(ArrayList<String> allPalindromes){
		for (String e : allPalindromes){
			System.out.println(e);
		}
	}
}
