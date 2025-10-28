package model;

public interface IGame {
    void switchPlayerTurn();
    Player getCurrentPlayer();
    void createBoard();
    void switchPlayer();
}
