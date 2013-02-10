package mazegen;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Random;

public class MazeFactory
{
	private int rows,columns,total_cells, current_cell_row, current_cell_col, visited_cells;
	
	public MazeFactory(int number_of_rows, int number_of_columns) throws Exception
	{
		rows = number_of_rows;
		columns = number_of_columns;
		total_cells = rows * columns;
		
		if (rows>0 && columns>0)
		{
			Grid maze = new Grid(rows,columns);
			maze.addBorder();
			
			Stack cell_stack = new Stack();
			Random random_gen = new Random();
			
			current_cell_row = random_gen.nextInt(rows-1);
			current_cell_col = random_gen.nextInt(columns-1);
			
			visited_cells = 1;
		}
		else
		{
			throw new Exception("Invalid Grid Dimensions.");
		}
	}
	
	public ArrayList<Cell> closedNeighbors(int row, int column, Grid maze)
	{
		ArrayList<Cell> neighbor_cells = maze.neighbors(row,column);
		
		for (int cell_index=0; cell_index<neighbor_cells.size(); cell_index++)
		{
			if (!neighbor_cells.get(cell_index).allClosed())
				neighbor_cells.remove(cell_index);
		}
		
		return neighbor_cells;
	}
}