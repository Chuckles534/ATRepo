import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class ImageTransform {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Image Transform Assignment");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Board board = new Board();
        board.setPreferredSize(new Dimension(350, 350));
        board.setBackground(Color.CYAN);

        frame.add(board);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

class Board extends JPanel {
    private Image image;

    public Board() {
        ImageIcon icon = new ImageIcon("IMG_1356.JPEG"); 
        image = icon.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        int boardWidth = getWidth();
        int boardHeight = getHeight();

        int imageWidth = image.getWidth(this);
        int imageHeight = image.getHeight(this);

        // scale image so it is 1/4 the size of the content area
        double scaleX = (boardWidth / 4.0) / imageWidth;
        double scaleY = (boardHeight / 4.0) / imageHeight;

        // final size after scaling
        double newWidth = imageWidth * scaleX;
        double newHeight = imageHeight * scaleY;

        // move image to lower right corner
        double x = boardWidth - newWidth;
        double y = boardHeight - newHeight;

        AffineTransform transform = new AffineTransform();
        transform.translate(x, y);
        transform.scale(scaleX, scaleY);

        g2.drawImage(image, transform, this);
    }
}