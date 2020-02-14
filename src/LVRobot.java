
import java.util.Random;
import java.lang.StringBuilder;

public class LVRobot extends Creature {
    
    final int width = getMapDimensions().width;
	final int height = getMapDimensions().height;
    Observation[][] map = new Observation[width][height];
    static private Random r = new Random();
	
    public void run() {
    		
    	while (true) {
    		
    		Observation[] obs = observe();
    		for(int xy = 0; xy < obs.length; xy++) {
    			map[obs[xy].position.x][obs[xy].position.y] = obs[xy];
    		}
    		
    		for(int u = 0; u < 100000; u++) {   			
    			moveForward();
    				if(!moveForward()) {
    					attack();
    					turn90Random();
    					moveForward();
    				}else {
    					moveForward();
    				}
    				printMap(height, width, map);
    			
    			}
    		
    		}
    		
    	}
    
    //print Map in a StringBuilder and sets a value for a type     
    public void printMap(int height, int width, Observation[][] a) {
    	StringBuilder textMap = new StringBuilder();
    	for(int x = 0; x < height; x++) {
    		for(int y = 0; y < width; y++) {
    			if(y == width) {
    				textMap.append("\n");
    			}
    			if(map[x][y] == null) {
    				textMap.append("#");
    			}
    			if(map[x][y].type.name() == "WALL") {
    				textMap.append("X");
    			}
    			textMap.append(a[x][y]);
    		}
    	}
    	System.out.print(textMap);
    }
    

    
    public void turn90Random() {
    	switch (r.nextInt(2)) {
    	case 0:
    	    turnLeft();
    	    break;

    	case 1:
    	    turnRight();
    	    break;
    		}
        }
    
   

    @Override
	public String getAuthorName() {
        return "Darwin SDK";
    }

    @Override
	public String getDescription() {
        return "A rover that looks before it moves.";
    }
}
