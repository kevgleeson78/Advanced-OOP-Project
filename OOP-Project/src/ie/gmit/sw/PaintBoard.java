package ie.gmit.sw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * <h1>PaintBoard</h1>
 * Adapted from https://learnonline.gmit.ie/mod/resource/view.php?id=127499
 * This class is responsible for painting the components of the board within the game view.
 * This class paints the sprites, tiles and object images and places them to there position within the Isometric view.
 * This class extends the Isometric class inheriting the conversion to isometric functionality.
 * 
 * @author Kevin Gleeson
 * @version 1.0
 * @since 2018-20-12
 */
public class PaintBoard extends Isometric {
	
	
	/**
	 * Needs to be serialized
	 */
	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_IMAGE_INDEX = 0;
	/**
	 * The Sprite objetc for the player sprite
	 */
	private Sprite player;
	/**
	 * matrix and things arrays for the mapping of the images to tiles and object arrays
	 */
	private int[][] matrix;
	private int[][] things;
	private BufferedImage[] tiles;
	private BufferedImage[] objects;
	/**
	 * Color array used for the 2d representation of the game view when toggled.
	 */
	private Color[] cartesian = { Color.GREEN, Color.GRAY, Color.DARK_GRAY, Color.ORANGE, Color.CYAN, Color.YELLOW,
			Color.PINK, Color.BLACK };
	/**
	 * Isometric view set to true. False when toggled and the cartesian view is displayed.
	 */
	private boolean isIsometric = true;
	
	public PaintBoard() {
		super();
	}
	/**
	 * This method paints the objects and player to the game view.
	 */
	public void paintComponent(Graphics g) { 
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		int imageIndex = -1, x1 = 0, y1 = 0;
		Point point;
		/**
		 * Nested for loop to get the matrix size and place the images into the matrix based on their index.
		 * The index is the same as the file number of each image 0001 , 0002 etc.
		 * The leading zeros on the file name are ignored so they can be easily mapped to the position in an array.
		 * 
		 */
		for (int row = 0; row < getMatrix().length; row++) {
			for (int col = 0; col < getMatrix()[row].length; col++) {
				imageIndex = getMatrix()[row][col];

				if (imageIndex >= 0 && imageIndex < getTiles().length) {
					/**
					 * Paint the tiles on the ground.
					 */
					if (isIsometric()) {
						x1 = getIsoX(col, row);
						y1 = getIsoY(col, row);
						/**
						 * Draw the image
						 */
						g2.drawImage(getTiles()[DEFAULT_IMAGE_INDEX], x1, y1, null);
						if (imageIndex > DEFAULT_IMAGE_INDEX) {
							g2.drawImage(getTiles()[imageIndex], x1, y1, null);
						}
					} else {
						/**
						 * Set the cartesian color view.
						 */
						x1 = col * getTileWidth();
						y1 = row * getTileHeight();
						if (imageIndex < cartesian.length) {
							g2.setColor(cartesian[imageIndex]);
						} else {
							g2.setColor(Color.WHITE);
						}

						g2.fillRect(x1, y1, getTileWidth(), getTileWidth());
					}
					/**
					 * Draw the objects on the ground
					 */

					imageIndex = getThings()[row][col];
					g2.drawImage(getObjects()[imageIndex], x1, y1, null);
				}
			}
		}

		/**
		 * Paint the player sprite within the game view.
		 * 
		 */
		point = getIso(getPlayer().getPosition().getX(), getPlayer().getPosition().getY());
		g2.drawImage(getPlayer().getImage(), point.getX(), point.getY(), null);
	}
	/**
	 * 
	 * @return
	 * Getters and setters for the class variables
	 */
	public int[][] getMatrix() {
		return matrix;
	}
	/**
	 *@param  matrix
	 *Setter for matrix
	 */
	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}
	/**
	 * 
	 * @return
	 * Getters and setters for the class variables
	 */
	public int[][] getThings() {
		return things;
	}
	/**
	 * 
	 * @param things
	 * Getters and setters for the class variables
	 */
	public void setThings(int[][] things) {
		this.things = things;
	}
	/**
	 *
	 * @return
	 *  Getters and setters for the class variables
	 */
	public BufferedImage[] getTiles() {
		return tiles;
	}
	/**
	 * 
	 * @param tiles
	 * Getters and setters for the class variables
	 */
	public void setTiles(BufferedImage[] tiles) {
		this.tiles = tiles;
	}
	/**
	 * 
	 * @return
	 * Getters and setters for the class variables
	 */
	public BufferedImage[] getObjects() {
		return objects;
	}
	/**
	 * 
	 * @param objects
	 * Getters and setters for the class variables
	 */
	public void setObjects(BufferedImage[] objects) {
		this.objects = objects;
	}
	/**
	 * 
	 * @return
	 * Getters and setters for the class variables
	 */
	public Sprite getPlayer() {
		return player;
	}
	/**
	 * 
	 * @param player
	 * Getters and setters for the class variables
	 */
	public void setPlayer(Sprite player) {
		this.player = player;
	}
	/**
	 * 
	 * @return
	 * Getters and setters for the class variables
	 */
	public boolean isIsometric() {
		return isIsometric;
	}
	/**
	 * 
	 * @param isIsometric
	 * Getters and setters for the class variables
	 */
	public void setIsometric(boolean isIsometric) {
		this.isIsometric = isIsometric;
	}

}