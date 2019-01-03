package ie.gmit.sw;

import java.awt.*;
import javax.swing.*;
public class GameWindow{
	Matrix m = new Matrix();
	//create an object of SingleObject
	   private static GameWindow instance = new GameWindow();

	   //make the constructor private so that this class cannot be
	   //instantiated
	   private GameWindow(){
		   GameView view;
		try {
			view = new GameView(m.getModel(), m.getObjects());
			Dimension d = new Dimension(Isometric.getDefaultViewSize(), Isometric.getDefaultViewSize()/2);
			view.setPreferredSize(d);
			view.setMinimumSize(d);
			view.setMaximumSize(d);

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
			e.printStackTrace();
		}
			
	   }

	   //Get the only object available
	   public static GameWindow getInstance(){
	      return instance;
	   }

	  
	
}