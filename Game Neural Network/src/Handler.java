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
	
	
	
	public void tick() {
		if(Game.levelBuilder && Game.started == false) {
			
		}
		else if(Game.startExistingLevels) {
			Game.startExistingLevels = false;
			Game.started = true;
			loadLevel(0,levelList);							
		}
		else {
			runLevel();
			
		}
	}
	public void runLevel() {
		for(int i = 0; i < object.size();i++){
			GameObject tempObject = object.get(i);
			tempObject.tick();
			for(int j = 0; j < object.size(); j++) {
				GameObject tempObject2 = object.get(j);				
			
				//If Enemy collides with a barrier					
				if (tempObject.getID().equals(ID.Barrier)&& !(tempObject2.getID().equals(ID.Barrier)) &&tempObject2.getBounds().intersects(tempObject.getBounds())) {
					//This will be what to do if the barrier intersects something else
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
	public void loadLevel(int currLevel, List<String> levelList ) {
		for (int i = 0; i < levelList.size(); i++) {					
			tempString = levelList.get(i);
			
			
			//Since there are multiple levels potentially stored in the csv file, need way of loading only one at a time
			//Could potentially make multiple csv files, one per level
			//Could also find way of just separating existing file into multiple lists, each corresponding to a level
			//Maybe make list of lists? each inner list contains singular level, outer list holds levels
			if (tempString.substring(0,5).equals("level") && i==0) {	
				levelNumber = Integer.valueOf(tempString.substring(6));
				
			}
			else if (tempString.substring(0,5).equals("level") && i != 0) {
				i = levelList.size();
			}
			else {
				;
				if (tempString.split(",")[0].equals("Barrier")) {
					object.add(new Barrier(Integer.valueOf(tempString.split(",")[1]), Integer.valueOf(tempString.split(",")[2]), ID.Barrier));	
				}
				else if (tempString.split(",")[0].equals("BasicEnemy")) {
					object.add(new BasicEnemy(Integer.valueOf(tempString.split(",")[1]), Integer.valueOf(tempString.split(",")[2]), ID.BasicEnemy));
				}
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

}
