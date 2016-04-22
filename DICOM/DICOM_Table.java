import java.awt.*;
import java.awt.event.* ;
import java.awt.image.* ;
import java.util.*;
import java.net.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;

public class DICOM_Table extends JFrame
{
	Container c;
	JTable table;
	int x=10,y=10;
	public DICOM_Table()
	{	
		super("MORE DETAILS...");
		setSize(1024,768);	
		setLocation(0,0);
		c = getContentPane();
		c.setLayout(null);
		
		table = new JTable(x,y);
		JScrollPane scrollpane = new JScrollPane(table);
		table.setFillsViewportHeight(true);


		c.add(scrollpane);
		setVisible(true);
	}	
		
			
}
