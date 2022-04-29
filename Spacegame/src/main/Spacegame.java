package main;

import main.Gameobject.Player;
import main.Gameobject.laser;
import main.Gameobject.enemy;
import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

public class Spacegame extends PApplet {
    public static void main(String []args){
        PApplet.main(new String[]{Spacegame.class.getName()});
    }

    public static PImage bg, oyuncuresmi,laserresmi,düşmanlazeri,düşmanresmi;
    int y3;
    public static Player p1;
    public static enemy em1;

    public static ArrayList<laser> lasers;
    public static float deltatime;
    public void settings(){
        size(800,600);
        bg = loadImage("res/space.jpg");
        oyuncuresmi =loadImage("res/playership.png");
        laserresmi= loadImage("res/laser.png");
        düşmanresmi = loadImage("res/enemyRed2.png");
        p1 = new Player(this,oyuncuresmi,width/2-oyuncuresmi.width/2,height-oyuncuresmi.height,1.5f);
        em1 = new enemy(this, düşmanresmi, width/2-düşmanresmi.width/2, düşmanresmi.height, 2f);
        lasers = new ArrayList<laser>();
        time1 = millis();
        System.out.println(p1.getScore());

    }

    float time1,time2;
   public void draw() {
        background(0);
        time2 = millis();
        deltatime=time2-time1;
        wrap(bg,0,0,width,height);
        for(laser l:lasers)
            l.render();
        p1.render();
        em1.render();
        for(laser l:lasers)
            l.hareket();
        p1.move();
        em1.update();
        time1=millis();
    }




    public void wrap(PImage img,float x1,float y1,float x2,float y2){
        for(float x = x1;x<x2;x+=img.width){
            for (float y =y1;y<y2;y+=img.height){
                image(img,x,y); }}}

    public static boolean[] keys = new boolean[5]; // W/UP, A/LEFT, S/DOWN, D/RIGHT, SPACE

    public void keyPressed(){
        if(key == 'w' || key == 'W' || keyCode == UP) keys[0] = true;
        if(key == 'a' || key == 'A' || keyCode == LEFT) keys[1] = true;
        if(key == 's' || key == 'S' || keyCode == DOWN) keys[2] = true;
        if(key == 'd' || key == 'D' || keyCode == RIGHT) keys[3] = true;
        if(key == ' ') keys[4] = true;
    }

    public void keyReleased(){
        if(key == 'w' || key == 'W' || keyCode == UP) keys[0] = false;
        if(key == 'a' || key == 'A' || keyCode == LEFT) keys[1] = false;
        if(key == 's' || key == 'S' || keyCode == DOWN) keys[2] = false;
        if(key == 'd' || key == 'D' || keyCode == RIGHT) keys[3] = false;
        if(key == ' ') keys[4] = false;
    }

}
