package com.tokyoschool.util;

import com.tokyoschool.domain.BeastType;
import com.tokyoschool.domain.HeroType;

public class Filter {

    public static HeroType getHeroTypeFromComboBox(String comboBoxValue){
        switch (comboBoxValue){
            case "Elfo":
            case "Elf":
            case "Elfe":
                return HeroType.ELF;
            case "Hobbit":
                return HeroType.HOBBIT;
            case "Humano":
            case "Humans":
            case "Humain":
                return HeroType.HUMAN;
        }
        return null;
    }

    public static BeastType getBeastTypeFromComboBox(String comboBoxValue){
        switch (comboBoxValue){
            case "Orco":
            case "Orc":
                return BeastType.ORC;
            case "Goblin":
                return BeastType.GOBLIN;
        }
        return null;
    }
}
