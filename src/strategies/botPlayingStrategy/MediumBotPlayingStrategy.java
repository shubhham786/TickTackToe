package strategies.botPlayingStrategy;

import models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MediumBotPlayingStrategy implements BotPlayingStrategy {
    private Random random;

    public MediumBotPlayingStrategy() {
        this.random = new Random();
    }

    @Override
    public Move makeMove(Board board, Player player) {
        int dimension = board.getDimension();
        List<Cell> emptyCells = new ArrayList<>();

        // Find all empty cells
        for(int i = 0; i < dimension; i++) {
            for(int j = 0; j < dimension; j++) {
              if(board.getBoard().get(i).get(j).getState().equals(CellState.AVAILABLE))
              {
                  emptyCells.add(board.getBoard().get(i).get(j));
              }

            }
        }

        if(emptyCells.isEmpty()) {
            return null;
        }

        // Pick a random empty cell
        int randomIndex = random.nextInt(emptyCells.size());
        Cell selectedCell = emptyCells.get(randomIndex);

        return new Move(selectedCell, player);
    }
}
