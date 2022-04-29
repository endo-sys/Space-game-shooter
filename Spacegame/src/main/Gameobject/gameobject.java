package main.Gameobject;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class gameobject {
    PApplet parent;
    PVector pos;
    PImage image;
    public gameobject(PApplet parent,PImage image,float x,float y){
        this.parent=parent;
        this.image = image;
        pos = new PVector(x,y);
    }
    public void render(){
        parent.image(image,pos.x,pos.y);
    }
}
