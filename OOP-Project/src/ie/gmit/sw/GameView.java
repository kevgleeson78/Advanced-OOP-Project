package ie.gmit.sw;

import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;

/*
 * This is a God class and is doing way too much. The instance variables cover everything from isometric to 
 * Cartesian drawing and the class has methods for loading images and converting from one coordinate space to
 * another.
 * 
 */
public class GameView extends PaintBoard implements ActionListener, KeyListener {
	private static final long serialVersionUID = 777L;
	private Timer timer; //Controls the repaint interval.
	
	
	public GameView(int[][] matrix,int[][] things) throws Exception {
		init();
		this.setMatrix(matrix);
		this.setThings(things);
		
		setBackground(Color.WHITE);
		setDoubleBuffered(true); //Each image is buffered twice to avoid tearing / stutter
		timer = new Timer(100, this); //calls the actionPerformed() method every 100ms
		timer.start(); //Start the timer
	}
	
	private void init() throws Exception {
		setTiles(loadImages("./resources/images/ground", getTiles()));
		setObjects(loadImages("./resources/images/objects", getObjects()));
                //A builder pattern for the sprite class.
		setPlayer(new SpriteBuilder().setName("Player 1").setP(new Point(0, 0)).setImg(loadImages("./resources/images/sprites/default", null)).createSprite());
	}
	
	public void toggleView() {
		setIsometric(!isIsometric());
		this.repaint();
	}

        @Override
	public void actionPerformed(ActionEvent e) { //This is called each time the timer reaches zero
		this.repaint();
	}

	
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
	
        @Override
	public void keyReleased(KeyEvent e) {
	} // Ignore
	
        @Override
	public void keyTyped(KeyEvent e) {
	} // Ignore
}