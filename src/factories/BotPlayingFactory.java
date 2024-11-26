package factories;

import models.BotDifficulityLevel;
import strategies.botPlayingStrategy.BotPlayingStrategy;
import strategies.botPlayingStrategy.EasyBotPlayingStrategy;
import strategies.botPlayingStrategy.MediumBotPlayingStrategy;

public class BotPlayingFactory {

     public static BotPlayingStrategy createBotPlayingStrategy(BotDifficulityLevel difficulty) {

         if(difficulty.equals(BotDifficulityLevel.EASY))
             return new EasyBotPlayingStrategy();
         if(difficulty.equals(BotDifficulityLevel.MEDIUM))
              return new MediumBotPlayingStrategy();

         return null;

     }

}
