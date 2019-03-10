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
		if (text.length() > 12) {
			return text.substring(1,11);
		}
		else {
			return text.substring(1,text.length()-1);
		}
	}

}
