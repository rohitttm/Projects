import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.awt.geom.*;
import javax.swing.filechooser.*;
import com.sun.image.codec.jpeg.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;

public class EnhancedImage extends JFrame implements MouseListener
{
	Container     	c;	
	ImageEnhancer 	imageEnhancer;
	OriginalImage 	originalImage;
	JPanel        	originalPanel, enhancedPanel;
	JPanel        	originPanel, enhancePanel;
	TitledBorder  	originalBorder, enhancedBorder;
	JButton       	jbtnReset,jbtnSave;
	JTabbedPane   	jtp;
	JTextArea	  	jta;
	JMenuBar		jmb1;
	JMenu			jmfile,jmmore,jmBlur,jmFilter,jmOption,jmNegative,jmSharpen,jmRotate;
	JMenuItem		jmiGaussian,jmiblur,jmiMinimum,jmiMedian,jmiMaximum,jmiZoom;
	JMenuItem		jmiNegative,jmiSolarise,jmiBlueNegative,jmiGlow,jmiLight,jmiThreshold,jmiExposure,jmiEqualize;
	JMenuItem		sharpan,rescale,bump,counter,dither,contrast,histogram;
	JMenuItem		rotate,mirror,displace,flip,zoomin,zoomout,jmicrop;
	JMenuItem		edgetracing,posterise,chrome,emobss,oil,diffuse,dilate;
	JMenuItem		save,reset,close,pmreset;
	JSeparator		jSeparator1,jSeparator2;
	JPanel			imagePanel;
	ImageIcon 		iconsave,iconreset,iconclose,iconzoomin,iconzoomout,iconsharp,iconnegative,iconmore,iconblur,iconneg,iconsharpen;
    JPopupMenu 		pmenu;
	JScrollPane 	jsp1;
	private Cursor m_Cursor;
    final Image img;
	Insets insets;
	 EnhancedImage app1;
	 			

	public EnhancedImage(Image image)
	{ 
	    super();
	    img = image;
		
		
		
		Image icon = Toolkit.getDefaultToolkit().getImage("doctor.png");
		super.setIconImage(icon);

		setSize(1024,768);	
		setLocation(250,0);

		c = getContentPane();
        c.setLayout(null);
		setResizable(false);
		setTitle("IMAGE ENHANCER");	 
		
		pmenu = new JPopupMenu();
		pmreset= new JMenuItem("Reset");
		pmenu.add(pmreset);
		
		
		pmreset.addActionListener(new ActionListener()
			{
			public void actionPerformed(ActionEvent e)
			{
				imageEnhancer.setImage(img);
			}
			});

		
		jmb1 = new JMenuBar();
		c.add(jmb1);
		
		jmfile= new JMenu("FILE");
		jmfile.setMnemonic('F');		
		jmb1.add(jmfile);
		
		iconsave = new ImageIcon(getClass().getResource("icon/savee.png"));
		save= new JMenuItem("SAVE", iconsave);
		save.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
		jmfile.add(save);
		
		iconreset = new ImageIcon(getClass().getResource("icon/reset.gif"));
		reset= new JMenuItem("RESET",iconreset);
		reset.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK));
		jmfile.add(reset);
					
		
		
		
		
		jSeparator1 = new JSeparator();	
		jmfile.add(jSeparator1);
		
		iconclose = new ImageIcon(getClass().getResource("icon/cloapph.gif"));
		close=new JMenuItem("EXIT",iconclose);				
		close.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
		jmfile.add(close);
		

		jmFilter = new JMenu();
		jmFilter.setMnemonic('M');
		jmFilter.setText("FILTER");
		jmb1.add(jmFilter);
		
		
		//Blur menu
		iconblur = new ImageIcon(getClass().getResource("icon/blur.jpg"));
		jmBlur = new JMenu();
		jmBlur.setText("BLUR");
		jmBlur.setIcon(iconblur);
		
		jmiblur = new JMenuItem("BLUR");
		jmBlur.add(jmiblur);
		
		jmiGaussian = new JMenuItem("GAUSSIAN");
		jmBlur.add(jmiGaussian);


		jmiMaximum = new JMenuItem("MAXIMUM");
		jmBlur.add(jmiMaximum);
		
		jmiMedian = new JMenuItem("MEDIAN");
		jmBlur.add(jmiMedian);
		
		jmiMinimum = new JMenuItem("MINIMUM");
		jmBlur.add(jmiMinimum);
		
		jmFilter.add(jmBlur);
		
				
		//sharp menu  
		iconsharpen = new ImageIcon(getClass().getResource("icon/sharpen.gif"));
		jmSharpen = new JMenu();		
		jmSharpen.setText("SHARPEN");
		jmFilter.add(jmSharpen);
		jmSharpen.setIcon(iconsharpen);

		bump = new JMenuItem("BUMP");
		jmSharpen.add(bump);

		contrast = new JMenuItem("CONTRAST");
		jmSharpen.add(contrast);
		
		counter = new JMenuItem("COUNTER");
		jmSharpen.add(counter);
		
		dither = new JMenuItem("DiITHER");
		jmSharpen.add(dither);		
		
		rescale = new JMenuItem("RESCALE");
		jmSharpen.add(rescale);

		sharpan = new JMenuItem("SHARPEN");
		jmSharpen.add(sharpan);
		
		
		//negative
		iconneg = new ImageIcon(getClass().getResource("icon/neg.jpg"));
		jmNegative=new JMenu("NEGATIVE");
		jmFilter.add(jmNegative);
		jmNegative.setIcon(iconneg);
		
		jmiNegative = new JMenuItem("NEGATIVE");
		jmNegative.add(jmiNegative);
		
		jmiSolarise = new JMenuItem("SOLARIZE");
		jmNegative.add(jmiSolarise);
		
		jmiBlueNegative = new JMenuItem("BLUE NEGATIVE");
		jmNegative.add(jmiBlueNegative);
		
		jmiGlow = new JMenuItem("GLOW");
		jmNegative.add(jmiGlow);
		
		jmiLight = new JMenuItem("LIGHT");
		jmNegative.add(jmiLight);
		
		jmiThreshold = new JMenuItem("THRESHOLD");
		jmNegative.add(jmiThreshold);
		
		jmiExposure = new JMenuItem("EXPOSURE");
		jmNegative.add(jmiExposure);
		
		jmiEqualize = new JMenuItem("NEGATIVE");
		jmNegative.add(jmiEqualize);
		
		
		//more
		iconmore=new ImageIcon(getClass().getResource("icon/more.png"));
		jmmore=new JMenu("MORE..");
		jmFilter.add(jmmore);
		jmmore.setIcon(iconmore);
		
		edgetracing = new JMenuItem("EDGETRACING");
		jmmore.add(edgetracing);		
		
		posterise = new JMenuItem("POSTERISE");
		jmmore.add(posterise);		
		
		chrome= new JMenuItem("CHROME");
		jmmore.add(chrome);		
		
		emobss = new JMenuItem("EMOBSS");
		jmmore.add(emobss);		
		
		oil= new JMenuItem("OIL");
		jmmore.add(oil);		
		
		diffuse= new JMenuItem("DIFFUSE");
		jmmore.add(diffuse);		
		
		dilate= new JMenuItem("DILATE");
		jmmore.add(dilate);		
			
		
	
		//option
		jmOption = new JMenu();
		jmOption.setMnemonic('R');
		jmOption.setText("TOOL's");
		jmb1.add(jmOption);		
		
		
		jmRotate = new JMenu();
		jmRotate.setText("ROTATE");
		jmOption.add(jmRotate);
		ImageIcon rotatee = new ImageIcon(getClass().getResource("icon/rotate.jpg"));
		jmRotate.setIcon(rotatee);
		
		displace= new JMenuItem("DISPLACE");
		jmRotate.add(displace);
		
		
		flip= new JMenuItem("FLIP");
		jmRotate.add(flip);
		
		mirror= new JMenuItem("MIRROR");
		jmRotate.add(mirror);
	
		rotate= new JMenuItem("ROTATE");
		jmRotate.add(rotate);
		
		zoomin = new JMenuItem();
		zoomin.setText("ZOOM IN");
		jmOption.add(zoomin);
		iconzoomin = new ImageIcon(getClass().getResource("icon/zoom_in.png"));
		zoomin.setIcon(iconzoomin);
		
		zoomout = new JMenuItem();
		zoomout.setText("ZOOM OUT");
		jmOption.add(zoomout);
		iconzoomout = new ImageIcon(getClass().getResource("icon/zoom_out.png"));
		zoomout.setIcon(iconzoomout);

		/*jmicrop = new JMenuItem();
		jmicrop.setText("CROP");
		jmOption.add(jmicrop);
		
		jmicrop.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
			System.out.println("\n\nhi1");
			BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
			Cropping crop=new Cropping();
			crop.callcrop(bi);
			
			
		    }
		});   */   	
		
		
		setJMenuBar(jmb1);
		
		
		//*****************************************************************
		

        originalBorder = BorderFactory.createTitledBorder("Original Image");
        enhancedBorder = BorderFactory.createTitledBorder("Enhanced Image");

		originalPanel  = new JPanel();
		originalPanel.setBounds(1,8,505,605);
		originalPanel.setLayout(null);
		originalPanel.setBorder(originalBorder);
		
		/*1*/
		enhancedPanel  = new JPanel();
		enhancedPanel.setLayout(null);
		enhancedPanel.setBorder(enhancedBorder);
		enhancedPanel.setBounds(505,8,505,605);	
	
		
		
		originPanel = new JPanel();
		originPanel.setLayout(null);
		originPanel.setBackground(new Color(226,227,230));
		originPanel.setBounds(2,610,500,120);
		c.add(originPanel);
		
		enhancePanel = new JPanel();
		enhancePanel.setLayout(null);
		enhancePanel.setBackground(new Color(226,227,230));		
		enhancePanel.setBounds(506,610,500,120);//
		c.add(enhancePanel);
		enhancedPanel.addMouseListener(this); 
		enhancedPanel.add(pmenu);
			
		
		jta = new JTextArea("ABOUT:");
		jta.setBounds(1,1,490,108);
		jta.setEditable(false);
		jta.setBackground(new Color(226,227,230));
		jta.setForeground(Color.black);

		
		JScrollPane jspT=new JScrollPane(jta);
		jspT.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jspT.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jspT.setBounds(1,1,500,118);
		originPanel.add(jspT);
		//////////////
	
		
		
		
	////////////////////////////	
	
		jtp=new JTabbedPane();
		jtp.addTab(" Blurig ", new BlurePanel());
		jtp.addTab("Negative", new NegativePanel());
		jtp.addTab("Sharpen", new SharpenPanel());
		jtp.addTab("Rotate", new RotatePanel());
		jtp.addTab("More...", new MorePanel());
		jtp.addTab("Zooming", new ZoomPanel());
		jtp.setBounds(5,27,490,90);
		jtp.setBackground(new Color(226,227,230));
		enhancePanel.add(jtp);
		
		
        jbtnReset = new JButton("RESET");
		jbtnReset.setBounds(300,1,80,25);
		
		jbtnSave = new JButton("SAVE");
		jbtnSave.setBounds(382,1,80,25);
		
		
		
		
		
		
		
		
		
		
		enhancePanel.add(jbtnReset);
		enhancePanel.add(jbtnSave);
		
		

		
		originalImage = new OriginalImage(image);
		JScrollPane jsp = new JScrollPane(originalImage);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(5,20,495,575);
		originalPanel.add(jsp);
		originalImage.setPreferredSize(new Dimension((image.getWidth(this)+20),(image.getHeight(this)+20)));
		c.add(originalPanel);

		imageEnhancer = new ImageEnhancer(image);
		jsp1 = new JScrollPane(imageEnhancer);	
		jsp1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp1.setBounds(5,20,495,575);
		enhancedPanel.add(jsp1);
		imageEnhancer.setPreferredSize(new Dimension(image.getWidth(this),image.getHeight(this)));
		c.add(enhancedPanel); 
		
		
		
		jbtnReset.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
			 imageEnhancer.setImage(img);
			 jta.setText("ABOUT:");
		    }
		});      	
		jbtnSave.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
			JFileChooser fcc = new JFileChooser();
			fcc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			int returnVal = fcc.showDialog(app1,"Save");
				if (returnVal == JFileChooser.APPROVE_OPTION) 
				{
					File filex = fcc.getSelectedFile();
				//saveimage(bufferimagesave,filex);
				saveJPG(ImageEnhancer.mBufferedImage,filex);
				}
			}
		});
		
		
		reset.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
			 imageEnhancer.setImage(img);
			 jta.setText("ABOUT:");
		    }
		});      	
		save.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
			JFileChooser fcc = new JFileChooser();
			fcc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			int returnVal = fcc.showDialog(app1,"Save");
				if (returnVal == JFileChooser.APPROVE_OPTION) 
				{
					File filex = fcc.getSelectedFile();
				//saveimage(bufferimagesave,filex);
				saveJPG(ImageEnhancer.mBufferedImage,filex);
				}
			}
		});
		
		close.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
			DICOM 	d= new DICOM();
			d.setVisible(true);			
			dispose();
			}
		});
		
		//blur
		
		jmiblur.addActionListener(new ActionListener()
			{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.blurImage();
				jta.setText("BLURR-IMAGE:\nEACH PIXEL IN THE SOURCE IMAGE GETS SPREAD OVER AND MIXED INTOSURROUNDING PIXELS.\nANOTHER WAY TO LOOK AT THIS IS THAT EACH PIXEL IN THE DESTINATION IMAGE IS \nMADE UP OUT OF A MIXTURE OF SURROUNDING PIXELS FROM THE SOURCE \nIMAGE");			
		    }
		});
		
		jmiGaussian.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.GaussianFilter();
				jta.setText("GAUSSIANFILTER:\nA GAUSSIAN BLUR IS THE RESULT OF BLURRING AN IMAGE BY A GAUSSIAN FUNCTION.\nIT IS A WIDELY USED EFFECT IN GRAPHICS SOFTWARE, TYPICALLY TO REDUCE IMAGE NOISE AND\nREDUCE DETAIL. THE VISUAL EFFECT OF THIS BLURRING TECHNIQUE IS A SMOOTH BLUR RESEMBLING THAT OF VIEWING THE \nIMAGE THROUGH A TRANSLUCENT SCREEN, DISTINCTLY DIFFERENT FROM THE BOKEH EFFECT PRODUCED BY AN OUT-OF-FOCUS\nLENS OR THE SHADOW OF AN OBJECT UNDER USUAL ILLUMINATION.");
				
		    }
		});
		
		jmiMaximum.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{				
				imageEnhancer.MyMaximumFilter();
				jta.setText("MAXIMUMFILTER:\nTHIS FILTER REPLACES EACH PIXEL BY THE MAXIMUM OF THE INPUT PIXEL AND ITS EIGHT\nNEIGHBOURS. EACH OF THE RGB CHANNELS IS CONSIDERED SEPARATELY.");
				}
			});
		
		
		jmiMedian.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.MyMedianFilter();
				jta.setText("MEDIANFILTER:\nTHIS FILTER REPLACES EACH PIXEL BY THE MEDIAN OF THE INPUT PIXEL AND ITS EIGHT \nNEIGHBOURS. EACH OF THE RGB CHANNELS IS CONSIDERED SEPARATELY.");
										
		    }
		});
		
		jmiMinimum.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.MyMinimumFilter();
				jta.setText("MINIMUMFILTER:\nTHIS FILTER REPLACES EACH PIXEL BY THE MINIMUM OF THE INPUT PIXEL AND ITS EIGHT\nNEIGHBOURS. EACH OF THE RGB CHANNELS IS CONSIDERED SEPARATELY.");
										 					
		    }
		});
		
		
		//negative 
		
		jmiSolarise.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.SolarizeFilter();
				jta.setText("SOLARIZEFILTER:\nSOLARISATION IS A PHENOMENON IN WHICH THE IMAGE RECORDED ON A NEGATIVE OR\nON A PHOTOGRAPHIC PRINT IS WHOLLY OR PARTIALLY REVERSED IN TONE. DARK AREAS APPEAR LIGHT OR LIGHT AREAS APPEAR DARK.\nTHE TERM IS SYNONYMOUS WITH THE SABATTIER EFFECT WHEN REFERRING TO NEGATIVES, BUT IS TECHNICALLY \nINCORRECT WHEN USED TO REFER TO PRINTS.");
		    }
		});
		
		jmiNegative.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.negativeEffect();
				jta.setText("NEGATIVE:\nA POSITIVE IMAGE IS A NORMAL IMAGE. A NEGATIVE IMAGE IS A TOTAL INVERSION OF A \nPOSITIVE IMAGE, IN WHICH LIGHT AREAS APPEAR DARK AND VICE VERSA.");
		    }
		});
		jmiBlueNegative.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.blueNImage();
				jta.setText("BLUENEGATIVE:\nA POSITIVE IMAGE IS A NORMAL IMAGE.A NEGATIVE COLOR IMAGE IS ADDITIONALLY COLOR \nREVERSED, WITH RED AREAS APPEARING CYAN, GREENS APPEARING MAGENTA AND BLUES APPEARING YELLOW. THIS SOMETIMES \nCAN HAVE A REVERSE EFFECT AND CAUSE THE GREENS TO APPEAR A REDDISH BROWN.");
		    }
		});
		
		jmiGlow.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.GlowFilter();
				jta.setText("GLOWFILTER:\nTHIS FILTER PRODUCES A GLOWING EFFECT ON AN IMAGE BY ADDING A BLURRED \nVERSION OF THE IMAGE TO SUBTRACTED FROM THE ORIGINAL IMAGE.");
				
		    }
		});
		
		jmiLight.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.MyLightFilter();
				jta.setText("LIGHTFILTERR:\nTHIS FILTER PROVIDES SOPHISTICATED EMBOSSING EFFECTS, USING PHONG SHADING TO \nSIMULATE THE APPEARANCE OF LIGHT SHINING ONTO THE IMAGE. YOU CAN USE THE INPUT IMAGE AS A \nTEXTURE MAP OR AS A BUMP MAP OR BOTH.. ");
										
		    }
		});
		
		jmiThreshold.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.threshold64Image();
				jta.setText("THRESHOLD:\nTHRESHOLDING IS USED TO SEGMENT AN IMAGE BY SETTING ALL PIXELS WHOSE INTENSITY VALUES \nARE ABOVE A THRESHOLD TO A FOREGROUND VALUE AND ALL THE REMAINING PIXELS TO A BACKGROUND VALUE.");
		    }
		});
		
		jmiExposure.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.ExposureFilter();
				jta.setText("EXPOSURE:\nEXPOSURE FUSION IS GUIDED BY WEIGHT MAPS FOR EACH INPUT IMAGE. A HIGH WEIGHT MEANS THAT A \nPIXEL SHOULD APPEAR IN THE FINAL IMAGE. THESE WEIGHTS REFLECT DESIRED IMAGE QUALITIES, \nSUCH AS HIGH CONTRAST AND SATURATION.");

		    }
		});
		
		jmiEqualize.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.MyEqualizeFilter();
				jta.setText(" EQUALIZEFILTER:\nEQUALIZATION IS THE PROCESS OF USING PASSIVE OR ACTIVE ELECTRONIC \nELEMENTS OR DIGITAL ALGORITHMS FOR THE PURPOSE OF ALTERING (ORIGINALLY FLATTENING) THE \nFREQUENCY RESPONSE CHARACTERISTICS OF A SYSTEM");

		    }
		});
		
		//Sharpen  ,,,,,
		
		sharpan.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.sharpenImage();
				jta.setText("SHARPENFILTER:\nTHIS FILTER SHARPENS AN IMAGE BY SHARP MASKING, WHERE A BLURRED VERSION \nOF THE IMAGE IS SUBTRACTED FROM THE ORIGINAL IMAGE.");
		    }
		});
		
		rescale.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.rescaleImage();
				jta.setText("RESCALEFILTER:\nTHIS FILTER SHARP AN IMAGE BY DRAWING AN IMAGE WITH BRIGHTER SCALE.\nIT PRODUCE MORE BRIGHTNESS IN IMAGE.");
		    }
		});
		
		bump.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.BumpFilter();
				jta.setText("BUMPFILTER:\nTHIS FILTER CREATES A 3D EFFECT BY EMBOSSING AN IMAGE AND THEN MAPPING IT TO ANOTHER IMAGE.\nBUMP HEIGHT DEPENDS ON PIXEL LUMINOSITY AND YOU CAN SET LIGHT DIRECTION.\nYOU CAN BUMP MAP ANY TYPE OF IMAGE, UNLIKE THE EMBOSS FILTER.");

		    }
		});
		
		counter.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.ContourFilter();
				jta.setText("CONTOURFILTER:\nTHIS FILTER DETECTS THE EACH EVERY EDGES IN THE IMAGE AND \nSEPERATE IT BY DRAWING THE LINE."); 
		    }
		});
		
		
		dither.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.DitherFilter();
				jta.setText("DITHERFILTER:\n THIS FILTER SMOOTH JAGGED EDGES OF A CURVE BY PLACING SHADED PIXELS BETWEEN THE PIXELS \nTHAT MAKE UP THE CURVE AND THE PATTERN OF BLACK AND WHITE PIXELS EQUALLY SPACED WOULD\nAPPEAR AS GREY.");
		    }
		});
		
		contrast.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.ContrastFilter();
				jta.setText("CONTRASTFILTER:\nCONTRAST FILTER GRADUALLY DARK THE DARKER PORTION OF IMAGE \nAND BRIGHT THE BRIGHTER PORTION OF AN IMAGE.");
		    }
		});
				
		
		//More.. 
		
		edgetracing.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.edgeTracing();
				jta.setText("EDGE TRACING:\nTHIS FILTER DETECTS THE EDGES IN A FILTER. FOR EACH PIXEL, IT LOOKS A EACH \nCHANNEL, FINDS THE LOCAL GRADIENT  AND REPLACES THE CHANNEL BY A VALUE DETERMINED BY THE \nGRADIENT. EDGES BECOME WHITE  WHILE FLAT AREAS BECOME BLACK. \nYOU CAN CHOOSE BETWEEN VARIOUS KERNELS FOR CALCULATING THE GRADIENT.");
		    }
		});
		
		posterise.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.posterizeImage();
				jta.setText("POSTERIZEIMAGE:\nPOSTERIZATION OF AN IMAGE ENTAILS CONVERSION OF A CONTINUOUS GRADATION OF \nTONE TO SEVERAL REGIONS OF FEWER TONES, WITH ABRUPT CHANGES FROM ONE TONE TO ANOTHER.\nIT CAN NOW BE DONE PHOTOGRAPHICALLY OR WITH DIGITAL IMAGE PROCESSING, AND MAY BE DELIBERATE OR \nMAY BE AN UNINTENDED ARTIFACT OF COLOR QUANTIZATION.");
		    }
		});
	
		dilate.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.DilateFilter();
				jta.setText("DILATEFILTER:\nDILATION IS ONE OF THE TWO BASIC OPERATORS IN THE AREA OF MATHEMATICAL \nMORPHOLOGY, THE OTHER BEING EROSION. IT IS TYPICALLY APPLIED TO BINARY IMAGES,\nBUT THERE ARE VERSIONS THAT WORK ON GRAYSCALE IMAGES. ");
				
		    }
		});
		
		chrome.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.ChromeFilter();
				jta.setText("CHROMEFILTER:\nCHROME TREATS THE IMAGE AS IF IT WERE A POLISHED CHROME SURFACE. HIGHLIGHTS \nARE HIGH POINTS AND SHADOWS ARE LOW POINTS IN THE REFLECTING SURFACE.\nAFTER APPLYING THE FILTER, USE THE LEVELS DIALOG BOX TO ADD MORE CONTRAST TO THE IMAGE.");

		    }
		});
		
		oil.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.OliFilter();
				jta.setText("OILFILTER:\nTHIS FILTER PRODUCES AN OIL PAINTING EFFECT AS DESCRIBED IN THE BOOK  YOU CAN SPECIFY \nTHE SMEARING RADIUS. IT'S QUITE A SLOW FILTER ESPECIALLY WITH A LARGE RADIUS.");
										
		    }
		});
			
		diffuse.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.MyDiffusionFilter();
				jta.setText("DIFFUSIONFILTER:\nTHIS FILTER CONVERTS AN IMAGE TO A SPECIFIED NUMBER OF COLOURS USING \nFLOYD-STEINBERG ERROR DIFFUSION DITHERING. IT GENERALLY PRODUCES BETTER RESULTS THAN ORDERED \n DITHERING, WITH LESS DISTINCT PATTERNING. YOU CAN CHOOSE STRAIGHT \nOR SERPENTINE DITHERING AND THE NUMBER OF COLOR LEVELS TO DITHER TO.");
							
		    }
		});
		
		emobss.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.MyEmbossFilter();
				jta.setText("EMBOSSFILTER:\nTHIS FILTER STAMPS AND CARVES THE ACTIVE LAYER OR SELECTION, GIVING IT\n RELIEF WITH BUMPS AND HOLLOWS. BRIGHT AREAS ARE RAISED AND DARK ONES ARE CARVED.\nYOU CAN VARY THE LIGHTING. ");
		    }
		});
	
	
	//ROTATE
	
		rotate.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.RotateFilter();
		    }
		});
		
		flip.addActionListener(new ActionListener()
			{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.FlipFilter();
				jta.setText("FLIPIMAGE:\nA FLIPPED IMAGE OR REVERSED IMAGE, THE MORE FORMAL TERM, IS A STATIC OR MOVING \nIMAGE THAT IS GENERATED BY A MIRROR-REVERSAL OF AN ORIGINAL ACROSS A HORIZONTAL AXIS.");
		    }
			});
	
		mirror.addActionListener(new ActionListener()
			{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.MirrorFilter();
				jta.setText("MirrorFilter:\nIt gives us an mirrior effect");
		    }
			});
			
		displace.addActionListener(new ActionListener()
			{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.DisplaceFilter();
				 jta.setText("DISPLACEFILTER:\nDISPLACEFILTER DISTORTS AN IMAGE USING A DISPLACEMENT MAP. \nTHE DISPLACEMENT MAP IS A GRAYSCALE IMAGE WHOSE GRADIENT AT EACH POINT IS USED TO DISPLACE \nPIXELS IN THE SOURCE IMAGE");
						
		    }
			});
	
		
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				DICOM 	d= new DICOM();
				d.setVisible(true);
				dispose();					
			}
		});
		
		

		setVisible(true);		
		
	}

	
////////////////////////////////////////

	
	 private void adjustLayout() 
    { 
        enhancedPanel.doLayout();         
        jsp1.doLayout(); 

       
    } 
	
	
	
	public void mouseClicked(MouseEvent event)  
    { 
        
         if(event.getButton() == MouseEvent.BUTTON3) 
        { 
           if( event.isPopupTrigger() )
			{
			pmenu.show( event.getComponent(),
								event.getX(), event.getY() );
			}

		super.processMouseEvent( event );
        } 
		adjustLayout(); 
        
    } 
         
    public void mouseEntered(MouseEvent e) 
    { 	  
		enhancedPanel.setCursor(m_Cursor); 
	} 
            
    public void mouseExited(MouseEvent e) 
    { 	    } 
            
    public void mousePressed(MouseEvent e) 
    { 		   } 
            
    public void mouseReleased(MouseEvent e) 
    {		   } 

	
	  public void processMouseEvent( MouseEvent event )
	{
		if( event.isPopupTrigger() )
		{
			pmenu.show( event.getComponent(),
								event.getX(), event.getY() );
		}

		super.processMouseEvent( event );
	}

	public void actionPerformed( ActionEvent event )
	{
		
		System.out.println( ""+event );
	}
	
	/////////////////////////////////////////
	
	public static void saveJPG(Image img, File s)
		{
				BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
				Graphics2D g2 = bi.createGraphics();
				g2.drawImage(img, null, null);
			 
				FileOutputStream out = null;
				try
				{ 
				  out = new FileOutputStream(s); 
				}
				catch (java.io.FileNotFoundException io)
				{ 
				  System.out.println("File Not Found"  + io); 
				}
				
				JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
				JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(bi);
				param.setQuality(0.5f,false);
				encoder.setJPEGEncodeParam(param);
				
				try 
				{ 
				  encoder.encode(bi); 
				  out.close(); 
				}
				catch (java.io.IOException io) 
				{
				  System.out.println("IOException"); 
				}
		}
	

//zoom class	
	
class BlurePanel extends JPanel
{
	JButton jbBlur,jbGaussian,jbMin,jbMedian,jbMax;
	public BlurePanel()
	{
		setBackground(new Color(226,227,230));
	
		
		jbBlur=new JButton("Bluring");
		jbGaussian=new JButton("Gaussian");
		jbMin=new JButton("Minimum");
		jbMax=new JButton("Maximum");
		jbMedian=new JButton("Median");
		
		add(jbBlur);
		add(jbGaussian);
		add(jbMin);
		add(jbMedian);
		add(jbMax);
	
	
	
	
		jbBlur.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.blurImage();
				jta.setText("BLURR-IMAGE:\nEACH PIXEL IN THE SOURCE IMAGE GETS SPREAD OVER AND MIXED INTOSURROUNDING PIXELS.\nANOTHER WAY TO LOOK AT THIS IS THAT EACH PIXEL IN THE DESTINATION IMAGE IS \nMADE UP OUT OF A MIXTURE OF SURROUNDING PIXELS FROM THE SOURCE \nIMAGE");
				
				
				
		    }
		});
		jbGaussian.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.GaussianFilter();
				jta.setText("GAUSSIANFILTER:\nA GAUSSIAN BLUR IS THE RESULT OF BLURRING AN IMAGE BY A GAUSSIAN FUNCTION.\nIT IS A WIDELY USED EFFECT IN GRAPHICS SOFTWARE, TYPICALLY TO REDUCE IMAGE NOISE AND\nREDUCE DETAIL. THE VISUAL EFFECT OF THIS BLURRING TECHNIQUE IS A SMOOTH BLUR RESEMBLING THAT OF VIEWING THE \nIMAGE THROUGH A TRANSLUCENT SCREEN, DISTINCTLY DIFFERENT FROM THE BOKEH EFFECT PRODUCED BY AN OUT-OF-FOCUS\nLENS OR THE SHADOW OF AN OBJECT UNDER USUAL ILLUMINATION.");
				
		    }
		});
		jbMin.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.MyMinimumFilter();
				jta.setText("MINIMUMFILTER:\nTHIS FILTER REPLACES EACH PIXEL BY THE MINIMUM OF THE INPUT PIXEL AND ITS EIGHT\nNEIGHBOURS. EACH OF THE RGB CHANNELS IS CONSIDERED SEPARATELY.");
										 					
		    }
		});
		jbMax.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.MyMaximumFilter();
				jta.setText("MAXIMUMFILTER:\nTHIS FILTER REPLACES EACH PIXEL BY THE MAXIMUM OF THE INPUT PIXEL AND ITS EIGHT\nNEIGHBOURS. EACH OF THE RGB CHANNELS IS CONSIDERED SEPARATELY.");
											 
		    }
		});
		jbMedian.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.MyMedianFilter();
				jta.setText("MEDIANFILTER:\nTHIS FILTER REPLACES EACH PIXEL BY THE MEDIAN OF THE INPUT PIXEL AND ITS EIGHT \nNEIGHBOURS. EACH OF THE RGB CHANNELS IS CONSIDERED SEPARATELY.");
										
		    }
		});
		
	}
	
	
}


class NegativePanel extends JPanel
{
	JButton jbSolarize, jbNegative, jbBlueN, jbGlow, jbLight, jbThreshold64, jbExposure, jbEqualize;
	public NegativePanel()
	{
		setBackground(new Color(226,227,230));
		
		jbSolarize=new JButton("Solarize");
		jbNegative=new JButton("Negative");
		jbBlueN=new JButton("BlueN");
		jbGlow=new JButton("Glow");
		jbLight=new JButton("Light");
		jbThreshold64=new JButton("Threshold");
		jbExposure=new JButton("Exposure");
		jbEqualize=new JButton("Equalize");
	
		add(jbSolarize);
		add(jbNegative);
		add(jbBlueN);
		add(jbGlow);
		add(jbLight);
		add(jbThreshold64);
		add(jbExposure);
		add(jbEqualize);
	



		jbSolarize.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.SolarizeFilter();
				jta.setText("SOLARIZEFILTER:\nSOLARISATION IS A PHENOMENON IN WHICH THE IMAGE RECORDED ON A NEGATIVE OR\nON A PHOTOGRAPHIC PRINT IS WHOLLY OR PARTIALLY REVERSED IN TONE. DARK AREAS APPEAR LIGHT OR LIGHT AREAS APPEAR DARK.\nTHE TERM IS SYNONYMOUS WITH THE SABATTIER EFFECT WHEN REFERRING TO NEGATIVES, BUT IS TECHNICALLY \nINCORRECT WHEN USED TO REFER TO PRINTS.");
		    }
		});
		jbNegative.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.negativeEffect();
				jta.setText("NEGATIVE:\nA POSITIVE IMAGE IS A NORMAL IMAGE. A NEGATIVE IMAGE IS A TOTAL INVERSION OF A \nPOSITIVE IMAGE, IN WHICH LIGHT AREAS APPEAR DARK AND VICE VERSA.");
		    }
		});
		jbBlueN.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.blueNImage();
				jta.setText("BLUENEGATIVE:\nA POSITIVE IMAGE IS A NORMAL IMAGE.A NEGATIVE COLOR IMAGE IS ADDITIONALLY COLOR \nREVERSED, WITH RED AREAS APPEARING CYAN, GREENS APPEARING MAGENTA AND BLUES APPEARING YELLOW. THIS SOMETIMES \nCAN HAVE A REVERSE EFFECT AND CAUSE THE GREENS TO APPEAR A REDDISH BROWN.");
		    }
		});
		jbGlow.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.GlowFilter();
				jta.setText("GlowFilter:\nTHIS FILTER PRODUCES A GLOWING EFFECT ON AN IMAGE BY ADDING A BLURRED \nVERSION OF THE IMAGE TO SUBTRACTED FROM THE ORIGINAL IMAGE.");
				
		    }
		});
		jbLight.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.MyLightFilter();
				jta.setText("LIGHTFILTERR:\nTHIS FILTER PROVIDES SOPHISTICATED EMBOSSING EFFECTS, USING PHONG SHADING TO \nSIMULATE THE APPEARANCE OF LIGHT SHINING ONTO THE IMAGE. YOU CAN USE THE INPUT IMAGE AS A \nTEXTURE MAP OR AS A BUMP MAP OR BOTH.. ");
										
		    }
		});
		jbThreshold64.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.threshold64Image();
				jta.setText("THRESHOLD:\nTHRESHOLDING IS USED TO SEGMENT AN IMAGE BY SETTING ALL PIXELS WHOSE INTENSITY VALUES \nARE ABOVE A THRESHOLD TO A FOREGROUND VALUE AND ALL THE REMAINING PIXELS TO A BACKGROUND VALUE.");
		    }
		});
		jbExposure.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.ExposureFilter();
				jta.setText("EXPOSURE:\nEXPOSURE FUSION IS GUIDED BY WEIGHT MAPS FOR EACH INPUT IMAGE. A HIGH WEIGHT MEANS THAT A \nPIXEL SHOULD APPEAR IN THE FINAL IMAGE. THESE WEIGHTS REFLECT DESIRED IMAGE QUALITIES, \nSUCH AS HIGH CONTRAST AND SATURATION.");

		    }
		});
		jbEqualize.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.MyEqualizeFilter();
				jta.setText(" EQUALIZEFILTER:\nEQUALIZATION IS THE PROCESS OF USING PASSIVE OR ACTIVE ELECTRONIC \nELEMENTS OR DIGITAL ALGORITHMS FOR THE PURPOSE OF ALTERING (ORIGINALLY FLATTENING) THE \nFREQUENCY RESPONSE CHARACTERISTICS OF A SYSTEM");

		    }
		});
	}
}
class RotatePanel extends JPanel
{
	JButton jbRotate,jbMirror,jbFlip,jbDisplace;
	public RotatePanel()
	{
	setBackground(new Color(226,227,230));
	
	
	jbRotate=new JButton("Rotate");
	jbMirror=new JButton("Mirror");
	jbFlip=new JButton(" Flip ");
	jbDisplace=new JButton("Displace");
	
	
	add(jbRotate);
	add(jbMirror);
	add(jbFlip);
	add(jbDisplace);

	
	
	jbRotate.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.RotateFilter();
		    }
		});
	jbFlip.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.FlipFilter();
				jta.setText("FLIPIMAGE:\nA FLIPPED IMAGE OR REVERSED IMAGE, THE MORE FORMAL TERM, IS A STATIC OR MOVING \nIMAGE THAT IS GENERATED BY A MIRROR-REVERSAL OF AN ORIGINAL ACROSS A HORIZONTAL AXIS.");
		    }
		});
	jbMirror.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.MirrorFilter();
				jta.setText("MIRRORFILTER:\nIT GIVES US AN MIRRIOR KIND OF EFFECT");
		    }
		});
	jbDisplace.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.DisplaceFilter();
				 jta.setText("DISPLACEFILTER:\nDISPLACEFILTER DISTORTS AN IMAGE USING A DISPLACEMENT MAP. \nTHE DISPLACEMENT MAP IS A GRAYSCALE IMAGE WHOSE GRADIENT AT EACH POINT IS USED TO DISPLACE \nPIXELS IN THE SOURCE IMAGE");
						
		    }
		});
	
	
	
	
	}
}


class SharpenPanel extends JPanel
{	JButton		jbSharpen,jbDither, jbContrast,jbBump,jbContour,jbRescale; 
	public SharpenPanel()
	{
		setBackground(new Color(226,227,230));
		
		jbSharpen=new JButton("Sharpen");
		jbDither=new JButton("Dither");
		jbContrast=new JButton("Contrast");
		jbBump=new JButton("  Bump  ");
		jbContour=new JButton("Countour");
		jbRescale=new JButton("Rescale");
		
		add(jbSharpen);
		add(jbRescale);
		add(jbBump);
		add(jbContour);
		add(jbDither);
		add(jbContrast);
		
		jbSharpen.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.sharpenImage();
				jta.setText("SHARPENFILTER:\nTHIS FILTER SHARPENS AN IMAGE BY SHARP MASKING, WHERE A BLURRED VERSION \nOF THE IMAGE IS SUBTRACTED FROM THE ORIGINAL IMAGE.");
		    }
		});
		jbRescale.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.rescaleImage();
				jta.setText("RESCALEFILTER:\nTHIS FILTER SHARP AN IMAGE BY DRAWING AN IMAGE WITH BRIGHTER SCALE.\nIT PRODUCE MORE BRIGHTNESS IN IMAGE.");
		    }
		});
		jbBump.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.BumpFilter();
				jta.setText("BUMPFILTER:\nTHIS FILTER CREATES A 3D EFFECT BY EMBOSSING AN IMAGE AND THEN MAPPING IT TO ANOTHER IMAGE.\nBUMP HEIGHT DEPENDS ON PIXEL LUMINOSITY AND YOU CAN SET LIGHT DIRECTION.\nYOU CAN BUMP MAP ANY TYPE OF IMAGE, UNLIKE THE EMBOSS FILTER.");

		    }
		});
		jbContour.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.ContourFilter();
				jta.setText("CONTOURFILTER:\nTHIS FILTER DETECTS THE EACH EVERY EDGES IN THE IMAGE AND \nSEPERATE IT BY DRAWING THE LINE."); 
		    }
		});
		
		jbDither.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.DitherFilter();
				jta.setText("DITHERFILTER:\n THIS FILTER SMOOTH JAGGED EDGES OF A CURVE BY PLACING SHADED PIXELS BETWEEN THE PIXELS \nTHAT MAKE UP THE CURVE AND THE PATTERN OF BLACK AND WHITE PIXELS EQUALLY SPACED WOULD\nAPPEAR AS GREY.");
		    }
		});
		jbContrast.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.ContrastFilter();
				jta.setText("CONTRASTFILTER:\nCONTRAST FILTER GRADUALLY DARK THE DARKER PORTION OF IMAGE \nAND BRIGHT THE BRIGHTER PORTION OF AN IMAGE.");
		    }
		});
		
		


	}
}


class MorePanel	extends JPanel
{
	JButton jbEdge,jbChrome,jbPosterize,jbEmboss,jbOil,jbDiffusion,jbDilate;
	public MorePanel()
	{
	setBackground(new Color(226,227,230));
	
	
	jbEdge=new JButton("Edge Tracing");
	jbChrome=new JButton("Chrome");
	jbPosterize=new JButton("Posterize");
	jbEmboss=new JButton("Emboss");
	jbOil=new JButton(" Oil ");
	jbDiffusion=new JButton("Diffusion");
	jbDilate=new JButton("Dilate");
	
	add(jbEdge);
	add(jbPosterize);
	add(jbChrome);
	add(jbEmboss);
	add(jbOil);
	add(jbDiffusion);
	add(jbDilate);
	
	jbEdge.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.edgeTracing();
				jta.setText("EDGE TRACING:\nTHIS FILTER DETECTS THE EDGES IN A FILTER. FOR EACH PIXEL, IT LOOKS A EACH \nCHANNEL, FINDS THE LOCAL GRADIENT  AND REPLACES THE CHANNEL BY A VALUE DETERMINED BY THE \nGRADIENT. EDGES BECOME WHITE  WHILE FLAT AREAS BECOME BLACK. \nYOU CAN CHOOSE BETWEEN VARIOUS KERNELS FOR CALCULATING THE GRADIENT.");
		    }
		});
	jbPosterize.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.posterizeImage();
				jta.setText("POSTERIZEIMAGE:\nPOSTERIZATION OF AN IMAGE ENTAILS CONVERSION OF A CONTINUOUS GRADATION OF \nTONE TO SEVERAL REGIONS OF FEWER TONES, WITH ABRUPT CHANGES FROM ONE TONE TO ANOTHER.\nIT CAN NOW BE DONE PHOTOGRAPHICALLY OR WITH DIGITAL IMAGE PROCESSING, AND MAY BE DELIBERATE OR \nMAY BE AN UNINTENDED ARTIFACT OF COLOR QUANTIZATION.");
		    }
		});
	
	jbDilate.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.DilateFilter();
				jta.setText("DILATEFILTER:\nDILATION IS ONE OF THE TWO BASIC OPERATORS IN THE AREA OF MATHEMATICAL \nMORPHOLOGY, THE OTHER BEING EROSION. IT IS TYPICALLY APPLIED TO BINARY IMAGES,\nBUT THERE ARE VERSIONS THAT WORK ON GRAYSCALE IMAGES. ");
				
		    }
		});
	jbChrome.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.ChromeFilter();
				jta.setText("CHROMEFILTER:\nCHROME TREATS THE IMAGE AS IF IT WERE A POLISHED CHROME SURFACE. HIGHLIGHTS \nARE HIGH POINTS AND SHADOWS ARE LOW POINTS IN THE REFLECTING SURFACE.\nAFTER APPLYING THE FILTER, USE THE LEVELS DIALOG BOX TO ADD MORE CONTRAST TO THE IMAGE.");

		    }
		});
	jbOil.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.OliFilter();
				jta.setText("OILFILTER:\nTHIS FILTER PRODUCES AN OIL PAINTING EFFECT AS DESCRIBED IN THE BOOK  YOU CAN SPECIFY \nTHE SMEARING RADIUS. IT'S QUITE A SLOW FILTER ESPECIALLY WITH A LARGE RADIUS.");
										
		    }
		});
	jbDiffusion.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.MyDiffusionFilter();
				jta.setText("DIFFUSIONFILTER:\nTHIS FILTER CONVERTS AN IMAGE TO A SPECIFIED NUMBER OF COLOURS USING \nFLOYD-STEINBERG ERROR DIFFUSION DITHERING. IT GENERALLY PRODUCES BETTER RESULTS THAN ORDERED \n DITHERING, WITH LESS DISTINCT PATTERNING. YOU CAN CHOOSE STRAIGHT \nOR SERPENTINE DITHERING AND THE NUMBER OF COLOR LEVELS TO DITHER TO.");
							
		    }
		});
    jbEmboss.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				imageEnhancer.MyEmbossFilter();
				jta.setText("EMBOSSFILTER:\nTHIS FILTER STAMPS AND CARVES THE ACTIVE LAYER OR SELECTION, GIVING IT\n RELIEF WITH BUMPS AND HOLLOWS. BRIGHT AREAS ARE RAISED AND DARK ONES ARE CARVED.\nYOU CAN VARY THE LIGHTING. ");
		    }
		});
	
	
	
	
	}
}



class ZoomPanel extends JPanel	
{	

	double per=10.0;
	JLabel enterZoomPer;
	JTextField m_zoomPercentage; 
	JButton m_launch;
	public ZoomPanel()
	{
	setBackground(new Color(226,227,230));
	enterZoomPer=new JLabel("Entyer Zoom percentage:");
	m_zoomPercentage=new JTextField("10",5);
	m_launch=new JButton("ZOOM");
	add(enterZoomPer);
	add(m_zoomPercentage);
	add(m_launch);
	
	m_launch.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				try 
				{ 
					per = Double.valueOf(m_zoomPercentage.getText().trim()).intValue(); 
				} 
				catch(NumberFormatException numExp) 
				{ 
				}   
				jta.setText("zoom");
				imageEnhancer.zoomImage(per);
				String imageName="knee";
				
		    }
		});
		

	zoomin.addActionListener(new ActionListener()
		{
		 public void actionPerformed(ActionEvent e)
		    {		
				imageEnhancer.zoomImage(per);
				String imageName="knee";
				}
			});
			
	zoomout.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {				
				
				jta.setText("zoom");
				imageEnhancer.zoomImage(per);
				String imageName="knee";
				}
			});
		}
	}
		
}
