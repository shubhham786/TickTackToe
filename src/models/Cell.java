package models;

public class Cell {
    
   private  Player player;
     private int row;
     private int col;
     private CellState state;

    public Cell(Player player, int row, int col, CellState state) {
        this.player = player;
        this.row = row;
        this.col = col;
        this.state = state;
    }

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.state=CellState.AVAILABLE;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
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

    public CellState getState() {
        return state;
    }

    public void setState(CellState state) {
        this.state = state;
    }
}
