package textExcel;
//@author Alexis Lin
//@version 3/29/19
//@this class the location of a grid
public class SpreadsheetLocation implements Location
{
	private int row;
	private int col;
    //get row of location
    public int getRow()
    {
        // TODO Auto-generated method stub
        return row;
    }

    @Override
    //get column of location
    public int getCol()
    {
        // TODO Auto-generated method stub
        return col;
    }
    //constructor
    public SpreadsheetLocation(String cellName)
    {
    	cellName = cellName.toUpperCase();
        col = cellName.charAt(0)-65;
        row = Integer.parseInt(cellName.substring(1))-1;
    }

}
