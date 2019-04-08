package textExcel;
// @author Alexis Lin
// @version 3/29/19
//@this class handles formulas in text excel
public class FormulaCell extends RealCell {
	Cell[][] sheet;
	public FormulaCell (String value, Cell[][] sheet) {
		super(value);
		this.sheet= sheet;
	}
	public double getDoubleValue(){
		String[] equation = getValue().split(" ");
		
		double answer = 0;
		for(int i = 1; i < equation.length; i += 2) {
			if(equation[i].toUpperCase().charAt(0) >= 65) {
				Location loc = new SpreadsheetLocation(equation[i]);	
				Cell cell = sheet[loc.getCol()][loc.getRow()];
				equation[i] = cell.fullCellText();
			}
			if(equation[i-1].equals("+") || equation[i-1].equals("(") ){
				answer += Double.parseDouble(equation[i]);
			}
			else if(equation[i-1].equals("-")) {
				answer -= Double.parseDouble(equation[i]);
			}
			else if(equation[i-1].equals("*")) {
				answer *= Double.parseDouble(equation[i]);
			}
			else if(equation[i-1].equals("/")) {
				answer /= Double.parseDouble(equation[i]);
			}
		}
		return answer;
	}
}
