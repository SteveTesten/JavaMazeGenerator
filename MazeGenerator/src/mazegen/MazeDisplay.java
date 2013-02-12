package mazegen;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MazeDisplay
{
	
	private int maze_rows, maze_cols;
	
	public MazeDisplay(Maze maze)
	{
		
		int window_height = 600;
		int window_width = 600;
		maze_rows = maze.getRows();
		maze_cols = maze.getColumns();
		
		maze_rows = 
		
		JFrame display_frame = new JFrame();
		
		display_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		display_frame.setTitle("Random Maze Generator!");
		display_frame.setSize(window_height,window_width);
		display_frame.setLocationRelativeTo(null);
		
		JPanel maze_panel = new JPanel();
		maze_panel.formatMazePanel(Maze maze);
		
		
		display_frame.add(maze_panel, BorderLayout.CENTER);
		
		display_frame.setVisible(true);
		
		
		
	}

	private void initializeFrame()
	{
		
	}

}
