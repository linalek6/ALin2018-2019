package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	Cell[][] sheet = new Cell[20][12];
	//constructor
	public Spreadsheet() {
		for(int i = 0; i<sheet.length;i++) {
			for(int j = 0; i < sheet[0].length; j++) {
				Cell cell = new EmptyCell(sheet[i][j]);
				//cell = sheet[i][j];
			}
		}
		//initializes a 2d array of cells with all elements containing empty cell objects.
	}
	@Override
	public String processCommand(String command)
	{
		// TODO Auto-generated method stub
		return "";
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getGridText()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
