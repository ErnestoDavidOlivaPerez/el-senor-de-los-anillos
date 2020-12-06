package com.tokyoschool.domain;

import java.util.ResourceBundle;

public enum HeroType{
    ELF(""), HOBBIT(""), HUMAN("");

    String type;
    HeroType(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void refreshLanguage(ResourceBundle res){
        ELF.setType(res.getString("elf"));
        HOBBIT.setType(res.getString("hobbit"));
        HUMAN.setType(res.getString("human"));
    }
}