public class Maze {
    protected String[][] arr = new String[10][10];
    static final int SIZE = 10;
    static final int MAX_MONSTERS = 10;
    static final int MAX_ITEMS = 10;
    int playerRow = 0;
    int playerCol = 0;
    int remainingMonsters = MAX_MONSTERS;
    Maze() {
        arr = new String[SIZE][SIZE];
        initializeMaze();
        remainingMonsters = MAX_MONSTERS;
    }
    public void initializeMaze() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                arr[i][j] = "*";
            }
        }
    }
    public void printMaze(Character character) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Power = " + character.getPower() + " Health = " + character.getHealth());
    }
    public void decreaseMonsterCount() {
        remainingMonsters--;
    }
    public boolean areAllMonstersDefeated() {
        return remainingMonsters <= 0;
    }
}