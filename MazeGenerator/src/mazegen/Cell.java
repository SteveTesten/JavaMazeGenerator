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
		
		if (walls[LEFT] != WallState.OPEN 
				&& walls[RIGHT] != WallState.OPEN 
				&& walls[TOP] != WallState.OPEN 
				&& walls[BOTTOM] != WallState.OPEN)
		{
			result = true;
		}
		
		return result;
	}
	
	public String toNumString()
	{
		String out = "";
		
		out+= numStringWallState(walls[LEFT]);
		out+= numStringWallState(walls[RIGHT]);
		out+= numStringWallState(walls[TOP]);
		out+= numStringWallState(walls[BOTTOM]);
		
		return out;
	}
	
	private String numStringWallState(WallState state)
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
	
	private String stringWallState(WallState state, int wall)
	{
		String out = "";
		
		if (state == WallState.OPEN)
			out = " ";
		else if (state == WallState.CLOSED && wall == LEFT)
			out = "|";
		else if (state == WallState.CLOSED && wall == RIGHT)
			out = "|";
		else if (state == WallState.CLOSED)
			out = "-";
		else
			out = "#";
		
		return out;
	}

	public String topToString()
	{
		String out = "";
		
		if (getWall(TOP) == WallState.BORDER)
			out+= ("#" + stringWallState(walls[TOP],TOP) + stringWallState(walls[TOP],TOP) + "#");
		else if (getWall(LEFT) == WallState.BORDER)
			out+= ("#" + stringWallState(walls[TOP],TOP) + stringWallState(walls[TOP],TOP) + "+");
		else if (getWall(RIGHT) == WallState.BORDER)
			out+= ("+" + stringWallState(walls[TOP],TOP) + stringWallState(walls[TOP],TOP) + "#");
		else
			out+= ("+" + stringWallState(walls[TOP],TOP) + stringWallState(walls[TOP],TOP) + "+");
		
		return out;
	}

	public String middleToString()
	{
		String out = "";
		
		out+= (stringWallState(walls[LEFT],LEFT) + "  " + stringWallState(walls[RIGHT],RIGHT));
		
		return out;
	}

	public String bottomToString()
	{
		String out = "";
		
		if (getWall(BOTTOM) == WallState.BORDER)
			out+= ("#" + stringWallState(walls[BOTTOM],BOTTOM) + stringWallState(walls[BOTTOM],BOTTOM) + "#");
		else if (getWall(LEFT) == WallState.BORDER)
			out+= ("#" + stringWallState(walls[BOTTOM],BOTTOM) + stringWallState(walls[BOTTOM],BOTTOM) + "+");
		else if (getWall(RIGHT) == WallState.BORDER)
			out+= ("+" + stringWallState(walls[BOTTOM],BOTTOM) + stringWallState(walls[BOTTOM],BOTTOM) + "#");
		else
			out+= ("+" + stringWallState(walls[BOTTOM],BOTTOM) + stringWallState(walls[BOTTOM],BOTTOM) + "+");
		
		return out;
	}
}
