import java.awt.*;
import com.jhlabs.image.*;

public class MyEdgeFilter extends EdgeFilter
{
	
	
	public int[] filterPixels( int width, int height, int[] inPixels, Rectangle transformedSpace ) 
	{
		int[] outPixels =new int[width*height];
		outPixels =super.filterPixels(width,height,inPixels,transformedSpace);
		return outPixels;
		}
		
}
