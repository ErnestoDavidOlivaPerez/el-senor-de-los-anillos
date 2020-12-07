package com.tokioschool.components.game;

import com.tokioschool.util.BorderUtil;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ResourceBundle;

public class AppGameExitStage extends Stage {

    private Label labelOk;
    private Label labelCancel;
    private ResourceBundle res;

    public AppGameExitStage(Stage ownerStage, ResourceBundle res){
        super(StageStyle.TRANSPARENT);
        this.res = res;

        initOwner(ownerStage);
        initModality(Modality.APPLICATION_MODAL);

        initComponents();
    }

    private void initComponents(){

        labelOk = new Label(res.getString("ok"));
        labelOk.setBorder(BorderUtil.getBlack());
        labelOk.setFont(Font.font("Cambria", FontWeight.NORMAL, FontPosture.REGULAR, 30));
        labelOk.setTextFill(Color.WHITE);
        labelOk.setPadding(new Insets(10));
        labelOk.setMinWidth(100);
        labelOk.setUserData("stageButtonOk");

        labelCancel = new Label(res.getString("cancel"));
        labelCancel.setBorder(BorderUtil.getBlack());
        labelCancel.setFont(Font.font("Cambria", FontWeight.NORMAL, FontPosture.REGULAR, 30));
        labelCancel.setTextFill(Color.WHITE);
        labelCancel.setPadding(new Insets(10));
        labelCancel.setMinWidth(100);
        labelCancel.setUserData("stageButtonCancel");

        HBox hBox = new HBox(labelOk, labelCancel);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(60);

        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(2);
        dropShadow.setRadius(5);
        dropShadow.setColor(Color.BLACK);

        Label labelQuest = new Label(res.getString("want_exit"));
        labelQuest.setFont(Font.font("Cambria", FontWeight.BOLD, FontPosture.ITALIC, 30));
        labelQuest.setTextFill(Color.WHITE);
        labelQuest.setEffect(dropShadow);

        Label labelInformation = new Label(res.getString("progress_save"));
        labelInformation.setFont(Font.font("Cambria", FontWeight.BOLD, FontPosture.ITALIC, 20));
        labelInformation.setTextFill(Color.WHITE);
        labelInformation.setEffect(dropShadow);

        VBox vBox = new VBox(labelQuest, labelInformation, hBox);
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setBackground(new Background(new BackgroundFill(Color.rgb(193, 202, 238, 0.6),
                new CornerRadii(15), null)));
        vBox.setSpacing(30);
        vBox.setPadding(new Insets(25));

        Scene scene = new Scene(vBox, Color.TRANSPARENT);
        setScene(scene);
    }

    public Label getLabelOk(){return labelOk;}

    public Label getLabelCancel(){return labelCancel;}
}

