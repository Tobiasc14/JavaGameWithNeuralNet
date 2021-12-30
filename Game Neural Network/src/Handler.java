import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	
	
	public void tick() {
		if(Game.levelBuilder) {
			
		}
		else {
			
			for(int i = 0; i < object.size();i++){
				GameObject tempObject = object.get(i);
				tempObject.tick();
				for(int j = 0; j < object.size(); j++) {
					GameObject tempObject2 = object.get(j);				
				
					//If Enemy collides with a barrier					
					if (tempObject.getID().equals(ID.Barrier)&& !(tempObject2.getID().equals(ID.Barrier)) &&tempObject2.getBounds().intersects(tempObject.getBounds())) {
						//This will be what to do if the barrier intersects something else, may need to add a clause that the thing it intersects isn't a barrier
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
