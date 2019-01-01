package ie.gmit.sw;

public class Runner {
	public static void main(String[] args) throws Exception {
		//Can read in necessary information here and process it before going any further...
		
		//Never run a GUI in the same thread as the main method... This is asynchronous:
		javax.swing.SwingUtilities.invokeLater(() -> {
                    //Template method....
                    try {
                        /*
                         * ----------------------------------------
                         *             Control Keys
                         * ----------------------------------------
                         * Use the arrow keys to move the player.
                         * Move Player: 'X'
                         * Toggle View: 'Z'
                         * ----------------------------------------
                         */
                        GameWindow gameWindow = new GameWindow(); //Could be done nicer?
                    } catch (Exception e) {
                        //Real lazy stuff here...
                        
                    }
                });
	}
}