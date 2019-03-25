package textExcel;

public class RealCell implements Cell{
	private String value;
	public RealCell(String input) {
		value = input;
	}
	public String abbreviatedCellText() {
		String number = getDoubleValue() + "          ";
		return number.substring(0,10);
	}
	
	// text for spreadsheet cell display, must be exactly length 10
	public String fullCellText() {
		return value;
	}
	public double getDoubleValue() {
		return Double.parseDouble(value);
	}
	public String getValue() {
		return value;
	}
}