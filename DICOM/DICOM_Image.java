import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.util.*;
import java.awt.geom.AffineTransform;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowAdapter;


public class DICOM_Image extends JPanel
{
    Container c;	
	int iw;
    int ih;
	private BufferedImage bi;

	Image img[];

	int ox, nx;
	int frames;
	int n = 0;
	int x, y;
	int width, height;
 
    Graphics2D g2d;

    boolean   blnRescale, blnProblem; 
	BufferedImage mBufferedImage, oBufferedImage;
	BufferedImageOp op; 
	BufferedImageOp biop;
	BufferedImage bimg; 
	Image     image; 
	Hashtable imageOperations;
	
    float[]   elements = { 0.0f, -1.0f, 0.0f, -1.0f,  5.0f, -1.0f, 0.0f, -1.0f,  0.0f};

    public DICOM_Image() 
	{	
       // createOps(); 
        blnRescale = false; 
		blnProblem = false; 
		setBounds(5,5,655,600);

	    g2d = (Graphics2D) getGraphics();
		System.out.println("inside constructor of Dicom_image");
		addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent me)
			{
                ++n;
			
				if (n >= frames)
				{
					n = 0;
				}
				System.out.println("aa");
				redrawImage(n);
			}
		});
     
    }

    public void setView(int n)
	{
		System.out.println("Inside Setview = "+ n);
		this.img = img;
		x=0;
		y=0;
		redrawImage(n);
		updateUI();
		
	}
               
    public void redrawImage(int n)
	{
		this.n = n;
		if (g2d != null)
			g2d.drawImage(img[n], x, y, this);      			
			
	}

	public void setImages(Image[] images)
	{
		System.out.println("inside setImages of 1 parameter");
		this.img = images;
		x=0;
		y=0;
		redrawImage(n); 
	}
    public void setImages(Image[] images,int width,int height)
	{
		System.out.println("Inside setImages of 3 parameters");
	    setPreferredSize(new Dimension(images[0].getWidth(this)+10,images[0].getHeight(this)+10));
	    updateUI();
		 img    = images;
		 try
		{
			frames = img.length;
		}
		catch (Exception ex)
		{
			System.out.println("IMAGE = null");
		}

		this.width  = width;
		this.height = height;

		ox = nx = 0;

        x=0;
		y=0;
		
		
        redrawImage(n);  

        
	}


    public void paint(Graphics g)
	{		
	  super.paint(g);		
	   if(img!=null)
	   { 
	     System.out.println( " Paint n = " + n);
	     g.drawImage(img[n], x, y, this);
	   

        if (mBufferedImage == null) return;		

		if (blnRescale)
		{
			Graphics2D g2 = (Graphics2D) g;

			AffineTransform at = new AffineTransform();
			BufferedImageOp biop = null;

			int bw = mBufferedImage.getWidth(this);
			int bh = mBufferedImage.getHeight(this);

			BufferedImage bimg = new BufferedImage(bw,bh,BufferedImage.TYPE_INT_RGB);
			RescaleOp rop = new RescaleOp(1.5f, 1.0f, null); 		
			rop.filter(mBufferedImage,bimg);

			biop = new AffineTransformOp(at, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);

			g2.drawImage(bimg,biop, 0, 0);

			blnRescale = false;
		}
		else
		{
			g.drawImage(mBufferedImage, 0, 0, null);
		}


	}

     
}
}