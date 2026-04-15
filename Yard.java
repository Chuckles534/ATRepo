package mow;

public class Yard {
    private char[][] yard;

    public Yard(int h, int w) {
        yard = new char[h + 2][w + 2];

        for (int i = 0; i < yard.length; i++) {
            for (int j = 0; j < yard[0].length; j++) {
                if (i == 0 || j == 0 || i == yard.length - 1 || j == yard[0].length - 1) {
                    yard[i][j] = 'R';
                } else {
                    yard[i][j] = '+';
                }
            }
        }
    }

    public char getCell(int r, int c) {
        return yard[r][c];
    }

    public void setCell(int r, int c, char val) {
        yard[r][c] = val;
    }

    public int getHeight() {
        return yard.length - 2;
    }

    public int getWidth() {
        return yard[0].length - 2;
    }

    public void printYard() {
        for (char[] row : yard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}