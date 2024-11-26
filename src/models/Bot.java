package models;

import factories.BotPlayingFactory;
import strategies.botPlayingStrategy.BotPlayingStrategy;

public class Bot extends Player {

    private BotDifficulityLevel difficulty;
    private BotPlayingStrategy strategy;

    public Bot(char symbol, String playerName,BotDifficulityLevel difficulty) {
        super(symbol, playerName, PlayerType.BOT);
        this.difficulty = difficulty;
        this.strategy = BotPlayingFactory.createBotPlayingStrategy(difficulty);
    }

    public BotDifficulityLevel getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(BotDifficulityLevel difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public Move nextMakeMove(Board board) {

       return strategy.makeMove(board, this);
    }
}
