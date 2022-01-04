import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject {
	
	

	public BasicEnemy(int x, int y, ID id) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		
		
		velocityX = (int) (7*Math.random());
		velocityX = Game.clamp(velocityX, 1, 6);
		velocityY = (int) (7*Math.random());;
		velocityY = Game.clamp(velocityY, 1, 6);
		//velocityX = 0;
		//velocityY = 0;
		
	}

	
	public void tick() {
		//This reverses the enemies motion when it collides with edge of window
		if(x>Game.WIDTH-32||x<0){
			velocityX=-velocityX;
		}
		if(y>Game.HEIGHT-82||y<0){
			velocityY=-velocityY;
		}
		x=x+velocityX;
		y=y+velocityY;
		
	}

	
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		Graphics2D g2 = (Graphics2D) g;
		
		//g2.draw(getBounds());
		
		
		g.setColor(Color.red);
		g.fillRect(x+5, y+24, 22, 32);
		g.fillOval(x, y, 32, 32);
		g.setColor(Color.black);
		g.drawLine(x+3, y+5, x+10, y+7);
		g.drawLine(x+22, y+7, x+29, y+5);
		g.drawLine(x+3, y+6, x+10, y+8);
		g.drawLine(x+22, y+8, x+29, y+6);
		g.fillOval(x+4, y+10, 5, 5);
		g.fillOval(x+25, y+10, 5, 5);
		
	}


	@Override
	public Rectangle getBounds() {
		Rectangle bounds = new Rectangle();
		bounds.setBounds(x+3, y, 25, 56);
		return bounds;
	}

}
