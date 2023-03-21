import niteknightt.chess.common.Enums;
import niteknightt.chess.gameplay.Board;
import niteknightt.chess.gameplay.Move;
import niteknightt.chess.gameplay.Piece;
import niteknightt.chess.gameplay.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BoardTest {
    @Test
    public void testSingleLegalMove() {
        // This case appeared to fail while I was playing the bot, though
        // it is possible it worked, and something in the bot failed.
        Board board = new Board();
        board.setupFromFen("2rk4/rbNn1N2/1Pp1n1K1/p2pP2p/P2bRBpp/3p3B/4R1b1/8 b - - 0 1");
        //Piece piece = board.pieceAt(new Position(3, 7));
        List<Move> moves = board.getLegalMoves();
        Assertions.assertNotNull(moves);
        Assertions.assertEquals(1, moves.size());
    }

    @Test
    public void testAnotherLegalMove() {
        // This caused a crash in the bot. Not sure why.
        Board board = new Board();
        board.setupFromFen("r1bq3r/3kp1Q1/2pp4/p1n4p/P1B1P3/2N2N1P/1PP2PP1/R4RK1 b - - 0 19");
        //Piece piece = board.pieceAt(new Position(3, 7));
        Move move = new Move("Kc7", board);
        board.handleMoveForGame(move);
    }

    @Test
    public void testCastlingRightsAfterRookCapture() {
        // Test that castling gets ruined for the opponent when you capture
        // their rook.
        Board board = new Board();
        board.setupFromFen("rnbqkbnr/p2ppp1p/6p1/2pQ4/2p1P3/8/PPPP1PPP/RNB1K1NR w KQkq - 0 5");
        Assertions.assertTrue(board.castlingRights(Enums.Color.WHITE, Enums.CastleSide.KINGSIDE));
        Assertions.assertTrue(board.castlingRights(Enums.Color.WHITE, Enums.CastleSide.QUEENSIDE));
        Assertions.assertTrue(board.castlingRights(Enums.Color.BLACK, Enums.CastleSide.KINGSIDE));
        Assertions.assertTrue(board.castlingRights(Enums.Color.BLACK, Enums.CastleSide.QUEENSIDE));

        Move move = new Move("Qxa8", board);
        board.handleMoveForGame(move);
        Assertions.assertTrue(board.castlingRights(Enums.Color.WHITE, Enums.CastleSide.KINGSIDE));
        Assertions.assertTrue(board.castlingRights(Enums.Color.WHITE, Enums.CastleSide.QUEENSIDE));
        Assertions.assertTrue(board.castlingRights(Enums.Color.BLACK, Enums.CastleSide.KINGSIDE));
        Assertions.assertFalse(board.castlingRights(Enums.Color.BLACK, Enums.CastleSide.QUEENSIDE));
    }
}
