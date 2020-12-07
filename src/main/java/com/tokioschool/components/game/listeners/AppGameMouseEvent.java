package com.tokioschool.components.game.listeners;

import com.tokioschool.AppView;
import com.tokioschool.database.AppModel;
import com.tokioschool.domain.Beast;
import com.tokioschool.domain.Hero;
import com.tokioschool.util.EffectUtil;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import java.sql.SQLException;
import java.util.List;

public class AppGameMouseEvent implements EventHandler<MouseEvent> {

    private final AppView view;
    private final AppModel model;

    public AppGameMouseEvent(AppView view, AppModel model){
        super();
        this.view = view;
        this.model = model;
    }

    @Override
    public void handle(MouseEvent event) {
        Node node = (Node) event.getSource();
        String userData = node.getUserData().toString();

        switch (userData){
            case "heroSliderArmor":
                view.getAppGameHeroes().getTextFieldArmor().setText(String.valueOf((int)view.getAppGameHeroes().getSliderArmor().getValue()));
                break;

            case "heroSliderLife":
                view.getAppGameHeroes().getTextFieldLife().setText(String.valueOf((int)view.getAppGameHeroes().getSliderLife().getValue()));
                break;

            case "beastSliderArmor":
                view.getAppGameBeast().getTextFieldArmor().setText(String.valueOf((int)view.getAppGameBeast().getSliderArmor().getValue()));
                break;

            case "beastSliderLife":
                view.getAppGameBeast().getTextFieldLife().setText(String.valueOf((int)view.getAppGameBeast().getSliderLife().getValue()));
                break;

            case "heroAddButton":
                if (event.getEventType() == MouseEvent.MOUSE_ENTERED){
                    view.getAppGameHeroes().getAddButton().setBackground(new Background(
                            new BackgroundFill(Color.rgb(193, 202, 238, 0.3), new CornerRadii(15), null)));
                } else {
                    view.getAppGameHeroes().getAddButton().setBackground(new Background(
                            new BackgroundFill(Color.TRANSPARENT, null, null)));
                }
                break;

            case "beastAddButton":
                if (event.getEventType() == MouseEvent.MOUSE_ENTERED){
                    view.getAppGameBeast().getAddButton().setBackground(new Background(
                            new BackgroundFill(Color.rgb(193, 202, 238, 0.3), new CornerRadii(15), null)));
                } else {
                    view.getAppGameBeast().getAddButton().setBackground(new Background(
                            new BackgroundFill(Color.TRANSPARENT, null, null)));
                }
                break;

            case "heroUp":
                if (event.getEventType() == MouseEvent.MOUSE_ENTERED){
                    view.getAppGameHeroes().getUpButton().setBackground(new Background(
                            new BackgroundFill(Color.rgb(193, 202, 238, 0.3), new CornerRadii(15), null)));
                } else {
                    view.getAppGameHeroes().getUpButton().setBackground(new Background(
                            new BackgroundFill(Color.TRANSPARENT, null, null)));
                }
                break;

            case "heroDown":
                if (event.getEventType() == MouseEvent.MOUSE_ENTERED){
                    view.getAppGameHeroes().getDownButton().setBackground(new Background(
                            new BackgroundFill(Color.rgb(193, 202, 238, 0.3), new CornerRadii(15), null)));
                } else {
                    view.getAppGameHeroes().getDownButton().setBackground(new Background(
                            new BackgroundFill(Color.TRANSPARENT, null, null)));
                }
                break;

            case "heroDelete":
                if (event.getEventType() == MouseEvent.MOUSE_ENTERED){
                    view.getAppGameHeroes().getDeleteButton().setBackground(new Background(
                            new BackgroundFill(Color.rgb(193, 202, 238, 0.3), new CornerRadii(15), null)));
                } else {
                    view.getAppGameHeroes().getDeleteButton().setBackground(new Background(
                            new BackgroundFill(Color.TRANSPARENT, null, null)));
                }
                break;

            case "beastUp":
                if (event.getEventType() == MouseEvent.MOUSE_ENTERED){
                    view.getAppGameBeast().getUpButton().setBackground(new Background(
                            new BackgroundFill(Color.rgb(193, 202, 238, 0.3), new CornerRadii(15), null)));
                } else {
                    view.getAppGameBeast().getUpButton().setBackground(new Background(
                            new BackgroundFill(Color.TRANSPARENT, null, null)));
                }
                break;

            case "beastDown":
                if (event.getEventType() == MouseEvent.MOUSE_ENTERED){
                    view.getAppGameBeast().getDownButton().setBackground(new Background(
                            new BackgroundFill(Color.rgb(193, 202, 238, 0.3), new CornerRadii(15), null)));
                } else {
                    view.getAppGameBeast().getDownButton().setBackground(new Background(
                            new BackgroundFill(Color.TRANSPARENT, null, null)));
                }
                break;

            case "beastDelete":
                if (event.getEventType() == MouseEvent.MOUSE_ENTERED){
                    view.getAppGameBeast().getDeleteButton().setBackground(new Background(
                            new BackgroundFill(Color.rgb(193, 202, 238, 0.3), new CornerRadii(15), null)));
                } else {
                    view.getAppGameBeast().getDeleteButton().setBackground(new Background(
                            new BackgroundFill(Color.TRANSPARENT, null, null)));
                }
                break;

            case "fight":
                if (event.getEventType() == MouseEvent.MOUSE_ENTERED){
                    view.getAppGameContainer().getAppGameFight().getFight().setBackground(new Background(
                            new BackgroundFill(Color.rgb(193, 202, 238, 0.3), new CornerRadii(15), null)));
                } else {
                    view.getAppGameContainer().getAppGameFight().getFight().setBackground(new Background(
                            new BackgroundFill(Color.TRANSPARENT, null, null)));
                }
                break;

            case "heroListView":
                if (!view.getAppGameHeroes().getListView().getSelectionModel().isEmpty()){
                    view.getAppGameHeroes().getUpButton().setDisable(false);
                    view.getAppGameHeroes().getDownButton().setDisable(false);
                    view.getAppGameHeroes().getDeleteButton().setDisable(false);
                }
                break;

            case "beastListView":
                if (!view.getAppGameBeast().getListView().getSelectionModel().isEmpty()){
                    view.getAppGameBeast().getUpButton().setDisable(false);
                    view.getAppGameBeast().getDownButton().setDisable(false);
                    view.getAppGameBeast().getDeleteButton().setDisable(false);
                }
                break;

            case "exit":
                if (event.getEventType() == MouseEvent.MOUSE_ENTERED){
                    view.getAppGameContainer().getAppGameFight().getExit().setBackground(new Background(
                            new BackgroundFill(Color.rgb(193, 202, 238, 0.3), new CornerRadii(15), null)));
                } else {
                    view.getAppGameContainer().getAppGameFight().getExit().setBackground(new Background(
                            new BackgroundFill(Color.TRANSPARENT, null, null)));
                }
                break;

            case "stageButtonOk":
                if (event.getEventType() == MouseEvent.MOUSE_ENTERED){
                    view.getAppGameContainer().getAppGameExitStage().getLabelOk().setEffect(EffectUtil.getBloom(0.5));
                } else {
                    view.getAppGameContainer().getAppGameExitStage().getLabelOk().setEffect(null);
                }

                if (event.getEventType() == MouseEvent.MOUSE_CLICKED){
                    List<Hero> heroes = view.getAppGameHeroes().getListView().getHeroPosDTOS();
                    List<Beast> beasts = view.getAppGameBeast().getListView().getBeastPosDTOS();

                    view.getAppMenuContainer().addMenu();
                    view.getAppGameContainer().getAppGameExitStage().close();
                    view.getStage().setScene(view.getSceneMenu());

                    try {
                        model.save(heroes, beasts);
                        view.getAppGameHeroes().reset();
                        view.getAppGameBeast().reset();
                        view.getAppGameContainer().getAppGameFight().reset();
                        model.disconnect();
                    } catch (SQLException sqlException) {
                        sqlException.printStackTrace();
                    }

                }
                break;

            case "stageButtonCancel":
                if (event.getEventType() == MouseEvent.MOUSE_ENTERED){
                    view.getAppGameContainer().getAppGameExitStage().getLabelCancel().setEffect(EffectUtil.getBloom(0.5));
                } else {
                    view.getAppGameContainer().getAppGameExitStage().getLabelCancel().setEffect(null);
                }

                if (event.getEventType() == MouseEvent.MOUSE_CLICKED) {
                    view.getAppGameContainer().getAppGameExitStage().close();
                }

                break;
        }
    }
}
