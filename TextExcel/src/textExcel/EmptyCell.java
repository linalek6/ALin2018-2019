//@author Alexis Lin
//@version 3/29/19
//@this class handles empty cells
package textExcel;

public class EmptyCell implements Cell {
	// text for spreadsheet cell display, must be exactly length 10
	public String abbreviatedCellText() {
		return "          ";
		
	}
	// text for individual cell inspection, not truncated or padded
	public String fullCellText() {
		return "";
		
	}
	public EmptyCell() {
	}
}
