import controllers.GameController;
import models.*;
import strategies.gameWinningStartegy.ColumnWinningStrategy;
import strategies.gameWinningStartegy.DiagonalWinningStrategy;
import strategies.gameWinningStartegy.GameWinningStrategy;
import strategies.gameWinningStartegy.RowWinningStrategy;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TickTackGame {


    public static void main(String[] args) {

        System.out.println("Tick Tack Game");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the dimension of Board:");
        int dimension = input.nextInt();

        List<Player> players = new ArrayList<Player>();
        players.add(new Player('X',"Shubham", PlayerType.HUMAN));
        players.add(new Bot('O',"Bot", BotDifficulityLevel.MEDIUM));

         List<GameWinningStrategy> gameWinningStrategies = new ArrayList<>();
         gameWinningStrategies.add(new RowWinningStrategy(dimension));
         gameWinningStrategies.add(new ColumnWinningStrategy(dimension));
         gameWinningStrategies.add(new DiagonalWinningStrategy(dimension));

        GameController gameController=new GameController();

        Game game=gameController.startGame(dimension,players,gameWinningStrategies);

        //player will start playing game


          while(gameController.getGameState(game).equals(GameState.IN_PROGRESS))
          {

              gameController.display(game);
              gameController.nextMove(game);
          }


        gameController.display(game);
        System.out.println("Game Over!");

          if(gameController.getGameState(game).equals(GameState.ENDED))
          {
              System.out.println("This Player won the game "+ gameController.checkWinner(game).getPlayerName());
          }
          else{

              System.out.println("The game ended in draw");
          }


    }
}