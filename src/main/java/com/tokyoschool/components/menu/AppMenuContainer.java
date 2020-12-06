package com.tokyoschool.components.menu;

import com.tokyoschool.AppController;
import com.tokyoschool.database.AppModel;
import com.tokyoschool.util.ImageUtil;
import com.tokyoschool.util.WindowUtil;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ResourceBundle;

public class AppMenuContainer extends Group {

    private AppMenu menuContinue, menuLoad, menuLanguish, menuExit;
    private StackPane vbox;
    private AppMenuLoad appMenuLoad;
    private AppMenuExit appMenuExit;
    private AppMenuNew appMenuNew;
    private AppMenuLanguage appMenuLanguage;
    private final Stage ownerStage;
    private final AppModel model;
    private final AppController controller;
    private final ResourceBundle res;

    public AppMenuContainer(Stage ownerStage, AppModel model, AppController controller, ResourceBundle res) {
        super();
        this.ownerStage = ownerStage;
        this.model = model;
        this.controller = controller;
        this.res = res;

        initComponents();
    }

    private void initComponents(){

        menuContinue = new AppMenu(res.getString("new"), "new");
        menuContinue.setMaxSize(50, 50);
        menuContinue.setTranslateY(-540);
        menuLoad = new AppMenu(res.getString("load"), "load");
        menuLoad.setMaxSize(50, 50);
        menuLoad.setTranslateY(-360);
        menuLanguish = new AppMenu(res.getString("language"), "language");
        menuLanguish.setMaxSize(50, 50);
        menuLanguish.setTranslateY(-180);
        menuExit = new AppMenu(res.getString("exit"), "exit");
        menuExit.setMaxSize(50, 50);

        vbox = new StackPane();
        vbox.setPrefHeight(WindowUtil.getDimension().height);
        vbox.setPrefWidth(WindowUtil.getDimension().width);
        vbox.setAlignment(Pos.BOTTOM_CENTER);
        vbox.setPadding(new Insets(0, 0, 30, 0));
        vbox.getChildren().addAll(menuContinue, menuLoad, menuLanguish, menuExit);

        try {
            getChildren().addAll(ImageUtil.getImageView("Menu.jpg"), vbox);
        } catch (IOException e) {
            e.printStackTrace();
        }

        appMenuLoad = new AppMenuLoad(model, controller, res);
        appMenuNew = new AppMenuNew(ownerStage, model, res);
        appMenuExit = new AppMenuExit(ownerStage, res);
        appMenuLanguage = new AppMenuLanguage(res);
    }

    public AppMenu getMenuContinue() {
        return menuContinue;
    }

    public AppMenu getMenuLoad() {
        return menuLoad;
    }

    public AppMenu getMenuExit() {
        return menuExit;
    }

    public AppMenu getMenuLanguish(){ return menuLanguish;}

    public AppMenuLoad getAppMenuLoad(){return appMenuLoad;}

    public void addMenu(){
        getChildren().remove(1);
        getChildren().add(vbox);
    }

    public void addLoad(){
        getChildren().remove(1);
        getChildren().add(appMenuLoad);
    }

    public void addNew(){
        getChildren().remove(1);
        getChildren().add(appMenuNew);
    }

    public void addLanguish(){
        getChildren().remove(1);
        getChildren().add(appMenuLanguage);
    }

    public AppMenuNew getAppMenuNew(){
        return appMenuNew;
    }

    public AppMenuExit getAppMenuExit(){
        return appMenuExit;
    }

    public AppMenuLanguage getAppMenuLanguish(){return appMenuLanguage;}
}
