import java.awt.*;
import com.jhlabs.image.*;

public class MyLevelsFilter extends LevelsFilter
{
protected int[] filterPixels( int width, int height, int[] inPixels, Rectangle transformedSpace ) 
	{
	super.filterPixels(width,height,inPixels,transformedSpace);
	return inPixels;
	}
}
