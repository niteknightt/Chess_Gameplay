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
}
