package com.tokyoschool.components.menu;

import com.tokyoschool.database.AppModel;
import com.tokyoschool.util.BorderUtil;
import com.tokyoschool.util.EffectUtil;
import com.tokyoschool.util.WindowUtil;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.effect.Bloom;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class AppMenuNew extends StackPane {

    private AppMenuSaves save1, save2, save3;
    private Button buttonExit;
    private AppMenuNewStage appMenuNewStage;
    private final Stage ownerStage;
    private final AppModel model;
    private final ResourceBundle res;

    public AppMenuNew(Stage ownerStage, AppModel model, ResourceBundle res){
        super();

        this.ownerStage = ownerStage;
        this.model = model;
        this.res = res;

        setPrefWidth(WindowUtil.getDimension().width);
        setPrefHeight(WindowUtil.getDimension().height);
        setAlignment(Pos.CENTER);
        initComponents();
    }

    private void initComponents(){
        save1 = new AppMenuSaves();
        save1.getSave().setUserData("save1");

        if (model.isSave1()){
            String name = "";
            try {
                model.setSave(1);
                model.connect();
                name = model.getName();
                model.disconnect();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }

            save1.getSave().setText(name);
        }

        save2 = new AppMenuSaves();
        save2.getSave().setUserData("save2");

        if (model.isSave2()){
            String name = "";
            try {
                model.setSave(2);
                model.connect();
                name = model.getName();
                model.disconnect();
            } catch (SQLException sqlException){
                sqlException.printStackTrace();
            }

            save2.getSave().setText(name);
        }

        save3 = new AppMenuSaves();
        save3.getSave().setUserData("save3");

        if (model.isSave3()){
            String name = "";
            try{
                model.setSave(3);
                model.connect();
                name = model.getName();
                model.disconnect();
            }catch (SQLException sqlException){
                sqlException.printStackTrace();
            }

            save3.getSave().setText(name);
        }

        HBox hBox1 = new HBox(save1, save2, save3);
        hBox1.setAlignment(Pos.CENTER);
        hBox1.setSpacing(40);
        hBox1.setMaxHeight(400);

        buttonExit = new Button(res.getString("back"));
        buttonExit.setFont(new Font("cambria", 50));
        buttonExit.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
        buttonExit.setTextFill(Color.WHITE);
        buttonExit.setBorder(BorderUtil.getBlack());
        buttonExit.setPadding(new Insets(15, 30, 15, 30));
        Bloom bloom = EffectUtil.getBloom(0.9);
        buttonExit.setEffect(bloom);
        buttonExit.setUserData("backNew");

        appMenuNewStage = new AppMenuNewStage(ownerStage, res);

        HBox hBox2 = new HBox(buttonExit);
        hBox2.setPadding(new Insets(0, 30, 30, 0));
        hBox2.setAlignment(Pos.BOTTOM_RIGHT);


        getChildren().addAll(hBox2, hBox1);
    }


    public Button getButtonExit(){
        return buttonExit;
    }

    public AppMenuSaves getSave1(){
        return save1;
    }

    public AppMenuSaves getSave2(){
        return save2;
    }

    public AppMenuSaves getSave3(){
        return save3;
    }

    public AppMenuNewStage getAppMenuNewStage(){return appMenuNewStage;}
}
