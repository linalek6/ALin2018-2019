package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a command: ");
		String userInput = scanner.nextLine();
		do {

			//Location loc = new SpreadsheetLocation(userInput);
			Grid sheet = new Spreadsheet();
			System.out.println(sheet.processCommand(userInput));
			//System.out.println(sheet.getCols());
			System.out.print("Input: " );
			userInput = scanner.nextLine();
		}
		while(!(userInput.equals("quit")));
		scanner.close();		
	}
}
