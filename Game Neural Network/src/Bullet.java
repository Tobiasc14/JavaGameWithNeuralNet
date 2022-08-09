import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends GameObject{
	
	int velocity = 7;
	int xVelocity;
	int yVelocity;
	double mouseX;
	double mouseY;
	double theta = 0;
	int time = (int) System.currentTimeMillis();
	int curTime = 0;

	public Bullet(int x, int y, ID id, int mouseX, int mouseY) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		this.mouseX = mouseX;
		this.mouseY = mouseY;
		
		
		if (mouseX-x<0){
			velocity = -7;
		}
		theta = Math.atan((double)(mouseY-y)/(mouseX-x));
		xVelocity = (int)(velocity*Math.cos(theta));
		yVelocity = (int)(velocity*Math.sin(theta));
		velocityX = Game.clamp(velocityX, -7, 7);
		velocityY = Game.clamp(velocityY, -7, 7);
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub	
		curTime = (int) System.currentTimeMillis();
		//removes bullet after x time
		if (curTime-time>5500){
			this.remove = true;
		}
		x = x+xVelocity;
		y = y+yVelocity;
		
		x = Game.clamp(x, -10, Game.WIDTH+20);
		y = Game.clamp(y, -10, Game.HEIGHT+20);
	}

	@Override
	public void render(Graphics g) {
		
		g.setColor(Color.black);
		g.fillRect(x, y, 5, 5);
	}

	@Override
	public Rectangle getBounds() {
		Rectangle bounds = new Rectangle();
		bounds.setBounds(x, y, 5, 5);
		return bounds;
	}

}
