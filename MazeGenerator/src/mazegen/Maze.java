package mazegen;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Maze
{
	private int total_rows, total_columns;
	private Grid grid;
	
	public Maze(int total_rows, int total_columns)
	{
		this.total_rows = total_rows;
		this.total_columns = total_columns;
		this.grid = new Grid(total_rows,total_columns);
		
		grid.addBorder();
		
		createMaze();
		
	}
	
	public void display()
	{
		System.out.println(grid.cellDisplay());
	}
	
	private void createMaze()
	{
		int visited_cells = 1;
		int total_cells = total_rows * total_columns;
		
		Stack<Cell> cell_stack = new Stack<Cell>();
		Random random_gen = new Random();
		
		Cell current_cell = grid.getCell(random_gen.nextInt(total_rows), random_gen.nextInt(total_columns));
		
		while (visited_cells < total_cells)
		{
			ArrayList<Cell> closed_neighbors = closedNeighbors(current_cell.getRow(), current_cell.getColumn());
			
			if (closed_neighbors.size()>0)
			{
				Cell next_cell = closed_neighbors.get(random_gen.nextInt(closed_neighbors.size()));
				
				if (current_cell.getColumn() > next_cell.getColumn())
				{
					current_cell.setWall(Cell.LEFT, Cell.WallState.OPEN);
					next_cell.setWall(Cell.RIGHT,Cell.WallState.OPEN);
				}
				
				else if (current_cell.getColumn() < next_cell.getColumn())
				{
					current_cell.setWall(Cell.RIGHT, Cell.WallState.OPEN);
					next_cell.setWall(Cell.LEFT,Cell.WallState.OPEN);
				}
				
				else if (current_cell.getRow() > next_cell.getRow())
				{
					current_cell.setWall(Cell.TOP, Cell.WallState.OPEN);
					next_cell.setWall(Cell.BOTTOM,Cell.WallState.OPEN);
				}
				
				else if (current_cell.getRow() < next_cell.getRow())
				{
					current_cell.setWall(Cell.BOTTOM, Cell.WallState.OPEN);
					next_cell.setWall(Cell.TOP,Cell.WallState.OPEN);
				}
				
				cell_stack.push(current_cell);
				
				current_cell = next_cell;
				
				visited_cells++;
			}
			else
			{
				current_cell = cell_stack.pop();
			}
			
		}
		
	}
	
	public ArrayList<Cell> closedNeighbors(int row, int column)
	{
		ArrayList<Cell> neighbor_cells = grid.neighbors(row,column);
		ArrayList<Cell> closed_neighbors = new ArrayList<Cell>();
		
		for (int cell_index=0; cell_index < neighbor_cells.size(); cell_index++)
		{
			if (neighbor_cells.get(cell_index).allClosed())
				closed_neighbors.add(neighbor_cells.get(cell_index));
		}
		
		return closed_neighbors;
	}
}
