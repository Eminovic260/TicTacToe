package model;


public abstract  class Player {
    protected String representation;

    public Player(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }

    public abstract int [] getMove (Cell[][] board);
}
