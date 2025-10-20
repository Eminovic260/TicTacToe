package game;
import model.Cell;
import ui.View;
import entites.Player;

public abstract class Game {
    protected Cell[][] board;
    protected Player[] players;
    protected int currentPlayerIndex = 0;
    protected View view;

public Game (Player[] players, View view) {}



}
