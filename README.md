```mermaid
classDiagram
direction BT
class ArtificialPlayer {
  + getMove(Cell[][]) int[]
}
class Cell {
  - Player owner
   String representation
   boolean empty
   Player owner
}
class Game {
  + checkWin(int, int) boolean
  + setOwner(int, int, Player) void
  + switchPlayer() void
  + getCell(int, int) Cell
  # isValidMove(int, int) boolean
  + createBoard() void
  + isValidCoordinate(int, int) boolean
   Player currentPlayer
   boolean boardFull
}
class GameChoiceController {
  - GameController currentController
  + chooseGameAndPlayers() GameController
   GameController currentController
}
class GameController {
<<Interface>>
  + resetGame() void
  + playTurn() boolean
  + startGame() void
   int lastMoveCol
   Game game
   int lastMoveRow
}
class GameState {
<<enumeration>>
  + values() GameState[]
  + valueOf(String) GameState
}
class GameView {
<<Interface>>
  + displayWinner(String) void
  + displayMessage(String) void
  + displayGameDraw() void
  + displayBotMove(String, int, int) void
  + displayBoard(Cell[][]) void
}
class Gomoku {
  - checkBothDirections(int, int, int, int) boolean
  # isValidMove(int, int) boolean
  + executeMove(int, int, Player) void
  + checkWin(int, int) boolean
  + switchPlayerTurn() void
  - countInDirection(int, int, int, int, Player) int
   Player currentPlayerTurn
}
class GomokuController {
  - int lastMoveCol
  - int lastMoveRow
  - Gomoku game
  + startGame() void
  + resetGame() void
  + playTurn() boolean
  - handlePlayerMove(Player) boolean
   int lastMoveCol
   Game game
   int lastMoveRow
}
class GomokuView {
  + displayWinner(String) void
  + displayBoard(Cell[][]) void
  + displayMessage(String) void
  + displayGameDraw() void
  + displayBotMove(String, int, int) void
}
class HumanPlayer {
  + getMove(Cell[][]) int[]
}
class IGame {
<<Interface>>
  + switchPlayer() void
  + switchPlayerTurn() void
  + createBoard() void
   Player currentPlayer
}
class InteractionUtilisateur {
  + displayErreurEntree() void
  + askForPlayerChoice() int
  + displayDemandePlacement(String) void
  + displayOutOfBounds() void
  + displayInputError() void
  + displayMessage(String) void
  + displayHorsPlateau() void
  + displayCellOccupied() void
  + nextInt() int
  + displayDejaOccupee() void
  + nextLine() void
  + displayMoveRequest(String) void
  + hasNextInt() boolean
  + askForGameChoice() int
}
class Main {
  + main(String[]) void
}
class Player {
  # String representation
  + getMove(Cell[][]) int[]
   String representation
}
class Power4 {
  + checkWin(int, int) boolean
  + switchPlayerTurn() void
  - countInDirection(int, int, int, int, Player) int
  + isValidMove(int, int) boolean
  + executeMove(int, Player) void
  # checkWin2(int, int) boolean
  + findLowestEmptyRow(int) int
  - checkBothDirections(int, int, int, int) boolean
   Player currentPlayerTurn
}
class Power4Controller {
  - Power4 game
  - int lastMoveCol
  + playTurn() boolean
  + startGame() void
  + resetGame() void
  - handlePlayerMove(Player) boolean
   int lastMoveCol
   Game game
   int lastMoveRow
}
class Power4View {
  + displayBoard(Cell[][]) void
  + displayBotMove(String, int, int) void
  + displayMessage(String) void
  + displayWinner(String) void
  + displayGameDraw() void
}
class StatusMachine {
  - GameState gameState
  - handlePlayingState() void
  + update() void
  - handleMenuState() void
  - handleVictoryState() void
  - handleGameOverState() void
   GameState gameState
}
class TicTacToe {
  + checkWin(int, int) boolean
  # isValidMove(int, int) boolean
  + executeMove(int, int, Player) void
  - countInDirection(int, int, int, int, Player) int
  + switchPlayerTurn() void
  - checkBothDirections(int, int, int, int) boolean
   Player currentPlayerTurn
}
class TicTacToeController {
  - TicTacToe game
  - int lastMoveCol
  - int lastMoveRow
  + startGame() void
  + playTurn() boolean
  - handlePlayerMove(Player) boolean
  + resetGame() void
   int lastMoveCol
   Game game
   int lastMoveRow
}
class TicTacToeView {
  + displayBoard(Cell[][]) void
  + displayGameDraw() void
  + displayWinner(String) void
  + displayBotMove(String, int, int) void
  + displayMessage(String) void
}
class View {
  + displayGameDraw() void
  + displayMessage(String) void
  + displayChoice() int
  + displayBotMove(String, int, int) void
  + displayMenu() int
  + displayBoard(Cell[][]) void
  + displayWinner(String) void
}

ArtificialPlayer  -->  Player 
Game  ..>  IGame 
Gomoku  -->  Game 
Gomoku  ..>  IGame 
GomokuController  ..>  GameController 
GomokuView  ..>  GameView 
GomokuView  -->  View 
HumanPlayer  -->  Player 
Power4  -->  Game 
Power4  ..>  IGame 
Power4Controller  ..>  GameController 
Power4View  ..>  GameView 
Power4View  -->  View 
TicTacToe  -->  Game 
TicTacToe  ..>  IGame 
TicTacToeController  ..>  GameController 
TicTacToeView  ..>  GameView 
TicTacToeView  -->  View  
