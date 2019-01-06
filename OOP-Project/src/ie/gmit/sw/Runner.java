package ie.gmit.sw;
/**
 * <h1>Runner</h1> 
 * This is the main runner class holding a singleton instance of the game window.
 * THis class had a Ui thread inside the main method. 
 * It was removed and called as a singleton to ensure that only one instance is called at any one time.
 * @author Kevin Gleeson
 * @version 1.0
 * @since 2018-20-12
 */
public class Runner {
	/**
	 * Main method
	 * @param args
	 * Args for mai8n method
	 * @throws Exception
	 * Exception thrown
	 */
	public static void main(String[] args) throws Exception {
		/**
		 * New singleton instance of the GAmeWindow class.
		 */
		 GameWindow.getInstance();
		
	}
}