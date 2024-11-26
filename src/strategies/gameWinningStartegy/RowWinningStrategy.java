package strategies.gameWinningStartegy;

import models.Move;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RowWinningStrategy implements GameWinningStrategy{

    //we will maintain List of Hashmap for each charcther count for each row

    List<HashMap<Character,Integer>> rowMap;
   int dimension;

    public RowWinningStrategy(int dimension) {

        this.dimension = dimension;
        rowMap = new ArrayList<>();
        for (int i = 0; i < dimension; i++) {
            rowMap.add(new HashMap<>());
        }
    }

    @Override
    public boolean checkWinner(Move move) {
        // Get the row where move was made
        int row = move.getCell().getRow();
        char symbol = move.getPlayer().getSymbol();

        // Get or initialize count for this symbol in this row
        HashMap<Character, Integer> currentRowMap = rowMap.get(row);
        currentRowMap.put(symbol, currentRowMap.getOrDefault(symbol, 0) + 1);

        // If count equals board dimension, we have a winner
        return currentRowMap.get(symbol) == dimension;
    }

    //undo



}
