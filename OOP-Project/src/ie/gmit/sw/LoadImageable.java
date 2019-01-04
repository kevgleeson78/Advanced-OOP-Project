package ie.gmit.sw;

import java.awt.image.BufferedImage;
import java.io.IOException;
/**
 * <h1>Title here</h1> 
 * @author Kevin Gleeson
 * @version 1.0
 * @since 2018-20-12
 */
public interface LoadImageable {
	public BufferedImage[] loadImages(String directory, BufferedImage[] img) throws IOException;
}