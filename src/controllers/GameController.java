package controllers;

import exception.InvalidGameBuildException;
import models.Game;
import models.GameState;
import models.Player;
import strategies.gameWinningStartegy.GameWinningStrategy;

import java.util.List;

public class GameController {

    //start game
    //display Board
    //check winner
    //undo
    //executeNextMove

    public Game startGame(int dimension, List<Player> players, List<GameWinningStrategy> gameWinningStrategies)
    {
        try {
            return  Game.getbuilder().setDimension(dimension).setPlayers(players).setGameWinningStrategies(gameWinningStrategies).build();
        } catch (InvalidGameBuildException e) {
             System.out.println(e.getMessage());
             return null;
        }
    }

    //display
    public void display(Game game)
    {
      game.displayBoard();
    }

  //check winner
   public Player checkWinner(Game game)
   {
        return game.getWinner();
   }

    public void nextMove(Game game)
    {
        game.makeMove();
    }

    public GameState getGameState(Game game)
    {
         return game.getGameState();
    }


    //undo



}
