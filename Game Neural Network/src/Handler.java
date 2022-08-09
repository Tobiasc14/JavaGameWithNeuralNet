import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;




public class Handler {

	List<String> levelList = new ArrayList<String>();
	public Scanner sc;
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	File tempFile = new File("GameData.csv");
	public int levelNumber = 0;
	String tempString = "";
	public int currentLevel;
	boolean up = false;
	boolean down= false;
	boolean left = false;
	boolean right = false;
	
	
	
	
	public void tick() {
		if(Game.levelBuilder && Game.started == false) {
			
		}
		else if(Game.startExistingLevels) {
			Game.startExistingLevels = false;
			Game.started = true;
			loadLevel(4,levelList);							
		}
		else if (Game.levelBeaten) {
			Game.levelBeaten = false;
			levelNumber++;
			loadLevel(levelNumber,levelList);
			
		}
		else {
			runLevel();
			
		}
		
	}
	public void runLevel() {
		for(int i = 0; i < object.size();i++){
			GameObject tempObject = object.get(i);
			if (tempObject.remove) {
				this.removeObject(tempObject);				
			}			
			//Players movement
			else if (tempObject.id.equals(ID.Player)){
				if(up) {
					tempObject.setY(tempObject.getY()-2);
				}
				if(down) {
					tempObject.setY(tempObject.getY()+2);
				}
				if(left) {
					tempObject.setX(tempObject.getX()-2);
				}
				if(right) {
					tempObject.setX(tempObject.getX()+2);
				}
				else {
					tempObject.setVelocityX(0);
					tempObject.setVelocityY(0);
				}			
							
			}
			//Collision detection
			
			else {
				for(int j = 0; j < object.size(); j++) {
					GameObject tempObject2 = object.get(j);	
					
					if(tempObject.getID().equals(ID.BasicEnemy)){
						if (tempObject2.getID().equals(ID.Player)) {
							if(tempObject.getBounds().intersects(tempObject2.getBounds())) {
								getPlayer().loseHealth(1);
								
							}
						}
						if (tempObject2.getID().equals(ID.Bullet)) {
							if(tempObject.getBounds().intersects(tempObject2.getBounds())) {
								tempObject.remove = true;
								tempObject2.remove = true;
							}
						}
						
					}
					
					
					else if(tempObject.getID().equals(ID.Barrier)) {				
						
						//If barrier is intersecting player
						//undo movement motion					
						if(tempObject2.getID().equals(ID.Player)&&tempObject.getBounds().intersects(tempObject2.getBounds())) {
							if(up) {
								tempObject2.setY(tempObject2.getY()+2);
							}
							if(down) {
								tempObject2.setY(tempObject2.getY()-2);
							}
							if(left) {
								tempObject2.setX(tempObject2.getX()+2);
							}
							if(right) {
								tempObject2.setX(tempObject2.getX()-2);
							}						
						}
						//if bullet intersects with barrier, remove bullet
						else if(tempObject2.getID().equals(ID.Bullet) && tempObject.getBounds().intersects(tempObject2.getBounds())) {
							tempObject2.remove = true;
						}
						
						//If Enemy collides with a barrier, change direction of velocity and keep moving
						else if(tempObject2.getID().equals(ID.BasicEnemy)&&tempObject.getBounds().intersects(tempObject2.getBounds())) {
							tempObject2.setX(tempObject2.x-tempObject2.getVelocityX());
							if(tempObject.getBounds().intersects(tempObject2.getBounds())) {
								tempObject2.setY(tempObject2.y-tempObject2.getVelocityY());
								tempObject2.setVelocityY(-tempObject2.velocityY);
							}
							else {
								tempObject2.setVelocityX(-tempObject2.velocityX);
							}
						}
					}
				}
				
			}
			tempObject.tick();
				
				
		}
	
			
			
		
	}
	public void loadLevel(int currLevel, List<String> levelList ) {
		int count = 0;
		boolean correctLevel = false;
		for (int i = 0; i < levelList.size(); i++) {					
			tempString = levelList.get(i);
			
			if (tempString.substring(0,5).equals("level") && count == currLevel) {	
				levelNumber = Integer.valueOf(tempString.substring(6,7));
				count++;
				correctLevel = true;
				
				
			}
			else if (tempString.substring(0,5).equals("level") && count > currLevel) {
				i = levelList.size();
				correctLevel = false;
			}
			else if (correctLevel) {
				
				if (tempString.split(",")[0].equals("Barrier")) {
					object.add(new Barrier(Integer.valueOf(tempString.split(",")[1]), Integer.valueOf(tempString.split(",")[2]), ID.Barrier));	
				}
				else if (tempString.split(",")[0].equals("BasicEnemy")) {
					object.add(new BasicEnemy(Integer.valueOf(tempString.split(",")[1]), Integer.valueOf(tempString.split(",")[2]), ID.BasicEnemy));
				}
				else if (tempString.split(",")[0].equals("Player")) {
					object.add(new Player(Integer.valueOf(tempString.split(",")[1]), Integer.valueOf(tempString.split(",")[2]), ID.Player));
				}
			}
			else if (tempString.substring(0,5).equals("level")){
				count++;
				correctLevel = false;
			}
		}
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < object.size(); i ++){
			GameObject tempObject = object.get(i);
			tempObject.render(g);
		}
	}
	
	public void addObject(GameObject object){
		this.object.add(object);
	}

	public void removeObject(GameObject object){
		this.object.remove(object);
	}
	
	public void removeAllObjects() {
		while (this.object.size() > 0) {
			GameObject tempObject = object.get(0);
			removeObject(tempObject);
		}
		
	}
	public Player getPlayer() {
		for (int i = 0; i < this.object.size();i++) {
			if (object.get(i).id.equals(ID.Player)){
				return (Player) object.get(i);				
			}
		}
		return null;
	}

}
