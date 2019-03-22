package textExcel;
public class FormulaCell extends RealCell {
	public FormulaCell (String value) {
		super(value);
	}
	public double getDoubleValue(){
		String[] equation = getValue().split(" ");
		double answer = Double.parseDouble(equation[1]);
		for(int i = 3; i < equation.length; i += 2) {
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
	public String abbreviatedCellText() {
	 String text = getDoubleValue() + "          ";
	 return text.substring(0,10);
	}
	public String fullCellText() {
		return getValue();
	}
}
