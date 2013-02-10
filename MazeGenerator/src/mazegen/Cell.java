package mazegen;

public class Cell
{
	public enum WallState { OPEN, CLOSED, BORDER };
	public static final int LEFT = 0;
	public static final int RIGHT = 1;
	public static final int TOP = 2;
	public static final int BOTTOM = 3;
	
	private WallState[] walls = new WallState[4];

	private boolean was_visited=false;
	
	private int row, column;
	
	
	public Cell()
	{
		walls[LEFT] = WallState.CLOSED;
		walls[RIGHT] = WallState.CLOSED;
		walls[TOP] = WallState.CLOSED;
		walls[BOTTOM] = WallState.CLOSED;
		row = -1;
		column = -1;
	}
	
	public WallState getWall(int side)
	{
		return walls[side];
	}
	
	public void setWall(int side, WallState wall)
	{
		walls[side] = wall;
	}
	
	public void setPosition(int row, int column)
	{
		this.row = row;
		this.column = column;
	}
	
	public int getRow()
	{
		return row;
	}
	
	public int getColumn()
	{
		return column;
	}
	
	public void setVisited()
	{
		was_visited=true;
	}
	
	public boolean wasVisited()
	{
		return was_visited;
	}
	
	public boolean allClosed()
	{
		boolean result = false;
		
		if (walls[LEFT] == WallState.CLOSED 
				&& walls[RIGHT] == WallState.CLOSED 
				&& walls[TOP] == WallState.CLOSED 
				&& walls[BOTTOM] == WallState.CLOSED)
		{
			result = true;
		}
		
		return result;
	}
	
	public String toString()
	{
		String out = "";
		
		out+= stringWallState(walls[LEFT]);
		out+= stringWallState(walls[RIGHT]);
		out+= stringWallState(walls[TOP]);
		out+= stringWallState(walls[BOTTOM]);
		
		return out;
	}
	
	private String stringWallState(WallState state)
	{
		String out = "";
		
		if (state == WallState.OPEN)
			out = "0";
		else if (state == WallState.CLOSED)
			out = "1";
		else
			out = "2";
		
		return out;
	}
}
