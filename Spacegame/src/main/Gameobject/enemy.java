package main.Gameobject;

import main.Spacegame;
import processing.core.PApplet;
import processing.core.PImage;


public class enemy extends gameobject{
    float  speed;
    double canhakkı;
    float kalanzaman;
    float cooldownMax = 200.0f;
    float cooldownMin = 50.0f;
    public enemy(PApplet parent, PImage image, float x, float y, float speed){
        super(parent,image,x,y);
        this.speed=speed;
        kalanzaman= parent.random(cooldownMin, cooldownMax);
    }
    public void update(){

        kalanzaman -= Spacegame.deltatime;
        if (pos.y < parent.height / 2) {
            pos.y += speed * Spacegame.deltatime;
            if (pos.y > parent.height / 2)
                pos.y = parent.height / 2;
        }
        düşmanateş();
    }
    public void düşmanateş() {
        if (kalanzaman <= 0) {
            laser laser = new laser(parent, Spacegame.laserresmi,
                    pos.x + image.width / 2 -Spacegame.laserresmi.width / 2,
                    pos.y + Spacegame.laserresmi.height * 0.75f, 2);
            Spacegame.lasers.add(laser);

            kalanzaman = parent.random(cooldownMin, cooldownMax);


    }
}}
