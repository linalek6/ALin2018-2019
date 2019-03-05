package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		String nextStep;
		do {
			String problem = scanner.nextLine();
			System.out.println(produceAnswer(problem));
			nextStep = scanner.next();
		}
		while(!(nextStep.equals("quit")));
		scanner.close();		
	}
	}
}
