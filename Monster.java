import java.util.Random;
public class Monster {
    Random rand = new Random();
    int power_Monster = rand.nextInt(10,100);
    private int row;
    private int col;
    private int power;
    public static int counter =0;
    public Monster() {
        this.row = row;
        this.col = col;
        this.power_Monster=power_Monster ;
    }
    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public int getCol() {
        return col;
    }
    public void setCol(int col) {
        this.col = col;
    }
    public int getPower() {
        return power;
    }
    public void setPower(int power) {
        this.power = power;
    }
    static void placeMonsters(Maze maze, Random rand) {
        int monstersPlaced = 0;
        while (monstersPlaced < maze.MAX_MONSTERS) {
            int row = rand.nextInt(maze.SIZE);
            int col = rand.nextInt(maze.SIZE);
            if (maze.arr[row][col].equals("*")) {
                maze.arr[row][col] = "M";
                counter++;
                monstersPlaced++;
            }
        }
    }
    @Override
    public String toString() {
        return "Monster at (" + row + ", " + col + ") with power " + power;
    }

}