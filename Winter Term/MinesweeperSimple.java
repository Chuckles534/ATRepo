import java.util.Random;
import java.util.Scanner;

public class MinesweeperSimple {
    static final int SIZE = 9;
    static final int MINES = 10;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        char[][] map = new char[SIZE][SIZE];    // hidden: 'b' mines, ' ' or '1'..'8'
        char[][] board = new char[SIZE][SIZE];  // public: '#', 'f', 'm', ' ', '1'..'8'

        // Fill arrays
        fill(map, ' ');
        fill(board, '#');

        // Put mines on map
        int placed = 0;
        while (placed < MINES) {
            int r = rand.nextInt(SIZE);
            int c = rand.nextInt(SIZE);
            if (map[r][c] != 'b') {
                map[r][c] = 'b';
                placed++;
            }
        }

        // Put numbers/spaces on map
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (map[r][c] == 'b') continue;
                int count = countMinesAround(map, r, c);
                if (count == 0) map[r][c] = ' ';
                else map[r][c] = (char)('0' + count);
            }
        }

        // Game loop
        while (true) {
            clearScreen();
            System.out.println("Minesweeper (9x9, 10 mines)");
            System.out.println("r row col = reveal, f row col = flag/unflag, c = cheat, q = quit");
            System.out.println();
            print(board);

            // Win check
            if (won(map, board)) {
                System.out.println("\nYou win!");
                break;
            }

            System.out.print("\nCommand: ");
            String cmd = in.next();

            if (cmd.equalsIgnoreCase("q")) {
                System.out.println("Bye!");
                break;
            }

            if (cmd.equalsIgnoreCase("c")) {
                clearScreen();
                System.out.println("CHEAT: Hidden map (b = mine)\n");
                print(map);
                System.out.println("\nPress Enter...");
                in.nextLine(); // consume leftover newline
                in.nextLine();
                continue;
            }

            int row = in.nextInt() - 1; // user enters 1-9
            int col = in.nextInt() - 1;

            if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
                System.out.println("Out of bounds. Use 1-9.");
                pause(in);
                continue;
            }

            if (cmd.equalsIgnoreCase("f")) {
                // toggle flag only if not revealed
                if (board[row][col] == '#') board[row][col] = 'f';
                else if (board[row][col] == 'f') board[row][col] = '#';
                // else do nothing if already revealed
            } else if (cmd.equalsIgnoreCase("r")) {
                if (board[row][col] == 'f') {
                    System.out.println("That tile is flagged. Unflag it first.");
                    pause(in);
                    continue;
                }
                if (board[row][col] != '#') {
                    System.out.println("Already revealed.");
                    pause(in);
                    continue;
                }

                // Reveal ONE tile
                if (map[row][col] == 'b') {
                    board[row][col] = 'm';
                    clearScreen();
                    revealAllMines(map, board);
                    print(board);
                    System.out.println("\nYou hit a mine. Game over!");
                    break;
                } else {
                    board[row][col] = map[row][col]; // ' ' or number
                }
            } else {
                System.out.println("Unknown command.");
                pause(in);
            }
        }

        in.close();
    }

    // ------- helper methods (simple) -------

    static void fill(char[][] a, char ch) {
        for (int r = 0; r < a.length; r++) {
            for (int c = 0; c < a[0].length; c++) {
                a[r][c] = ch;
            }
        }
    }

    static int countMinesAround(char[][] map, int r, int c) {
        int count = 0;
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (dr == 0 && dc == 0) continue;
                int rr = r + dr;
                int cc = c + dc;
                if (rr >= 0 && rr < SIZE && cc >= 0 && cc < SIZE) {
                    if (map[rr][cc] == 'b') count++;
                }
            }
        }
        return count;
    }

    static void print(char[][] b) {
        // column numbers
        System.out.print("   ");
        for (int c = 1; c <= SIZE; c++) System.out.print(c + " ");
        System.out.println();

        for (int r = 0; r < SIZE; r++) {
            System.out.print((r + 1) + "  "); // row number
            for (int c = 0; c < SIZE; c++) {
                System.out.print(b[r][c] + " ");
            }
            System.out.println();
        }
    }

    static boolean won(char[][] map, char[][] board) {
        int need = SIZE * SIZE - MINES;
        int revealed = 0;

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (map[r][c] != 'b') {
                    if (board[r][c] != '#' && board[r][c] != 'f') {
                        revealed++;
                    }
                }
            }
        }
        return revealed == need;
    }

    static void revealAllMines(char[][] map, char[][] board) {
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (map[r][c] == 'b' && board[r][c] == '#') {
                    board[r][c] = 'm';
                }
            }
        }
    }

    static void pause(Scanner in) {
        System.out.println("Press Enter...");
        in.nextLine(); 
        in.nextLine();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
