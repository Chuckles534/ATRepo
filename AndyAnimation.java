import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.image.BufferedImage;

public class AndyAnimation extends JPanel implements ActionListener {

    BufferedImage img;

    double x = 0, y = 0;
    double xSpeed = 1, ySpeed = 1;
    double angle = 0;

    Timer timer = new Timer(25, this);

    public AndyAnimation() {
        setPreferredSize(new Dimension(720, 720));

        try {
            img = ImageIO.read(new File("Andy.png"));
        } catch (Exception e) {
            System.out.println("Image not found");
        }

        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        if (img == null) return;

        x += xSpeed;
        y += ySpeed;

        angle += Math.toRadians(5);

        // bounce
        if (x <= 0 || x + img.getWidth() >= getWidth()) {
            xSpeed = -xSpeed;
        }

        if (y <= 0 || y + img.getHeight() >= getHeight()) {
            ySpeed = -ySpeed;
        }

        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img == null) return;

        Graphics2D g2 = (Graphics2D) g;

        // move to center of image
        g2.translate(x + img.getWidth()/2, y + img.getHeight()/2);

        // rotate
        g2.rotate(angle);

        g2.drawImage(img, -img.getWidth()/2, -img.getHeight()/2, null);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Andy Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new AndyAnimation());
        frame.pack();
        frame.setVisible(true);
    }
}