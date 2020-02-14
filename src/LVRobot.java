import java.util.Random;

public class LVRobot extends Creature {
	static private Random r = new Random();

	@Override
    public void run() {

		final int width = getMapDimensions().width;
		final int height = getMapDimensions().height;
		Observation [][] map = new Observation[width][height];

		while (true) {
			Observation[] obs = observe();
			for (int u = 0; u < 100000; u++) {
				moveForward();
				if (!moveForward()) {
					attack();
					turn90Random2();
					moveForward();
				} else {
					moveForward();
				}
				printMap(height, width, map);
				}
			
    		}
    	
		}

	public void turn90Random2() {
		switch (r.nextInt(2)) {
			case 0:
				turnLeft();
				break;

			case 1:
				turnRight();
				break;
		}
	}

	//print Map in a StringBuilder and sets a value for a type
	public void printMap(int height, int width, Observation[][] map) {
		StringBuilder textMap = new StringBuilder();
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				if(x == width) {
					textMap.append("\n");
				}
				if(map[x][y] == null) {
					textMap.append("#");
				}
				//TODO: FEHLER
				if(map[x][y].type == Type.WALL) {
					textMap.append("X");
				}
				textMap.append(map[x][y]);
			}
		}
		System.out.print(textMap);
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
