package ie.gmit.sw;

import java.awt.image.BufferedImage;
import java.io.IOException;
/**
 * <h1>LoadImageable</h1>
 * This Interface provides a bufferedImmage method to be used by implementing classes.
 * @author Kevin Gleeson
 * @version 1.0
 * @since 2018-20-12
 */
public interface LoadImageable {
	/**
	 * 
	 * @param directory
	 * The location of the images to be processed.
	 * @param img
	 * The image to be processed
	 * @return
	 * A Buffered Image
	 * @throws IOException
	 * Needs to be added to check for validity if input/output.
	 */
	public BufferedImage[] loadImages(String directory, BufferedImage[] img) throws IOException;
}