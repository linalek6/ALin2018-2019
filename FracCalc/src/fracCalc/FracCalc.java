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
        return "whole:" + fracTwoArray[0] + " numerator:" + fracTwoArray[1] + " denominator:" + fracTwoArray[2];
        
        
        //return "";
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    public static int[] makeIntFrac(String fraction) {
    	String[] fracSplit = fraction.split("/");
    	String[] wholeSplit = fraction.split("_");
    	int whole = 0;
    	int numerator = 0;
    	int denominator = 1;
    	if(fraction.contains("_")) { 		
    		whole = Integer.parseInt(wholeSplit[0]);
    		numerator = Integer.parseInt(fractionArray[1]);
        	denominator = Integer.parseInt(fractionArray[2]);
    	}
    	else if (fraction.contains("/")) {
    		numerator = Integer.parseInt(fractionArray[0]);
        	denominator = Integer.parseInt(fractionArray[1]);
    	}
    	else {
    		whole = Integer.parseInt(fractionArray[0]);
    	}
    	int[] arr = {whole, numerator, denominator};
    	return arr;
    }
}
