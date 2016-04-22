import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

public class DICOM_MiscPanel extends JPanel
{
    JLabel jlbMake, jlbInst, jlbImageDet, jlbPhys, jlbMod, jlbFrames, jlbWidth, jlbHeight, jlbSlice, jlbPhoto, jlbInterp;
    JTextField jtfMake, jtfInst, jtfBDate, jtfPhys, jtfMod, jtfFrames, jtfWidth, jtfHeight, jtfSlice, jtfPhoto;

	public DICOM_MiscPanel()
    {
        setLayout(null);
        setBounds(5,190,300,472);
        setBorder(BorderFactory.createTitledBorder("MISC. DETAILS"));


		System.out.println("Misc_Panel");
		
        jlbMake = new JLabel("MANUFACTURER");
        jlbMake.setBounds(10,20,75,25);
        add(jlbMake);

        jtfMake = new JTextField();
        jtfMake.setBounds(110,20,175,25);
        jtfMake.setEditable(false);
        add(jtfMake);    
 
        jlbInst = new JLabel("INSTITUTION");
        jlbInst.setBounds(10,50,75,25);
        add(jlbInst);

        jtfInst = new JTextField();
        jtfInst.setBounds(110,50,175,25);
        jtfInst.setEditable(false);
		jtfInst.setToolTipText(jtfInst.getText());
        add(jtfInst);

        jlbPhys = new JLabel("PHYSICIAN");
        jlbPhys.setBounds(10,80,75,25);
        add(jlbPhys);

        jtfPhys = new JTextField();
        jtfPhys.setBounds(110,80,175,25);
        jtfPhys.setEditable(false);
        add(jtfPhys);

        jlbImageDet = new JLabel("IMAGE DETAILS");
        jlbImageDet.setBounds(10,110,100,25);
        jlbImageDet.setForeground(Color.darkGray);
        add(jlbImageDet);

        jlbMod = new JLabel("MODALITY");
        jlbMod.setBounds(10,140,100,25);
        add(jlbMod);

        jtfMod = new JTextField();
        jtfMod.setBounds(110,140,175,25);
        jtfMod.setEditable(false);
        add(jtfMod);

		jlbFrames = new JLabel("NO. OF FRAMES");
        jlbFrames.setBounds(10,170,100,25);
        add(jlbFrames);

        jtfFrames = new JTextField();
        jtfFrames.setBounds(110,170,175,25);
        jtfFrames.setEditable(false);
        add(jtfFrames);

		jlbWidth = new JLabel("WIDTH");
        jlbWidth.setBounds(10,200,100,25);
        add(jlbWidth);

        jtfWidth = new JTextField();
        jtfWidth.setBounds(110,200,175,25);
        jtfWidth.setEditable(false);
        add(jtfWidth);

		jlbHeight = new JLabel("HEIGHT");
        jlbHeight.setBounds(10,230,100,25);
        add(jlbHeight);

        jtfHeight = new JTextField();
        jtfHeight.setBounds(110,230,175,25);
        jtfHeight.setEditable(false);
        add(jtfHeight);

		jlbSlice = new JLabel("SLICE THICKNESS");
        jlbSlice.setBounds(10,260,100,25);
        add(jlbSlice);

        jtfSlice = new JTextField();
        jtfSlice.setBounds(110,260,175,25);
        jtfSlice.setEditable(false);
        add(jtfSlice);

		jlbPhoto = new JLabel("PHOTOMETRIC");
        jlbPhoto.setBounds(10,290,100,25);
		add(jlbPhoto);

		jlbInterp = new JLabel("INTERPRETATION");
        jlbInterp.setBounds(10,305,100,25);
		add(jlbInterp);

		jtfPhoto = new JTextField();
        jtfPhoto.setBounds(110,295,175,25);
        jtfPhoto.setEditable(false);
        add(jtfPhoto);
    }
	public void setMiscInfo(String[] info)
	{
		jtfMake.setText(info[6]);
		jtfInst.setText(info[14]);
		jtfPhys.setText(info[13]);
		jtfMod.setText(info[5]);
		jtfFrames.setText(info[7]);
		jtfWidth.setText(info[8]);
		jtfHeight.setText(info[9]);
		jtfSlice.setText(info[16]);
		jtfPhoto.setText(info[17]);
	}
	
	 public void reset_misc()
 {
 	jtfMake.setText("");
 	jtfInst.setText("");
 	jtfPhys.setText("");
 	jtfMod.setText("");
 	jtfFrames.setText("");
 	jtfWidth.setText("");
 	jtfHeight.setText("");
 	jtfSlice.setText("");
 	jtfPhoto.setText("");
 }

}