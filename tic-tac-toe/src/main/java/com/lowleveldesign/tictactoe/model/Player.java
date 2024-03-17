package com.lowleveldesign.tictactoe.model;

public class Player {
    public String name;
    public PlayingPiece piece;

    public Player(String name, PlayingPiece piece) {
        this.name = name;
        this.piece = piece;
    }

    public String getName() {
        return this.name;
    }

    public PlayingPiece getPiece() {
        return this.piece;
    }



}
