package ie.gmit.sw;
/**
* <h1>Direction enum</h1>
* This enum set is used to map a numerical value to fours directions of the characters used in the game.
* It is also used to get the orientation of the character.
* @author  Kevin Gleeson
* @version 1.0
* @since   2018-12-20
*/
public enum Direction {
	/**
	 * The four different directions the character can move.
	 */
	UP (0), 
	DOWN (1), 
	LEFT (2), 
	RIGHT (3);
	/**
	 * The orientation of the character.
	 */
	private final int orientation;
	/**
	 * Constructor taking the orientation variable as an argument
	 * @param orientation
	 */
    private Direction(int orientation) {
        this.orientation = orientation;
    }
    /**
     * GetOrientation method returns the current instance of the orientation variable.
     * @return
     */
    public int getOrientation() {
        return this.orientation;
    }
}