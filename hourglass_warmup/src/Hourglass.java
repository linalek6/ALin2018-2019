
public class Hourglass {

	public static void main(String[] args) {
		printBase();
		printTopHalf();
		System.out.println("||");
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
			System.out.print ("\\");
				for (int n = 1; n <= i; n++) {

					System.out.print(":");
				}
			System.out.print("/");
		}
		System.out.println(); 
	}

	/*public static void printStringOfChars (String left, String right, String center, int n) {
		
		System.out.print(left);
		for (int i= 1; i <= n; i++) {
			System.out.print(center);
		}
		System.out.print(right);
	}
	*/
}
