/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.gmit.sw;

import java.awt.image.BufferedImage;
/**
 * <h1>SpriteBuilder</h1>
 * This a implementation of the builder design pattern and is used in the game view when building the player sprite.
 * This class promotes the reuse of this class for different implementations of the sprite class.
 * @author Kevin Gleeson
 * @version 1.0
 * @since 2018-20-12
 */
public class SpriteBuilder {

    private String name;
    private Point p;
    private BufferedImage[] img;
    /**
     * Null Constructor
     */
    public SpriteBuilder() {
    }
    /**
     * Sets the String name of the sprite 
     * @param name
     * @return
     * Returns the name
     */
    public SpriteBuilder setName(String name) {
        this.name = name;
        return this;
    }
    /**
     * Sets the pont in space of the sprite
     * @param p
     * @return
     * Returns the point
     */
    public SpriteBuilder setP(Point p) {
        this.p = p;
        return this;
    }
    /**
     * Sets the image of the sprite
     * @param img
     * @return
     * Returns the image
     */
    public SpriteBuilder setImg(BufferedImage[] img) {
        this.img = img;
        return this;
    }
    /**
     * Build a new sprite method
     * @return
     * Returns a new sprite with a name, point in space and the image to be used.
     */
    public Sprite createSprite() {
        return new Sprite(name, p, img);
    }
    
}
