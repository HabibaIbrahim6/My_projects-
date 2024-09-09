import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            boolean playAgain = true;
            while (playAgain) {
                System.out.println("Do you want to play? (y/n): ");
                String answer = sc.nextLine();
                if (answer.equalsIgnoreCase("y")) {
                    Maze maze = new Maze();
                    Random rand = new Random();
                    Monster d = new Monster();
                    d.placeMonsters(maze, rand);
                    PowerItem powerItem = new PowerItem(0, 0);
                    powerItem.placePower(maze.arr, rand);
                    HealthItem healthItem = new HealthItem(0, 0);
                    healthItem.placeHealth(maze.arr, rand);
                    Character character = new Character(maze.playerRow, maze.playerCol);
                    maze.arr[maze.playerRow][maze.playerCol] = "A";
                    boolean running = true;

                    while (running) {
                        maze.printMaze(character);
                        System.out.println("Enter direction (w, a, s, d) or 'e' to Exit:");
                        char direction = sc.nextLine().charAt(0);

                        if (direction == 'e') {
                            running = false;
                        } else {
                            try {
                                character.move(direction, maze);
                                if (character.isLost()) {
                                    System.out.println("You have lost. Do you want to play again? (y/n): ");
                                    String playAgainResponse = sc.nextLine();
                                    if (playAgainResponse.equalsIgnoreCase("n")) {
                                        playAgain = false;
                                    }
                                    running = false; // Exit the current game loop
                                }
                            } catch (Character.InvalidMoveException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                } else if (answer.equalsIgnoreCase("n")) {
                    playAgain = false;
                } else {
                    System.out.println("Invalid input. Please enter 'y' or 'n'.");
                }
            }

            System.out.println("Thanks for playing!");
        } finally {
            sc.close();
        }
    }
}
