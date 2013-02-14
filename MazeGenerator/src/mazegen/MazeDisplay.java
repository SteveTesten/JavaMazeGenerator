package mazegen;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MazeDisplay extends JPanel
{
	
	private int maze_rows, maze_cols;
	
	public MazeDisplay(Maze maze)
	{
		
		int window_height = 600;
		int window_width = 600;
		maze_rows = maze.getRows();
		maze_cols = maze.getColumns();
		
		JFrame display_frame = new JFrame();
		
		display_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		display_frame.setTitle("Random Maze Generator!");
		display_frame.setSize(window_height,window_width);
		display_frame.setLocationRelativeTo(null);
		
		display_frame.add(new MazePanel());
		
		
		display_frame.setVisible(true);
		
		
		
	}
}
