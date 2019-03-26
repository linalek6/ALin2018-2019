package textExcel;
// @author Alexis Lin
// @version 3/25/19
public class FormulaCell extends RealCell {
	public FormulaCell (String value) {
		super(value);
	}
	public double getDoubleValue(){
		String[] equation = getValue().split(" ");
		
		double answer = 0;
		for(int i = 1; i < equation.length; i += 2) {
			if(equation[i].toUpperCase().charAt(0) >= 65) {
				Location loc = new SpreadsheetLocation(equation[i]);
				
				
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
