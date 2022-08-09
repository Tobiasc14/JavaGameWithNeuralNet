import java.awt.Graphics;
import java.awt.Rectangle;

//any object in the game is a game object, so they will implement this class
//so we don't have to define 
public abstract class GameObject {
	//protected means only things that inherit GameObject can
	//Access these variables
	protected int x;
	protected int y;
	protected ID id;
	protected int velocityX, velocityY;
	protected int gameWidth;
	protected int gameHeight;
	boolean remove = false;
	
	
	public GameObject(int x, int y, ID id){
		
		this.x = x;
		this.y = y;
		this.id = id;
		
		
		
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void setID(ID id){
		this.id = id;
	}
	public ID getID(){
		return id; 
	}
	public void setVelocityX(int velocityX){
		this.velocityX = velocityX;
	}
	public void setVelocityY(int velocityY){
		this.velocityY = velocityY;
	}
	public int getVelocityX(){
		return velocityX;
	}
	public int getVelocityY(){
		return velocityY;
	}
	
	
	
	
	
}
