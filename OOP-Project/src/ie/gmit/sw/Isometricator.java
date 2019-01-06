/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.gmit.sw;

/**
 * <h1>Isometricator</h1>
 * Adapted from https://learnonline.gmit.ie/mod/resource/view.php?id=127499
 * An interface to supply the methods getIsoX, getIsoY,
 * getIso to an implementing class.
 * 
 * @author Kevin Gleeson
 * @version 1.0
 * @since 2018-20-12
 */
public interface Isometricator {
	/**
	 * 
	 * @param x
	 * x in 2D space
	 * @param y
	 * y in 2d space
	 * @return
	 * Converted isometric x coordinate.
	 */
	public int getIsoX(int x, int y);
	/**
	 * 
	 * @param x
	 * x in 2D space
	 * @param y
	 * y in 2d space
	 * @return
	 * Converted isometric y coordinate.
	 */
	public int getIsoY(int x, int y);
	/**
	 * 
	 * @param x
	 * Gets isoX
	 * @param y
	 * Gets isoY
	 * @return
	 * Converts the character position from cartesian to isometric.
	 */
	public Point getIso(int x, int y);
}
