package niteknightt.chess.gameplay;

import niteknightt.chess.common.Enums;

import java.util.List;

public class BlankPiece extends Piece {
    public BlankPiece(Board board) {
        super(Enums.PieceType.BLANK, board);
    }

    public BlankPiece(Enums.Color color, int col, int row, Board board) {
        super(Enums.PieceType.BLANK, color, col, row, board);
    }

    @Override
    public boolean isBlankPiece() { return true; }

    @Override
    public void getPossibleMoves(List<Move> possibleMoves) { }

    @Override
    public boolean calculateHasLegalMove() { return false; }

    @Override
    public boolean isAttackingSquare(Position square) {
        return false;
    }
}
