package com.tokyoschool.domain;

import java.util.ResourceBundle;

public class Beast {
    private String name;
    private int armor;
    private int life;
    private BeastType type;
    private int pos;
    private ResourceBundle res;

    public Beast(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public BeastType getType() {
        return type;
    }

    public void setType(BeastType type) {
        this.type = type;
    }

    public int getPos() {
        return pos;
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
