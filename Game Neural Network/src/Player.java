import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Player extends GameObject{ 
	
	
	
	
	public Player(int x, int y, ID id) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		//setTime(0);
		
		//setX(30);
		//setY(30);
		/**
		velocityX = (int)(6.6*Math.random());
		velocityY = (int)(6.6*Math.random());
*/

	}

	@Override
	public void tick() {
		
		x+=velocityX;
		y+=velocityY;		
		
		x = Game.clamp(x, 0, Game.WIDTH-36);
		y = Game.clamp(y, 0, Game.HEIGHT-89);
		
		/**
		// position gets position plus how fast you move per tick
		//this just gets them to bounce around the screen 
		if(x>gameWidth-32||x<0){
			velocityX=-velocityX;
		}
		if(y>gameHeight-82||y<0){
			velocityY=-velocityY;
		}
		x=x+velocityX;
		y=y+velocityY;
		*/


	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.BLACK);
		g2.draw(getBounds());
		
		g.setColor(Color.lightGray);
		g.fillRect(x+5, y+24, 22, 32);
		g.fillOval(x, y, 32, 32);
		g.setColor(Color.black);
		g.fillOval(x+4, y+10, 5, 5);
		g.fillOval(x+25, y+10, 5, 5);
		
	}

	
	public Rectangle getBounds() {
		Rectangle bounds = new Rectangle();
		bounds.setBounds(x+3, y, 24, 56);
		
		return bounds;
	}
}









