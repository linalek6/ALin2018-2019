package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	Cell[][] sheet = new Cell[20][12];
	//constructor
	public Spreadsheet() {
		for(int i = 0; i < sheet.length;i++) {
			for(int j = 0; j < sheet[0].length; j++) {
				Cell cell = new EmptyCell();
				sheet[i][j] = cell;
			}
		}
		//initializes a 2d array of cells with all elements containing empty cell objects.
	}
	@Override
	public String processCommand(String command)
	{
		if(command.contains("="))
			return assign(command);
		else if (command.toLowerCase().contains("clear")) {
			return clear(command);
		}
		else 
			return cellInspect(command);
	}
	//cell inspections
	//does it take in a string or location
	public String cellInspect (String cell) {
		Location loc = new SpreadsheetLocation(cell);
		return (getCell(loc)).fullCellText();
	}
	public String assign(String command) {
		String[] arr=command.split(" ",3);
		Cell stringAssign = new TextCell(arr[2]);
		Location loc = new SpreadsheetLocation(arr[0]);
		sheet[loc.getRow()][loc.getCol()] = stringAssign;
		return getGridText();
		
	}
	public String clear(String command) {
		if(command.length() > 6) {
			String[] split = command.split(" ");
			SpreadsheetLocation loc = new SpreadsheetLocation(split[1]);
			Cell cell = new EmptyCell();
			sheet[loc.getRow()][loc.getCol()] = cell;
			return getGridText();
		}
		else {
			for(int i = 0; i < sheet.length;i++) {
				for(int j = 0; j < sheet[0].length; j++) {
					Cell cell = new EmptyCell();
					sheet[i][j] = cell;
				}
			}
			return getGridText();
		}
	}
		
	@Override
	public int getRows()
	{
		// TODO Auto-generated method stub
		return 20;
	}

	@Override
	public int getCols()
	{
		// TODO Auto-generated method stub
		return 12;
	}

	@Override
	public Cell getCell(Location loc)
	{		
		return sheet[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText()
	{
		String gridHead = "   |";
		for(int i = 'A'; i <= 'L'; i++) {
			gridHead += (char) i + "         |";
		}
		String sheetStr = gridHead + "\n";
		for(int i = 0; i < 20; i++) {
			sheetStr += (i+1 + "  ").substring(0, 3) + "|";
			for(int j = 0; j < 12; j++) {
				sheetStr += (sheet[i][j].abbreviatedCellText() + "          ").substring(0, 10) +"|";
			}
		sheetStr += "\n";
		}
	 return sheetStr;
	}
}
