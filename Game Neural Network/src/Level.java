import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Level {
	
	private Handler handler;
	private HUD hud;
	public FileWriter writer;
	public Scanner sc;
	boolean fileExists;

	
	
	public Level(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
		File tempFile = new File(("GameData.csv"));
		fileExists = tempFile.exists();
		System.out.println(fileExists);
		
		
		
		
		
		
		
	}

	public void tick() {
		// TODO Auto-generated method stub
		if (Game.savingLevel) {
			Game.savingLevel = false;
			try {
				writer = new FileWriter("GameData.csv");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for (int i = 0; i < handler.object.size(); i++) {
				GameObject tempObject = handler.object.get(i);
				try {
					
					writer.append(Integer.toString(tempObject.getX()) + "," + Integer.toString(tempObject.getY()) + "," + tempObject.id);
					writer.append("\n");
					writer.flush();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
	}

}
