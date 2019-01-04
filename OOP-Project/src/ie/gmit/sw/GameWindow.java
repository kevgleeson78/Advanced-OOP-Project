package ie.gmit.sw;

import java.awt.*;

/**
 * <h1>Game Window</h1> 
 * This class is responsible for creating a singleton instance of the GAmeWindow class.
 * The two matrices of model and objests were abstracted out to the Matrix class with anew instance of the Matrix class created with this class.
 * This allows for the encapsulation of the two matrices within this class.
 * It also ensures that only one instance of the game window can be instantiated at any one time.
 * @author Kevin Gleeson
 * @version 1.0
 * @since 2018-20-12
 */
import javax.swing.*;
public class GameWindow{
	/**
	 * A new instance of the Matrix class.
	 */
	private Matrix m = new Matrix();
	   /**
	    * A private instance of this class.
	    */
	   private static GameWindow instance = new GameWindow();

	   /**
	    * A private constructor so the class cannot be instantiated multiple times.
	    */
	   private GameWindow(){
		   GameView view;
		try {
			/**
			 * A new parameterized private instance of this class with the model and objects 2d arrays from the Matrix class.
			 */
			view = new GameView(m.getModel(), m.getObjects());
			/**
			 * Set the Dimensions width and height with the maximum size of the game window.
			 * The default size is taken from the isometric class.
			 */
			Dimension d = new Dimension(Isometric.getDefaultViewSize(), Isometric.getDefaultViewSize()/2);
			view.setPreferredSize(d);
			view.setMinimumSize(d);
			view.setMaximumSize(d);
			/**
			 * A new jFrame with title layout screen position and visibility set.
			 */
			JFrame f = new JFrame("GMIT - B.Sc. in Computing (Software Development)");
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.getContentPane().setLayout(new FlowLayout());
			f.add(view);
			f.addKeyListener(view);
			f.setSize(1000, 1000);
			f.setLocation(100, 100);
			f.pack();
			f.setVisible(true);
		} catch (Exception e) {
                       // TODO Auto-generated catch block

		}
			
	   }

	   /**
	    * Returns a single instance of the game window in the main runner class.
	    * @return
            * GameWindow instance
	    */
	   public static GameWindow getInstance(){
	      return instance;
	   }

	  
	
}