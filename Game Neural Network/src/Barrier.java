import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Barrier extends GameObject{
	
	int width;
	int height;

	public Barrier(int x, int y, ID id) {
		super((int)(Math.random()*Game.WIDTH), (int)(Math.random()*Game.HEIGHT), id);
		width = (int) (60);
		height =(int) (60);
		this.setX(x);
		this.setY(y);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		//These aren't necessary
		
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.black);
		g.fillRect(x, y, width, height);
		
	}

	@Override
	public Rectangle getBounds() {
		Rectangle r = new Rectangle(x,y,width,height);
		
		
		return r;
	}

}
