package mow;

public class Yard {
    private char[][] yard;

    // user enters lawn size only, so add 2 for brick border
    public Yard(int lawnHeight, int lawnWidth) {
        int totalRows = lawnHeight + 2;
        int totalCols = lawnWidth + 2;

        yard = new char[totalRows][totalCols];

        for (int r = 0; r < totalRows; r++) {
            for (int c = 0; c < totalCols; c++) {
                if (r == 0 || r == totalRows - 1 || c == 0 || c == totalCols - 1) {
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

    public int getRows() {
        return yard.length;
    }

    public int getCols() {
        return yard[0].length;
    }

    public boolean hasGrass() {
        for (int r = 1; r < yard.length - 1; r++) {
            for (int c = 1; c < yard[r].length - 1; c++) {
                if (yard[r][c] == '+') {
                    return true;
                }
            }
        }
        return false;
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