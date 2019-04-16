package textExcel;
//@author Alexis Lin
//@version 3/29/19
//@this is a  superclass that handles real cells
public class RealCell implements Cell{
	private String input;
	public RealCell(String input) {
		this.input = input;
	}
	public String abbreviatedCellText() {
		String value = getDoubleValue() + "          ";
		return value.substring(0,10);
	}
	
	//returns the full text of a cell
	public String fullCellText() {
		return input;
	}
	//returns truncated text of a cell
	public double getDoubleValue() {
		return Double.parseDouble(input);
	}
	//returns inputted value
}