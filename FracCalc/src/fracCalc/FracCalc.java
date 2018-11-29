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
        int[] answer = new int[3];
        if (fracOneArray[0] != 0) {
        	fracOneArray = toImproperFrac(fracOneArray);
        }
        if (fracTwoArray[0] != 0) {
        	fracTwoArray = toImproperFrac(fracTwoArray);
        }
        if (operator.equals("+") || operator.equals("-")) {
        	answer = addSub(fracOneArray, fracTwoArray, operator);
        }
        else if (operator.equals("/") || operator.equals("*")) {
        	answer = multDiv(fracOneArray, fracTwoArray, inputArray[1]);
        }
       answer = reduce(answer);
       return toMixedNum(answer[0], answer[1]);
        //return Arrays.toString(answer);
        
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
    public static int[] multDiv(int[] frac1, int[] frac2, String operator){
    	int denom2 = frac2[1];
    	if (operator.equals("/")) {
    		frac2[1] = frac2[2];
    		frac2[2] = denom2;
    		
    	}
    	int numerator = frac1[1] * frac2[1];
    	int denominator = frac1[2] *frac2[2];
    	int[] product = {numerator, denominator};
    	return product;
    }
    public static int[] toImproperFrac(int[] fraction) {
    	if (fraction[0] < 0) {
    		fraction[1] = (fraction[0]*fraction[2])-fraction[1];
    	}
    	else {
    	fraction[1] = (fraction[0]*fraction[2])+fraction[1];
    	}
    	fraction [0] = 0;
    	return fraction;
    	
    }
    public static String toMixedNum(int numerator, int denominator) {
		if (numerator % denominator == 0) {
			return numerator / denominator + "";
		} else {
			return (numerator / denominator) + "_" + Math.abs(numerator % denominator) + "/" + Math.abs(denominator);
		}
	}
    public static int[] reduce(int[] frac) {
    	int gcf = 1;
		for(int cf = 1; cf <= Math.abs(Math.min(frac[0], frac[1])); cf++) {
			if (frac[0]%cf == 0 && frac[1]%cf == 0) {
				gcf = cf;
			}				
		}
		frac[0] = frac[0]/gcf;
		frac[1] = frac[1]/gcf;
		return frac;
    }
}
