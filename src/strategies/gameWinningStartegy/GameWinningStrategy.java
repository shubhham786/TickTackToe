package strategies.gameWinningStartegy;

import models.Move;

public interface GameWinningStrategy {

    boolean checkWinner(Move move);
}
