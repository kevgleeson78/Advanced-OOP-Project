package ie.gmit.sw;

import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class LoadImages extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoadImages() {
		super();
	}

	public LoadImages(LayoutManager layout) {
		super(layout);
	}

	public LoadImages(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	public LoadImages(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}

	protected BufferedImage[] loadImages(String directory, BufferedImage[] img) throws Exception {
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