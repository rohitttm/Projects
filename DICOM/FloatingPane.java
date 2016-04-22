import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import com.jgoodies.looks.plastic.*;
import com.jgoodies.looks.*;


public class FloatingPane extends JInternalFrame
{
	JPanel  jp;
	JButton jbtnOk;
	Image img;
	JTextArea jtf;
	ImageOperations imgop;

	
	public FloatingPane() 
	{
		 super("Palette1", true, true, true, true);

		 putClientProperty(PlasticInternalFrameUI.IS_PALETTE, Boolean.TRUE);
		 
		 setOpaque(false);
		 setResizable(false);			  
		 toFront();	
		 
		 jp = new JPanel();
		 jp.setLayout(null);
		 add(jp);

		 jbtnOk = new JButton("Ok");
		 jbtnOk.setBounds(10,5,50,25);
		 jp.add(jbtnOk);

		 img= getToolkit().getImage("ABCD");
		 imgop = new ImageOperations(img);
		 add(imgop);
		 

		 	
	}
	public FloatingPane(int v) 
	{
		super("Palette1", true, true, true, true);

		 putClientProperty(PlasticInternalFrameUI.IS_PALETTE, Boolean.TRUE);
		 
		 setOpaque(false);
		 setResizable(false);			  
		 toFront();	
		 
		 jp = new JPanel();
		 jp.setLayout(null);
		 add(jp);

		 jtf = new JTextArea();
		 jtf.setBounds(0,0,400,50);
		 jtf.setEditable(false);
		 jtf.setForeground(Color.RED);
		 jp.add(jtf);
	}
}
