package ie.gmit.sw;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.Timer;
import javax.imageio.*;
import java.io.*;
import java.util.*;

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
		this.matrix = matrix;
		this.things = things;
		
		setBackground(Color.WHITE);
		setDoubleBuffered(true); //Each image is buffered twice to avoid tearing / stutter
		timer = new Timer(100, this); //calls the actionPerformed() method every 100ms
		timer.start(); //Start the timer
	}
	
	private void init() throws Exception {
		tiles = loadImages("./resources/images/ground", tiles);
		objects = loadImages("./resources/images/objects", objects);
		player = new Sprite("Player 1", new Point(0, 0), loadImages("./resources/images/sprites/default", null));
	}
	
	public void toggleView() {
		isIsometric = !isIsometric;
		this.repaint();
	}

	public void actionPerformed(ActionEvent e) { //This is called each time the timer reaches zero
		this.repaint();
	}

	
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.setDirection(Direction.RIGHT);
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.setDirection(Direction.LEFT);
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			player.setDirection(Direction.UP);
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.setDirection(Direction.DOWN);
		} else if (e.getKeyCode() == KeyEvent.VK_Z) {
			toggleView();
		} else if (e.getKeyCode() == KeyEvent.VK_X) {
			player.move();
		} else {
			return;
		}
	}
	
	public void keyReleased(KeyEvent e) {
	} // Ignore
	
	public void keyTyped(KeyEvent e) {
	} // Ignore
}