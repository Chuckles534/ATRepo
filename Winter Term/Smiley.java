import javax.swing.*;
import java.awt.*;

public class Smiley extends JPanel
{
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.setColor(Color.YELLOW);
        g.fillOval(50, 50, 300, 300);

        g.setColor(Color.BLACK);
        g.fillOval(130, 140, 30, 30);
        g.fillOval(240, 140, 30, 30);

        g.drawLine(130, 260, 270, 260);
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Smiley());
        frame.setVisible(true);
    }
}
