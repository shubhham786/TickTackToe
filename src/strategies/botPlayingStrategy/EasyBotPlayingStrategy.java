package strategies.botPlayingStrategy;

import models.*;

import java.util.Random;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {

    @Override
    public Move makeMove(Board board, Player player) {



        for(int i=0;i<board.getDimension();i++)
        {

             for(int j=0;j<board.getDimension();j++)
             {
                  if(board.getBoard().get(i).get(j).getState().equals(CellState.AVAILABLE))
                 {
                     return new Move(new Cell(player,i,j,CellState.FILLED),player);
                 }
             }
        }

        return null;
    }
}
