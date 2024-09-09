
public abstract class Item {
    protected int powerPlaced = 0;
    static final int SIZE = 10;
    static final int MAX_ITEMS = 10;
    protected int row;
    protected int col;
    public Item(int row, int col) {
        this.row = row;
        this.col = col;
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
    }}