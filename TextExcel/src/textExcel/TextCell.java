package textExcel;

public class TextCell implements Cell {
	private String text;
	public TextCell(String text) {
		this.text = text;		
	}
	public String fullCellText() {
		return text;
	}
	public String abbreviatedCellText() {
		text = text.substring(1, text.length()-1);
		text += "          ";
		return text.substring(0,10);
		
	}

}
