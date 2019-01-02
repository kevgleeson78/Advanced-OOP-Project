package ie.gmit.sw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class PaintBoard extends Isometric {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_IMAGE_INDEX = 0;
	protected Sprite player;
	protected int[][] matrix;
	protected int[][] things;
	protected BufferedImage[] tiles;
	protected BufferedImage[] objects;
	private Color[] cartesian = {Color.GREEN, Color.GRAY, Color.DARK_GRAY, Color.ORANGE, Color.CYAN, Color.YELLOW, Color.PINK, Color.BLACK};
	protected boolean isIsometric = true;

	public PaintBoard() {
		super();
	}

	public void paintComponent(Graphics g) { //This method needs to execute quickly...
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		int imageIndex = -1, x1 = 0, y1 = 0;
		Point point;
		
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				imageIndex = matrix[row][col];
				
				if (imageIndex >= 0 && imageIndex < tiles.length) {
					//Paint the ground tiles
					if (isIsometric) {
						x1 = getIsoX(col, row);
						y1 = getIsoY(col, row);
						
						g2.drawImage(tiles[DEFAULT_IMAGE_INDEX], x1, y1, null);
						if (imageIndex > DEFAULT_IMAGE_INDEX) {
							g2.drawImage(tiles[imageIndex], x1, y1, null);
						}
					} else {
						x1 = col * TILE_WIDTH;
						y1 = row * TILE_HEIGHT;
	        			if (imageIndex < cartesian.length) {
	        				g2.setColor(cartesian[imageIndex]);
	        			}else {
	        				g2.setColor(Color.WHITE);
	        			}
						
	        			g2.fillRect(x1, y1, TILE_WIDTH, TILE_WIDTH);
					}
					//Paint the object or things on the ground
					
					
					imageIndex = things[row][col];
					g2.drawImage(objects[imageIndex], x1, y1, null);
				}
			}
		}
		
		//Paint the player on  the ground
		point = getIso(player.getPosition().getX(), player.getPosition().getY());
		g2.drawImage(player.getImage(), point.getX(), point.getY(), null);
	}

}