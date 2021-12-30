

import java.awt.event.KeyAdapter;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	private HUD hud;
	private Level level;
	private boolean uP = false;
	private boolean dP = false;
	private boolean lP = false;
	private boolean rP = false;
	private boolean sP = false;
	private boolean gP = false;
	private int time;
	private int curTime;

	public KeyInput(Handler handler, HUD hud, Level level){
		this.handler=handler;
		this.hud = hud;
		this.level = level;
		
	}
	

	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		if(Game.newGame && key == KeyEvent.VK_B) {
			Game.newGame = false;
			Game.levelBuilder = true;
		}
		if(Game.levelBuilder && key == KeyEvent.VK_S) {
			Game.newGame = false;
			Game.levelBuilder = false;
			Game.started = true;
		}


/**
		for (int i =0; i < handler.object.size();i++){
			GameObject tempObject = handler.object.get(i);

			if(tempObject.getID()== ID.Player){
				if(key == KeyEvent.VK_W){
					uP=true;
					tempObject.setVelocityY(-2);
				}
				if(key == KeyEvent.VK_A){
					lP=true;
					tempObject.setVelocityX(-2);
				}
				if(key == KeyEvent.VK_S){
					dP=true;
					tempObject.setVelocityY(2);
				}
				if(key == KeyEvent.VK_D){
					rP=true;
					tempObject.setVelocityX(2);
				}
				if(key == KeyEvent.VK_SPACE){
					sP=true;
					tempObject.setVelocityY(-7);
				}



			}
			if(!handler.isAlive() && key == KeyEvent.VK_R){
				handler.setLifeStatus(true);


				handler.addObject(new Player(0, 0, ID.Player, Game.WIDTH, Game.HEIGHT));
				

			}
			

		}
		if(!handler.enemies && key == KeyEvent.VK_N) {
			System.out.println("Button Press Registered");
			level.ready();
			level.level++;
			//handler.enemies = true;
			//hud.tick();
			//handler.tick();
			
		}
		if (!handler.isAlive() && handler.enemies && key == KeyEvent.VK_T) {
			level.level = 0;
			level.ready();
			level.restart = true;
			handler.tick();
			handler.setLifeStatus(true);
		}


		//System.out.println(key);
		 * 
		 */
	}
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		/**
		for (int i =0; i < handler.object.size();i++){
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getID()== ID.Player){
				if(key == KeyEvent.VK_W){
					uP=false;
					if(dP){
						tempObject.setVelocityY(2);
					}
					else{
						tempObject.setVelocityY(0);
					}
				}
				if(key == KeyEvent.VK_A){
					lP=false;
					if(rP){
						tempObject.setVelocityX(2);
					}
					else{
						tempObject.setVelocityX(0);
					}

				}
				if(key == KeyEvent.VK_S){
					dP=false;
					if(uP){
						tempObject.setVelocityY(-2);
					}
					else{
						tempObject.setVelocityY(0);
					}

				}
				if(key == KeyEvent.VK_D){
					rP=false;
					if(lP){
						tempObject.setVelocityX(-2);
					}
					else{
						tempObject.setVelocityX(0);
					}

				}
				if(key == KeyEvent.VK_SPACE){
					
					sP=false;
					if(sP){
						tempObject.setVelocityY(-7);
					}
					else{
						while(tempObject.getVelocityY()<14){
						
							tempObject.setVelocityY(tempObject.getVelocityY()+1);
							handler.tick();
							
							
							
							
						}
						tempObject.setVelocityY(0);
						
					}

				}
			}

		}
		**/

	}

}
