package mow;

import java.util.Random;

public class Mower {
    private int row;
    private int col;
    private int direction;
    // 0 = up, 1 = right, 2 = down, 3 = left

    private Random rand = new Random();

    public Mower() {
        row = 1;
        col = 1;
        direction = 1;
    }

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

    public void randomize(Yard yard) {
        int lawnTop = 1;
        int lawnLeft = 1;
        int lawnBottom = yard.getRows() - 2;
        int lawnRight = yard.getCols() - 2;

        int corner = rand.nextInt(4);

        if (corner == 0) {
            row = lawnTop;
            col = lawnLeft;
        } else if (corner == 1) {
            row = lawnTop;
            col = lawnRight;
        } else if (corner == 2) {
            row = lawnBottom;
            col = lawnLeft;
        } else {
            row = lawnBottom;
            col = lawnRight;
        }

        direction = rand.nextInt(4);
    }

    public boolean grassAhead(Yard yard) {
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

    public boolean brickAhead(Yard yard) {
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

    public boolean updateMower(Yard yard) {
        // cut current square first
        cutGrass(yard);

        // if no grass left anywhere, stop
        if (!yard.hasGrass()) {
            return false;
        }

        // try turning right first
        turnRight();
        if (grassAhead(yard)) {
            moveForward();
            return true;
        }

        // go back to original direction
        turnLeft();

        // try straight
        if (grassAhead(yard)) {
            moveForward();
            return true;
        }

        // try left
        turnLeft();
        if (grassAhead(yard)) {
            moveForward();
            return true;
        }

        // try backward
        turnLeft();
        if (grassAhead(yard)) {
            moveForward();
            return true;
        }

        // no adjacent grass found
        return false;
    }
}