package ie.gmit.sw;

public class Isometric extends LoadImages implements Isometricator{

	/**
	 * <h1>Title here</h1> 
	 * @author Kevin Gleeson
	 * @version 1.0
	 * @since 2018-20-12
	 */
	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_VIEW_SIZE = 1280;
	private static final int TILE_WIDTH = 128;
	private static final int TILE_HEIGHT = 64;

	public Isometric() {
		super();
	}

 
	public int getIsoX(int x, int y) {
		int rshift = (getDefaultViewSize()/2) - (getTileWidth()/2) + (x - y); //Pan camera to the right
		return (x - y) * (getTileWidth()/2) + rshift;
	}

     
	public int getIsoY(int x, int y) {
		return (x + y) * (getTileHeight()/2);
	}

       
	public Point getIso(int x, int y) {
		return new Point(getIsoX(x, y), getIsoY(x, y)); //Could be more efficient...
	}


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