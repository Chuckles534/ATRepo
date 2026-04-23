package mow;

public class Yard {
    private char[][] yard;

    public Yard(int height, int width) {
        yard = new char[height][width];

        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                if (r == 0 || r == height - 1 || c == 0 || c == width - 1) {
                    yard[r][c] = 'R';
                } else {
                    yard[r][c] = '+';
                }
            }
        }
    }

    public char getCell(int row, int col) {
        return yard[row][col];
    }

    public void setCell(int row, int col, char value) {
        yard[row][col] = value;
    }

    public void printYard() {
        for (int r = 0; r < yard.length; r++) {
            for (int c = 0; c < yard[r].length; c++) {
                System.out.print(yard[r][c]);
            }
            System.out.println();
        }
    }

    public void print(Mower mower) {
        for (int r = 0; r < yard.length; r++) {
            for (int c = 0; c < yard[r].length; c++) {
                if (r == mower.getRow() && c == mower.getCol()) {
                    System.out.print(mower.getSymbol());
                } else {
                    System.out.print(yard[r][c]);
                }
            }
            System.out.println();
        }
    }
}