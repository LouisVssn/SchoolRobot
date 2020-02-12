/** A rover that looks before it moves. */
public class LVRobot extends Creature {
    
    static private int [][] ay;
	
    public void run() {
        
    	int width = getMapDimensions().width;
    	int height = getMapDimensions().height;
    	ay = new int [height][width];
    	
    	printMap(height, width, ay);
    	
    	
    	while (true) {
    		
    		Observation obs = observe()[0];
            
    		turnLeft();
    		
    		for(int u = 0; u < 100000; u++) {
    		moveForward();
    			if(!moveForward()) {
    				attack();
    			}else {
    				moveForward();
    			}
    		
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
    
    
    
  

    @Override
	public String getAuthorName() {
        return "Darwin SDK";
    }

    @Override
	public String getDescription() {
        return "A rover that looks before it moves.";
    }
}
