package mazegen;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MazeDisplay extends JPanel
{
	
	private static final long serialVersionUID = 1L;
	private int maze_rows, maze_cols, cell_size;
	
	public MazeDisplay(Maze maze)
	{
		maze_rows = maze.getRows();
		maze_cols = maze.getColumns();
		cell_size = 20;  //needs to be adaptive
		int window_height = maze_rows*cell_size;
		int window_width = maze_cols*cell_size;
		
		JFrame display_frame = new JFrame();
		
		display_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		display_frame.setTitle("Random " + maze_rows + "x" + maze_cols + " maze!");
		display_frame.setSize(window_width+1,window_height+23);
		display_frame.setLocationRelativeTo(null);
		display_frame.setResizable(false);
		
		display_frame.add(new MazePanel(maze));
		display_frame.add(new SolutionPanel(maze));
		
		display_frame.setVisible(true);
	}
	
	public int getCellSize()
	{
		return cell_size;
	}
}
