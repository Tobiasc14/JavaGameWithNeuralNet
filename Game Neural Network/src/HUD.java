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
		if(Game.levelBuilder) {
			g.setColor(Color.orange);
			Font font1 = new Font("Verdana", Font.BOLD, 18);
			g.setFont(font1);
			g.drawString("Left click to place, right click to remove", Game.WIDTH/2-230,50);
			g.drawString("Middle click mouse to switch what you place", Game.WIDTH/2-250,18+50);
			g.drawString("Press S to start playing the game you made", Game.WIDTH/2-240,36+50);
		}
	}

}
