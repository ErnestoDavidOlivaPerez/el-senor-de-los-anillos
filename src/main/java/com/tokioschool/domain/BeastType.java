package com.tokioschool.domain;

import java.util.ResourceBundle;

public enum BeastType {

    ORC(""), GOBLIN("");

    String type;
     BeastType (String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void refreshLanguage( ResourceBundle res){
        ORC.setType(res.getString("orc"));
        GOBLIN.setType(res.getString("goblin"));
    }
}
