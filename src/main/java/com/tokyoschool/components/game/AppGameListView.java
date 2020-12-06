package com.tokyoschool.components.game;

import com.tokyoschool.database.AppModel;
import com.tokyoschool.domain.Beast;
import com.tokyoschool.domain.Hero;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.text.Font;
import java.sql.SQLException;
import java.util.*;

public class AppGameListView extends ListView<Label>{

    private final AppModel model;
    private final String userData;
    private final List<Hero> heroes;
    private final List<Beast> beasts;
    private ResourceBundle res;

    public AppGameListView(AppModel model, String userData, ResourceBundle res){
        super();
        this.model = model;
        this.userData = userData;
        this.res = res;

        heroes = new ArrayList<>();
        beasts = new ArrayList<>();
        setUserData(userData);

        setMaxHeight(250);
    }

    public void loadData() {
        getItems().clear();
        try {
            if (userData.equals("heroListView")) {
                heroes.clear();
                List<Hero> heroes = model.getHeroes();
                for (Hero hero : heroes) {
                    hero.setRes(res);
                    Label label = new Label(hero.toString());
                    label.setFont(new Font(20));
                    this.heroes.add(hero);
                    getItems().add(hero.getPos() , label);
                }
            }

            if (userData.equals("beastListView")) {
                beasts.clear();
                List<Beast> beasts = model.getBeast();
                for (Beast beast : beasts) {
                    beast.setRes(res);
                    Label label = new Label(beast.toString());
                    label.setFont(new Font(20));
                    this.beasts.add(beast);
                    getItems().add(beast.getPos() ,label);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Hero> getHeroPosDTOS() {
        return heroes;
    }

    public List<Beast> getBeastPosDTOS() {
        return beasts;
    }
}
