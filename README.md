# Advanced Tic-tac-toe Game

A Java-based implementation of the classic Tic-tac-toe game with additional features like variable board sizes, bot players, and multiple winning strategies.

## Features

- 🎮 Variable board dimensions (minimum 3x3)
- 🤖 Support for both Human and Bot players
- 🎯 Multiple winning strategies:
  - Row winning condition
  - Column winning condition
  - Diagonal winning condition
- 🎲 Different bot difficulty levels
- 📊 Clean object-oriented design using design patterns
- 🖥️ Console-based user interface with grid display

## Project Structure

```
src/
├── controllers/
│   └── GameController.java
├── models/
│   ├── Board.java
│   ├── Cell.java
│   ├── Game.java
│   ├── Move.java
│   ├── Player.java
│   └── Bot.java
├── strategies/
│   ├── botPlayingStrategy/
│   └── gameWinningStartegy/
│       ├── RowWinningStrategy.java
│       ├── ColumnWinningStrategy.java
│       └── DiagonalWinningStrategy.java
├── factories/
└── exception/
```

## Design Patterns Used

- Builder Pattern: For Game object creation
- Strategy Pattern: For winning strategies and bot playing strategies
- Factory Pattern: For creating different types of players
- Model-View-Controller (MVC): Overall architectural pattern

## How to Run

1. Clone the repository:
```bash
git clone https://github.com/shubhham786/TickTackToe.git
```

2. Navigate to the project directory:
```bash
cd TickTackToe
```

3. Compile the Java files:
```bash
javac TickTackGame.java
```

4. Run the game:
```bash
java TickTackGame
```

## Gameplay Instructions

1. Enter the dimension of the board (minimum 3)
2. The game alternates between players
3. Enter row and column numbers to make a move
4. First player to complete a row, column, or diagonal wins

## Sample Game Play

```
Tick Tack Game
Enter the dimension of Board:
3

| X |   |   |
| O | X |   |
|   |   | X |

Player 1's turn (X)
Enter row (0-2): 1
Enter column (0-2): 1
```

## Future Enhancements

- [ ] Add game state save/load functionality
- [ ] Implement an undo feature
- [ ] Add network multiplayer support
- [ ] Create a graphical user interface
- [ ] Add game statistics tracking
- [ ] Support for custom board shapes

## Dependencies

- Java 8 or higher
- No external libraries required

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request
