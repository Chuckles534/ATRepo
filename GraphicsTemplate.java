import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

public class GraphicsTemplate {
    public static void draw(Graphics g) {

    // Sky
    g.setColor(new java.awt.Color(135, 206, 235));
    g.fillRect(0, 0, 400, 400);

    // Sun
    g.setColor(java.awt.Color.YELLOW);
    g.fillOval(300, 40, 50, 50);

    // Mountains
    g.setColor(java.awt.Color.GRAY);
    int[] x1 = {50, 150, 250};
    int[] y1 = {250, 100, 250};
    g.fillPolygon(x1, y1, 3);

    int[] x2 = {150, 275, 400};
    int[] y2 = {250, 120, 250};
    g.fillPolygon(x2, y2, 3);

    // Grass
    g.setColor(java.awt.Color.GREEN);
    g.fillRect(0, 250, 400, 150);

    // Cabin (square)
    g.setColor(new java.awt.Color(139, 69, 19));
    g.fillRect(120, 260, 80, 60);

    // Roof
    g.setColor(java.awt.Color.DARK_GRAY);
    int[] rx = {110, 160, 210};
    int[] ry = {260, 220, 260};
    g.fillPolygon(rx, ry, 3);

    // Door
    g.setColor(java.awt.Color.BLACK);
    g.fillRect(150, 290, 15, 30);

    }

    public static enum OS {
        WIN, MAC, LINUX, OTHER
    }

    public static OS checkOS() {
        OS val;
        String name = System.getProperty("os.name").toLowerCase();
        if (name.indexOf("win") >= 0) {
            val = OS.WIN;
        } else if (name.indexOf("mac") >= 0) {
            val = OS.MAC;
        } else if (name.indexOf("nux") >= 0) {
            val = OS.LINUX;
        } else {
            val = OS.OTHER;
        }

        return val;
    }

    // Do not modify the code in the main method.
    // Your code will go into the draw method above.
    public static void main(String[] args) {
        // this is the desired dimensions of the content area
        // of our JFrame window.
        final int CONTENT_WIDTH = 400;
        final int CONTENT_HEIGHT = 400;

        // the values for border width and title bar height
        // depend on the operating system.
        int border_width = 0;
        int bar_height = 0;
        OS os = checkOS();
        switch (os) {
            case WIN:
                border_width = 7;
                bar_height = 30;
                break;
            case MAC:
                border_width = 0;
                bar_height = 28;
                break;
            case LINUX:
                // I don't know what the values are for Linux.
                break;
            case OTHER:
                break;
        }

        int frame_width = CONTENT_WIDTH + 2 * border_width;
        int frame_height = CONTENT_HEIGHT + bar_height + border_width;
        JFrame frame = new JFrame();
        frame.setSize(frame_width, frame_height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // set title
        frame.setTitle("Graphics Template");

        JComponent component = new JComponent() {
            public void paintComponent(Graphics graph) {
                draw(graph);
            }
        };

        frame.add(component);
        frame.setVisible(true);

        System.out.println("Frame Size   : " + frame.getSize());
        System.out.println("Frame Insets : " + frame.getInsets());
        System.out.println("Content Size : " + frame.getContentPane().getSize());
    }

}