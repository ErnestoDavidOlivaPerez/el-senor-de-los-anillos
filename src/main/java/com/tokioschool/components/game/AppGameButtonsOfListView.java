package com.tokioschool.components.game;

import com.tokioschool.util.FontUtil;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import java.util.ResourceBundle;


public class AppGameButtonsOfListView extends HBox {

    private Button up, down, delete;
    private final String userData;
    private final ResourceBundle res;

    public AppGameButtonsOfListView(String userData, ResourceBundle res){
        super();
        this.userData = userData;
        this.res = res;

        setAlignment(Pos.CENTER);
        setSpacing(20);
        initComponents();
    }

    private void initComponents(){
        DropShadow dropShadow = new DropShadow(10, Color.WHITE);

        up = new Button(res.getString("up"));
        up.setUserData(userData + "Up");
        up.setTextFill(Color.WHITE);
        up.setBackground(Background.EMPTY);
        up.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(10),
                new BorderWidths(2))));
        up.setEffect(dropShadow);
        up.setDisable(true);

        down = new Button(res.getString("down"));
        down.setUserData(userData + "Down");
        down.setTextFill(Color.WHITE);
        down.setBackground(Background.EMPTY);
        down.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(10),
                new BorderWidths(2))));
        down.setEffect(dropShadow);
        down.setDisable(true);

        delete = new Button(res.getString("delete"));
        delete.setUserData(userData + "Delete");
        delete.setTextFill(Color.WHITE);
        delete.setBackground(Background.EMPTY);
        delete.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(10),
                new BorderWidths(2))));
        delete.setEffect(dropShadow);
        delete.setDisable(true);

        FontUtil.buttonsFontAll(up, down, delete);

        getChildren().addAll(up, down, delete);
    }

    public Button getUp() {
        return up;
    }

    public Button getDown() {
        return down;
    }

    public Button getDelete() {
        return delete;
    }
}
