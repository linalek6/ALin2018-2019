package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.
public class TextExcel
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		String userInput;
		Grid sheet = new Spreadsheet();
		TestsALL.Helper th = new TestsALL.Helper();
		System.out.println(th.getText());
		do {
			System.out.print("Enter a command: ");
			userInput = scanner.nextLine();
			//Location loc = new SpreadsheetLocation(userInput);
			System.out.println(sheet.processCommand(userInput));
			//System.out.println(sheet.getCols());	
		}
		while(!(userInput.equals("quit")));
		scanner.close();		
	}
}
