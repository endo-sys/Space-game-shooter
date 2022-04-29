package main.Gameobject;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class laser   {
    PApplet parent;
    PVector pos;
    float speed;
    PImage picture;
    float damage;

    public laser(PApplet parent,PImage picture,float x,float y,float speed){
        this.parent=parent;
        this.speed=speed;
        pos = new PVector(x,y);
        this.picture=picture;
        this.damage=100;
    }
    public void render(){
        parent.image(picture,pos.x,pos.y);
    }
    public void hareket(){
        pos.y+=speed;
    }
}


