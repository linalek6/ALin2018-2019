package textExcel;
//@author Alexis Lin
//@version 3/29/19
//@this class the string of the spreadsheet

public class Spreadsheet implements Grid
{
	Cell[][] sheet = new Cell[20][12];
	//constructor
	//initializes a 2d array of cells with all elements containing empty cell objects.
	public Spreadsheet() {
		clear("clear");
	}

	//takes in a command and returns the result of the command
	public String processCommand(String command)
	{
		if(command.contains("=")) {
			return assign(command);
		}
		else if (command.toLowerCase().contains("clear")) {
			return clear(command);
		}
		else {
			return cellInspect(command);
		}
	}
	//cell inspections 
	// returns value at location
	public String cellInspect (String cell) {
		Location cellLoc = new SpreadsheetLocation(cell);
		return (getCell(cellLoc)).fullCellText();
	}
	//assigns value at location
	public String assign(String command) {
		String[] splitCommand =command.split(" ",3);
		Location loc = new SpreadsheetLocation(splitCommand[0]);
		Cell assignedCell; 
		String value = splitCommand[2];
		if (value.contains("\"")) {
			assignedCell = new TextCell(value);
		}
		else if(value.contains("%")) {
			assignedCell = new PercentCell(value);
			
		}
		else if(value.contains("(")) {
			assignedCell = new FormulaCell(value, sheet);
			
		}
		else {
			assignedCell = new ValueCell(value);
		}
		sheet[loc.getRow()][loc.getCol()] = assignedCell;
		return getGridText();	
	}
	//clears
	public String clear(String command) {
		//clears cell
		if(command.length() > 6) {
			String[] splitCommand = command.split(" ");
			SpreadsheetLocation clearCell = new SpreadsheetLocation(splitCommand[1]);
			Cell cell = new EmptyCell();
			sheet[clearCell.getRow()][clearCell.getCol()] = cell;
		}
		//clears grid
		//edit for code reuse
		else { 
			for(int row = 0; row < sheet.length;row++) {
				for(int col = 0; col < sheet[0].length; col++) {
					Cell cell = new EmptyCell();
					sheet[row][col] = cell;
				}
			} 
			
		}
		return getGridText();
	}
	
	//returns the number of rows
	public int getRows()
	{
		// TODO Auto-generated method stub
		return 20;
	}

	//returns the number of columns
	public int getCols() {
		return 12;
	}

	//returns the cell at a location
	public Cell getCell(Location loc) {		
		return sheet[loc.getRow()][loc.getCol()];
	}

	//returns grid
	public String getGridText()
	{
		String gridHead = "   |";
		for(int letter = 'A'; letter < 'A'+ getCols(); letter++) {
			gridHead += (char) letter + "         |";
		}
		String sheetStr = gridHead + "\n";
		for(int row = 0; row < getRows(); row++) {
			sheetStr += (row+1 + "  ").substring(0, 3) + "|";
			for(int col = 0; col < getCols(); col++) {
				sheetStr += (sheet[row][col].abbreviatedCellText() + "          ").substring(0, 10) +"|";
			}
		sheetStr += "\n";
		}
	 return sheetStr;
	}
}
