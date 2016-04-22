
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.* ;
import java.awt.image.* ;
import java.util.*;
import java.net.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.*;
import java.rmi.*;
import java.sql.*;
import com.sun.image.codec.jpeg.*;
 
 public class DICOM extends JFrame 
{
	public static String 				name;
	Container 			c;
	DICOM_PatientPanel 	DPP;
	DICOM_MiscPanel 	DMP;
	DICOM_Image_Panel 	DIP; 
	
	JMenuBar		jmb1;
	JMenu 			jm1,jm2;
	JMenuItem 		jmi1,jmi2,jmi3;
	JSeparator		jSeparator1,jSeparator2;
	JPanel    		imagePanel;
	JButton 		vmd ,jbtnEnhance;
	ImageIcon 		iconsave,iconreset,iconclose,iconopen;
	EnhancedImage 		eid;
	Image[ ]            img;
	DICOM_Image	        dicom_Image;
	static FileInputStream fis;
	static DataInputStream dis;	

	DicomReader Dr;
	DicomHeaderReader Dhr;
	byte[]  DICOM_Bytes;
	
	Image[] images;
	String[] info;
    
	int width, height;
	

	
	public DICOM()
	{	
		super("DICOM - DIGITAL IMAGING AND COMMUNICATIONS IN MEDICINE");
		toFront();
		setSize(1024,768);	
		setLocation(250,0);
		c = getContentPane();
		c.setLayout(null);	
		jmb1 = new JMenuBar();
		c.add(jmb1);
		
		jSeparator1 = new JSeparator();
		setResizable(false);
		
		jm1 = new JMenu();
		jm1.setMnemonic('F');
		jm1.setText("FILE");
		jmb1.add(jm1);
		
		jm2 = new JMenu();
		jm2.setMnemonic('R');
		jm2.setText("RESET");
		jmb1.add(jm2);
		
		JMenu jm3 = new JMenu();
		jm3.setMnemonic('A');
		jm3.setText("ABOUT");
		jmb1.add(jm3);
		
		/*ImageIcon iconhelp = new ImageIcon(getClass().getResource("icon/help.jpg"));
		JMenuItem help=new  JMenuItem("HELP",iconhelp);
		jm3.add(help);*/
		
		JMenuItem aboutus = new JMenuItem ("ABOUT US");
		jm3.add(aboutus);
		aboutus.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
			new About();
			}

            
        });		
		
		
		iconopen = new ImageIcon(getClass().getResource("icon/open.jpg"));
		jmi1 = new JMenuItem(iconopen);
		jmi1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
		jmi1.setMnemonic('o');
		jmi1.setText("OPEN");
		jm1.add(jmi1);
		jm1.add(jSeparator1);
		
	
		iconclose = new ImageIcon(getClass().getResource("icon/cloapph.gif"));
		jmi2 = new JMenuItem(iconclose);
		jmi2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        jmi2.setMnemonic('C');
		jmi2.setText("EXIT");
		jm1.add(jmi2);
		
		iconreset = new ImageIcon(getClass().getResource("icon/reset.gif"));
		jmi3 = new JMenuItem(iconreset);
		jmi3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK));
        jmi3.setMnemonic('x');
		jmi3.setText("RESET");
		jm2.add(jmi3);
		
				
		jbtnEnhance = new JButton("ENHANCE IMAGE");
        jbtnEnhance.setToolTipText("IMAGE ENHANCER");
	    jbtnEnhance.setBounds(430,677,300,28);
	     
        c.add(jbtnEnhance);
        jbtnEnhance.setEnabled(false);
		
	/*	help.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
			new MediaPlay();
			}

            
        });		
*/		
		
        jbtnEnhance.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
				DIP.buttoncall();
				setVisible(false);
            }
        });		
		
		setJMenuBar(jmb1);
		 
		vmd = new JButton("VIEW MORE DETAILS >>");
		vmd.setBounds(5,675,300,28);
		c.add(vmd);
		vmd.setEnabled(false);
		vmd.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("VIEWING MORE DETAILS...");
				
				TagsDialog tg = new TagsDialog(Dhr);
				                
            }
		}		
		);  
		//to add JTable for more details
		 
				 
		DPP = new DICOM_PatientPanel();
		c.add(DPP);
		
		DMP = new DICOM_MiscPanel();
		c.add(DMP);
		
		DIP  = new DICOM_Image_Panel();  // instantiate all objects in cons not above
		DIP.setBounds(307,7,705,750);
	    c.add(DIP);
		

		jmi1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
					System.out.println("ok");
					openfile();
			}
		}	
		
		);
		
		
		
		jmi2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		}
		);
		
		
		
		jmi3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
					DPP.reset_pat();
					DMP.reset_misc();
					DIP.jbtnEnhance.setEnabled(false);
					vmd.setEnabled(false);
					System.out.println(" Disabled ");
					DIP.jbtnFirst.setEnabled(false);
					DIP.jbtnPrev.setEnabled(false);
					DIP.jbtnNext.setEnabled(false);
					DIP.jbtnLast.setEnabled(false);
					
					images[0]=null;
					//DIP.setImages(images);
					DIP.dicom_Image.setView(0);
			}
		}
		);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{	
				
				System.exit(0);
				
			}
		});
		setVisible(true);

	}//constructor DICOM ends

    public void openfile()
	{			
       try
		{			
			
			JFileChooser fc;
			int returnVal;
			File file = null;
			
			System.out.println("DICOM Reader.");

			fc = new JFileChooser();
			File curDir = new File("DICOM_Files");
			fc.setCurrentDirectory(curDir);
			fc.setDialogTitle("Dicom Files");
			returnVal = fc.showDialog(null,"Accept");
			if (returnVal == JFileChooser.APPROVE_OPTION)
				{
					file = fc.getSelectedFile();
					System.out.println("Selected file: " + file.getName());
					 name=file.getName();


			 
		int n = 0;
		
		DICOM_Bytes = null;
    
	
	    try
        {			
			fis = new FileInputStream(file.getPath());
			
			dis = new DataInputStream(fis);
			
			DICOM_Bytes = new byte[dis.available()];

            dis.read(DICOM_Bytes, 0, dis.available());
            
        	Dr  = new DicomReader(DICOM_Bytes);
			Dhr = Dr.getDicomHeaderReader() ;

			String  manufacturer	= Dhr.getaString (0x0008,0x0070); 
			info = Dhr.getInfo();
	       
			for (int i = 0; i < info.length; ++i)
			{
			      System.out.println(info[i]);
			}  
            info=Dhr.getHeaderInfo();
            DPP.setInfo(info);
			DMP.setMiscInfo(info);

			
			try
			{				
				images = Dr.getImages();
				width  = Dhr.getColumns();
				height = Dhr.getRows();			
				
			}
			catch (Exception e)
			{	
			JOptionPane.showMessageDialog(null, "UNSUPPORTED FORMAT", "ERROR", JOptionPane.ERROR_MESSAGE);	
			System.out.println("$$$$Exception 12 : " + e.getMessage());
			vmd.setEnabled(false);
			jbtnEnhance.setEnabled(false);
										
			}

			
        }
        catch (Exception ex)
        {
        	JOptionPane.showMessageDialog(null, "UNSUPPORTED FORMAT", "ERROR", JOptionPane.ERROR_MESSAGE);	
			System.out.println("###Exception   : " + ex.getMessage());
			DPP.reset_pat();
			DMP.reset_misc();
			vmd.setEnabled(false);
			jbtnEnhance.setEnabled(false);
        }		
      
		 if((Dhr.getNumberOfFrames())>1)
		 {
		  System.out.println(" Enabled ");
		  DIP.jbtnFirst.setEnabled(true);
		  DIP.jbtnPrev.setEnabled(true);
		  DIP.jbtnNext.setEnabled(true);
		  DIP.jbtnLast.setEnabled(true);
		 }
		  if((Dhr.getNumberOfFrames())==1)
		 {
		  System.out.println(" Disabled ");
		  DIP.jbtnFirst.setEnabled(false);
		  DIP.jbtnPrev.setEnabled(false);
		  DIP.jbtnNext.setEnabled(false);
		  DIP.jbtnLast.setEnabled(false);
		 }
		 
		 vmd.setEnabled(true);
		 jbtnEnhance.setEnabled(true);
		 DIP.setNumberOfFrames(Dhr.getNumberOfFrames());
         DIP.setImages(images);//this is for 2nd window
		
		DIP.dicom_Image.setPreferredSize(new Dimension(images[0].getWidth(this)+10,images[0].getHeight(this)+10));
		DIP.dicom_Image.setImages(images, width, height);//this is for drawing image on 1st window
		
		System.out.println("width="+width+"height="+height);
					} 
			else 
				{
					System.out.println("Cancelled by user.");
					
				}
		
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{	
				dispose();
			}
		});

  				System.out.println("---------******----------");
     
	

      	}
			
		catch (Exception e)
		{
			System.out.println("###Exception :"+ e);
			vmd.setEnabled(false);
			jbtnEnhance.setEnabled(false);
		}
	}	
	
	
	
	public static void main(String a[])
	{
		
       try
		{
			JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);			
			//UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
			UIManager.setLookAndFeel("com.nilo.plaf.nimrod.NimRODLookAndFeel");
		
		
		
		
		DICOM d=new DICOM();
		BufferedImage image = ImageIO.read(d.getClass().getResource("icon/family_1doctor.png"));		
		d.setIconImage(image);
		d.setVisible(true);
		System.out.println("------------------- in main-------------------");
						 
	
		}
		catch (Exception e)
		{
			
			System.out.println("Exception 15 \t:"+ e);
		}	

	}
}