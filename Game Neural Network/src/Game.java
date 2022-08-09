import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Game extends Canvas implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1442798787354930462L;
	public static final int WIDTH = 1000, HEIGHT = WIDTH/12*9;
	private Thread thread;
	private boolean running = false;
	private Handler handler;
	private HUD hud;
	private Level level;
	static boolean newGame = true;
	public static boolean levelBuilder = false;
	public static boolean started = false;
	public static boolean simulating = false;
	public static boolean savingLevel = false;
	public static boolean startExistingLevels = false;
	public static boolean levelBeaten = false;
	public static boolean isAlive = true;
	public static String gameName = "Game; The Game";
	Image skin;
	BufferedImage image;
	
	
	
	
	
	public Game() {
		handler = new Handler();
		hud = new HUD(handler, level);
		level = new Level(handler, hud);
		this.addKeyListener(new KeyInput(handler, hud, level));
		this.addMouseListener(new MouseInput(handler, hud));
		
		new Window(WIDTH, HEIGHT, gameName,this);
		try {
			this.skin = ImageIO.read(new File("images/Map Background.png"));
			this.image = (BufferedImage) skin;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	
	public synchronized void stop(){
		try {
			thread.join();
			running = false;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void run(){
		 this.requestFocus();
		 long lastTime = System.nanoTime();
		 double amountOfTicks = 60.0;
		 double optimalTime = 1000000000/amountOfTicks;
		 double delta = 0;
		 int frames = 0;
		 long timer = System.currentTimeMillis();
		 
		 while(running){
			 
			 long now = System.nanoTime();
			 delta = delta + ((now-lastTime)/optimalTime);
			 lastTime = now;
			 while(delta >= 1){
				 tick();
				 delta--;
			 }
			 if(running){
				 render();
			 }
			 //This section updates the FPS once every second
			 //1000ms = 1 second
			 frames++;
			 if(System.currentTimeMillis()-timer>1000){
				 timer +=1000;
				 System.out.println("FPS: " +frames);
				 frames = 0;
			 }
		 }
		 stop();
		 
		 
		
	}
	 private void tick(){
		 handler.tick();
		 level.tick();
		 hud.tick();
		 
	 }
	 public static int clamp(int var, int min, int max){
		 if(var<min){
			 return min;
		 }
		 else if(var>max){
			 return max;
		 }
		 else{
			 return var;
		 }
		 
	 }
	 public static int exclude(int var, int min, int max){
		 if(var>min){
			 return min;
		 }
		 else if(var<max){
			 return max;
		 }
		 else{
			 return var;
		 }
	 }
	 

	 
	private void render(){
		 //This forces the game to slow down the number of frames
		 //it creates by creating a buffer
		 BufferStrategy bs = this.getBufferStrategy();
		 if(bs == null){
			 this.createBufferStrategy(4);
			 return;
		 }
		 
		 Graphics g = bs.getDrawGraphics();
		 Graphics2D g2 = (Graphics2D) g;
		 /**
		 g.setColor(Color.gray);
		 g.fillRect(0, 0, WIDTH, HEIGHT);
		 
		 
		 */
		 g2.drawImage(image, 0, 0, null);
		 handler.render(g);
		 hud.render(g);
		 g.dispose();
		 bs.show();
	 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Game();

	}

}
