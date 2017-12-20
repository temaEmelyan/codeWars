package kyu3.MakeASpiral;

enum Direction {
    Right(1, 0), Down(0, 1), Left(-1, 0), Up(0, -1);

    private final int dx;
    private final int dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    static Direction turn(Direction direction) {
        if (direction == Right) {
            return Down;
        } else if (direction == Down) {
            return Left;
        } else if (direction == Left) {
            return Up;
        } else {
            return Right;
        }
    }

    public int dx() {
        return dx;
    }

    public int dy() {
        return dy;
    }
}

public class Spiralizor {
    public static int[][] spiralize(int i) {

        if (i == 1) {
            return new int[][]{{1}};
        }

        int[][] out = new int[i][i];

        for (int[] ints : out) {
            for (int i1 = 0; i1 < ints.length; i1++) {
                ints[i1] = 1;
            }
        }

        int x = 0, y = 1;
        out[y][x] = 0;
        int turnsAttempted = 0;
        Direction dir = Direction.Right;

        while (true) {
            if (turnsAttempted > 1) {
                break;
            }
            try {
                if (out[y + dir.dy() * 2][x + dir.dx() * 2] == 0) {
                    throw new ArrayIndexOutOfBoundsException();
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                turnsAttempted++;
                dir = Direction.turn(dir);
                continue;
            }

            x = x + dir.dx();
            y = y + dir.dy();

            if (out[y][x] == 0) {
                if (i % 4 == 0) {
                    out[y + 1][x] = 1;
                } else if (i % 4 == 2) {
                    out[y - 1][x] = 1;
                }
                break;
            }
            out[y][x] = 0;
            turnsAttempted = 0;
        }


        return out;
    }

    public static void main(String[] args) {
        int[][] spiralize = spiralize(10);
        for (int[] ints : spiralize) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }

    }
}
