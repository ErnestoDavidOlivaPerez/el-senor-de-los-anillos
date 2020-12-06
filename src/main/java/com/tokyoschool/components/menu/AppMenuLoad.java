package com.tokyoschool.components.menu;

import com.tokyoschool.AppController;
import com.tokyoschool.database.AppModel;
import com.tokyoschool.util.BorderUtil;
import com.tokyoschool.util.FontUtil;
import com.tokyoschool.util.WindowUtil;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AppMenuLoad extends VBox {

    private Button backButton;
    private AppMenuSaves load1, load2, load3;
    private final AppModel model;
    private HBox hBox;
    private final AppController controller;
    private final ResourceBundle res;

    public AppMenuLoad(AppModel model, AppController controller, ResourceBundle res){
        super();
        this.model = model;
        this.controller = controller;
        this.res = res;

        setPrefHeight(WindowUtil.getDimension().height);
        setPrefWidth(WindowUtil.getDimension().width);
        setAlignment(Pos.BOTTOM_CENTER);
        setSpacing(150);
        initComponents();
    }

    private void initComponents(){
        Label titleLabel = new Label(res.getString("game_save"));
        FontUtil.labelFontAll("Cambria", FontWeight.NORMAL, FontPosture.ITALIC, 100, Color.WHITE, titleLabel);
        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(10);
        dropShadow.setOffsetX(5);
        dropShadow.setSpread(0.4);

        Bloom bloom = new Bloom(0.9);
        bloom.setInput(dropShadow);
        titleLabel.setEffect(bloom);

        hBox = new HBox();

        if (model.isSave1()){
            load1 = new AppMenuSaves();
            load1.setUserData("load1");
            model.setSave(1);
            model.connect();
            try {
                load1.getSave().setText(model.getName());
                hBox.getChildren().add(load1);
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }

        if (model.isSave2()){
            load2 = new AppMenuSaves();
            load2.setUserData("load2");
            model.setSave(2);
            model.connect();
            try {
                load2.getSave().setText(model.getName());
                hBox.getChildren().add(load2);
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }

        if (model.isSave3()){
            load3 = new AppMenuSaves();
            load3.setUserData("load3");
            model.setSave(3);
            model.connect();
            try {
                load3.getSave().setText(model.getName());
                hBox.getChildren().add(load3);
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }

        hBox.setSpacing(40);
        hBox.setAlignment(Pos.CENTER);

        backButton = new Button(res.getString("back"));
        backButton.setUserData("backLoad");
        backButton.setFont(Font.font(50));
        backButton.setTextFill(Color.WHITE);
        backButton.setBackground(Background.EMPTY);
        backButton.setBorder(BorderUtil.getBlack());

        HBox hbox2 = new HBox(backButton);
        hbox2.setAlignment(Pos.BOTTOM_RIGHT);
        hbox2.setPrefWidth(WindowUtil.getDimension().width);
        hbox2.setPrefHeight(WindowUtil.getDimension().height/ 4.0);
        hbox2.setPadding(new Insets(0, 20, 20, 0));

        getChildren().addAll(titleLabel, hBox, hbox2);
    }

    public Button getBackButton(){return backButton;}

    public AppMenuSaves getLoad1() {
        return load1;
    }

    public AppMenuSaves getLoad2() {
        return load2;
    }

    public AppMenuSaves getLoad3() {
        return load3;
    }

    public void refresh(){
        hBox.getChildren().clear();

        if (model.isSave1()){
            load1 = new AppMenuSaves();
            load1.setUserData("load1");
            model.setSave(1);
            model.connect();
            try {
                load1.getSave().setText(model.getName());
                hBox.getChildren().add(load1);
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }

        if (model.isSave2()){
            load2 = new AppMenuSaves();
            load2.setUserData("load2");
            model.setSave(2);
            model.connect();
            try {
                load2.getSave().setText(model.getName());
                hBox.getChildren().add(load2);
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }

        if (model.isSave3()){
            load3 = new AppMenuSaves();
            load3.setUserData("load3");
            model.setSave(3);
            model.connect();
            try {
                load3.getSave().setText(model.getName());
                hBox.getChildren().add(load3);
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }

        controller.connectSave();
    }
}
