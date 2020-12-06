package com.tokyoschool.components.game;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.util.ResourceBundle;

public class AppGameFight extends HBox {

    private Button fight;
    private TextArea textArea;
    private Button exit;
    private final ResourceBundle res;

    public AppGameFight(ResourceBundle res){
        super();

        this.res = res;
        setAlignment(Pos.CENTER);
        setPadding(new Insets(28));
        initComponents();
    }

    private void initComponents(){
        DropShadow dropShadow = new DropShadow(10, Color.WHITE);

        fight = new Button(res.getString("fight"));
        fight.setFont(new Font(30));
        fight.setUserData("fight");
        fight.setTextFill(Color.WHITE);
        fight.setBackground(Background.EMPTY);
        fight.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(10),
                new BorderWidths(2))));
        fight.setEffect(dropShadow);
        fight.setDisable(true);
        fight.setTranslateX(75);

        textArea = new TextArea();
        textArea.setMinWidth(700);
        textArea.setMaxHeight(500);
        textArea.setFont(new Font(20));
        textArea.setStyle("-fx-base: black");
        textArea.setEditable(false);
        textArea.setTranslateX(75);

        exit = new Button(res.getString("exit"));
        exit.setFont(new Font(40));
        exit.setUserData("exit");
        exit.setTextFill(javafx.scene.paint.Color.WHITE);
        exit.setBackground(Background.EMPTY);
        exit.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(10),
                new BorderWidths(2))));
        exit.setTranslateX(475);
        exit.setEffect(dropShadow);

        VBox vBox = new VBox(fight, textArea);
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);

        getChildren().addAll(vBox, exit);
    }

    public Button getFight() {
        return fight;
    }

    public TextArea getTextArea() {
        return textArea;
    }

    public Button getExit() {
        return exit;
    }

    public void reset(){
        textArea.clear();
    }
}
