package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid {
	private Cell[][] sheet;
	private int numCols;
	private int numRows;
	private int row;
	private int col;

	// constructor
	public Spreadsheet() {
		numCols = 12;
		numRows = 20;
		sheet = new Cell[numRows][numCols];
		for (int i = 0; i < sheet.length; i++) {
			for (int j = 0; j < sheet[0].length; j++) {
				Cell cell = new EmptyCell();
				sheet[i][j] = cell;
			}
		}
		// initializes a 2d array of cells with all elements containing empty cell
		// objects.
	}

	@Override
	public String processCommand(String command)
	{
		if(command.contains("=")) {
			return assign(command);
			
		}
		else if (command.equals("clear"))
			return "";
					//clear(command);
		else {
			return cellInspect(command);
		}
	}

	public Cell[][] clear (String command) {
		if (command.length() == 5) {
			for(int i = 0; i < sheet.length;i++) {
				for(int j = 0; j < sheet[0].length; j++) {
					Cell cell = new EmptyCell();
					sheet[i][j] = cell;
				}
			}
		}
		//else
		return sheet;
	}

	// cell inspections
	// does it take in a string or location
	public String cellInspect(String command) {
		getCell(command);
		return sheet[row][col].fullCellText();

	}

	public Cell assign(String command) {
		String[] arr = command.split(" ", 3);
		Cell stringAssign = new TextCell(arr[2]);
		Location loc = new SpreadsheetLocation(arr[0]);
		/*row = loc.getRow();
		col = loc.getCol();
		sheet[row][col] = stringAssign;
		*/
		//Cell cell = getCell(loc);
		//cell = stringAssign;
		//return cell;

		// return getGridText();
		//return sheet[loc.getRow()][loc.getCol()].abbreviatedCellText();
		return cell.abbreviatedCellText();
	}

	@Override
	public int getRows() {
		// TODO Auto-generated method stub
		return numRows;
	}

	@Override
	public int getCols() {
		// TODO Auto-generated method stub
		return numCols;
	}

	@Override
	public Cell getCell(Location loc) {
		return sheet[loc.getRow()][loc.getCol()];
	}
	public void getCell(String cellName) {
		cellName = cellName.toUpperCase();
        col = cellName.charAt(0)-65;
        row = Integer.parseInt(cellName.substring(1))-1;
	}
	//overload getcell so it takes a row and a column

	@Override
	public String getGridText() {
		// TODO Auto-generated method stub
		return null;
	}

}
