/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.gmit.sw;

/**
 *
 * @author Kevin
 */
public interface Isometricator {
   public int getIsoX(int x, int y);
   public int getIsoY(int x, int y);
   public Point getIso(int x, int y);
}
