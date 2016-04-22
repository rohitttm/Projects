import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;//PRAVIGAR DICOM VIEWER

public class About extends JFrame
      {
	   public About()
	       {
		    super("About PRAVIGAR DICOM Viewer Application");
			setVisible(true);
			setLocation(554,266);
			setSize(500,395);
			Container c = getContentPane();
			c.setLayout(null);	
			setResizable(false);
			JButton jl= new JButton(new ImageIcon("icon/diacom_viewer.jpg"));
			try{
			UIManager.setLookAndFeel("com.nilo.plaf.nimrod.NimRODLookAndFeel");
			} 
			catch(Exception  r){}
			jl.setBounds(0,0,500,175);
			jl.setEnabled(true);
		
			c.add(jl);
			JTextArea jta=new JTextArea();
			jta.setBounds(0,176,500,188);
			jta.setEditable(false);
			jta.setBackground(new Color(26,227,180));
			jta.setForeground(Color.blue);
			jta.setText("PRAVIGAR DICOM Viewer Application\n\n"+	"Version 1.0(32bit)\n"+			"Developed by:\n\tPravin Raut\n\t Vikesh Sante\n\t JIgar Parmar\n");
			jta.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 20));;
		    c.add(jta);
			}
		}