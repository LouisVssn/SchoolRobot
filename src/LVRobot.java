
public class LVRobot extends Creature {

    @Override
    public void run() {

        final int width = getMapDimensions().width;
        final int height = getMapDimensions().height;
        Observation[][] map = new Observation[width][height];

        while (true) {
            Observation[] obs = observe();
            for (int i = 0; i < obs.length; i++) {
                map[obs[i].position.x][obs[i].position.y] = obs[i];
            }
                move(obs);
                printMap(height, width, map);
        }

    }


    //print Map in a StringBuilder and sets a value for a type
    public void printMap(int height, int width, Observation[][] map) {
        StringBuilder textMap = new StringBuilder();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (x == width) {
                    textMap.append("\n");
                }
                if (map[x][y] == null) {
                    textMap.append("#");
                    continue;
                }
                if (map[x][y].type.equals(Type.WALL)) {
                    textMap.append("X");
                }
                textMap.append(map[x][y]);
            }
        }
        System.out.print(textMap);
    }

    public void move(Observation[]obs){
        turnLeft();
        int two = 2;
        int obselenght = observe().length;
        if (obs.length > two){
            if (obselenght == two){
                turnRight();
            }
            moveForward();
        }else {
            attack();
            if (obselenght > two){
                moveForward();
            }else {
                turnRight();
                turnRight();
            }
        }
    }


    @Override
    public String getAuthorName() {
        return "Darwin SDK";
    }

    @Override
    public String getDescription() {
        return "A Robot.";
    }
}
