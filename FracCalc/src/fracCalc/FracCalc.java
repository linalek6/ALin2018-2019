package fracCalc;
import java.util.*;
/* This class
 * @author Alexis Lin
 * @version November 19, 2018
 */
public class FracCalc {

    public static void main(String[] args) {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	
    	Scanner scanner = new Scanner(System.in);
    	String nextStep;
    	do {
    	String problem = scanner.nextLine();
   
    	//String problem = "1/2 + 1/4"; //delete this later and replace with scanner
    	System.out.println(produceAnswer(problem));
    	nextStep = scanner.next();
    	}
    	while(!(nextStep.equals("quit")));
    	scanner.close();
    	
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    { 
        // TODO: Implement this function to produce the solution to the input
    	String[] inputArray = input.split(" ");
    	String fracOne = inputArray[0];
    	String operator = inputArray[1];
    	String fracTwo = inputArray[2]; 	
        int[] fracTwoArray =makeIntFrac(fracTwo);
        int[] fracOneArray = makeIntFrac(fracOne);
        if (fracOneArray[0] != 0) {
        	fracOneArray = toImproperFrac(fracOneArray);
        }
        if (fracTwoArray[0] != 0) {
        	fracTwoArray = toImproperFrac(fracTwoArray);
        }
        int[] arr = addSub(fracOneArray, fracTwoArray, inputArray[1]);
        return Arrays.toString(arr);
        
        
        //return "";
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    public static int[] makeIntFrac(String fraction) {
    	int whole = 0;
    	int numerator = 0;
    	int denominator = 1;
    	String[] wholeSplit = fraction.split("_");
    	String[] fractionSplit = new String[2];
    	if (fraction.contains("/")) {
    		if (wholeSplit.length == 2) {
    			fractionSplit = wholeSplit[1].split("/");
    		}
    		else {
    			fractionSplit = wholeSplit[0].split("/");
    		}
    	}
    	if (fraction.contains("_")) {
    		whole = Integer.parseInt(wholeSplit[0]);
    		numerator = Integer.parseInt(fractionSplit[0]);
    		denominator = Integer.parseInt(fractionSplit[1]);
    	}
    	else if (fraction.contains("/")) {
    		numerator = Integer.parseInt(fractionSplit[0]);
        	denominator = Integer.parseInt(fractionSplit[1]);
    	}
    	else {
    		whole = Integer.parseInt(wholeSplit[0]);
    	}
    	int[] arr = {whole, numerator, denominator};
    	return arr;
    }
    public static int[] addSub(int[] frac1, int[] frac2, String operator) {
    	int denominator = frac1[2]*frac2[2];
    	int numer1 = frac1[1]*frac2[2];
    	int numer2 = frac2[1]*frac1[2];
    	int numSum = 0;
    	if (operator.equals("+")) {
    		numSum = numer1 + numer2;
    	}
    	else {
    		numSum = numer1 - numer2;
    	}
    	int[] sum= {numSum, denominator};
    	return sum; 
    }
    public static int[] toImproperFrac(int[] fraction) {
    	fraction[1] = (fraction[0]*fraction[2])+fraction[1];
    	fraction [0] = 0;
    	return fraction;
    	
    }
}
