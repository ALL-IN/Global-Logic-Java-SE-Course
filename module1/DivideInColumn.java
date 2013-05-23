package ua.kpi_java_training5.alekseenko.module1;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DivideInColumn {

	/**
     *
     * The class divide two integer number in column
     *
     * @autor Aleksey Alekssenko
     * @version 1.10
     * @since 2013-05-14
     *
	 */
	public static void main(String[] args) throws NumberFormatException, IOException{
		int dividend = input("dividend");
		int divisor = input("divisor");
		output(division(dividend, divisor));
	}

    /**
     * Inputs a variable
     *
     * @param nameOfVariable   name of variable which we input
     * @return number which was inputted
     * @throws NumberFormatException
     * @throws IOException
     */
	public static int input(String nameOfVariable) throws NumberFormatException, IOException{
		System.out.println(String.format("Please, input %s", nameOfVariable));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(bf.readLine());
		return number;
	}

    /**
     * Divides two integer number and adds all intermediate result to list
     *
     * @param dividend
     * @param divisor
     * @return list with all intermediate results
     * @throws NumberFormatException
     * @throws IOException
     */
	public static ArrayList<String> division(int dividend, int divisor) throws NumberFormatException, IOException{
		ArrayList<String> pseudographics = new ArrayList<String>();
		try{
		ArrayList<Integer> digitsInDividend = new ArrayList<Integer>();
		ArrayList<Integer> resultByDigits = new ArrayList<Integer>();
		boolean negativeSign = isNegativeSign(dividend, divisor);
		String indent = "  ";
		isDividendLessZero(dividend, divisor, pseudographics);
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		digitsInDividend = splitIntoDigits(dividend);
		int firstDivident = digitsInDividend.get(0);
		int i = 1;
		int reminder;
		while(firstDivident < divisor){
			if(i >= digitsInDividend.size()){
				break;
			}
			firstDivident = firstDivident * 10 + digitsInDividend.get(i);
			i++;
		}
		reminder = extractReminder(firstDivident, divisor, resultByDigits, pseudographics);
		while(i < digitsInDividend.size()){
			if(reminder == 0){
				reminder = extractReminder(digitsInDividend.get(i), divisor, resultByDigits, pseudographics);
				i++;
			} else {
				reminder = extractReminder((reminder * 10 + digitsInDividend.get(i)), divisor, resultByDigits, pseudographics);
				i++;
			}
		}
		pseudographics.add(indent + reminder);
		pseudographics = combineAllResults(pseudographics, resultByDigits, negativeSign, howMuchDigits(divisor));
		} catch (ArithmeticException ie) {
				System.out.println("You mustn't diveded by zero");
				System.out.println("Please, re-enter dividend and divisor");
				dividend = input("dividend");
				divisor = input("divisor");
				division(dividend,divisor);
			}
		return pseudographics;
	}

    /**
     * Finds sign of division of 2 number
     *
     * @param dividend
     * @param divisor
     * @return true if result of division "-", false if "+"
     */
	public static boolean isNegativeSign(int dividend, int divisor) {
		
		return ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0));
	}

    /**
     * Finds sign of 2 number and adds to list
     *
     * @param dividend
     * @param divisor
     * @param pseudographics list with intermediate result
     */
	public static void isDividendLessZero(int dividend, int divisor, ArrayList<String> pseudographics) {
		if (dividend < 0) {
			pseudographics.add(" " + dividend + "|" + divisor);
			pseudographics.add(" -" + signPerDigits(howMuchDigits(dividend), " "));
		} else {
			pseudographics.add("  " + dividend + "|" + divisor);
			pseudographics.add(" -" + signPerDigits(howMuchDigits(dividend), " "));
		}
	}

    /**
     * Finds amount of digits in number
     *
     * @param number
     * @return amount of digits in number
     */
	public static int howMuchDigits(int number) {
		int count = 1;
		while (number / 10 != 0) {
			count++;
			number /= 10;
		}
		return count;
	}

    /**
     * Writes number in list by digits
     *
     * @param number
     * @return list of number digits
     */
	public static ArrayList<Integer> splitIntoDigits(int number) {
		ArrayList <Integer> digitsInNumber = new ArrayList <Integer>();
		do {
		    digitsInNumber.add(0, number % 10);
			number /= 10;
			if (number / 10 == 0 & number % 10 != 0)
				digitsInNumber.add(0, number % 10);
		} while (number / 10 != 0);
		
		return digitsInNumber;
	}

    /**
     * Returns reminder from difference of number and multiply from max integer from number divides of divisor
     * Adds result to list
     * @param number
     * @param divisor
     * @param resultByDigits  integer result from divide
     * @param pseudographics  list of all results
     * @return difference
     */
	private static int extractReminder(int number, int divisor, ArrayList<Integer> resultByDigits, ArrayList<String> pseudographics) {
		int integerDivision;
		int reminder;
		int subtrahend;
		integerDivision = number / divisor;
		resultByDigits.add(integerDivision);
		subtrahend =  integerDivision * divisor;
		pseudographics.add("  " + subtrahend);
		reminder = number - subtrahend;
		pseudographics.add("  " + signPerDigits(howMuchDigits(subtrahend), "¯"));
		return reminder;
	}

    /**
     * Creates string with set sign of length by amount of digits
     *
     * @param amountOfDigits
     * @param sign
     * @return string with set sign
     */
	private static String signPerDigits(int amountOfDigits, String sign){
		StringBuilder sb= new StringBuilder ("");
		int count = 0;
		while(count < amountOfDigits){
			sb.append(sign);
			count++;
		}
		return sb.toString();
	}

    /**
     * Combines results of divide
     *
     * @param pseudographics
     * @param resultByDigits
     * @param negativeSign
     * @param divisorHasDigits
     * @return list with all intermediate results
     */
	private static ArrayList<String> combineAllResults
    (ArrayList<String> pseudographics, ArrayList<Integer> resultByDigits, boolean negativeSign, int divisorHasDigits) {
		int res = resultByDigits.get(0);
		for(int i = 1; i < resultByDigits.size(); i++){
			res = res * 10 + resultByDigits.get(i);
		}
		if(negativeSign){
			res *= -1;
		}
		int count = 0;
		StringBuilder s = new StringBuilder("|");
		if(divisorHasDigits > resultByDigits.size()){
			while(count < divisorHasDigits){
				count++;
				s.append("-");
			}
		} else {
			while(count < resultByDigits.size()){
				count++;
				s.append("-");
			}
		}
		pseudographics.add(1, (pseudographics.get(1)) + s.toString());
		pseudographics.remove(2);
		pseudographics.add(2, (pseudographics.get(2)  + signPerDigits(divisorHasDigits, " ") + "|" + res));
		pseudographics.remove(3);
		return pseudographics;
	}

    /**
     * Outputs results from a list
     *
     * @param pseudographics  list with results
     */
	private static void output (ArrayList <String> pseudographics){
		for (String e : pseudographics){
			System.out.println(e);
		}
	}
}

