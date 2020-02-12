import java.awt.Dimension;
import java.awt.Point;
import java.util.Random;

/** A rover that looks before it moves. */
public class LVRobot extends Creature {
    
    static private int [][] ay;
    static private Random r = new Random();
	
    public void run() {
        
    	int width = getMapDimensions().width;
    	int height = getMapDimensions().height;
    	ay = new int [height][width];
    	
    	
    	while (true) {
    		
    		Observation obs = observe()[0];
    		
    		for(int u = 0; u < 100000; u++) {
    			moveForward();
    				if(!moveForward()) {
    					attack();
    					turn90Random();
    					moveForward();
    				}else {
    					moveForward();
    					
    				}
    				printMap(height, width, ay);
    			
    			}
    				
    		}
    		
    	}
    
        
    
    
    
    public void printMap(int height, int width, int[][] ay) {
    	for(int i = 0; i < ay.length; i++) {
    		for(int b = 0; b < ay[0].length; b++) {
    			System.out.println(ay[i][b]);
    		}
    		System.out.println("");
    	}
    	System.out.println("");
    	System.out.println("");
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
