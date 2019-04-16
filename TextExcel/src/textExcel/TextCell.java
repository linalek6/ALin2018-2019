package textExcel;

public class TextCell implements Cell {
	private String input;
	public TextCell(String text) {
		input = text;		
	}
	public String fullCellText() {
		return input;
	}
	public String abbreviatedCellText() {
		String text = input.substring(1, input.length()-1);
		text += "          ";
		return text.substring(0,10);
		
	}

}
