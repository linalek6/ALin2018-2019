package textExcel;

public class PercentCell extends RealCell {
	public double getDoubleValue(){
		String[] arr = getValue().split("%");
		double percent = Double.parseDouble(arr[0])/100;
		return percent;
		
	} 
	public PercentCell(String input) {
		super(input);
	}
	public String fullCellText() {
		return getDoubleValue() + "";
	}
	public String abbreviatedCellText() {
		String cellText = (int) (getDoubleValue()*100) + "%          ";
		return cellText.substring(0,10);
	}

}
