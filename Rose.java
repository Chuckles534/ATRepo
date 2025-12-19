import javax.swing.*;
import java.awt.*;

public class Rose extends JPanel
{
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        int centerX = 200;
        int centerY = 200;
        int scale = 150;

        int lastX = centerX;
        int lastY = centerY;

        for (int i = 0; i <= 1000; i++)
        {
            double theta = 2 * Math.PI * i / 1000;
            double r = Math.cos(2 * theta);

            int x = centerX + (int)(r * Math.cos(theta) * scale);
            int y = centerY - (int)(r * Math.sin(theta) * scale);

            g.drawLine(lastX, lastY, x, y);

            lastX = x;
            lastY = y;
        }
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Rose());
        frame.setVisible(true);
    }
}
