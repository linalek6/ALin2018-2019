
public class Hourglass {

	public static void main(String[] args) {
		printBase();
		printTopHalf();
		System.out.println("     ||");
		printBottomHalf();
		printBase();
	}
	public static void printBase() {
		for (int i = 0; i  < 12; i++) {
			if (i==0 || i ==11) {
				System.out.print("|");
			}
			else {
			System.out.print("\"");
			}
		}
		System.out.println(); 
	}
	public static void printTopHalf() {
		for (int i = 8; i >= 2; i -= 2) {
			//System.out.println();
			for (int x = 8; x >= i; x -=2) {
				System.out.print(" ");
			}
			System.out.print ("\\");
			for (int n = 1; n <= i; n++) {
				System.out.print(":");
			}
			System.out.println("/");
			
		}
		//System.out.println(); 
	}
	public static void printBottomHalf() {
		for (int i = 2; i <= 8; i+= 2) {
			for (int x = 8; x >= i; x -= 2) {
				System.out.print(" ");
			}
			System.out.print("/");
			for (int n = 1; n <= i; n++) {
				System.out.print(":");
			}
			System.out.println("\\");
		}
	}
}