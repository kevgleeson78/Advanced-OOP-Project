/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.gmit.sw;

import java.awt.image.BufferedImage;
/**
 * <h1>Title here</h1> 
 * @author Kevin Gleeson
 * @version 1.0
 * @since 2018-20-12
 */
public class SpriteBuilder {

    private String name;
    private ie.gmit.sw.Point p;
    private BufferedImage[] img;

    public SpriteBuilder() {
    }

    public SpriteBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public SpriteBuilder setP(ie.gmit.sw.Point p) {
        this.p = p;
        return this;
    }

    public SpriteBuilder setImg(BufferedImage[] img) {
        this.img = img;
        return this;
    }

    public Sprite createSprite() {
        return new Sprite(name, p, img);
    }
    
}
