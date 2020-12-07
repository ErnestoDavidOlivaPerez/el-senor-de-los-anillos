package com.tokioschool.components.menu.listeners;

import com.tokioschool.AppView;
import com.tokioschool.database.AppModel;
import com.tokioschool.util.EffectUtil;
import javafx.event.*;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.sql.SQLException;
import java.util.Locale;

public class AppMenuMouseEvent implements EventHandler<MouseEvent> {

    private final AppView view;
    private final AppModel model;

    public AppMenuMouseEvent(AppView view, AppModel model){
        this.view = view;
        this.model = model;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        Node node = (Node) mouseEvent.getSource();
        String userData = node.getUserData().toString();

        switch (userData){
            case "new":
                if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED) {
                    view.getMenuStart().getLabelButton().setOpacity(0.8);
                    view.getMenuStart().getLabelButton().setFont(Font.font("Cambria", FontWeight.NORMAL,
                            FontPosture.ITALIC, 86));
                } else {
                    view.getMenuStart().getLabelButton().setOpacity(1);
                    view.getMenuStart().getLabelButton().setFont(Font.font("Cambria", FontWeight.NORMAL,
                            FontPosture.ITALIC, 80));
                }

                if (mouseEvent.getButton() == MouseButton.PRIMARY && mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED){
                    if (model.isConnect()){
                        view.getAppMenuContainer().addNew();
                    } else {
                        view.getStage().setScene(view.getScenePrimary());
                    }
                }
                break;

            case "save1":
                view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().setIsSave(1);

                if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED){
                    view.getAppMenuContainer().getAppMenuNew().getSave1().getSave().setBackground(new Background(
                            new BackgroundFill(Color.rgb(193, 202, 238, 0.3), new CornerRadii(15), null)));
                } else {
                    view.getAppMenuContainer().getAppMenuNew().getSave1().getSave().setBackground(new Background(
                            new BackgroundFill(Color.TRANSPARENT, null, null)));
                }

                if (mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED){
                    view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().setIsSave(1);

                    if (model.isSave1()){
                        view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().sceneReplace();
                    } else {
                        view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().sceneSave();
                    }
                    view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().show();
                }
                break;

            case "save2":
                view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().setIsSave(2);

                if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED){
                    view.getAppMenuContainer().getAppMenuNew().getSave2().getSave().setBackground(new Background(
                            new BackgroundFill(Color.rgb(193, 202, 238, 0.3), new CornerRadii(15), null)));
                } else {
                    view.getAppMenuContainer().getAppMenuNew().getSave2().getSave().setBackground(new Background(
                            new BackgroundFill(Color.TRANSPARENT, null, null)));
                }

                if (mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED){
                    if (model.isSave2()){
                        view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().sceneReplace();
                    } else {
                        view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().sceneSave();
                    }
                    view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().show();
                }
                break;

            case "save3":
                view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().setIsSave(3);

                if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED){
                    view.getAppMenuContainer().getAppMenuNew().getSave3().getSave().setBackground(new Background(
                            new BackgroundFill(Color.rgb(193, 202, 238, 0.3), new CornerRadii(15), null)));
                } else {
                    view.getAppMenuContainer().getAppMenuNew().getSave3().getSave().setBackground(new Background(
                            new BackgroundFill(Color.TRANSPARENT, null, null)));
                }

                if (mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED){
                    if (model.isSave3()){
                        view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().sceneReplace();
                    } else {
                        view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().sceneSave();
                    }
                    view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().show();
                }
                break;

            case "backNew":
                if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED) {
                    view.getAppMenuContainer().getAppMenuNew().getButtonExit().setBackground(new Background(
                            new BackgroundFill(Color.rgb(193, 202, 238, 0.3), new CornerRadii(15), null)));
                } else {
                    view.getAppMenuContainer().getAppMenuNew().getButtonExit().setBackground(new Background(
                            new BackgroundFill(Color.TRANSPARENT, null, null)));
                }
                break;

            case "newStageButtonOk":
                if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED){
                    view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().getLabelOkSave().setEffect(
                            EffectUtil.getBloom(0.5));
                    view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().getLabelOkReplace().setEffect(
                            EffectUtil.getBloom(0.5));
                }else {
                    view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().getLabelOkSave().setEffect(null);
                    view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().getLabelOkReplace().setEffect(null);
                }

                if (mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED) {
                    int save = view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().getIsSave();
                    switch (save) {
                        case 1:
                            if (model.isSave1()) {
                                if (view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().getIsScene() == 1) {
                                    String text = view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().getTextField().getText();
                                    view.getAppMenuContainer().getAppMenuNew().getSave1().getSave().setText(text);
                                    view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().close();

                                    model.setSave(1);
                                    model.connect();
                                    try {
                                        model.reset();
                                        model.saveName(text);
                                        view.getAppMenuLoad().getLoad1().getSave().setText(text);
                                    } catch (SQLException sqlException) {
                                        sqlException.printStackTrace();
                                    }
                                } else if (view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().getIsScene() == 2) {
                                    view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().close();
                                    view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().sceneSave();
                                    view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().showAndWait();

                                    break;
                                }
                            } else {
                                String text = view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().getTextField().getText();
                                view.getAppMenuContainer().getAppMenuNew().getSave1().getSave().setText(text);
                                view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().close();

                                model.setSave(1);
                                model.connect();
                                try {
                                    model.saveName(text);
                                    view.getAppMenuLoad().refresh();
                                } catch (SQLException sqlException) {
                                    sqlException.printStackTrace();
                                }
                            }
                            view.getStage().setScene(view.getScenePrimary());
                            view.getAppGameHeroes().getListView().loadData();
                            view.getAppGameBeast().getListView().loadData();

                            if (view.getAppGameHeroes().getTfName().getText().isEmpty()){
                                view.getAppGameHeroes().getAddButton().setDisable(true);
                            }

                            if (view.getAppGameBeast().getTfName().getText().isEmpty()){
                                view.getAppGameBeast().getAddButton().setDisable(true);
                            }

                            break;

                        case 2:
                            if (model.isSave2()) {
                                if (view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().getIsScene() == 1) {
                                    String text = view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().getTextField().getText();
                                    view.getAppMenuContainer().getAppMenuNew().getSave2().getSave().setText(text);
                                    view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().close();

                                    model.setSave(2);
                                    model.connect();
                                    try {
                                        model.reset();
                                        model.saveName(text);
                                        view.getAppMenuLoad().getLoad2().getSave().setText(text);
                                    } catch (SQLException sqlException) {
                                        sqlException.printStackTrace();
                                    }
                                } else if (view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().getIsScene() == 2) {
                                    view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().close();
                                    view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().sceneSave();
                                    view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().showAndWait();

                                    break;
                                }
                            } else {
                                String text = view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().getTextField().getText();
                                view.getAppMenuContainer().getAppMenuNew().getSave2().getSave().setText(text);
                                view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().close();

                                model.setSave(2);
                                model.connect();
                                try {
                                    model.saveName(text);
                                    view.getAppMenuLoad().refresh();
                                } catch (SQLException sqlException) {
                                    sqlException.printStackTrace();
                                }
                            }
                            view.getStage().setScene(view.getScenePrimary());
                            view.getAppGameHeroes().getListView().loadData();
                            view.getAppGameBeast().getListView().loadData();

                            if (view.getAppGameHeroes().getTfName().getText().isEmpty()){
                                view.getAppGameHeroes().getAddButton().setDisable(true);
                            }

                            if (view.getAppGameBeast().getTfName().getText().isEmpty()){
                                view.getAppGameBeast().getAddButton().setDisable(true);
                            }
                            break;

                        case 3:
                            if (model.isSave3()) {
                                if (view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().getIsScene() == 1) {
                                    String text = view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().getTextField().getText();
                                    view.getAppMenuContainer().getAppMenuNew().getSave3().getSave().setText(text);
                                    view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().close();

                                    model.setSave(3);
                                    model.connect();
                                    try {
                                        model.reset();
                                        model.saveName(text);
                                        view.getAppMenuLoad().getLoad3().getSave().setText(text);
                                    } catch (SQLException sqlException) {
                                        sqlException.printStackTrace();
                                    }
                                } else if (view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().getIsScene() == 2) {
                                    view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().close();
                                    view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().sceneSave();
                                    view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().showAndWait();

                                    break;
                                }
                            } else {
                                String text = view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().getTextField().getText();
                                view.getAppMenuContainer().getAppMenuNew().getSave3().getSave().setText(text);
                                view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().close();

                                model.setSave(3);
                                model.connect();
                                try {
                                    model.saveName(text);
                                    view.getAppMenuLoad().refresh();
                                } catch (SQLException sqlException) {
                                    sqlException.printStackTrace();
                                }
                            }
                            view.getStage().setScene(view.getScenePrimary());
                            view.getAppGameHeroes().getListView().loadData();
                            view.getAppGameBeast().getListView().loadData();

                            if (view.getAppGameHeroes().getTfName().getText().isEmpty()){
                                view.getAppGameHeroes().getAddButton().setDisable(true);
                            }

                            if (view.getAppGameBeast().getTfName().getText().isEmpty()){
                                view.getAppGameBeast().getAddButton().setDisable(true);
                            }
                        break;
                    }
                }
                break;

            case "newStageButtonCancel":
                if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED){
                    view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().getLabelCancelSave().setEffect(
                            EffectUtil.getBloom(0.5));
                    view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().getLabelCancelReplace().setEffect(
                            EffectUtil.getBloom(0.5));
                }else {
                    view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().getLabelCancelSave().setEffect(null);
                    view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().getLabelCancelReplace().setEffect(null);
                }

                if (mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED){
                    view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().close();
                }
                break;

            case "load":
                if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED){
                    view.getMenuLoad().getLabelButton().setOpacity(0.8);
                    view.getMenuLoad().getLabelButton().setFont(Font.font("Cambria", FontWeight.NORMAL,
                            FontPosture.ITALIC, 86));
                } else {
                    view.getMenuLoad().getLabelButton().setOpacity(1);
                    view.getMenuLoad().getLabelButton().setFont(Font.font("Cambria", FontWeight.NORMAL,
                            FontPosture.ITALIC, 80));
                }

                if (mouseEvent.getButton() == MouseButton.PRIMARY && mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED){
                    view.getAppMenuContainer().addLoad();
                }
                break;

            case "load1":
                if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED){
                    view.getAppMenuLoad().getLoad1().setBackground(new Background(
                            new BackgroundFill(Color.rgb(193, 202, 238, 0.3), new CornerRadii(15), null)));

                } else {
                    view.getAppMenuLoad().getLoad1().setBackground(new Background(
                            new BackgroundFill(Color.TRANSPARENT, null, null)));
                }

                if (mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED){
                    model.setSave(1);
                    model.connect();
                    view.getAppGameHeroes().getListView().loadData();
                    view.getAppGameBeast().getListView().loadData();
                    if (!view.getAppGameHeroes().getListView().getItems().isEmpty() &&
                            !view.getAppGameBeast().getListView().getItems().isEmpty())
                        view.getAppGameContainer().getAppGameFight().getFight().setDisable(false);

                    if (view.getAppGameHeroes().getTfName().getText().isEmpty()){
                        view.getAppGameHeroes().getAddButton().setDisable(true);
                    }

                    if (view.getAppGameBeast().getTfName().getText().isEmpty()){
                        view.getAppGameBeast().getAddButton().setDisable(true);
                    }

                    view.getStage().setScene(view.getScenePrimary());
                }
                break;

            case "load2":
                if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED){
                    view.getAppMenuLoad().getLoad2().setBackground(new Background(
                            new BackgroundFill(Color.rgb(193, 202, 238, 0.3), new CornerRadii(15), null)));
                } else {
                    view.getAppMenuLoad().getLoad2().setBackground(new Background(
                            new BackgroundFill(Color.TRANSPARENT, null, null)));
                }

                if (mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED){
                    model.setSave(2);
                    model.connect();
                    view.getAppGameHeroes().getListView().loadData();
                    view.getAppGameBeast().getListView().loadData();
                    if (!view.getAppGameHeroes().getListView().getItems().isEmpty() &&
                            !view.getAppGameBeast().getListView().getItems().isEmpty())
                        view.getAppGameContainer().getAppGameFight().getFight().setDisable(false);

                    if (view.getAppGameHeroes().getTfName().getText().isEmpty()){
                        view.getAppGameHeroes().getAddButton().setDisable(true);
                    }

                    if (view.getAppGameBeast().getTfName().getText().isEmpty()){
                        view.getAppGameBeast().getAddButton().setDisable(true);
                    }

                    view.getStage().setScene(view.getScenePrimary());
                }
                break;

            case "load3":
                if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED){
                    view.getAppMenuLoad().getLoad3().setBackground(new Background(
                            new BackgroundFill(Color.rgb(193, 202, 238, 0.3), new CornerRadii(15), null)));

                } else {
                    view.getAppMenuLoad().getLoad3().setBackground(new Background(
                            new BackgroundFill(Color.TRANSPARENT, null, null)));
                }

                if (mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED){
                    model.setSave(3);
                    model.connect();
                    view.getAppGameHeroes().getListView().loadData();
                    view.getAppGameBeast().getListView().loadData();
                    if (!view.getAppGameHeroes().getListView().getItems().isEmpty() &&
                            !view.getAppGameBeast().getListView().getItems().isEmpty())
                        view.getAppGameContainer().getAppGameFight().getFight().setDisable(false);

                    if (view.getAppGameHeroes().getTfName().getText().isEmpty()){
                        view.getAppGameHeroes().getAddButton().setDisable(true);
                    }

                    if (view.getAppGameBeast().getTfName().getText().isEmpty()){
                        view.getAppGameBeast().getAddButton().setDisable(true);
                    }

                    view.getStage().setScene(view.getScenePrimary());
                }
                break;

            case "backLoad":
                if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED){
                    view.getAppMenuLoad().getBackButton().setBackground(new Background(new BackgroundFill(
                            Color.rgb(193, 202, 238, 0.3), new CornerRadii(15), null)));
                } else {
                    view.getAppMenuLoad().getBackButton().setBackground(new Background(new BackgroundFill(
                            Color.TRANSPARENT, null, null)));
                }
                break;

            case "language":
                if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED){
                    view.getMenuLanguish().getLabelButton().setOpacity(0.8);
                    view.getMenuLanguish().getLabelButton().setFont(Font.font("Cambria", FontWeight.NORMAL,
                            FontPosture.ITALIC, 86));
                } else {
                    view.getMenuLanguish().getLabelButton().setOpacity(1);
                    view.getMenuLanguish().getLabelButton().setFont(Font.font("Cambria", FontWeight.NORMAL,
                            FontPosture.ITALIC, 80));
                }

                if (mouseEvent.getButton() == MouseButton.PRIMARY && mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED){
                    view.getAppMenuContainer().addLanguish();
                }
                break;

            case "languageBack":
                if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED){
                    view.getAppMenuContainer().getAppMenuLanguish().getBackButton().setBackground(new Background(
                            new BackgroundFill(Color.rgb(193, 202, 238, 0.3), new CornerRadii(15), null)));
                } else {
                    view.getAppMenuContainer().getAppMenuLanguish().getBackButton().setBackground(Background.EMPTY);
                }
                break;

            case "spanish":
                if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED){
                    view.getAppMenuContainer().getAppMenuLanguish().getImageSpanish().setOpacity(0.8);
                } else {
                    view.getAppMenuContainer().getAppMenuLanguish().getImageSpanish().setOpacity(1);

                }

                if (mouseEvent.getButton() == MouseButton.PRIMARY && mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED){
                    try {
                        model.saveLanguage("es");
                    } catch (SQLException sqlException) {
                        sqlException.printStackTrace();
                    }
                    view.setLocale(new Locale("es"));
                }

                break;

            case "english":
                if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED){
                    view.getAppMenuContainer().getAppMenuLanguish().getImageEnglish().setOpacity(0.8);
                } else {
                    view.getAppMenuContainer().getAppMenuLanguish().getImageEnglish().setOpacity(1);
                }

                if (mouseEvent.getButton() == MouseButton.PRIMARY && mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED){
                    try {
                        model.saveLanguage("en");
                    } catch (SQLException sqlException) {
                        sqlException.printStackTrace();
                    }
                    view.setLocale(new Locale("en"));
                }

                break;

            case "french":
                if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED){
                    view.getAppMenuContainer().getAppMenuLanguish().getImageFrench().setOpacity(0.8);
                } else {
                    view.getAppMenuContainer().getAppMenuLanguish().getImageFrench().setOpacity(1);
                }

                if (mouseEvent.getButton() == MouseButton.PRIMARY && mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED){
                    try {
                        model.saveLanguage("fr");
                    } catch (SQLException sqlException) {
                        sqlException.printStackTrace();
                    }
                    view.setLocale(new Locale("fr"));
                }

                break;

            case "exit":
                if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED) {
                    view.getMenuExit().getLabelButton().setOpacity(0.8);
                    view.getMenuExit().getLabelButton().setFont(Font.font("Cambria", FontWeight.NORMAL,
                            FontPosture.ITALIC, 86));
                } else {
                    view.getMenuExit().getLabelButton().setOpacity(1);
                    view.getMenuExit().getLabelButton().setFont(Font.font("Cambria", FontWeight.NORMAL,
                            FontPosture.ITALIC, 80));
                }

                if (mouseEvent.getButton() == MouseButton.PRIMARY && mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED) {
                    view.getAppMenuContainer().getAppMenuExit().showAndWait();
                }
                break;

            case "exitImage":
                if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED){
                    view.getAppMenuContainer().getAppMenuExit().getImageViewExit().setOpacity(0.6);
                } else {
                    view.getAppMenuContainer().getAppMenuExit().getImageViewExit().setOpacity(1);
                }

                if (mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED){
                    view.getAppMenuContainer().getAppMenuExit().close();
                }
                break;

            case "exitOkButton":
                if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED){
                    view.getAppMenuContainer().getAppMenuExit().getOkLabel().setEffect(EffectUtil.getBloom(0.9));
                } else {
                    view.getAppMenuContainer().getAppMenuExit().getOkLabel().setEffect(null);
                }

                if (mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED){
                    view.getStage().close();
                }
                break;

            case "exitCancelButton":
                if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED){
                    view.getAppMenuContainer().getAppMenuExit().getCancelLabel().setEffect(EffectUtil.getBloom(0.9));
                } else {
                    view.getAppMenuContainer().getAppMenuExit().getCancelLabel().setEffect(null);
                }

                if (mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED){
                    view.getAppMenuContainer().getAppMenuExit().close();
                }
                break;
        }
    }
}
