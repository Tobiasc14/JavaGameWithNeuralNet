import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {
	
	
	private Handler handler;
	long timeClick;
	String [] levelParts = {"barrier","enemy"};
	int selection = 0;
	
	
	public MouseInput(Handler handler){
		this.handler = handler;
		timeClick = System.currentTimeMillis();
	}
	
	public void mousePressed(MouseEvent e){
		
		
		
		if (e.getButton()== 1){
			//System.out.println("Left Click");
			
			if(Game.levelBuilder) {
				int xPos = e.getX();
				int yPos = e.getY();
				if (levelParts[selection%levelParts.length].equals("barrier")){
					handler.addObject(new Barrier(xPos, yPos, ID.Barrier));	
				}
				else if (levelParts[selection%levelParts.length].equals("enemy")) {
					handler.addObject(new BasicEnemy(xPos, yPos, ID.BasicEnemy));
				}
						
						
				
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
				int xPos = e.getX();
				int yPos = e.getY();
				for(int i = 0; i < handler.object.size(); i++) {
					GameObject tempObject =  handler.object.get(i);
					//If you right clicked on an existing barrier or enemy, remove it
					if((tempObject.id.equals(ID.Barrier) ||tempObject.id.equals(ID.BasicEnemy))&& tempObject.getBounds().contains(xPos, yPos)){
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
