package ie.gmit.sw;

public class Isometric extends LoadImages implements Isometricator{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int DEFAULT_VIEW_SIZE = 1280;
	protected static final int TILE_WIDTH = 128;
	protected static final int TILE_HEIGHT = 64;

	public Isometric() {
		super();
	}

 
	public int getIsoX(int x, int y) {
		int rshift = (DEFAULT_VIEW_SIZE/2) - (TILE_WIDTH/2) + (x - y); //Pan camera to the right
		return (x - y) * (TILE_WIDTH/2) + rshift;
	}

     
	public int getIsoY(int x, int y) {
		return (x + y) * (TILE_HEIGHT/2);
	}

       
	public Point getIso(int x, int y) {
		return new Point(getIsoX(x, y), getIsoY(x, y)); //Could be more efficient...
	}

}