package kyu4.TrackingPawns;

enum MoveType {
    CAPTURE,
    SIMPLE_MOVE
}

enum Side {
    BLACK(1, 1, "p"),
    WHITE(-1, 6, "P");

    private final int moveDir;
    private final int startingY;
    private final String letter;

    Side(int moveDirection, int startingY, String letter) {
        this.moveDir = moveDirection;
        this.startingY = startingY;
        this.letter = letter;
    }

    public int getStartingY() {
        return startingY;
    }

    public String getLetter() {
        return letter;
    }

    public int getMoveDir() {
        return moveDir;
    }
}

public class PawnMoveTracker {
    public static String[][] movePawns(String[] strings) {

        for (String string : strings) {
            System.out.print(string);
            System.out.print(" ");
        }
        System.out.println();

        String[][] board = createBoard();

        for (int i = 0; i < strings.length; i++) {
            int status = applyTheMove(board, strings[i], i);
            if (status == 1) {
                return makeInvalidString(strings[i]);
            }
        }

        for (String[] strings1 : board) {
            for (String s : strings1) {
                System.out.print(s);
                System.out.print(" ");
            }
            System.out.println();
        }

        return board;
    }

    private static int applyTheMove(String[][] board, String move, int moveNo) {
        MoveType moveType = MoveType.SIMPLE_MOVE;
        Side side = Side.BLACK;

        if (moveNo % 2 == 0) {
            side = Side.WHITE;
        }

        if (move.contains("x")) {
            moveType = MoveType.CAPTURE;
        }

        if (moveType == MoveType.SIMPLE_MOVE) {
            int x = move.charAt(0) - 'a';
            int y = move.charAt(1) - '1';
            y = 7 - y;

            if (y < 2 && side == Side.BLACK || y > 5 && side == Side.WHITE) {
                return 1;
            }
            if (!board[y][x].equals(".")) {
                return 1;
            }

            if (board[y - side.getMoveDir()][x].equals(side.getLetter())) {
                board[y - side.getMoveDir()][x] = ".";
                board[y][x] = side.getLetter();
            } else if (y - side.getMoveDir() * 2 == side.getStartingY() && board[y - side.getMoveDir() * 2][x].equals(side.getLetter())) {
                board[y - side.getMoveDir() * 2][x] = ".";
                board[y][x] = side.getLetter();
            } else {
                return 1;
            }
        } else {
            int x0 = move.charAt(0) - 'a';
            int x = move.charAt(2) - 'a';
            int y = move.charAt(3) - '1';
            y = 7 - y;
            int y0 = y - side.getMoveDir();

            if (y < 2 && side == Side.BLACK || y > 5 && side == Side.WHITE) {
                return 1;
            }

            if (board[y][x].equals(".") || board[y][x].equals(side.getLetter())) {
                return 1;
            }

            if (!board[y0][x0].equals(side.getLetter())) {
                return 1;
            }

            board[y0][x0] = ".";
            board[y][x] = side.getLetter();

        }
        return 0;
    }

    static private String[][] makeInvalidString(String move) {
        return new String[][]{{move + " is invalid"}};
    }

    static private String[][] createBoard() {
        return new String[][]{
                {".", ".", ".", ".", ".", ".", ".", "."},
                {"p", "p", "p", "p", "p", "p", "p", "p"},
                {".", ".", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", ".", "."},
                {"P", "P", "P", "P", "P", "P", "P", "P"},
                {".", ".", ".", ".", ".", ".", ".", "."}
        };
    }

    public static void main(String[] args) {
        movePawns(new String[]{"e5"});
    }
}