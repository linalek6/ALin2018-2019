import java.util.*;
public class Split {
/* This class contains a method that will the insides of a sandwich
* @author Alexis Lin
* @version November 13, 2018
 */
 

 public static void main(String[] args) {

// Your task Part 0

//String.split();

//It's a method that acts on a string, <StringName>.split(<sp>);

//Where sp is the string where the string splits

//And it returns an array
System.out.println(Arrays.toString("I like apples!".split(" ")));

// it will split at spaces and return an array of ["I","like","apples!"]

System.out.println(Arrays.toString("I really like really red apples!".split("really")));

// it will split at the word "really" and return an array of ["I "," like ","red apples!"]

//play around with String.split!

System.out.println(Arrays.toString("I reallyreally likeapplesreally".split("really")));
System.out.println(sandwich("breadapplesbpinebreadappleslettucetomatobaconmayohambreadcheesebreadbread"));
System.out.println(sandwich("applesbpinebreadappleslettucetomatobaconmayohambreadcheese"));
System.out.println(sandwich2("apples pineapples bread bread lettuce tomato bacon mayo ham bread bread cheese"));
 }

//Your task Part 1:
	public static String sandwich(String description) {
		description += " "; //makes sure that array includes an element for "breadbread"
		String[] sw = description.split("bread"); //creates array
		String sand = sw[1];
		for(int i = 2; i < sw.length-1; i++) {
			sand = sand + "bread" + sw[i];
		}
		String last = "";
		if (description.substring(description.length()-6, description.length()-1).equals("bread")) {
			last = sw[sw.length-1];
		}
		return sand + last;		
	}

/*Write a method that take in a string like

* "applespineapplesbreadlettucetomatobaconmayohambreadcheese"

* describing a sandwich.

* Use String.split to split up the sandwich by the word "bread" and return what's in the middle of

* the sandwich and ignores what's on the outside

* What if it's a fancy sandwich with multiple pieces of bread?

*/

//Your task pt 2:

/*Write a method that take in a string like

* "apples pineapples bread lettuce tomato bacon mayo ham bread cheese"

* describing a sandwich

* use String.split to split up the sandwich at the spaces, " ", and return what's in the middle of

* the sandwich and ignores what's on the outside.

* Again, what if it's a fancy sandwich with multiple pieces of bread?

*/
	public static String sandwich2(String description) {
		String[] descriptionArray = description.split(" ");	
		int firstBread = -2;
		int lastBread = -1;
		for(int i = 0; i-1 != firstBread; i++)
			if(descriptionArray[i].equals("bread")) {
				firstBread = i;
			}
		for(int i = descriptionArray.length-1; i+1 != lastBread; i--) {
			if(descriptionArray[i].equals("bread")) {
				lastBread = i;			
			}
		}
		return Arrays.toString(Arrays.copyOfRange(descriptionArray, firstBread+1,lastBread));

	}

 }




