package ie.gmit.sw;

import java.awt.image.BufferedImage;
import java.io.IOException;

public interface LoadImageable {
	public BufferedImage[] loadImages(String directory, BufferedImage[] img) throws IOException;
}