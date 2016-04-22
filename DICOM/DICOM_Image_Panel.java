import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.awt.geom.*;
import java.util.*;

public class DICOM_Image_Panel extends JPanel
{		
	DICOM_Image	        dicom_Image;
	JPanel              imagePanel, jpDraw;
	JButton             jbtnFirst, jbtnPrev, jbtnNext, jbtnLast;
	JLabel              jlbSep;
	TitledBorder        border;
	JButton             jbtnEnhance;
	JSlider             jslide;
	String              title;                                
	Image[ ]            img;
	EnhancedImage 		eid;
                            
	int                 frames;
	
	public DICOM_Image_Panel()
	{
	    setLayout(null);	
		
		System.out.println("Inside constructor of Dicom_image_panel");
	    
        jpDraw = new JPanel();      
		jpDraw.setBackground(new Color(226,227,230));
		jpDraw.setLayout(null);
		jpDraw.setBounds(5,670,700,28);      
		add(jpDraw);
		jbtnFirst = new JButton(new ImageIcon("icon/first.jpg"));
		jbtnFirst.setBounds(1,1,27,25);
	    jbtnPrev  = new JButton(new ImageIcon("icon/prev.jpg"));
	    jbtnPrev.setBounds(28,1,27,25);
		jbtnNext  = new JButton(new ImageIcon("icon/next.jpg"));
		jbtnNext.setBounds(56,1,27,25);
		jbtnLast  = new JButton(new ImageIcon("icon/last.jpg"));
		jbtnLast.setBounds(83,1,27,25);

        jbtnEnhance = new JButton("ENHANCE IMAGE");
        jbtnEnhance.setToolTipText("IMAGE ENHANCER");
	    jbtnEnhance.setBounds(125,1,200,25);
	     
        jpDraw.add(jbtnEnhance);
        jbtnEnhance.setEnabled(false);
      
		jlbSep = new JLabel(new ImageIcon("sep.jpg"));
		jlbSep.setBounds(115,1,5,25);
		
		jpDraw.add(jbtnFirst);
		jpDraw.add(jbtnPrev);  
		jpDraw.add(jbtnNext);
		jpDraw.add(jbtnNext);
		jpDraw.add(jbtnNext);
		jpDraw.add(jbtnLast);
		jpDraw.add(jlbSep);
		
		
		  jbtnFirst.setEnabled(false);
		  jbtnPrev.setEnabled(false);
		  jbtnNext.setEnabled(false);
		  jbtnLast.setEnabled(false);
		
      
		try
		{
			frames = img.length;
		}
		catch (Exception ex)
		{
			System.out.println("IMAGE = null");
		}
		
        dicom_Image = new DICOM_Image();
        JScrollPane jsp = new JScrollPane(dicom_Image);
		jsp.setBounds(5,5,655,650);
		jsp.setWheelScrollingEnabled(true);
		dicom_Image.setBackground(Color.black);	
		add(jsp);

		jbtnFirst.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{	
				dicom_Image.n = 0;		
				setFrame(dicom_Image.n);
			}
		});

		jbtnPrev.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				--dicom_Image.n;
				
				if (dicom_Image.n ==0)
				{
					jbtnPrev.setEnabled(false);
				}
				jbtnNext.setEnabled(true);
				setFrame(dicom_Image.n);
			}
		});

		jbtnNext.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				++dicom_Image.n;
				jbtnPrev.setEnabled(true);
				if (dicom_Image.n >= frames)
				{
					jbtnNext.setEnabled(false);
					--dicom_Image.n;
				}

				setFrame(dicom_Image.n);
			}
		});

		
		jbtnLast.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{	
				dicom_Image.n = frames - 1;	
				setFrame(dicom_Image.n);
			}
		});
       		
		setVisible(true);		
	}

    public void setNumberOfFrames(int frames)
    {
    	this.frames= frames;
    }
    public void setFrame(int index)
	{		
		System.out.println("Inside setFrame");
		dicom_Image.setView(index);
	}	
	public void setImages(Image[] images)
	{
		System.out.println("Inside setImages of Dicom_Image_Panel....");
		this.img = images;
		if(img!=null)
		{
			//System.out.println("width="+img[0].getWidth(this)+"height="+img[0].getHeight(this));
			dicom_Image.setView(0);
		}
		
	}
	public void buttoncall()
	{
	if(img==null)System.out.println("img = null");
                System.out.println("index before " + dicom_Image.n);
				eid = new EnhancedImage(img[dicom_Image.n]);	
				System.out.println("index after " + dicom_Image.n);
				
	}
	
     
}