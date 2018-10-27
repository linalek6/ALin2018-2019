
public class Hourglass {

	public static void main(String[] args) {
		printBase();
		printCenter();
		printBase();
	}
	public static void printBase() {
		String s = "|";
		for (int i = 0; i  < 10; i++) {
			s += "\"";
			}
		s += "|";
		System.out.println(s); 
	}
	public static void printCenter() {
		for (int i = 8; i >= 2; i -= 2) {
			for (int x = 8; x >= i; x -=2) {
				System.out.print(" ");
			}
			body("\\", i);
		}
		body("     ||", 0);
		for (int i = 2; i <= 8; i+= 2) {
			for (int x = 8; x >= i; x -= 2) {
				System.out.print(" ");
			}
			body("/",i);
		}
	}
	public static void body(String s, int x) {
		String line = "";
		line += s;
		for (int i = 0; i < x; i += 2 ) {
			line += "::";
		}
		if (s == "\\")
			line += "/";
		else if (s == "/")
			line += "\\";
		System.out.println(line);
	}
		
	
}