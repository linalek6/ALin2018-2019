package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private Cell[][] sheet;
	private int numCols;
	private int numRows;
	private int row;
	private int col;
	//constructor
	public Spreadsheet() {
		numCols = 12;
		numRows = 20;
		sheet = new Cell[numRows][numCols];
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
		//if(command.equals("clear"))
			//return "";
		else {
			command = command.toUpperCase();
			//return sheet[loc.getRow()][loc.getCol()].fullCellText();
			return getCell(sheet[row][col]).fullCellText();
			
			//return cellInspect(command);
		}
	}
	//cell inspections
	//does it take in a string or location
	public String cellInspect (String command) {
		return "";
		
	}
	public String assign(String command) {
		String[] arr=command.split(" ",3);
		Cell stringAssign = new TextCell(arr[2]);
		Location loc = new SpreadsheetLocation(arr[0]);
		row = loc.getRow();
		col = loc.getCol();
		sheet[row][col] = stringAssign;
		
		//return getGridText();
		return sheet[loc.getRow()][loc.getCol()].abbreviatedCellText();
	}
	@Override
	public int getRows()
	{
		// TODO Auto-generated method stub
		return numRows;
	}

	@Override
	public int getCols()
	{
		// TODO Auto-generated method stub
		return numCols;
	}

	@Override
	public Cell getCell(Location loc)
	{		
		return sheet[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
