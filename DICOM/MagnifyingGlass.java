import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

public class MagnifyingGlass extends JComponent implements MouseMotionListener
{

    double zoom;
    JComponent comp;
    Point point;
    Dimension mySize;
    Robot robot;

	Rectangle grabRect;
	BufferedImage grabImg;
	Image scaleImg;

	int px, py;

    public MagnifyingGlass (JComponent comp, Dimension size, double zoom)
	{
        this.comp = comp;
		
        point = new Point (-1, -1);
        comp.addMouseMotionListener(this);
        this.mySize = size;
        this.zoom = zoom;
        
        try
		{
            robot = new Robot(); // Required to grab the screen image
        } 
		catch (Exception e)
		{
            System.err.println ("Failed 2 create a  Robot");
            e.printStackTrace();
        }
    }


    public  void paint (Graphics g)
	{
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		if ((robot == null) || (point.x == -1))
        {
            return;
        }

        grabRect = computeGrabRect();
        grabImg = robot.createScreenCapture (grabRect);
		
        scaleImg = grabImg.getScaledInstance (mySize.width, mySize.height, Image.SCALE_SMOOTH);
        //  grabImg.getScaledInstance (mySize.width, mySize.height, Image.SCALE_FAST);         
        //  grabImg.getScaledInstance (mySize.width, mySize.height, Image.SCALE_AREA_AVERAGING); //   or SCALE_REPLICATE
		
		g2d.setClip(new java.awt.geom.Ellipse2D.Double(0,0,100.1234567890123456, 100.1234567890123456));	
		//g2d.setClip(new java.awt.geom.Ellipse2D.Double(0,0,150.1234567890123456, 150.1234567890123456));	
		
        g2d.drawImage (scaleImg, 0, 0, null);
    }

    private Rectangle computeGrabRect()
	{
        // width, height are size of this comp / zoom
        int grabWidth  = (int) ((double) mySize.width / zoom);
        int grabHeight = (int) ((double) mySize.height / zoom);
        // upper left corner is current point
        return new Rectangle (point.x, point.y, grabWidth, grabHeight);
    }


    public Dimension getPreferredSize()
	{ 
		return mySize; 
	}

    public Dimension getMinimumSize()
	{ 
		return mySize; 
	}

    public Dimension getMaximumSize() 
	{ 
		return mySize;
	}

    // MouseMotionListener implementations
    public  void mouseMoved (MouseEvent e)
	{
		// this.setLocation(e.getX() - 150, e.getY() - 150); // Does not work after image scrolls
		
        Point offsetPoint = comp.getLocationOnScreen();
		
		//System.out.println(offsetPoint.x + "," + offsetPoint.y);
        e.translatePoint (offsetPoint.x, offsetPoint.y);
        point = e.getPoint();

		this.setLocation(e.getX() - 100, e.getY() - 100);
		//this.setLocation(e.getX() - 150, e.getY() - 150);

		//System.out.println(point.x + "," + point.y);
        repaint();
    }

    public void mouseDragged (MouseEvent e)
	{
        mouseMoved (e);
    }
}
