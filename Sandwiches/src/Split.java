import java.util.*;
public class Split {
	public static void main (String[] args) {
		// Your task Part 0

		//String.split();

		//It's a method that acts on a string, <StringName>.split(<String sp>);

		//Where sp is the string where the string splits

		//And it returns an array

		System.out.println(Arrays.toString("I like apples!".split(" ")));

		// it will split at spaces and return an array of ["I","like","apples!"]

		System.out.println(Arrays.toString("I really like really red apples".split("really")));

		// it will split at the word "really" and return an array of ["I "," like ","red apples!"]

		//play around with String.split!

		System.out.println(Arrays.toString("I reallyreally likeapples".split("really")));
		sandwich("breadapplespineappleslettusbreadtomatobaconmayohamcheesebread");
		//Your task Part 1:

		/*Write a method that take in a string like

		* "applespineapplesbreadlettustomatobaconmayohambreadcheese"

		* describing a sandwich.

		* Use String.split to split up the sandwich by the word "bread" and return what's in the middle of

		* the sandwich and ignores what's on the outside

		* What if it's a fancy sandwich with multiple pieces of bread?

		*/
	}
	public static void sandwich(String description) {
		string
			String[] bread = description.split("bread");
		if (bread.length == 2) {	
			System.out.print(bread[bread.length/2]);
		}
		else {
			String s = bread;
					Arrays.
					
					//if theres three pieces of bread, print the 2 arrays in the middle
					//four, print the three in the middle
		}
	}

		//Your task pt 2:

		/*Write a method that take in a string like

		* "apples pineapples bread lettus tomato bacon mayo ham bread cheese"

		* describing a sandwich

		* use String.split to split up the sandwich at the spaces, " ", and return what's in the middle of

		* the sandwich and ignores what's on the outside.

		* Again, what if it's a fancy sandwich with multiple pieces of bread?

		*/


}
