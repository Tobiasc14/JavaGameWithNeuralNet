import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HUD {
	
	private Handler handler;
	private Level level;
	long curTime = System.currentTimeMillis();
	
	

	public HUD(Handler handler, Level level) {
		// TODO Auto-generated constructor stub
		this.handler = handler;
		this.level = level;
		
	}
	
	public void tick() {
		
	}
	public void render(Graphics g) {
		if(Game.newGame){
			//newGame = false;
			g.setColor(Color.orange);
			Font font1 = new Font("Verdana", Font.BOLD, 34);
			g.setFont(font1);
			g.drawString("Press B to Build a new Level", Game.WIDTH/2-250,Game.HEIGHT/2);
			g.drawString("Press S to Start existing levels", Game.WIDTH/2-270,Game.HEIGHT/2+40);
		}
	}

}
