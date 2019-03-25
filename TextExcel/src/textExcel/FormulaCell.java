package textExcel;
// @author Alexis Lin
// @version 3/25/19
public class FormulaCell extends RealCell {
	public FormulaCell (String value) {
		super(value);
	}
	public double getDoubleValue(){
		String[] equation = getValue().split(" ");
		double answer = Double.parseDouble(equation[1]);
		for(int i = 3; i < equation.length; i += 2) {
			if(equation[i].toUpperCase().charAt(0) >= 65) {
				Location loc = new SpreadsheetLocation(equation[i]);
				loc.get
			}
			if(equation[i-1].equals("+")){
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
