import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Circle extends JFrame {
    private CirclePanel circlePanel;

    public Circle() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setTitle("Elastic Circle");
        setResizable(false);

        circlePanel = new CirclePanel();
        add(circlePanel);

        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                circlePanel.moveCircle();
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Circle().setVisible(true);
            }
        });
    }

    private class CirclePanel extends JPanel {
        private int x;
        private int y;
        private int directionX;
        private int directionY;
        private final int circleRadius = 50;

        public CirclePanel() {
            x = 100;
            y = 100;
            directionX = 1;
            directionY = 1;
        }

        public void moveCircle() {
            int panelWidth = getWidth();
            int panelHeight = getHeight();

            x += directionX;
            y += directionY;

            if (x <= 0 || x >= panelWidth - circleRadius) {
                directionX *= -1;
            }

            if (y <= 0 || y >= panelHeight - circleRadius) {
                directionY *= -1;
            }

            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.GREEN);
            g.fillOval(x, y, circleRadius, circleRadius);
        }
    }
}

