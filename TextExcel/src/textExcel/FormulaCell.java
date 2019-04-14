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
		String[] formula = getValue().split(" ");	
		double answer = 0;
		if(formula.length == 4) {
			int counter = 0;
			String[] range = formula[2].split("-");
			Location start = new SpreadsheetLocation(range[0]);
			Location end = new SpreadsheetLocation(range[1]);
			for(int row = start.getRow(); row <= end.getRow(); row++) {
				for(int col = start.getCol(); col <= end.getCol(); col++) {
					answer += Double.parseDouble(sheet[row][col].abbreviatedCellText());
					counter++;
				}
			}
			if(formula[1].equalsIgnoreCase("avg")) {
				return answer/counter;
			}
		}
		else {	
		for(int i = 1; i < formula.length; i += 2) {
			if(formula[i].charAt(0) >= 65) {
				Location loc = new SpreadsheetLocation(formula[i]);	
				formula[i]  = sheet[loc.getRow()][loc.getCol()].abbreviatedCellText();
			}
			if(formula[i-1].equals("+") || formula[i-1].equals("(") ){
				answer += Double.parseDouble(formula[i]);
			}
			else if(formula[i-1].equals("-")) {
				answer -= Double.parseDouble(formula[i]);
			}
			else if(formula[i-1].equals("*")) {
				answer *= Double.parseDouble(formula[i]);
			}
			else if(formula[i-1].equals("/")) {
				answer /= Double.parseDouble(formula[i]);
			}
		}
		}
		return answer;
	}

}
