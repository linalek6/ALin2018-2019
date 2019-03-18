package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	Cell[][] sheet = new Cell[20][12];
	//constructor
	//initializes a 2d array of cells with all elements containing empty cell objects.
	public Spreadsheet() {
		for(int i = 0; i < sheet.length;i++) {
			for(int j = 0; j < sheet[0].length; j++) {
				Cell cell = new EmptyCell();
				sheet[i][j] = cell;
			}
		}
	}
	@Override
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
		Location loc = new SpreadsheetLocation(cell);
		return (getCell(loc)).fullCellText();
	}
	//assigns value at location
	public String assign(String command) {
		String[] arr=command.split(" ",3);
		Cell stringAssign = new TextCell(arr[2]);
		Location loc = new SpreadsheetLocation(arr[0]);
		sheet[loc.getRow()][loc.getCol()] = stringAssign;
		return getGridText();	
	}
	//clears
	public String clear(String command) {
		//clears cell
		if(command.length() > 6) {
			String[] split = command.split(" ");
			SpreadsheetLocation loc = new SpreadsheetLocation(split[1]);
			Cell cell = new EmptyCell();
			sheet[loc.getRow()][loc.getCol()] = cell;
		}
		//clears grid
		else {
			for(int i = 0; i < sheet.length;i++) {
				for(int j = 0; j < sheet[0].length; j++) {
					Cell cell = new EmptyCell();
					sheet[i][j] = cell;
				}
			}
		}
		return getGridText();
	}
		
	@Override
	//returns the number of rows
	public int getRows()
	{
		// TODO Auto-generated method stub
		return 20;
	}

	@Override
	//returns the number of columns
	public int getCols()
	{
		// TODO Auto-generated method stub
		return 12;
	}

	@Override
	//returns the cell at a location
	public Cell getCell(Location loc)
	{		
		return sheet[loc.getRow()][loc.getCol()];
	}

	@Override
	//returns grid
	public String getGridText()
	{
		String gridHead = "   |";
		for(int i = 'A'; i < 'A'+ getCols(); i++) {
			gridHead += (char) i + "         |";
		}
		String sheetStr = gridHead + "\n";
		for(int i = 0; i < getRows(); i++) {
			sheetStr += (i+1 + "  ").substring(0, 3) + "|";
			for(int j = 0; j < getCols(); j++) {
				sheetStr += (sheet[i][j].abbreviatedCellText() + "          ").substring(0, 10) +"|";
			}
		sheetStr += "\n";
		}
	 return sheetStr;
	}
}
