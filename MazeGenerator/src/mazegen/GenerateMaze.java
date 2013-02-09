package mazegen;

import java.lang.Integer;

public class GenerateMaze {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		if (args.length==2)
		{
			System.out.println("Maze dimensions: " + args[0] + " by " + args[1]);
			int rows = Integer.parseInt(args[0]);
			int columns = Integer.parseInt(args[1]);
			
			String[][] Grid = formGrid(rows,columns);
			
			System.out.println(Grid[2][1]);
			
		}
		else
		{
			System.out.println("Maze dimensions not entered properly! Try again with with args 'x y'.");
		}
			
	}
	
	public static String[][] formGrid (int rows,int columns)
	{
		String[][] GridStructure = new String[rows][columns];
		for(int i=0;i<rows;i++)
		{
			for(int j=0; j<columns;j++)
			{
				GridStructure[i][j] = new String("1111");
			}
		}
		
		return GridStructure;
	}

}
