package textExcel;
import java.io.FileNotFoundException;
import java.util.Scanner;
//@author Alexis Lin
//@version 3/29/19
//@this class contains the  main method of text excel
public class TextExcel
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		String userInput;
		Grid sheet = new Spreadsheet();
		System.out.println(sheet.getGridText());
		//TestsALL.Helper th = new TestsALL.Helper();
		//System.out.println(th.getText());
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
