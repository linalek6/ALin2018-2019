package textExcel;

public class PercentCell extends RealCell {
	private String value;
	public double getDoubleValue(){
		String[] arr = value.split("%");
		double dec = Double.parseDouble(arr[0])/100;
		return dec;
		
	} 
	public PercentCell(String input) {
		super(input);
	}

}
