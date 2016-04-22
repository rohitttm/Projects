import java.awt.*;
import com.jhlabs.image.*;

public class MyDespeckleFilter extends DespeckleFilter
{
	
	/*public MyEdgeFilter()
	{
		System.out.println("IN MYEDGE FILTER");
	}*/
	
	public int[] filterPixels( int width, int height, int[] inPixels, Rectangle transformedSpace ) 
	{
		int[] outPixels =new int[width*height];
		outPixels =super.filterPixels(width,height,inPixels,transformedSpace);
	//	super.filterPixels(width,height,inPixels,transformedSpace);
		return outPixels;//run MyEdgeFilter 1st then GuiMain Then FinalMenu
		}
		
}

