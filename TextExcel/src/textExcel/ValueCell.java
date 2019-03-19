package textExcel;

public class ValueCell extends RealCell {
	public ValueCell(String value) {
		super(value);
	}
	public String abbreviatedCellText() {
		//String value = this.value.substring(1, this.value.length()-1);
		String number = getDoubleValue() + "          ";
		return number.substring(0,10);
	}
	
	// text for spreadsheet cell display, must be exactly length 10
	public String fullCellText() {
		return getDoubleValue() + "";
	}
	/*public double getDoubleValue() {
		return (double) Double.parseDouble(value);
	}
	*/
}
