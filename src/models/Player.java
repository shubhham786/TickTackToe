package models;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Player {
    
    private char symbol;
    private String playerName;
    private PlayerType playerType;

    public Player(char symbol, String playerName, PlayerType playerType) {
        this.symbol = symbol;
        this.playerName = playerName;
        this.playerType = playerType;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Move nextMakeMove(Board board)
    {

        while(true) {
            System.out.println("Enter the row where you want to go");
            Scanner sc = new Scanner(System.in);
            int row = sc.nextInt();
            System.out.println("Enter the column where you want to go");
            int col = sc.nextInt();

            if (board.getBoard().get(row).get(col).getState().equals(CellState.AVAILABLE)) {

                return new Move(new Cell(this, row, col, CellState.FILLED), this);
            }
            else
            {
                 System.out.println("cell is already filled");
                System.out.println("try again");
            }

        }


    }
}
