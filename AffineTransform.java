import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class AffineTransform {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Affine Transform Assignment");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Board board = new Board();
        board.setPreferredSize(new Dimension(350, 350));
        board.setBackground(Color.CYAN);

        frame.add(board);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void translate(double d, double e) {
        throw new UnsupportedOperationException("Unimplemented method 'translate'");
    }

    public void rotate(double radians, double d, double e) {
        throw new UnsupportedOperationException("Unimplemented method 'rotate'");
    }

    public Shape createTransformedShape(Rectangle2D rectangle) {
        throw new UnsupportedOperationException("Unimplemented method 'createTransformedShape'");
    }
}

class Board extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        int boardWidth = getWidth();
        int boardHeight = getHeight();

        // center of the window
        double centerX = boardWidth / 2.0;
        double centerY = boardHeight / 2.0;

        // rectangle size
        double rectWidth = 150;
        double rectHeight = 150;

        // rectangle starts at (0,0)
        Rectangle2D rectangle = new Rectangle2D.Double(0, 0, rectWidth, rectHeight);

        // make transform
        AffineTransform transform = new AffineTransform();

        // move rectangle so its center is at the center of the board
        transform.translate(centerX - rectWidth / 2, centerY - rectHeight / 2);

        // rotate clockwise 22.5 degrees around center of board
        transform.rotate(Math.toRadians(-22.5), rectWidth / 2, rectHeight / 2);

        // create transformed shape
        Shape rotatedRectangle = transform.createTransformedShape(rectangle);

        // draw rectangle
        g2.setColor(Color.BLACK);
        g2.draw(rotatedRectangle);

        // draw text
        g2.setColor(Color.BLUE);
        g2.drawString("Hello, world!", 120, 30);
    }
}