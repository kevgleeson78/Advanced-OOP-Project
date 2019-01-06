package ie.gmit.sw;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * <h1>LoadImages</h1>
 * Adapted from https://learnonline.gmit.ie/mod/resource/view.php?id=127499 
 * The implementation of the LoadImagable interface.
 * 
 * @author Kevin Gleeson
 * @version 1.0
 * @since 2018-20-12
 */
public class LoadImages extends JPanel implements LoadImageable {

	private static final long serialVersionUID = 1L;

	/**
	 * Null Constructor
	 */
	public LoadImages() {
		super();
	}

	@Override
	/**
	 * Method implemented from the LoadImagable Interface.
	 */
	public BufferedImage[] loadImages(String directory, BufferedImage[] img) throws IOException {
		File dir = new File(directory);
		File[] files = dir.listFiles();
		Arrays.sort(files, (s, t) -> s.getName().compareTo(t.getName()));

		img = new BufferedImage[files.length];
		for (int i = 0; i < files.length; i++) {
			img[i] = ImageIO.read(files[i]);
		}
		return img;
	}

}