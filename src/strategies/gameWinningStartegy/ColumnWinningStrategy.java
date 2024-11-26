package strategies.gameWinningStartegy;

import models.Move;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ColumnWinningStrategy implements GameWinningStrategy {


    private List<HashMap<Character,Integer>> colMap;
    private int dimension;

    public ColumnWinningStrategy(int dimension) {
        this.dimension = dimension;
        colMap = new ArrayList<>();
        for (int i = 0; i < dimension; i++) {
            colMap.add(new HashMap<>());
        }
    }

    @Override
    public boolean checkWinner(Move move) {
        // Get the row where move was made
        int col = move.getCell().getCol();
        char symbol = move.getPlayer().getSymbol();

        // Get or initialize count for this symbol in this row
        HashMap<Character, Integer> currentRowMap = colMap.get(col);
        currentRowMap.put(symbol, currentRowMap.getOrDefault(symbol, 0) + 1);

        // If count equals board dimension, we have a winner
        return currentRowMap.get(symbol) == dimension;
    }
}
