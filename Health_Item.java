import java.util.Random;
class HealthItem extends Item {
    Random rand = new Random();
    public HealthItem(int row, int col) {
        super(row, col);
    }
    public void placeHealth(String[][] arr, Random rand) {
        int healthPlaced = 0;
        while (healthPlaced < MAX_ITEMS) {
            int row = rand.nextInt(SIZE);
            int col = rand.nextInt(SIZE);
            if (arr[row][col].equals("*")) {
                arr[row][col] = "H";
                healthPlaced++;
            }
        }
    }
}