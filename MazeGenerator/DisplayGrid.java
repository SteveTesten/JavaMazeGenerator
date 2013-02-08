import javax.swing.JFrame;

public class DisplayGrid
{
	public static void main(String [] args)
	{
		JFrame maze = new JFrame("Random Maze!");
		int width = 800;
		int height = 400;

		maze.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		maze.setSize(width,height);
		maze.setVisible(true);
	}
}