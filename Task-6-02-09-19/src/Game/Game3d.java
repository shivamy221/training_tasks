package Game;

public class Game3d {

	private static final long serialVersionUID = 1L;
	public int zPos;
	public int xPos;
	public int yPos;
	
	public void xMove(int pos)
	{
		this.xPos+=pos;
	}
	
	public void yMove(int pos)
	{
		this.yPos+=pos;
	}


	public void zMove(int pos)
	{
		this.zPos+=pos;
	}
}
