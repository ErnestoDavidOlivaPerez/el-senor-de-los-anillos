package com.tokioschool;

import com.tokioschool.components.game.AppGame;
import com.tokioschool.components.game.AppGameContainer;
import com.tokioschool.components.menu.AppMenu;
import com.tokioschool.components.menu.AppMenuContainer;
import com.tokioschool.components.menu.AppMenuLoad;
import com.tokioschool.database.AppModel;
import com.tokioschool.util.ImageUtil;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

public class AppView {

    private AppGameContainer gameContainer;
    private AppMenuContainer menuContainer;
    private Scene sceneMenu, scenePrimary;
    private final Stage stage;
    private final AppModel model;
    private final AppController controller;
    private Locale locale;
    private ResourceBundle res;

    public AppView(Stage stage, AppModel model, AppController controller){
        super();
        this.stage = stage;
        this.model = model;
        this.controller = controller;
        try {
            if (model.isLanguage()){
                locale = new Locale(model.getLanguage());
            } else {
                locale = new Locale("en");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        res = ResourceBundle.getBundle("strings", locale);

        stage.initStyle(StageStyle.UNDECORATED);
        stageConfigure(stage);
        initComponents();
    }

    private void initComponents() {
    }

    private void stageConfigure(Stage stage){
        gameContainer = new AppGameContainer(model, stage, res);
        menuContainer = new AppMenuContainer(stage, model, controller, res);

        scenePrimary = new Scene(gameContainer);
        sceneMenu = new Scene(menuContainer);

        try {
            stage.getIcons().add(ImageUtil.getImage("logo.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(sceneMenu);
        stage.setTitle("El Señor de los Anillos");
        stage.setMaximized(true);
        stage.show();
    }

    public AppMenu getMenuStart(){
        return menuContainer.getMenuContinue();
    }

    public AppMenu getMenuExit(){return  menuContainer.getMenuExit();}

    public AppMenu getMenuLanguish(){return menuContainer.getMenuLanguish();}

    public AppMenu getMenuLoad(){return  menuContainer.getMenuLoad();}

    public AppMenuContainer getAppMenuContainer(){return menuContainer;}

    public AppMenuLoad getAppMenuLoad(){return menuContainer.getAppMenuLoad();}

    public AppGame getAppGameHeroes(){return gameContainer.getAppGameHeroes();}

    public AppGame getAppGameBeast(){return gameContainer.getAppGameBeast();}

    public AppGameContainer getAppGameContainer(){return gameContainer;}

    public Scene getScenePrimary() {
        return scenePrimary;
    }

    public Scene getSceneMenu(){return sceneMenu;}

    public Stage getStage() {
        return stage;
    }

    public ResourceBundle getRes(){return res;}

    public void setLocale(Locale locale){
        this.locale = locale;
        res = ResourceBundle.getBundle("strings", locale);
        stageConfigure(stage);
        controller.initListeners(this, res);
    }
}
