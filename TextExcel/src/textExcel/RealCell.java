package textExcel;
//@author Alexis Lin
//@version 3/29/19
//@this is a  superclass that handles real cells
public class RealCell implements Cell{
	private String value;
	public RealCell(String input) {
		value = input;
	}
	public String abbreviatedCellText() {
		String number = getDoubleValue() + "          ";
		return number.substring(0,10);
	}
	
	//returns the full text of a cell
	public String fullCellText() {
		return value;
	}
	//returns truncated text of a cell
	public double getDoubleValue() {
		return Double.parseDouble(value);
	}
	//returns inputted value
	public String getValue() {
		return value;
	}
}