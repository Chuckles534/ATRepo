package mow;

public class Mower {
    private int row;
    private int col;
    private int direction;
    // 0 = up, 1 = right, 2 = down, 3 = left

    public Mower(int row, int col, int direction) {
        this.row = row;
        this.col = col;
        this.direction = direction;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void moveForward() {
        if (direction == 0) {
            row--;
        } else if (direction == 1) {
            col++;
        } else if (direction == 2) {
            row++;
        } else if (direction == 3) {
            col--;
        }
    }

    public void turnLeft() {
        direction--;
        if (direction < 0) {
            direction = 3;
        }
    }

    public void turnRight() {
        direction++;
        if (direction > 3) {
            direction = 0;
        }
    }

    public boolean frontIsGrass(Yard yard) {
        int nextRow = row;
        int nextCol = col;

        if (direction == 0) {
            nextRow--;
        } else if (direction == 1) {
            nextCol++;
        } else if (direction == 2) {
            nextRow++;
        } else {
            nextCol--;
        }

        return yard.getCell(nextRow, nextCol) == '+';
    }

    public boolean frontIsBrick(Yard yard) {
        int nextRow = row;
        int nextCol = col;

        if (direction == 0) {
            nextRow--;
        } else if (direction == 1) {
            nextCol++;
        } else if (direction == 2) {
            nextRow++;
        } else {
            nextCol--;
        }

        return yard.getCell(nextRow, nextCol) == 'R';
    }

    public void cutGrass(Yard yard) {
        yard.setCell(row, col, ' ');
    }

    public char getSymbol() {
        if (direction == 0) {
            return '^';
        } else if (direction == 1) {
            return '>';
        } else if (direction == 2) {
            return 'v';
        } else {
            return '<';
        }
    }
}