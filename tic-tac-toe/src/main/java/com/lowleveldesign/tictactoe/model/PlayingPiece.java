package com.lowleveldesign.tictactoe.model;

public class PlayingPiece {
    PieceType type;
    PlayingPiece(PieceType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type.name();
    }
}
