package mazegen;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

public class MazePanel extends JPanel
{
	private int maze_rows, maze_cols, cell_size;
	private Maze maze;
	private int cell_loc_x,cell_loc_y;
	private int tl_corner_x,tr_corner_x,bl_corner_x,br_corner_x;
	private int tl_corner_y,tr_corner_y,bl_corner_y,br_corner_y;
	
	public MazePanel(Maze maze)
	{
		this.maze = maze;
		maze_rows = maze.getRows();
		maze_cols = maze.getColumns();
		cell_size = 20; //link to maze display
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g); 
		
		for (int row = 0; row<maze_rows; row++)
		{
			for (int col = 0; col<maze_cols; col++)
			{
				cell_loc_x = (cell_size / 2) + (cell_size * col);
				cell_loc_y = (cell_size / 2) + (cell_size * row);
				
				tl_corner_x = cell_loc_x - (cell_size / 2);
				tl_corner_y = cell_loc_y - (cell_size / 2);
				
				tr_corner_x = cell_loc_x + (cell_size / 2);
				tr_corner_y = cell_loc_y - (cell_size / 2);
				
				bl_corner_x = cell_loc_x - (cell_size / 2);
				bl_corner_y = cell_loc_y + (cell_size / 2);
				
				br_corner_x = cell_loc_x + (cell_size / 2);
				br_corner_y = cell_loc_y + (cell_size / 2);
				
				Graphics2D wall_line = (Graphics2D) g;

				wall_line.setPaint(Color.black);
				wall_line.setStroke(new BasicStroke(5));
				if (maze.getGrid().getCell(row, col).getWall(Cell.TOP) != Cell.WallState.OPEN)
					wall_line.draw(new Line2D.Double(tl_corner_x,tl_corner_y,tr_corner_x,tr_corner_y));
				if (maze.getGrid().getCell(row, col).getWall(Cell.LEFT) != Cell.WallState.OPEN)
					wall_line.draw(new Line2D.Double(tl_corner_x,tl_corner_y,bl_corner_x,bl_corner_y));
				if (maze.getGrid().getCell(row, col).getWall(Cell.RIGHT) != Cell.WallState.OPEN)
					wall_line.draw(new Line2D.Double(br_corner_x,br_corner_y,tr_corner_x,tr_corner_y));
				if (maze.getGrid().getCell(row, col).getWall(Cell.BOTTOM) != Cell.WallState.OPEN)
					wall_line.draw(new Line2D.Double(br_corner_x,br_corner_y,bl_corner_x,bl_corner_y));
			}
		}
	}
}
