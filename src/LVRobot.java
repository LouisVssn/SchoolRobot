import java.util.Random;

public class LVRobot extends Creature {
    static private Random rnd = new Random();

    @Override
    public void run() {

        final int width = getMapDimensions().width;
        final int height = getMapDimensions().height;
        Observation[][] map = new Observation[width][height];

        while (true) {
            Observation[] obs = observe();
            //Type a = obs[1].type;
            for (int i = 0; i < obs.length; i++) {
                map[obs[i].position.x][obs[i].position.y] = obs[i];
            }


            for (int u = 0; u < 100000; u++) {
                moveForward();
                if (!moveForward()) {
                    attack();
                    turn90Random();
                    moveForward();
                } else {
                    moveForward();
                }
                printMap(height, width, map);
            }
        }
    }

    public void turn90Random() {
        switch (rnd.nextInt(2)) {
            case 0:
                turnRight();
                break;
            case 1:
                turnLeft();
                break;
        }
    }

    //print Map in a StringBuilder and sets a value for a type
    public void printMap(int height, int width, Observation[][] map) {
        String typ = ".type";
        StringBuilder textMap = new StringBuilder();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (x == width) {
                    textMap.append("\n");
                }
                if (map[x][y] == null) {
                    textMap.append("#");
                }
                //TODO: FEHLER
                if (map[x][y].type == Type.WALL && map[x][y] != null) {
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
        return "A Robot.";
    }
}
