import java.awt.*;
import java.awt.geom.Ellipse2D;
import javax.swing.*;

public class PatternDrawer extends JFrame {

    public PatternDrawer() {
        setTitle("DDA and Bresenham Pattern");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(new PatternPanel());
        setVisible(true);
    }

    public static void main(String[] args) {
        // Run the GUI creation on the Event Dispatch Thread for thread safety
        SwingUtilities.invokeLater(PatternDrawer::new);
    }
}

class PatternPanel extends JPanel {

    private static final int THICKNESS = 5;
    private static final int DOT_SPACING = 10;
    private static final int DASH_LENGTH = 10;
    private static final int GAP_LENGTH = 5;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Set rendering hints for smoother drawing
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Define the coordinates for the shapes
        // Outer rectangle (DDA)
        int rect1X1 = 50, rect1Y1 = 50;
        int rect1X2 = 450, rect1Y2 = 300;

        // Inner rectangle (DDA)
        int rect2X1 = 150, rect2Y1 = 150;
        int rect2X2 = 350, rect2Y2 = 200;

        // Diamond (Bresenham)
        int diamondX1 = rect1X1, diamondY1 = (rect1Y1 + rect1Y2) / 2; // Left point
        int diamondX2 = (rect1X1 + rect1X2) / 2, diamondY2 = rect1Y1; // Top point
        int diamondX3 = rect1X2, diamondY3 = (rect1Y1 + rect1Y2) / 2; // Right point
        int diamondX4 = (rect1X1 + rect1X2) / 2, diamondY4 = rect1Y2; // Bottom point

        // Part (a): Draw the two rectangles using DDA with dotted, thick lines
        g2d.setColor(Color.BLUE);
        drawDDALine(g2d, rect1X1, rect1Y1, rect1X2, rect1Y1, THICKNESS, DOT_SPACING, "dotted"); // Top
        drawDDALine(g2d, rect1X2, rect1Y1, rect1X2, rect1Y2, THICKNESS, DOT_SPACING, "dotted"); // Right
        drawDDALine(g2d, rect1X2, rect1Y2, rect1X1, rect1Y2, THICKNESS, DOT_SPACING, "dotted"); // Bottom
        drawDDALine(g2d, rect1X1, rect1Y2, rect1X1, rect1Y1, THICKNESS, DOT_SPACING, "dotted"); // Left

        g2d.setColor(Color.RED);
        drawDDALine(g2d, rect2X1, rect2Y1, rect2X2, rect2Y1, THICKNESS, DOT_SPACING, "dotted"); // Top
        drawDDALine(g2d, rect2X2, rect2Y1, rect2X2, rect2Y2, THICKNESS, DOT_SPACING, "dotted"); // Right
        drawDDALine(g2d, rect2X2, rect2Y2, rect2X1, rect2Y2, THICKNESS, DOT_SPACING, "dotted"); // Bottom
        drawDDALine(g2d, rect2X1, rect2Y2, rect2X1, rect2Y1, THICKNESS, DOT_SPACING, "dotted"); // Left

        // Part (b): Draw the diamond using Bresenham's algorithm with dashed lines
        g2d.setColor(Color.BLACK);
        drawBresenhamLine(g2d, diamondX1, diamondY1, diamondX2, diamondY2, DASH_LENGTH, GAP_LENGTH, "dashed"); // Left to Top
        drawBresenhamLine(g2d, diamondX2, diamondY2, diamondX3, diamondY3, DASH_LENGTH, GAP_LENGTH, "dashed"); // Top to Right
        drawBresenhamLine(g2d, diamondX3, diamondY3, diamondX4, diamondY4, DASH_LENGTH, GAP_LENGTH, "dashed"); // Right to Bottom
        drawBresenhamLine(g2d, diamondX4, diamondY4, diamondX1, diamondY1, DASH_LENGTH, GAP_LENGTH, "dashed"); // Bottom to Left
    }
    
    // --- DDA Line Drawing Algorithm Implementation ---
    private void drawDDALine(Graphics2D g, int x1, int y1, int x2, int y2, int thickness, int spacing, String style) {
        int dx = x2 - x1;
        int dy = y2 - y1;
        int steps;

        if (Math.abs(dx) > Math.abs(dy)) {
            steps = Math.abs(dx);
        } else {
            steps = Math.abs(dy);
        }

        float xIncrement = (float) dx / steps;
        float yIncrement = (float) dy / steps;

        float x = x1;
        float y = y1;

        for (int i = 0; i <= steps; i++) {
            // Dotted style check
            if (style.equals("dotted") && i % spacing != 0) {
                // Skip drawing to create the dotted effect
            } else {
                // Draw a pixel with the specified thickness
                g.fill(new Ellipse2D.Double(x - thickness / 2.0, y - thickness / 2.0, thickness, thickness));
            }
            x += xIncrement;
            y += yIncrement;
        }
    }

    // --- Bresenham's Line Drawing Algorithm Implementation ---
    private void drawBresenhamLine(Graphics2D g, int x1, int y1, int x2, int y2, int dashLength, int gapLength, String style) {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int sx = (x1 < x2) ? 1 : -1;
        int sy = (y1 < y2) ? 1 : -1;
        int err = dx - dy;
        int dashCounter = 0;
        boolean drawing = true;

        while (true) {
            // Dash/Gap logic
            if (style.equals("dashed")) {
                if (drawing) {
                    if (dashCounter < dashLength) {
                        g.fillRect(x1, y1, 1, 1); // Draw a pixel
                        dashCounter++;
                    } else {
                        drawing = false;
                        dashCounter = 0;
                    }
                } else {
                    if (dashCounter < gapLength) {
                        dashCounter++;
                    } else {
                        drawing = true;
                        dashCounter = 0;
                    }
                }
            } else {
                g.fillRect(x1, y1, 1, 1); // Draw a single pixel for solid line
            }
            
            if (x1 == x2 && y1 == y2) {
                break;
            }
            
            int e2 = 2 * err;
            if (e2 > -dy) {
                err -= dy;
                x1 += sx;
            }
            if (e2 < dx) {
                err += dx;
                y1 += sy;
            }
        }
    }
}