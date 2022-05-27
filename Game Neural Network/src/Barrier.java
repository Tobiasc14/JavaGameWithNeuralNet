import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Barrier extends GameObject{
	
	int width;
	int height;
	Image skin;
	BufferedImage image;


	public Barrier(int x, int y, ID id) {
		super((int)(Math.random()*Game.WIDTH), (int)(Math.random()*Game.HEIGHT), id);
		width = (int) (60);
		height =(int) (60);
		this.setX(x);
		this.setY(y);
		
		try {
			if (Math.random() > .5){
				this.skin = ImageIO.read(new File("images/BarbedWire2.png"));
			}
			else {
				this.skin = ImageIO.read(new File("images/BarbedWire.png"));
			}
			
			this.image = (BufferedImage) skin;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
			
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		//g.setColor(Color.black);
		//g.fillRect(x, y, width, height);
		g.drawImage(image,x, y, null);
		
	}

	@Override
	public Rectangle getBounds() {
		Rectangle r = new Rectangle(x,y,width,height);
		
		
		return r;
	}

}
