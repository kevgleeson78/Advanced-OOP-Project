/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.gmit.sw;

/**
 * <h1>Title here</h1> 
 * @author Kevin Gleeson
 * @version 1.0
 * @since 2018-20-12
 */
public interface Isometricator {
   public int getIsoX(int x, int y);
   public int getIsoY(int x, int y);
   public Point getIso(int x, int y);
}
