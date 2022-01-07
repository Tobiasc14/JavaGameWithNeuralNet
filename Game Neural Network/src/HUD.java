import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class HUD {
	
	private Handler handler;
	private Level level;
	long curTime = System.currentTimeMillis();
	int health = 100;
	Font Menu = new Font("Verdana", Font.BOLD, 40);
	Font smallText = new Font("Verdana", Font.BOLD, 18);
	public String buildLevel = "Build a new Level";
	public String startLevels = "Start existing levels";;
	
	

	public HUD(Handler handler, Level level) {
		// TODO Auto-generated constructor stub
		this.handler = handler;
		this.level = level;
		
		
	}
	
	public void tick() {
		if(Game.newGame) {
			
		}
		
	}
	public void render(Graphics g) {
		if(Game.newGame){
			//newGame = false;
			g.setColor(Color.orange);			
			g.setFont(Menu);			
			int textWidth = g.getFontMetrics().stringWidth(Game.gameName);			
			g.drawString(Game.gameName, Game.WIDTH/2-textWidth/2,50);			
			
			g.setFont(smallText);
			
			textWidth = g.getFontMetrics().stringWidth(buildLevel);
			g.setColor(Color.black);
			g.drawString(buildLevel, Game.WIDTH/2-textWidth/2,Game.HEIGHT/2);
			
			Rectangle buildLevel = new Rectangle(Game.WIDTH/2-textWidth/2-4,Game.HEIGHT/2-20,textWidth+8,26);
			g.setColor(Color.orange);
			g.drawRect(Game.WIDTH/2-textWidth/2-4,Game.HEIGHT/2-20,textWidth+8,26);
			
			g.setColor(Color.black);
			textWidth = g.getFontMetrics().stringWidth(startLevels);
			g.drawString(startLevels, Game.WIDTH/2-textWidth/2,Game.HEIGHT/2+30);
			
			Rectangle startLevels = new Rectangle(Game.WIDTH/2-textWidth/2-4,Game.HEIGHT/2-20,textWidth+8,26);
			g.setColor(Color.orange);
			g.drawRect(Game.WIDTH/2-textWidth/2-4,Game.HEIGHT/2+10,textWidth+8,26);
			g.setColor(Color.black);
		}
		else if(Game.levelBuilder) {
			g.setColor(Color.orange);
			
			g.setFont(smallText);
			g.drawString("Left click to place, right click to remove", Game.WIDTH/2-230,50);
			g.drawString("Middle click mouse to switch what you place", Game.WIDTH/2-250,18+50);
			g.drawString("Press S to start simulating the game you made", Game.WIDTH/2-240,36+50);
		}
		else if (Game.simulating) {
			g.setColor(Color.orange);
			Font font1 = new Font("Verdana", Font.BOLD, 18);
			g.setFont(smallText);
			g.drawString("Press S again to stop simulating game", Game.WIDTH/2-200,50);
		}
		else if(Game.started) {
			g.setColor(Color.red);
			g.fillRect(10, 10, 200, 20);
			g.setColor(Color.green);
			g.fillRect(10, 10, health, 20);
			g.setColor(Color.white);
			g.drawRect(9, 9, 201, 21);
			
		}
	}

}
