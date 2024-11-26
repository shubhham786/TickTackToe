package models;

import exception.InvalidGameBuildException;
import strategies.gameWinningStartegy.GameWinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Board board;
    private List<Player> players;
    private List<Move>moves;
    private int nextPlayerIndex;
    private GameState gameState;
    private List<GameWinningStrategy> gameWinningStrategies;

    public List<GameWinningStrategy> getGameWinningStrategies() {
        return gameWinningStrategies;
    }

    public void setGameWinningStrategies(List<GameWinningStrategy> gameWinningStrategies) {
        this.gameWinningStrategies = gameWinningStrategies;
    }
    public Player getWinner() {
        return winner;
    }



    public void setWinner(Player winner) {
        this.winner = winner;
    }

    private Player winner;


    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void displayBoard() {
        board.displayBoard();
    }

    public void makeMove() {

        Player currentPlayer = players.get(nextPlayerIndex);

        System.out.println(currentPlayer.getPlayerName()+"'s turn");
        Move move=currentPlayer.nextMakeMove(this.getBoard());

        //validate move

        int row=move.getCell().getRow();
        int col=move.getCell().getCol();

        System.out.println("Player is playing a move at (" + row + ", " + col + ")");

        //add to move
        moves.add(move);





        //update the board
         board.getBoard().get(row).get(col).setPlayer(currentPlayer);
         board.getBoard().get(row).get(col).setState(CellState.FILLED);

        //checkWinner
        for(GameWinningStrategy gameWinningStrategy : gameWinningStrategies) {

            if(gameWinningStrategy.checkWinner(move)==true)
            {
                this.setWinner(move.getPlayer());
                this.setGameState(GameState.ENDED);
            }
        }

        //check for Draw
        if(moves.size()== board.getDimension()*board.getDimension())
        {
            if(!this.getGameState().equals(GameState.ENDED))
                this.setGameState(GameState.DRAW);
        }


        //next Player index updation
        nextPlayerIndex=(nextPlayerIndex+1)%players.size();

    }
  public static GameBuilder getbuilder()
  {
       return new GameBuilder();
  }

    public static class GameBuilder
    {

        private int dimension;

        private List<Player>players;
        private List<GameWinningStrategy> gameWinningStrategies;

        public GameBuilder setGameWinningStrategies(List<GameWinningStrategy>gameWinningStrategies) {
              this.gameWinningStrategies = gameWinningStrategies;
               return this;
        }


        public GameBuilder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public GameBuilder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

          public boolean isValid() throws InvalidGameBuildException {

                if(dimension <3){

                    throw new InvalidGameBuildException("dimension should be at least 3");
                }

                if(players.size() < dimension-1  || players.size() >= dimension){

                    throw new InvalidGameBuildException("There should be exactly "+(dimension-1)+" players");
                }
              //more validation
                return true;
          }
        public Game build() throws InvalidGameBuildException {

             isValid();
           Game game=new Game();
           game.setPlayers(players);
           game.setGameWinningStrategies(gameWinningStrategies);
           game.setBoard(new Board(dimension));
           game.setGameState(GameState.IN_PROGRESS);
           game.setNextPlayerIndex(0);
           game.setMoves(new ArrayList<>());
           return game;

        }
    }
}
