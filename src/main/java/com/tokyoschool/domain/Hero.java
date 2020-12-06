package com.tokyoschool.domain;

import java.util.ResourceBundle;

public class Hero {

    private String name;
    private int armor;
    private int life;
    private HeroType type;
    private int pos;
    private ResourceBundle res;

   public Hero(){

   }

    public String getName() {
        return name;
    }

    public int getArmor() {
        return armor;
    }

    public int getLife() {
        return life;
    }

    public HeroType getType() {
        return type;
    }

    public int getPos() {
        return pos;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setType(HeroType type) {
        this.type = type;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    @Override
    public String toString() {
       return name + " (" + res.getString("life2") + "=" + life + " - " + res.getString("armor2") +
               "=" + armor + ") " + getType().getType();
    }

    public void setRes(ResourceBundle res){
       this.res = res;
    }
}
