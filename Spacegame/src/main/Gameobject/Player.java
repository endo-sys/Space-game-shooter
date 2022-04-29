package main.Gameobject;

import main.Spacegame;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Player extends gameobject{

    float  speed;
    double canhakkı;
    int score;
    int cooldown=30;
    int kalanzaman;
    public Player(PApplet parent,PImage image,float x,float y,float speed){
        super(parent,image,x,y);

        this.speed= speed;
        this.canhakkı = 300;
        this.score = 0;
        this.kalanzaman=0;

    }
    public void render(){
        super.render();
    }
    public void move(){

        if(kalanzaman>0)kalanzaman--;

        if (Spacegame.keys[0]) pos.y -= speed* Spacegame.deltatime;
        if (Spacegame.keys[2]) pos.y += speed*Spacegame.deltatime;
        if (Spacegame.keys[1]) pos.x -= speed*Spacegame.deltatime;
        if (Spacegame.keys[3]) pos.x += speed*Spacegame.deltatime;

        if(pos.x < 0) pos.x = 0;
        else if(pos.x + image.width > parent.width) pos.x = parent.width-image.width;

        if(pos.y < 0) pos.y = 0;
        else if(pos.y + image.height > parent.height) pos.y = parent.height-image.height;
        if(Spacegame.keys[4])
            ateşet();
    }
    void ateşet(){
        if(kalanzaman<=0){
            laser laser1 = new laser(parent,Spacegame.laserresmi,pos.x+image.width/2-Spacegame.laserresmi.width/2,pos.y-Spacegame.laserresmi.height*0.75f,-8f);
            Spacegame.lasers.add(laser1);
            kalanzaman=cooldown;
        }
    }

    public int getScore() {
        return score;
    }
}

