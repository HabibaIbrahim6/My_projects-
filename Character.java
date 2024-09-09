import java.util.Random;
public class Character extends Monster {
    private int row;
    private int col;
    public int power = 10; // Initial power value
    public int health = 10; // Initial health value
    private int powerIncrease;
    private int healthIncrease;
    private static final int POWER_MONSTER_THRESHOLD = 5;
    private static final Random rand = new Random();
    public Character(int startRow, int startCol) {
        super();
        this.row = startRow;
        this.col = startCol;
        this.powerIncrease = rand.nextInt(10);
        this.healthIncrease = rand.nextInt(10);
    }

    public Character() {
    }

    public void move(char direction, Maze maze) throws InvalidMoveException{
        int newRow = row;
        int newCol = col;
        switch (direction) {
            case 'w':
                if (row == 0) {
                    throw new InvalidMoveException("Cannot move up, you are at the top edge.");
                }

                newRow--; break;
            case 's':
                if (row == maze.SIZE - 1) {
                    throw new InvalidMoveException("Cannot move down, you are at the bottom edge.");
                }
                newRow++; break;
            case 'a':
                if (col == 0) {
                    throw new InvalidMoveException("Cannot move left, you are at the left edge.");
                }
                newCol--; break;
            case 'd':
                if (col == maze.SIZE - 1) {
                    throw new InvalidMoveException("Cannot move right, you are at the right edge.");
                }
                newCol++; break;
            default:
                throw new InvalidMoveException("Invalid direction");
        }
            if (newRow >= 0 && newRow < maze.SIZE && newCol >= 0 && newCol < maze.SIZE) {
                String cell = maze.arr[newRow][newCol];
                if (cell.equals("P")) {
                    power += powerIncrease;
                    maze.arr[newRow][newCol] = "*";
                    System.out.println("Power increased by " + powerIncrease + ". New power: " + power);
                } else if (cell.equals("H")) {
                    health += healthIncrease;
                    maze.arr[newRow][newCol] = "*";
                    System.out.println("Health increased by " + healthIncrease + ". New health: " + health);
                } else if (cell.equals("M")) {
                    if (power >= power_Monster) {
                        maze.arr[newRow][newCol] = "A";
                        maze.decreaseMonsterCount();
                    } else {
                        power -= power_Monster;
                        if (power <= 0) {
                            System.out.println("you lost your power = 0");
                            return;

                        }
                    }
                }
                maze.arr[row][col] = "*";
                row = newRow;
                col = newCol;
                maze.arr[row][col] = "A";
                if (maze.areAllMonstersDefeated()) {
                    System.out.println("Congratulations! You have defeated all the monsters.");
                    System.exit(0); // End the game
                }
            } else {
                System.out.println("Move out of bounds");

        }
    }
    public boolean isLost() {
        return false;
    }
    public class InvalidMoveException extends Exception {
        public InvalidMoveException(String message) {
            super(message);
        }
    }
    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }
    public int getPower() {
        return power;
    }
    public int getHealth() {
        return health;
    }
}
