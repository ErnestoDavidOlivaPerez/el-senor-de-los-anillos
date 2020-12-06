package com.tokyoschool.components.menu;

import com.tokyoschool.util.BorderUtil;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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

public class AppMenuNewStage extends Stage {

    private TextField textField;
    private Label labelOkReplace, labelCancelReplace, labelCancelSave, labelOkSave;
    private Scene sceneSave, sceneReplace;
    private int isScene, isSave;
    private final ResourceBundle res;

    public AppMenuNewStage(Stage ownerStage, ResourceBundle res){
        super(StageStyle.TRANSPARENT);
        this.res = res;

        initOwner(ownerStage);
        initModality(Modality.APPLICATION_MODAL);

        initComponents();
    }

    private void initComponents(){
        textField = new TextField();
        textField.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
        textField.setFont(Font.font("Cambria", FontWeight.NORMAL, FontPosture.REGULAR, 30));
        textField.setStyle("-fx-text-fill: white");
        textField.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(15),
                new BorderWidths(2), null)));
        DropShadow dropShadow = new DropShadow(10, Color.WHITE);
        textField.setEffect(dropShadow);
        textField.setMaxWidth(350);
        textField.setUserData("newStageTextField");

        labelOkSave = new Label("Ok");
        labelOkSave.setBorder(BorderUtil.getBlack());
        labelOkSave.setFont(Font.font("Cambria", FontWeight.NORMAL, FontPosture.REGULAR, 30));
        labelOkSave.setTextFill(Color.WHITE);
        labelOkSave.setPadding(new Insets(10));
        labelOkSave.setMinWidth(100);
        labelOkSave.setUserData("newStageButtonOk");

        labelCancelSave = new Label(res.getString("cancel"));
        labelCancelSave.setBorder(BorderUtil.getBlack());
        labelCancelSave.setFont(Font.font("Cambria", FontWeight.NORMAL, FontPosture.REGULAR, 30));
        labelCancelSave.setTextFill(Color.WHITE);
        labelCancelSave.setPadding(new Insets(10));
        labelCancelSave.setMinWidth(100);
        labelCancelSave.setUserData("newStageButtonCancel");

        HBox hBox = new HBox(labelOkSave, labelCancelSave);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(60);

        VBox vBox = new VBox(textField, hBox);
        vBox.setPadding(new Insets(20, 0, 0, 0));
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setSpacing(30);
        vBox.setBackground(new Background(new BackgroundFill(Color.rgb(193, 202, 238, 0.4),
                new CornerRadii(15), null)));

        sceneSave = new Scene(vBox, Color.TRANSPARENT);

        DropShadow dropShadow2 = new DropShadow();
        dropShadow2.setOffsetX(2);
        dropShadow2.setRadius(5);
        dropShadow2.setColor(Color.BLACK);

        Label labelQuest = new Label(res.getString("quest"));
        labelQuest.setFont(Font.font("Cambria", FontWeight.BOLD, FontPosture.ITALIC, 30));
        labelQuest.setTextFill(Color.WHITE);
        labelQuest.setEffect(dropShadow2);

        Label labelInformation = new Label(res.getString("information"));
        labelInformation.setFont(Font.font("Cambria", FontWeight.BOLD, FontPosture.ITALIC, 20));
        labelInformation.setTextFill(Color.WHITE);
        labelInformation.setEffect(dropShadow2);

        labelOkReplace = new Label("Ok");
        labelOkReplace.setBorder(BorderUtil.getBlack());
        labelOkReplace.setFont(Font.font("Cambria", FontWeight.NORMAL, FontPosture.REGULAR, 30));
        labelOkReplace.setTextFill(Color.WHITE);
        labelOkReplace.setPadding(new Insets(10));
        labelOkReplace.setMinWidth(100);
        labelOkReplace.setUserData("newStageButtonOk");

        labelCancelReplace = new Label("Cancelar");
        labelCancelReplace.setBorder(BorderUtil.getBlack());
        labelCancelReplace.setFont(Font.font("Cambria", FontWeight.NORMAL, FontPosture.REGULAR, 30));
        labelCancelReplace.setTextFill(Color.WHITE);
        labelCancelReplace.setPadding(new Insets(10));
        labelCancelReplace.setMinWidth(100);
        labelCancelReplace.setUserData("newStageButtonCancel");

        HBox hBox2 = new HBox(labelOkReplace, labelCancelReplace);
        hBox2.setAlignment(Pos.CENTER);
        hBox2.setSpacing(60);

        VBox vBox2 = new VBox(labelQuest, labelInformation, hBox2);
        vBox2.setAlignment(Pos.TOP_CENTER);
        vBox2.setBackground(new Background(new BackgroundFill(Color.rgb(193, 202, 238, 0.4),
                new CornerRadii(15), null)));
        vBox2.setSpacing(30);

        sceneReplace = new Scene(vBox2, Color.TRANSPARENT);
    }

    public Label getLabelOkSave(){return labelOkSave;}

    public Label getLabelCancelSave(){return labelCancelSave;}

    public Label getLabelOkReplace(){return labelOkReplace;}

    public Label getLabelCancelReplace(){return labelCancelReplace;}

    public TextField getTextField(){return textField;}

    public int getIsScene(){return isScene;}

    public void sceneSave(){
        setHeight(200);
        setWidth(500);
        setScene(sceneSave);
        isScene = 1;
    }

    public void sceneReplace(){
        setHeight(200);
        setWidth(600);
        setScene(sceneReplace);
        isScene = 2;
    }

    public void setIsSave(int save){
        isSave = save;
    }

    public int getIsSave(){return isSave;}
}
