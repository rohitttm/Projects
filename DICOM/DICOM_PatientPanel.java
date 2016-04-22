import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

public class DICOM_PatientPanel extends JPanel
{
    JLabel jlbName, jlbID, jlbBirthDate, jlbSex, jlbStudy;
    JTextField jtfName, jtfID, jtfBDate, jtfSex, jtfStudy;
	String strDD, strMM, strYY, strBDate, strSDate;

	public DICOM_PatientPanel()
    {
        setLayout(null);
        setBounds(5,5,300,180);
        setBorder(BorderFactory.createTitledBorder("PATIENT DETAILS"));

        strDD    = "";
        strMM    = "";
        strYY    = "";
		strBDate = "";
		strSDate = "";

        jlbName = new JLabel("NAME");
        jlbName.setBounds(10,20,75,25);
        add(jlbName);

        jtfName = new JTextField();
        jtfName.setBounds(90,20,175,25);
        jtfName.setEditable(false);
        add(jtfName);    
 
        jlbID = new JLabel("Patient ID");
        jlbID.setBounds(10,50,75,25);
        add(jlbID);

        jtfID = new JTextField();
        jtfID.setBounds(90,50,175,25);
        jtfID.setEditable(false);
        add(jtfID);

        jlbSex = new JLabel("GENDER");
        jlbSex.setBounds(10,80,75,25);
        add(jlbSex);

        jtfSex = new JTextField();
        jtfSex.setBounds(90,80,175,25);
        jtfSex.setEditable(false);
        add(jtfSex);

        jlbBirthDate = new JLabel("BIRTH DATE");
        jlbBirthDate.setBounds(10,110,75,25);
        add(jlbBirthDate);

		
        jtfBDate = new JTextField();
        jtfBDate.setBounds(90,110,175,25);
        jtfBDate.setEditable(false);
        add(jtfBDate);

        jlbStudy = new JLabel("STUDY DATE");
        jlbStudy.setBounds(10,140,75,25);
        add(jlbStudy);

       

        jtfStudy = new JTextField();
        jtfStudy.setBounds(90,140,175,25);
        jtfStudy.setEditable(false);
        add(jtfStudy);

     	System.out.println("PATIENT_PANEL");
    }

	public void setInfo(String[] info)
	{
		jtfName.setText(info[0]);
		jtfID.setText(info[1]);
		jtfSex.setText(info[3]);

		strBDate = info[2];

		if (strBDate.equalsIgnoreCase("Anonymized") || strBDate.equalsIgnoreCase("Unknown") || strBDate.equalsIgnoreCase(""))
		{
			strBDate = "Unknown";
		}
		else if (strBDate.length() == 10)
		{
			strYY    = strBDate.substring(0,4);
			strMM    = strBDate.substring(5,7);
			strDD    = strBDate.substring(8,10);
			strBDate = strDD + "-" + strMM + "-" + strYY;
		}
		else if (strBDate.length() == 8)
		{
			strYY    = strBDate.substring(0,4);
			strMM    = strBDate.substring(4,6);
			strDD    = strBDate.substring(6,8);			
			strBDate = strDD + "-" + strMM + "-" + strYY;			
		}
		
		jtfBDate.setText(strBDate);

		 strSDate = info[4];

		if (strSDate.equalsIgnoreCase("Anonymized") || strSDate.equalsIgnoreCase("Unknown") || strSDate.equalsIgnoreCase(""))
		{
			strSDate = "Unknown";
		}
		else if (strSDate.length() == 10)
		{
			strYY    = strSDate.substring(0,4);
			strMM    = strSDate.substring(5,7);
			strDD    = strSDate.substring(8,10);
			strSDate = strDD + "-" + strMM + "-" + strYY;
		}
		else if (strSDate.length() == 8)
		{
			strYY    = strSDate.substring(0,4);
			strMM    = strSDate.substring(4,6);
			strDD    = strSDate.substring(6,8);			
			strSDate = strDD + "-" + strMM + "-" + strYY;			
		}

		jtfStudy.setText(strSDate);
	}//End setInfo

 public void reset_pat()
 {
 	jtfName.setText("");
 	jtfID.setText("");
 	jtfBDate.setText("");
 	jtfSex.setText("");
 	jtfStudy.setText("");

 }


}
