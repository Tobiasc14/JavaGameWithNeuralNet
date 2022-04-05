import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {
	
	
	private Handler handler;
	private HUD hud;
	long timeClick;
	String [] levelParts = {"barrier","enemy", "player"};
	int selection = 0;
	
	
	public MouseInput(Handler handler, HUD hud){
		this.handler = handler;
		this.hud = hud;
		timeClick = System.currentTimeMillis();
	}
	
	public void mousePressed(MouseEvent e){
		int xPos = e.getX();
		int yPos = e.getY();
		
		
		if (e.getButton()== 1){
			//System.out.println("Left Click");
			
			if (Game.newGame && hud.buildLevelButton.getBounds().contains(xPos, yPos)){
				Game.newGame = false;
				Game.levelBuilder = true;
			}
			else if(Game.newGame && hud.startLevelsButton.getBounds().contains(xPos, yPos)) {
				Game.startExistingLevels = true;	
				Game.newGame = false;
				Game.simulating = true;
				Game.started = true;
			}
			else if(Game.levelBuilder) {
				
				if (levelParts[selection%levelParts.length].equals("barrier")){
					handler.addObject(new Barrier(xPos, yPos, ID.Barrier));	
				}
				else if (levelParts[selection%levelParts.length].equals("enemy")) {
					handler.addObject(new BasicEnemy(xPos, yPos, ID.BasicEnemy));
				}
				else if (levelParts[selection%levelParts.length].equals("player")) {
					handler.addObject(new Player(xPos, yPos, ID.Player));
				}
				//Can add more else if's with a similar structure (levelParts[selection%levelParts.length].equals("thing to place"))
				
						
						
				
			}
			
			
			//These two get the current player coordinates
			//int xp = handler.object.get(handler.findPlayer()).getX();
			//int yp = handler.object.get(handler.findPlayer()).getY();
			//These two get the mouse's click position
			//int xt = e.getX();
			//int yt = e.getY();
			//handler.addObject(new Bullets(xp, yp, ID.Bullet, Game.WIDTH, Game.HEIGHT, xt, yt));
			//timeClick = System.currentTimeMillis();
			
		}
		if (e.getButton()== 3){
			//System.out.println("Right Click");
			if(Game.levelBuilder) {
				
				for(int i = 0; i < handler.object.size(); i++) {
					GameObject tempObject =  handler.object.get(i);
					//If you right clicked on an existing barrier or enemy, remove it
					if((tempObject.id.equals(ID.Barrier) ||tempObject.id.equals(ID.BasicEnemy) || tempObject.id.equals(ID.Player))&& tempObject.getBounds().contains(xPos, yPos)){
						handler.object.remove(i);
						i--;
					}
					
				}
				
			}
		}
		if (e.getButton()== 2){
			//System.out.println("Middle Click");
			selection++;
		}
		
	}

}
