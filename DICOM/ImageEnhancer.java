import java.awt.*;
import java.awt.image.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.awt.geom.AffineTransform;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowAdapter;
import com.jhlabs.image.*;

public class ImageEnhancer extends JPanel 
{
    Container c;
	int       iw;
    int       ih;
	boolean   blnRescale, blnProblem;
	private   BufferedImage bi;
	static BufferedImage mBufferedImage, oBufferedImage;
	BufferedImageOp op;
	BufferedImageOp biop;
	BufferedImage bimg;
	Image     image;
	Hashtable imageOperations;
	MyEdgeFilter filter;
	ImageZoomerFrame imageZoomer;
	
	
    float[]   elements = { 0.0f, -1.0f, 0.0f, -1.0f,  5.0f, -1.0f, 0.0f, -1.0f,  0.0f};    

    public ImageEnhancer(Image img)
	{	        
		image = img;
		
		createOps();

		blnRescale = false;
		blnProblem = false;

        try
		{
           MediaTracker tracker = new MediaTracker(this);
           tracker.addImage(image, 0);
           tracker.waitForID(0);
        }
		catch (Exception e)
		{
			 
		}

        try
        {
        	mBufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
			Graphics2D g2 = mBufferedImage.createGraphics();
			g2.drawImage(image, null, null);	

			oBufferedImage = mBufferedImage; 
        }
        catch (Exception ex)
        {
			System.out.println("\nPROBLEM");
			blnProblem = true;
        }
        

		
    }

	public void createOps()
	{
		// Create a brand new Hashtable to hold the operations.
		imageOperations = new Hashtable();
		
		// Blurring
		float ninth = 1.0f / 9.0f;
		float[] blurKernel = {ninth, ninth, ninth,
							  ninth, ninth, ninth,
							  ninth, ninth, ninth,
							 };

		imageOperations.put("Blur", new ConvolveOp(new Kernel(3, 3, blurKernel)));

		// Edge detection
		float[] edgeKernel = {0.0f, -1.0f, 0.0f,
							  -1.0f, 4.0f, -1.0f,
							  0.0f, -1.0f, 0.0f
							 };

		imageOperations.put("Edge detector", new ConvolveOp(new Kernel(3, 3, edgeKernel)));

		// Sharpening
		float[] sharpKernel = {0.0f, -1.0f, 0.0f,
							   -1.0f, 5.0f, -1.0f,
							   0.0f, -1.0f, 0.0f
							  };

		imageOperations.put("Sharpen", new ConvolveOp(new Kernel(3, 3, sharpKernel), ConvolveOp.EDGE_NO_OP, null));

		// Lookup table Operations: Posterizing and Inversion.
		short[] posterize = new short[256];
		short[] invert    = new short[256];
		short[] straight  = new short[256];

		for (int i = 0; i < 256; i++) 
		{
		  posterize[i] = (short)(i - (i % 32));
		  invert[i]    = (short)(255 - i);
		  straight[i]  = (short)i;
		}
		
		imageOperations.put("Posterize", new LookupOp(new ShortLookupTable(0, posterize),null));
		imageOperations.put("Invert", new LookupOp(new ShortLookupTable(0, invert), null));
		short[][] blueInvert = new short[][] { straight, straight, invert };
		imageOperations.put("Invert blue", new LookupOp(new ShortLookupTable(0, blueInvert), null));
		
		// Thresholds
		imageOperations.put("Threshold 192", createThresholdOp(192, 0, 255));
		imageOperations.put("Threshold 128", createThresholdOp(128, 0, 255));
		imageOperations.put("Threshold 64", createThresholdOp(64, 0, 255));
	}

	public BufferedImageOp createThresholdOp(int threshold, int minimum, int maximum)
    {
		short[] thresholdArray = new short[256];

		for (int i = 0; i < 256; i++)
		{
		  if (i < threshold)
		  {
			thresholdArray[i] = (short)minimum;
		  }
		  else
		  {
			thresholdArray[i] = (short)maximum;
		  }
		}

		return new LookupOp(new ShortLookupTable(0, thresholdArray), null);
    }

    public void sharpenImage()
	{
		if (blnProblem)
		{
			return;
		}

		mBufferedImage = oBufferedImage;
		op = (BufferedImageOp)imageOperations.get("Sharpen");
        mBufferedImage     = op.filter(mBufferedImage, null);       
        repaint();
	}

	public void blurImage()
	{
		if (blnProblem)
		{
			return;
		}

		mBufferedImage = oBufferedImage;
		op = (BufferedImageOp)imageOperations.get("Blur");
        mBufferedImage     = op.filter(mBufferedImage, null);       
        repaint();
	}

	public void edgeTracing()
   {		
	int w,h;
	filter = new MyEdgeFilter();
	w = oBufferedImage.getWidth();
	h = oBufferedImage.getHeight();
	System.out.println("FILTER W=" + w + "H="  +h);
	
	int [] rawData = oBufferedImage.getRGB(0,0,w,h,null,0,w);
    System.out.println("FILTER rawData[] =" + rawData);
	 
	int[] processedData = filter.filterPixels(w,h,rawData, new Rectangle(w,h));
	System.out.println("FILTER processedData[] =" + processedData);
	oBufferedImage.setRGB(0,0,w,h,processedData,0,w);
	repaint();
    }
	
	
  
    public void negativeEffect()
	{
		if (blnProblem)
		{
			return;
		}

		mBufferedImage = oBufferedImage;
		op = (BufferedImageOp)imageOperations.get("Invert");
        mBufferedImage     = op.filter(mBufferedImage, null);       
        repaint();
	}
	public void posterizeImage()
	{
		if (blnProblem)
		{
			return;
		}

		mBufferedImage = oBufferedImage;
		op = (BufferedImageOp)imageOperations.get("Posterize");
        mBufferedImage     = op.filter(mBufferedImage, null);       
        repaint();
	}
	public void blueNImage()
	{
		if (blnProblem)
		{
			return;
		}

		mBufferedImage = oBufferedImage;
		op = (BufferedImageOp)imageOperations.get("Invert blue");
        mBufferedImage     = op.filter(mBufferedImage, null);       
        repaint();
	}
	public void threshold192Image()
	{
		if (blnProblem)
		{
			return;
		}

		mBufferedImage = oBufferedImage;
		op = (BufferedImageOp)imageOperations.get("Threshold 192");
        mBufferedImage     = op.filter(mBufferedImage, null);       
        repaint();
	}
	public void threshold128Image()
	{
		if (blnProblem)
		{
			return;
		}

		mBufferedImage = oBufferedImage;
		op = (BufferedImageOp)imageOperations.get("Threshold 128");
        mBufferedImage     = op.filter(mBufferedImage, null);       
        repaint();
	}
	public void threshold64Image()
	{
		if (blnProblem)
		{
			return;
		}

		mBufferedImage = oBufferedImage;
		op = (BufferedImageOp)imageOperations.get("Threshold 64");
        mBufferedImage     = op.filter(mBufferedImage, null);       
        repaint();
	}
	
	
	
	
	public void GaussianFilter()
	{
	GaussianFilter gaussianFilter = new GaussianFilter();
	gaussianFilter.filter(oBufferedImage,mBufferedImage);
	repaint();
	}
	
	public void DilateFilter()
	{
	DilateFilter dilateFilter = new DilateFilter();
	dilateFilter.filter(oBufferedImage,mBufferedImage);
	repaint();
	}
	public void GlowFilter()
	{
	GlowFilter glowFilter = new GlowFilter();
	glowFilter.filter(oBufferedImage,mBufferedImage);
	repaint();
	}
	public void ChromeFilter()
	{
	ChromeFilter chromeFilter = new ChromeFilter();
	chromeFilter.filter(oBufferedImage,mBufferedImage);
	repaint();
	}
	public void OliFilter()
	{
	MyOilFilter oilFilter = new MyOilFilter();
	oilFilter.filter(oBufferedImage,mBufferedImage);
	repaint();
	}
	public void ContrastFilter()
	{
	ContrastFilter contrastFilter = new ContrastFilter();
	contrastFilter.filter(oBufferedImage,mBufferedImage);
	repaint();
	}
	public void MyDiffusionFilter()
	{
	MyDiffusionFilter diffusionFilter = new MyDiffusionFilter();
	diffusionFilter.filter(oBufferedImage,mBufferedImage);
	repaint();
	}
	public void MyEmbossFilter()
	{
	MyEmbossFilter embossFilter = new MyEmbossFilter();
	embossFilter.filter(oBufferedImage,mBufferedImage);
	repaint();
	}
	public void MyMedianFilter()
	{
	MyMedianFilter medianFilter = new MyMedianFilter();
	medianFilter.filter(oBufferedImage,mBufferedImage);
	repaint();
	}
	public void MyLightFilter()
	{
	MyLightFilter lightFilter = new MyLightFilter();
	lightFilter.filter(oBufferedImage,mBufferedImage);
	repaint();
	}
	public void MyEqualizeFilter()
	{
	MyEqualizeFilter equalizeFilter = new MyEqualizeFilter();
	equalizeFilter.filter(oBufferedImage,mBufferedImage);
	repaint();
	}
	public void MyMaximumFilter()
	{
	MyMaximumFilter maxFilter = new MyMaximumFilter();
	maxFilter.filter(oBufferedImage,mBufferedImage);
	repaint();
	}
	public void SolarizeFilter()
	{
	SolarizeFilter solarizeFilter = new SolarizeFilter();
	solarizeFilter.filter(oBufferedImage,mBufferedImage);
	repaint();
	}
	public void MyMinimumFilter()
	{
	MyMinimumFilter minFilter = new MyMinimumFilter();
	minFilter.filter(oBufferedImage,mBufferedImage);
	repaint();
	}
	public void BumpFilter()
	{
    BumpFilter bumpFilter = new BumpFilter();
	bumpFilter.filter(oBufferedImage,mBufferedImage);
	repaint();
	}
	public void ContourFilter()
	{
    ContourFilter contourFilter = new ContourFilter();
	contourFilter.filter(oBufferedImage,mBufferedImage);
	repaint();
	}
	public void ExposureFilter()
	{
    ExposureFilter exposureFilter = new ExposureFilter();
	exposureFilter.filter(oBufferedImage,mBufferedImage);
	repaint();
	}
	public void DitherFilter()
	{
    DitherFilter ditherFilter = new DitherFilter();
	ditherFilter.filter(oBufferedImage,mBufferedImage);
	repaint();
	}
	public void DisplaceFilter()
	{
    DisplaceFilter displaceFilter = new DisplaceFilter();
	displaceFilter.filter(oBufferedImage,mBufferedImage);
	repaint();
	}
	
	public void FlipFilter()
	{
    FlipFilter flipFilter = new FlipFilter();
	flipFilter.filter(oBufferedImage,mBufferedImage);
	repaint();
	}
	public void MirrorFilter()
	{
    MirrorFilter mirrorFilter = new MirrorFilter();
	mirrorFilter.filter(oBufferedImage,mBufferedImage);
	repaint();
	}
	public void RotateFilter()
	{
    RotateFilter rotateFilter = new RotateFilter();
	rotateFilter.filter(oBufferedImage,mBufferedImage);
	repaint();
	}
	
	public void CropFilter()
	{
	System.out.println("ab*00**************");
	int pixels[]=new int[oBufferedImage.getWidth()*oBufferedImage.getHeight()];
	Histogram histogram = new Histogram(pixels,oBufferedImage.getWidth(),oBufferedImage.getHeight(),0,oBufferedImage.getWidth());
	//CropFilter cp= new CropFilter();
	System.out.println("aa*66*********");
	//cp.filter(oBufferedImage,mBufferedImage);
	System.out.println("aa23***********");
	repaint();
	}
	
	
	public void zoomImage(double p)
	{
	double percentage=p;
	imageZoomer = new ImageZoomerFrame(mBufferedImage, percentage, " ");
	}
	
	
	
    public void rescaleImage()
	{		
		if (blnProblem)
		{
			return;
		}

		blnRescale     = true;
		mBufferedImage = oBufferedImage;
		AffineTransform at = new AffineTransform();
		biop = null;

		int bw = mBufferedImage.getWidth(this);
		int bh = mBufferedImage.getHeight(this);

		bimg = new BufferedImage(bw,bh,BufferedImage.TYPE_INT_RGB);
		RescaleOp rop = new RescaleOp(1.5f, 1.0f, null); 		
		rop.filter(mBufferedImage,bimg);

		biop = new AffineTransformOp(at, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		repaint();
	}
	
	
	
	
	
	

    public void paint(Graphics g) 
    {
		if (mBufferedImage == null) return;		

		if (blnRescale)
		{
			Graphics2D g2 = (Graphics2D) g;
			g2.drawImage(bimg,biop, 0, 0);

			blnRescale = false;
		}
		else
		{
			g.drawImage(mBufferedImage, 0, 0, null);
		}
    }
    
    public void setImage(Image img)
    {
    	this.image = img;
    	
    	try
        {
        	mBufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
			Graphics2D g2 = mBufferedImage.createGraphics();
			g2.drawImage(image, null, null);	

			oBufferedImage = mBufferedImage; 
        }
        catch (Exception ex)
        {
			System.out.println("\nPROBLEM");
			blnProblem = true;
        }
        
    	repaint();
    }
    
}
