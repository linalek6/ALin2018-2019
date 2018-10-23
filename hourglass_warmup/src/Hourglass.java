
public class Hourglass {

	public static void main(String[] args) {
		printBase();
		printTopHalf();
		System.out.println("     ||");
	}
	public static void printBase() {
		System.out.print("|");
		for (int i = 0; i  < 10; i++) {
			System.out.print("\"");
		}
		System.out.print("|");
	}
	public static void printTopHalf() {
		for (int i = 8; i >= 2; i -= 2) {
			System.out.println();
			for (int x = 8; x >= i; x -=2) {
				System.out.print(" ");
			}
			System.out.print ("\\");
			for (int n = 1; n <= i; n++) {
				System.out.print(":");
			}
			System.out.print("/");
		}
		System.out.println(); 
	}
	public static void printBottomHalf() {
		for (int i = 2; i <= 8; i+= 2) {
			System.out.println();
			for (int x = 2; x <= i; x += 2) {
				System.out.print(" ");
			}
			System.out.print("/");
			for (int n = 1; n <= 2
		}
	}
}