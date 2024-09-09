import java.util.Random;
class PowerItem extends Item {
    Random rand = new Random();
    public PowerItem(int row, int col) {
        super(row, col);
    }
    public void placePower(String[][] arr, Random rand) {
        while (powerPlaced < MAX_ITEMS) {
            int row = rand.nextInt(SIZE);
            int col = rand.nextInt(SIZE);
            if (arr[row][col].equals("*")) {
                arr[row][col] = "P";
                powerPlaced++;
            }
        }
    }}