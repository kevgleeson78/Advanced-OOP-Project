package ie.gmit.sw;

/*
 *   
 *   BufferedImage[][]
 *   --------------------------
 *   {U0, U1, U2, U3}, =>Up
 *   {D0, D1, D2, D3}, =>Down
 *   {L0, L1, L2, L3}, =>Left
 *   {R0, R1, R2, R3}, =>Right
 * 
 */

import java.awt.image.*;
/**
 * <h1>Sprite</h1> 
 * This class is responsible for holding the data for each sprite in the application.
 * With: the name of the sprite,
 * 		 the images for the sprite to be animated,
 * 		 The direct the sprite is facing,
 * 		 The index of the sprite image,
 * 		 The current x, y position,
 * 	 	 Moving the sprite.
 * A builder design pattern is used with this class and the SpriteBuilder class
 * to enable the building (reuse) of custom sprites with different names e.g player enemy goal objects.		 
 * @author Kevin Gleeson
 * @version 1.0
 * @since 2018-20-12
 */
public class Sprite { 
	
	private String name; 
	private BufferedImage[][] images = new BufferedImage[4][3]; //The images used in the animation
	private Direction direction = Direction.DOWN; //The current orientation of the sprite
	private int index = 0; //The current image index.
	private Point position; //The current x, y position

	
	/**
	 * Constructor 
	 * @param name
	 * The name of the sprite
	 * @param p
	 * the x,y coordinate of the sprite
	 * @param img
	 * the buffered image of the sprite
	 */
	public Sprite(String name, Point p, BufferedImage[] img) {
		this.name = name;
        this.position =  p;
		int row = 0, col = 0;
		
            for (BufferedImage img1 : img) {
                images[row][col] = img1;
                if (col == images[row].length - 1) {
                    row++;
                    col = 0;
                }else {
                    col++;
                }
            }
		
	}
	
	public String getName() {
		return name;
	}

	public Point getPosition() {
		return position;
	}
	/**
	 * Method to get the image
	 * @return
	 * Returns the image with the animation index and orientation
	 */
	public BufferedImage getImage() {
		return images[direction.getOrientation()][index];
	}
	/**
	 * 
	 * @param d
	 * The direction character is facing from the Direction enum
	 * @return
	 * Returns the direction the sprite should be facing.
	 */
	public BufferedImage step(Direction d) {
		setDirection(d);
		if (index < images[direction.getOrientation()].length - 1) {
			index++;
		}else {
			index = 0;
		}

		return images[d.getOrientation()][index];
	}

	public void setDirection(Direction d) {
		direction = d;
	}

    public Direction getDirection() {
        return this.direction;
    }
    /**
     * Move method to to set and update the position of the character.
     * The movement is restricted if the characters x, y position is outside if the current grid space.
     */
	public void move() { 
		/**
		 * Encapsulated instance of Matrix class to get the max x,y movement of the character.
		 * Instance called as is can grow if the matrices are made bigger or smaller without the need to change the code here in this method.
		 */
		Matrix m = new Matrix();
		step(direction);

		switch(direction.getOrientation()) {
		case 1:
			if(position.getY()< m.getModel().length-1) {
			position.setY(position.getY() + 1); //UP
			}
			break;
		case 2:
			if(position.getX()>0) {
			position.setX(position.getX() - 1); //DOWN
			}
			break;
		case 3:
			if(position.getX()< m.getModel().length-1) {
			position.setX(position.getX() + 1); //LEFT
			}
			break;
		default:
			if(position.getY()>0) {
			position.setY(position.getY() - 1); //RIGHT
			}
			break;
		}
	}
}