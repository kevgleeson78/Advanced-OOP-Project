/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.gmit.sw;


public class SpriteBuilder {

    private String name;
    private ie.gmit.sw.Point p;
    private java.awt.image.BufferedImage[] img;

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

    public SpriteBuilder setImg(java.awt.image.BufferedImage[] img) {
        this.img = img;
        return this;
    }

    public Sprite createSprite() {
        return new Sprite(name, p, img);
    }
    
}
