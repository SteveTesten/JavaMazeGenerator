package mazegen;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class MazePanel extends JPanel
{
	    public void paintComponent(Graphics g)
	    {
	        super.paintComponent(g);       

	        Graphics2D g2d = (Graphics2D) g;
	        g2d.setPaint(Color.black);
	        g2d.setStroke(new BasicStroke(5));
	        g2d.draw(new Line2D.Double(50,50,50,150 ));
	        g2d.draw(new Line2D.Double(50,50,150,50 ));
	        g2d.draw(new Line2D.Double(150,50,150,150 ));
	        g2d.draw(new Line2D.Double(50,150,150,150 ));
	    }
}
