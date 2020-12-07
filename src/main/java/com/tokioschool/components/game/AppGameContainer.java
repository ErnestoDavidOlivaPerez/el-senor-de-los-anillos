package com.tokioschool.components.game;

import com.tokioschool.database.AppModel;
import com.tokioschool.util.ImageUtil;
import com.tokioschool.util.WindowUtil;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ResourceBundle;

public class AppGameContainer extends Group {

    private AppGame appGameHeroes, appGameBeast;
    private final AppModel model;
    private AppGameFight appGameFight;
    private ScrollBar scrollBar;
    private AppGameExitStage appGameExitStage;
    private final Stage ownerStage;
    private final ResourceBundle res;

    public AppGameContainer(AppModel model, Stage ownerStage, ResourceBundle res){
        super();
        this.model = model;
        this.ownerStage = ownerStage;
        this.res = res;

        initComponents();
    }

    private void initComponents(){
        appGameHeroes = new AppGame("hero", model, res);
        appGameHeroes.setTitle(res.getString("heroes"));
        appGameHeroes.setComboType(0);
        appGameBeast = new AppGame("beast", model, res);
        appGameBeast.setTitle(res.getString("beast"));
        appGameBeast.setComboType(1);

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(50);
        hBox.getChildren().addAll(appGameHeroes, appGameBeast);

        appGameFight = new AppGameFight(res);

        scrollBar = new ScrollBar();
        scrollBar.setOrientation(Orientation.VERTICAL);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(hBox);
        borderPane.setBottom(appGameFight);
        borderPane.setMinHeight(WindowUtil.getDimension().height);
        borderPane.setMinWidth(WindowUtil.getDimension().width);

        Group group = null;
        try {
            group = new Group(ImageUtil.getImageView("Pantalla.jpg"), borderPane);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(group);
        scrollPane.setPrefSize(WindowUtil.getDimension().width , WindowUtil.getDimension().height );
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setStyle("-fx-padding: 0");

        getChildren().addAll(scrollPane);

        appGameExitStage = new AppGameExitStage(ownerStage, res);
    }

    public AppGame getAppGameHeroes() {
        return appGameHeroes;
    }

    public AppGame getAppGameBeast() {
        return appGameBeast;
    }

    public AppGameFight getAppGameFight(){return appGameFight;}

    public ScrollBar getScrollBar() {
        return scrollBar;
    }

    public AppGameExitStage getAppGameExitStage(){return appGameExitStage;}
}
