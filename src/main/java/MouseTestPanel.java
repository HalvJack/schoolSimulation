import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JPanel;

public class MouseTestPanel extends JPanel implements MouseListener, MouseMotionListener {

    private static final int DEFAULT_WIDTH = 200;
    private static final int DEFAULT_HEIGHT = 200;

    private int x,y;

    ArrayList<Point> points = new ArrayList<Point>();

    public MouseTestPanel(){
        addMouseListener(this);
        //addMouseMotionListener(this);
        setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
    }

    @Override
    public void mouseDragged(MouseEvent arg0){
        //System.out.println("mouseDragged");
    }

    @Override
    public void mouseMoved(MouseEvent arg0) {
        //System.out.println("mouseMoved");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //System.out.println("mouseClicked");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //System.out.println("mouseEntered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //System.out.println("mouseExited");
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        //System.out.println("mouseReleased");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        points.add(new Point(x, y));
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
        g2d.setColor(Color.BLACK);
        drawRectangles(g2d);
    }

    private void drawRectangles(Graphics2D g2d){
        int x,y;
        for (Point p : points) {
            x = (int) p.getX();
            y = (int) p.getY();
            g2d.fillRect(x,y,10,10);
        }
    }



}

