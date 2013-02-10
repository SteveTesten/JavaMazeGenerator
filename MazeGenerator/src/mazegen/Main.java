package mazegen;

public class Main
{
	public static void main(String[] args)
	{
		if (args.length>=2)
		{
			int total_rows = Integer.parseInt(args[0]);
			int total_columns = Integer.parseInt(args[1]);
			
			Maze maze = new Maze(total_rows, total_columns);
			maze.display();
		}
		else
		{
			System.out.println("Invalid matrix dimensions.  Please format args as 'rows columns' where 'rows' and 'columns' are integers.");
		}
	}
}
