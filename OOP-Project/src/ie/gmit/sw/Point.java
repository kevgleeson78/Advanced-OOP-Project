package ie.gmit.sw;
/**
 * <h1>Point</h1> 
 * THis class is a used to point the character in the direction (x , y coordinates).
 * @author Kevin Gleeson
 * @version 1.0
 * @since 2018-20-12
 */
public class Point {
	private int x;
	private int y;
	/**
	 * Constructor
	 * @param x
	 * x Coordinate
	 * @param y
	 * y coordinate
	 */
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}