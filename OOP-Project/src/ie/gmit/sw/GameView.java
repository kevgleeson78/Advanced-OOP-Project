package ie.gmit.sw;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.Timer;

/**
 * <h1>Game View</h1> This GameView class extends the Paintboard class
 * responsible for paintng the character, tiles and objects within the game
 * view. This class also extends the ActionListener and KeyListener interfaces
 * to handle user input key events used to move the player and toggle the
 * isometric view to 2D and back.
 * 
 * @author Kevin Gleeson
 * @version 1.0
 * @since 2018-20-12
 */
public class GameView extends PaintBoard implements ActionListener, KeyListener {
	private static final long serialVersionUID = 777L;
	private Timer timer; // Controls the repaint interval.

	/**
	 * 
	 * @param matrix The matrix 2d array parameter is used to store and display the
	 *               tiles of the game view.
	 * @param things The things 2D array is used to store and display the game
	 *               objects on top of the game tiles
	 * @throws Exception Exception needs to be thrown for the init() function
	 */
	public GameView(int[][] matrix, int[][] things) throws Exception {
		init();

		this.setMatrix(matrix);
		this.setThings(things);
		/**
		 * Set the background colour of the game view to white. All other games objects
		 * will be placed on top of this background.
		 */
		setBackground(Color.WHITE);
		/**
		 * Double buffering used to avoid stutter in animation of characters.
		 */
		setDoubleBuffered(true);
		/**
		 * Action performed called every 100 ms.
		 */
		timer = new Timer(100, this);
		/**
		 * Begin the timer for the refresh rate of animation.
		 */
		timer.start();
	}

	/**
	 * 
	 * @throws IOException 
	 * IOException used for the tile and object images to ensure they exist.
	 */
	private void init() throws IOException{
		setTiles(loadImages("./resources/images/ground", getTiles()));
		setObjects(loadImages("./resources/images/objects", getObjects()));
		/**
		 * A builder pattern used from the SpriteBuilder class to build an instance of a new sprite.
		 * This can be used to create different versions of the same object.
		 * ie A Player, enemy or goal object needed to complete a mission.
		 * Each new object can be named via a simple string declaration with the Point on the game board.
		 */
		setPlayer(new SpriteBuilder().setName("Player 1").setP(new Point(0, 0))
				.setImg(loadImages("./resources/images/sprites/default", null)).createSprite());
	}

	/**
	 * Toggle view method is used to change the view from isometric to 2D representaion of the game view.
	 */
	public void toggleView() {
		setIsometric(!isIsometric());
		this.repaint();
	}

	/**
	 * The Action performed method is triggered each time the timer reaches zero.
	 * THe entire board is repainted for each time frame.
	 */
	@Override
	public void actionPerformed(ActionEvent e) { 
		this.repaint();
	}

	/**
	 * An event handler for user input.
	 * A switch statement is used to detect the user input of arrow keys or the 'X' or 'Z' buttons.
	 * IF the arrow keys are pressed the sprite setDirection method is set with the enum Direction value mapped to the 
	 * arrow pressed.
	 * 
	 * When the Z button is pressed the toggle view method is called.
	 * 
	 * When the X button is pressed the move method from the inherited sprite class is called.
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			getPlayer().setDirection(Direction.RIGHT);
			break;
		case KeyEvent.VK_LEFT:
			getPlayer().setDirection(Direction.LEFT);
			break;
		case KeyEvent.VK_UP:
			getPlayer().setDirection(Direction.UP);
			break;
		case KeyEvent.VK_DOWN:
			getPlayer().setDirection(Direction.DOWN);
			break;
		case KeyEvent.VK_Z:
			toggleView();
			break;
		case KeyEvent.VK_X:
			getPlayer().move();
			break;
		default:
			break;
		}
	}

	/**
	 * 
	 */
	@Override
	public void keyReleased(KeyEvent e) {
	} // Ignore

	@Override
	public void keyTyped(KeyEvent e) {
	} // Ignore
}