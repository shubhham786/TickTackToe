package strategies.gameWinningStartegy;

import models.Move;

import java.util.HashMap;

public class DiagonalWinningStrategy implements GameWinningStrategy{

    // row == col for main diagonal
    private HashMap<Character, Integer> mainDiagonal;
    // row + col == dimension-1 for anti-diagonal
    private HashMap<Character, Integer> antiDiagonal;
    private int dimension;

    public DiagonalWinningStrategy(int dimension) {
        this.dimension = dimension;
        mainDiagonal = new HashMap<>();
        antiDiagonal = new HashMap<>();
    }

    private boolean checkMainDiagonal(char symbol) {
        mainDiagonal.put(symbol, mainDiagonal.getOrDefault(symbol, 0) + 1);
        return mainDiagonal.get(symbol) == dimension;
    }

    private boolean checkAntiDiagonal(char symbol) {
        antiDiagonal.put(symbol, antiDiagonal.getOrDefault(symbol, 0) + 1);
        return antiDiagonal.get(symbol) == dimension;
    }


    public boolean checkWinner(Move move) {

        boolean winner = false;
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        char symbol = move.getPlayer().getSymbol();


        // Check main diagonal (top-left to bottom-right)
        if (row == col) {
            winner=winner || checkMainDiagonal(symbol);
        }

        // Check anti-diagonal (top-right to bottom-left)
        if (row + col == dimension - 1) {
            winner=winner || checkAntiDiagonal(symbol);
        }

        return winner;
    }

}
