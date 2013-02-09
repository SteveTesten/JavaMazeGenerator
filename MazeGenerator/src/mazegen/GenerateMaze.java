package mazegen;

import java.lang.Integer;

public class GenerateMaze {

	public static void main(String[] args)
	{
		if (args.length==2)
		{
			System.out.println("Maze dimensions: " + args[0] + " by " + args[1]);
			int rows = Integer.parseInt(args[0]);
			int columns = Integer.parseInt(args[1]);
			
			String[][] Grid = formGridStructure(rows,columns);
			
			int a = 0;
			int b = 0;
			
			for (a=0;a<rows;a++)
			{
				for (b=0;b<(columns-1);b++)
				{
					System.out.print(Grid[a][b] + " ");
				}
				System.out.println(Grid[a][b]);
			}
		}
		else
			System.out.println("Maze dimensions not entered properly! Try again with with args 'x y'.");
			
	}
	
	public static String[][] formGridStructure (int rows,int columns)
	{
		/*
		 * This method forms the structure of the grid.  Each cell of
		 * RxC array contains the information about the surrounding
		 * walls of that cell.  Each cell is 4 values, describing the
		 * North, East, South, and West walls, respectively.  The value
		 * describes the state: 0=No Wall, 1 = Wall, 2 = Border.
		 */
		
		String[][] GridStructure = new String[rows][columns];
		
		for(int i=0;i<rows;i++)
		{
			for(int j=0; j<columns;j++)
			{
				if (i==0)
				{
					if (j==0)
						GridStructure[i][j] = new String("2112");
					else if (j==(columns-1))
						GridStructure[i][j] = new String("2211");
					else
						GridStructure[i][j] = new String("2111");
				}
				else if (i==(rows-1))
				{
					if (j==0)
						GridStructure[i][j] = new String("1122");
					else if (j==(columns-1))
						GridStructure[i][j] = new String("1221");
					else
						GridStructure[i][j] = new String("1121");
				}
				else
				{
					if (j==0)
						GridStructure[i][j] = new String("1112");
					else if (j==(columns-1))
						GridStructure[i][j] = new String("1211");
					else
						GridStructure[i][j] = new String("1111");
				}
			}
		}
		
		return GridStructure;
	}

}
