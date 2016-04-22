import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class MediaPlay
{
  
   public MediaPlay()
   {
      URL mediaURL= null;
      try{
          mediaURL =  new URL("file:/D:/DICOM/help.avi");
         }
		 catch(MalformedURLException e)
		    {   }
  
         if ( mediaURL != null ) // only display if there is a valid URL
         {
            JFrame mediaTest = new JFrame( "HELP TOPIC VIDEO TUTORIAL " );
            mediaTest.setLocation(250,50);
            mediaTest.setSize(1024,768);
            MediaPanel mediaPanel = new MediaPanel( mediaURL );
            mediaTest.add( mediaPanel );
            
          //  mediaTest.setSize( 300, 300 );
            mediaTest.setVisible( true );
         } // end inner if
   
   } // end constructor
} // end class MediaPlay