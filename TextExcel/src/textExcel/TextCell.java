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
		String text = this.text.substring(1, this.text.length()-1);
		text += "          ";
		return text.substring(0,10);
		
	}

}
