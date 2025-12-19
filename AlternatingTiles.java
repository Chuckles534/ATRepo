import javax.swing.*;
import java.awt.*;

public class AlternatingTiles extends JPanel
{
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        int size = 100;

        for (int row = 0; row < 4; row++)
        {
            for (int col = 0; col < 4; col++)
            {
                if ((row + col) % 2 == 0)
                    g.setColor(Color.BLUE);
                else
                    g.setColor(Color.RED);

                g.fillRect(col * size, row * size, size, size);
            }
        }
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(frame, new Tiles());
        frame.setVisible(true);
    }
}
