import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends GameObject{ 
	
	Image skin;
	BufferedImage image;
	public int health;
	

	public Player(int x, int y, ID id) {
		super(x, y, id);
		health = 2000;
		// TODO Auto-generated constructor stub
		//setTime(0);
		
		//setX(30);
		//setY(30);
		
		try {
			this.skin = ImageIO.read(new File("images/beakers.jpg"));
			this.image = (BufferedImage) skin;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		velocityX = 2;
		velocityY = 2;
		

	}
	public int getHealth() {
		return health;
	}
	public void loseHealth(int healthLost) {
		health= health-healthLost;
	}

	@Override
	public void tick() {
		
		
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
		Graphics2D g2 = (Graphics2D)g;
		
		// TODO Auto-generated method stub
		
		g2.setColor(Color.BLACK);
		g2.draw(getBounds());
		
		g.setColor(Color.lightGray);
		g.fillRect(x+5, y+24, 22, 32);
		g.fillOval(x, y, 32, 32);
		g.setColor(Color.black);
		g.fillOval(x+4, y+10, 5, 5);
		g.fillOval(x+25, y+10, 5, 5);
		
		//If I design a skin in paint or something I can just upload it here
		//g2.drawImage(image, x, y, null);
		
	}

	
	public Rectangle getBounds() {
		Rectangle bounds = new Rectangle();
		bounds.setBounds(x+3, y, 24, 56);
		
		return bounds;
	}
}









