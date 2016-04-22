import java.awt.*;
import com.jhlabs.image.*;

public class MyCausticsFilter extends CausticsFilter
{
protected int[] filterPixels( int width, int height, int[] inPixels, Rectangle transformedSpace ) 
	{
	int outWidth = transformedSpace.width;
		int outHeight = transformedSpace.height;
   int[] pixels = new int[outWidth * outHeight];
	pixels = super.filterPixels(width,height,inPixels,transformedSpace);
	return pixels;
	}
}
