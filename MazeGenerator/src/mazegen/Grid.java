package mazegen;

import java.util.ArrayList;

public class Grid
{
	private int rows,columns;
	private Cell[][] cells = null;
	
	public Grid(int number_of_rows, int number_of_columns)
	{
		rows = number_of_rows;
		columns = number_of_columns;
		
		if (rows>0 && columns>0)
		{
			cells = new Cell[rows][columns];
			
			for (int row=0; row<rows; row++)
				for (int col=0;col<columns; col++)
				{
					cells[row][col] = new Cell();
					cells[row][col].setPosition(row, col);
				}
		}
	}
	
	public int getRows()
	{
		return rows;
	}
	
	public int getColumns()
	{
		return columns;
	}
	
	public Cell getCell(int row, int column)
	{
		Cell cell = null;
		
		if (column >= 0 && column < columns && row >= 0 && row < rows)
		{
			cell = cells[row][column];
		}
		
		return cell;
	}
	
	public void addBorder()
	{
		for (int row=0; row<rows; row++)
		{
			getCell(row,0).setWall(Cell.LEFT, Cell.WallState.BORDER);
			getCell(row,(columns-1)).setWall(Cell.RIGHT, Cell.WallState.BORDER);
		}
		
		for (int column=0; column<columns; column++)
		{
			getCell(0,column).setWall(Cell.TOP, Cell.WallState.BORDER);
			getCell((rows-1),column).setWall(Cell.BOTTOM, Cell.WallState.BORDER);
		}
	}
	
	public ArrayList<Cell> neighbors(int row, int column)
	{
		ArrayList<Cell> neighbor_cells = new ArrayList<Cell>();
		
		if(getCell(row,column).getWall(Cell.LEFT) != Cell.WallState.BORDER)
			neighbor_cells.add(getCell(row,column-1));
		if(getCell(row,column).getWall(Cell.RIGHT) != Cell.WallState.BORDER)
			neighbor_cells.add(getCell(row,column+1));
		if(getCell(row,column).getWall(Cell.TOP) != Cell.WallState.BORDER)
			neighbor_cells.add(getCell(row-1,column));
		if(getCell(row,column).getWall(Cell.BOTTOM) != Cell.WallState.BORDER)
			neighbor_cells.add(getCell(row+1,column));
		
		return neighbor_cells;
	}
	
	public String toNumString()
	{
		String out = "";
		
		for (int row=0; row<rows; row++)
		{
			for(int col=0; col<columns; col++)
				out+= (cells[row][col].toNumString() + " ");
			out+="\n";
		}
		return out;
	}

	public String cellDisplay()
	{
		String out = "";
		
		for (int row=0; row<rows; row++)
		{
			for(int col=0; col<columns; col++)
				out+= (cells[row][col].topToString());
			out+="\n";
			
			for(int col=0; col<columns; col++)
				out+= (cells[row][col].middleToString());
			out+="\n";
			
			for(int col=0; col<columns; col++)
				out+= (cells[row][col].bottomToString());
			out+="\n";
		}
		
		return out;
	}
	
}
