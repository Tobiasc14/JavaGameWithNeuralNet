import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Level {
	
	private Handler handler;
	private HUD hud;
	public FileWriter writer;
	public Scanner sc;
	boolean fileExists;
	int levelNumber = 0;
	List<String> tempList = new ArrayList<String>();
	
	
	public Level(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
		File tempFile = new File(("GameData.csv"));
		fileExists = tempFile.exists();
		System.out.println(fileExists);
		
		if (fileExists){
			try {
				sc = new Scanner(tempFile);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sc.useDelimiter("\n");
			while(sc.hasNext()){
				tempList.add(sc.next());
			}
			handler.levelList = tempList;
		}	
		
		
	}

	public void tick() {
		// TODO Auto-generated method stub
		
		if (Game.savingLevel) {
			Game.savingLevel = false;
			levelNumber++;
			try {
				
				
				
				writer = new FileWriter("GameData.csv");
				fileExists = true;
				//Assuming there is game data, write it to the new file before adding additional level data
				for (int i = 0; i < tempList.size(); i++) {
					writer.append(tempList.get(i));
					writer.append("\n");
					writer.flush();
				}
				writer.append("level" + ',' + Integer.toString(levelNumber));
				writer.append("\n");
				writer.flush();
				
				for (int i = 0; i < handler.object.size(); i++) {
					GameObject tempObject = handler.object.get(i);					
					writer.append(Integer.toString(tempObject.getX()) + "," + Integer.toString(tempObject.getY()) + "," + tempObject.id);
					writer.append("\n");
					writer.flush();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();				
			}
		}
		
	}

}
