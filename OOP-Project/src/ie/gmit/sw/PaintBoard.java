package ie.gmit.sw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
/**
 * <h1>Title here</h1> 
 * @author Kevin Gleeson
 * @version 1.0
 * @since 2018-20-12
 */
public class PaintBoard extends Isometric {

	
	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_IMAGE_INDEX = 0;
	private Sprite player;
	private int[][] matrix;
	private int[][] things;
	private BufferedImage[] tiles;
	private BufferedImage[] objects;
	private Color[] cartesian = {Color.GREEN, Color.GRAY, Color.DARK_GRAY, Color.ORANGE, Color.CYAN, Color.YELLOW, Color.PINK, Color.BLACK};
	private boolean isIsometric = true;

	public PaintBoard() {
		super();
	}

	public void paintComponent(Graphics g) { //This method needs to execute quickly...
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		int imageIndex = -1, x1 = 0, y1 = 0;
		Point point;
		
		for (int row = 0; row < getMatrix().length; row++) {
			for (int col = 0; col < getMatrix()[row].length; col++) {
				imageIndex = getMatrix()[row][col];
				
				if (imageIndex >= 0 && imageIndex < getTiles().length) {
					//Paint the ground tiles
					if (isIsometric()) {
						x1 = getIsoX(col, row);
						y1 = getIsoY(col, row);
						
						g2.drawImage(getTiles()[DEFAULT_IMAGE_INDEX], x1, y1, null);
						if (imageIndex > DEFAULT_IMAGE_INDEX) {
							g2.drawImage(getTiles()[imageIndex], x1, y1, null);
						}
					} else {
						x1 = col * getTileWidth();
						y1 = row * getTileHeight();
	        			if (imageIndex < cartesian.length) {
	        				g2.setColor(cartesian[imageIndex]);
	        			}else {
	        				g2.setColor(Color.WHITE);
	        			}
						
	        			g2.fillRect(x1, y1, getTileWidth(), getTileWidth());
					}
					//Paint the object or things on the ground
					
					
					imageIndex = getThings()[row][col];
					g2.drawImage(getObjects()[imageIndex], x1, y1, null);
				}
			}
		}
		
		//Paint the player on  the ground
		point = getIso(getPlayer().getPosition().getX(), getPlayer().getPosition().getY());
		g2.drawImage(getPlayer().getImage(), point.getX(), point.getY(), null);
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	public int[][] getThings() {
		return things;
	}

	public void setThings(int[][] things) {
		this.things = things;
	}

	public BufferedImage[] getTiles() {
		return tiles;
	}

	public void setTiles(BufferedImage[] tiles) {
		this.tiles = tiles;
	}

	public BufferedImage[] getObjects() {
		return objects;
	}

	public void setObjects(BufferedImage[] objects) {
		this.objects = objects;
	}

	public Sprite getPlayer() {
		return player;
	}

	public void setPlayer(Sprite player) {
		this.player = player;
	}

	public boolean isIsometric() {
		return isIsometric;
	}

	public void setIsometric(boolean isIsometric) {
		this.isIsometric = isIsometric;
	}

}