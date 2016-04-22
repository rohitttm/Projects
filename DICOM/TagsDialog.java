import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class TagsDialog extends JDialog 
{
	Container c;
	JScrollPane jsp;
	JTable table;
	String[] cols = {"Tag", "Type", "Description", "Value"};
	String[][] data;
	TableColumn tc;
	
	BufferedReader bRdr;
	String str,s1,s2,s3;
	int i;
	
	DicomHeaderReader Dhr;
	
	int[] width = {100, 75, 300, 300};
	
	public TagsDialog(DicomHeaderReader Dhr)
	{ 
	    super((Frame)null,"Tag Details", true);
	    setSize(805,750);
	    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	    
	    this.Dhr = Dhr;
	    
	    c = getContentPane();
	    c.setLayout(null);
	    
	    data = new String[2354][4];
	    readData();
	    
	    table = new JTable(data,cols);
	    jsp = new JScrollPane(table);
	    jsp.setBounds(0,0,800,700);
	    
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    table.setCellSelectionEnabled(false);
	    for (int i = 0;i < width.length; ++i)
	    {
	    	tc = table.getColumnModel().getColumn(i);
	    	tc.setPreferredWidth(width[i]);	
	    }
	    
	    c.add(jsp);
	    
        
        
		System.out.println("TagsDialog");
		
		setVisible(true);
	}
	
	public void readData()
	{
		String value = "";
		String grpNo, grpEle;
	  try
	  {
	  	 
	  	
		bRdr = new BufferedReader(new FileReader("DICOM_tag.txt"));
		
		i=0;
		
		while((str=bRdr.readLine())!= null)
		{
			s1 = str.substring(0,9);
 			s2 = str.substring(16,18);
			s3 = str.substring(23);
			
			grpNo  = s1.substring(0,4);
			grpEle = s1.substring(5,9);
			System.out.println(grpNo + " - " + grpEle);
			data[i][0] = s1;
			data[i][1] = s2;
			data[i][2] = s3;
			data[i][3] = Dhr.getaString(Integer.decode(grpNo),Integer.decode(grpEle));

			i++;
			
		}
		
		
	  }
	  
	  catch(FileNotFoundException e)
	  {
	  	System.out.println("File Not Found");
	  }	
	   
	   catch (Exception e)
	   {
	   	System.out.println(e.getMessage());
	   }
	  	
	}
}
