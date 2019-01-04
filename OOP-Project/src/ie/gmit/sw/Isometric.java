package ie.gmit.sw;
/**
 * <h1>Isometric</h1>
 * This classs implements the Isometricator interface and extends the LoadImages class.
 * It is responsible for getting the isometric coordinates for the sprite character and creating a new point within the isometric space within the game view.
 * @author Kevin Gleeson
 * @version 1.0
 * @since 2018-20-12
 */
public class Isometric extends LoadImages implements Isometricator{

	
	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_VIEW_SIZE = 1280;
	private static final int TILE_WIDTH = 128;
	private static final int TILE_HEIGHT = 64;
	/**
	 * Null Constructor
	 */
	public Isometric() {
		super();
	}

	/**
	 * @param
	 * The x,y parameters are used to map the 2D coordinate space to an isometric view on the X plain.
	 * @return
	 * Returns the the converted X coordinate of the isometric position.
	 */
	public int getIsoX(int x, int y) {
		int rshift = (getDefaultViewSize()/2) - (getTileWidth()/2) + (x - y); //Pan camera to the right
		return (x - y) * (getTileWidth()/2) + rshift;
	}

    /**
     * @param
     * The x,y parameters are used to map the 2D coordinate space to an isometric view on the Y plain.
     * @return
	 * Returns the the converted Y coordinate of the isometric position.
     */
	public int getIsoY(int x, int y) {
		return (x + y) * (getTileHeight()/2);
	}

    /**
     * @param
     * A public Point method to take in 2D coordinates of the direction the character is facing.
     * @return
     * Returns the direction the character is pointing in the converted isometric view.
     */
	public Point getIso(int x, int y) {
		return new Point(getIsoX(x, y), getIsoY(x, y)); 
	}

	/**
	 * 
	 * @return
	 * Getters returning DEFAULT_VIEW_SIZE, TILE_WIDTH and TILE_HEIGHT.
	 */
	public static int getDefaultViewSize() {
		return DEFAULT_VIEW_SIZE;
	}


	public static int getTileWidth() {
		return TILE_WIDTH;
	}


	public static int getTileHeight() {
		return TILE_HEIGHT;
	}

}