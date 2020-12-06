package com.tokyoschool;

import com.tokyoschool.components.game.listeners.AppGameActionEvent;
import com.tokyoschool.components.game.listeners.AppGameKeyEvent;
import com.tokyoschool.components.game.listeners.AppGameMouseEvent;
import com.tokyoschool.components.menu.listeners.AppMenuActionEvent;
import com.tokyoschool.components.menu.listeners.AppMenuKeyEvent;
import com.tokyoschool.components.menu.listeners.AppMenuMouseEvent;
import com.tokyoschool.database.AppModel;

import java.util.ResourceBundle;

public class AppController {

    private final AppModel model;
    private AppView view;

    public AppController(AppModel model){
        this.model = model;

        initComponents();
    }

    private void initComponents(){

    }

    public void initListeners(AppView view, ResourceBundle res){
        this.view = view;

        AppMenuMouseEvent appMenuMouseEvent = new AppMenuMouseEvent(view, model);

        view.getMenuStart().getLabelButton().setOnMouseClicked(appMenuMouseEvent);
        view.getMenuStart().getLabelButton().setOnMouseEntered(appMenuMouseEvent);
        view.getMenuStart().getLabelButton().setOnMouseExited(appMenuMouseEvent);

        view.getAppMenuContainer().getAppMenuNew().getButtonExit().setOnMouseEntered(appMenuMouseEvent);
        view.getAppMenuContainer().getAppMenuNew().getButtonExit().setOnMouseExited(appMenuMouseEvent);

        view.getAppMenuContainer().getAppMenuNew().getSave1().getSave().setOnMouseEntered(appMenuMouseEvent);
        view.getAppMenuContainer().getAppMenuNew().getSave1().getSave().setOnMouseExited(appMenuMouseEvent);
        view.getAppMenuContainer().getAppMenuNew().getSave1().getSave().setOnMouseClicked(appMenuMouseEvent);

        view.getAppMenuContainer().getAppMenuNew().getSave2().getSave().setOnMouseEntered(appMenuMouseEvent);
        view.getAppMenuContainer().getAppMenuNew().getSave2().getSave().setOnMouseExited(appMenuMouseEvent);
        view.getAppMenuContainer().getAppMenuNew().getSave2().getSave().setOnMouseClicked(appMenuMouseEvent);

        view.getAppMenuContainer().getAppMenuNew().getSave3().getSave().setOnMouseEntered(appMenuMouseEvent);
        view.getAppMenuContainer().getAppMenuNew().getSave3().getSave().setOnMouseExited(appMenuMouseEvent);
        view.getAppMenuContainer().getAppMenuNew().getSave3().getSave().setOnMouseClicked(appMenuMouseEvent);

        view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().getLabelOkSave().setOnMouseEntered(appMenuMouseEvent);
        view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().getLabelOkSave().setOnMouseExited(appMenuMouseEvent);
        view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().getLabelOkSave().setOnMouseClicked(appMenuMouseEvent);

        view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().getLabelCancelSave().setOnMouseEntered(appMenuMouseEvent);
        view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().getLabelCancelSave().setOnMouseExited(appMenuMouseEvent);
        view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().getLabelCancelSave().setOnMouseClicked(appMenuMouseEvent);

        view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().getLabelOkReplace().setOnMouseEntered(appMenuMouseEvent);
        view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().getLabelOkReplace().setOnMouseExited(appMenuMouseEvent);
        view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().getLabelOkReplace().setOnMouseClicked(appMenuMouseEvent);

        view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().getLabelCancelReplace().setOnMouseEntered(appMenuMouseEvent);
        view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().getLabelCancelReplace().setOnMouseExited(appMenuMouseEvent);
        view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().getLabelCancelReplace().setOnMouseClicked(appMenuMouseEvent);

        view.getMenuLoad().getLabelButton().setOnMouseClicked(appMenuMouseEvent);
        view.getMenuLoad().getLabelButton().setOnMouseEntered(appMenuMouseEvent);
        view.getMenuLoad().getLabelButton().setOnMouseExited(appMenuMouseEvent);

        connectSave();

        view.getAppMenuLoad().getBackButton().setOnMouseEntered(appMenuMouseEvent);
        view.getAppMenuLoad().getBackButton().setOnMouseExited(appMenuMouseEvent);

        view.getMenuLanguish().getLabelButton().setOnMouseClicked(appMenuMouseEvent);
        view.getMenuLanguish().getLabelButton().setOnMouseEntered(appMenuMouseEvent);
        view.getMenuLanguish().getLabelButton().setOnMouseExited(appMenuMouseEvent);

        view.getAppMenuContainer().getAppMenuLanguish().getImageSpanish().setOnMouseEntered(appMenuMouseEvent);
        view.getAppMenuContainer().getAppMenuLanguish().getImageSpanish().setOnMouseExited(appMenuMouseEvent);
        view.getAppMenuContainer().getAppMenuLanguish().getImageSpanish().setOnMouseClicked(appMenuMouseEvent);

        view.getAppMenuContainer().getAppMenuLanguish().getImageEnglish().setOnMouseEntered(appMenuMouseEvent);
        view.getAppMenuContainer().getAppMenuLanguish().getImageEnglish().setOnMouseExited(appMenuMouseEvent);
        view.getAppMenuContainer().getAppMenuLanguish().getImageEnglish().setOnMouseClicked(appMenuMouseEvent);

        view.getAppMenuContainer().getAppMenuLanguish().getImageFrench().setOnMouseEntered(appMenuMouseEvent);
        view.getAppMenuContainer().getAppMenuLanguish().getImageFrench().setOnMouseExited(appMenuMouseEvent);
        view.getAppMenuContainer().getAppMenuLanguish().getImageFrench().setOnMouseClicked(appMenuMouseEvent);

        view.getMenuExit().getLabelButton().setOnMouseClicked(appMenuMouseEvent);
        view.getMenuExit().getLabelButton().setOnMouseEntered(appMenuMouseEvent);
        view.getMenuExit().getLabelButton().setOnMouseExited(appMenuMouseEvent);

        view.getAppMenuContainer().getAppMenuLanguish().getBackButton().setOnMouseEntered(appMenuMouseEvent);
        view.getAppMenuContainer().getAppMenuLanguish().getBackButton().setOnMouseExited(appMenuMouseEvent);

        view.getAppMenuContainer().getAppMenuExit().getImageViewExit().setOnMouseClicked(appMenuMouseEvent);
        view.getAppMenuContainer().getAppMenuExit().getImageViewExit().setOnMouseEntered(appMenuMouseEvent);
        view.getAppMenuContainer().getAppMenuExit().getImageViewExit().setOnMouseExited(appMenuMouseEvent);

        view.getAppMenuContainer().getAppMenuExit().getOkLabel().setOnMouseEntered(appMenuMouseEvent);
        view.getAppMenuContainer().getAppMenuExit().getOkLabel().setOnMouseExited(appMenuMouseEvent);
        view.getAppMenuContainer().getAppMenuExit().getOkLabel().setOnMouseClicked(appMenuMouseEvent);

        view.getAppMenuContainer().getAppMenuExit().getCancelLabel().setOnMouseEntered(appMenuMouseEvent);
        view.getAppMenuContainer().getAppMenuExit().getCancelLabel().setOnMouseExited(appMenuMouseEvent);
        view.getAppMenuContainer().getAppMenuExit().getCancelLabel().setOnMouseClicked(appMenuMouseEvent);

        AppMenuActionEvent appMenuActionEvent = new AppMenuActionEvent(view);
        view.getAppMenuLoad().getBackButton().setOnAction(appMenuActionEvent);

        view.getAppMenuContainer().getAppMenuNew().getButtonExit().setOnAction(appMenuActionEvent);

        view.getAppMenuContainer().getAppMenuLanguish().getBackButton().setOnAction(appMenuActionEvent);

        AppMenuKeyEvent appMenuKeyEvent = new AppMenuKeyEvent(view);

        view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().getTextField().setOnKeyTyped(appMenuKeyEvent);

        AppGameActionEvent appGameActionEvent = new AppGameActionEvent(view, model, res);
        view.getAppGameHeroes().getAddButton().setOnAction(appGameActionEvent);
        view.getAppGameBeast().getAddButton().setOnAction(appGameActionEvent);

        view.getAppGameHeroes().getUpButton().setOnAction(appGameActionEvent);
        view.getAppGameHeroes().getDownButton().setOnAction(appGameActionEvent);
        view.getAppGameHeroes().getDeleteButton().setOnAction(appGameActionEvent);

        view.getAppGameBeast().getUpButton().setOnAction(appGameActionEvent);
        view.getAppGameBeast().getDownButton().setOnAction(appGameActionEvent);
        view.getAppGameBeast().getDeleteButton().setOnAction(appGameActionEvent);

        view.getAppGameContainer().getAppGameFight().getFight().setOnAction(appGameActionEvent);

        view.getAppGameContainer().getAppGameFight().getExit().setOnAction(appGameActionEvent);

        AppGameMouseEvent appGameMouseEvent = new AppGameMouseEvent(view, model);
        view.getAppGameHeroes().getSliderArmor().setOnMouseDragged(appGameMouseEvent);
        view.getAppGameHeroes().getSliderLife().setOnMouseDragged(appGameMouseEvent);
        view.getAppGameBeast().getSliderArmor().setOnMouseDragged(appGameMouseEvent);
        view.getAppGameBeast().getSliderLife().setOnMouseDragged(appGameMouseEvent);

        view.getAppGameHeroes().getAddButton().setOnMouseEntered(appGameMouseEvent);
        view.getAppGameHeroes().getAddButton().setOnMouseExited(appGameMouseEvent);
        view.getAppGameBeast().getAddButton().setOnMouseEntered(appGameMouseEvent);
        view.getAppGameBeast().getAddButton().setOnMouseExited(appGameMouseEvent);

        view.getAppGameHeroes().getUpButton().setOnMouseEntered(appGameMouseEvent);
        view.getAppGameHeroes().getUpButton().setOnMouseExited(appGameMouseEvent);
        view.getAppGameHeroes().getDeleteButton().setOnMouseEntered(appGameMouseEvent);
        view.getAppGameHeroes().getDeleteButton().setOnMouseExited(appGameMouseEvent);
        view.getAppGameHeroes().getDownButton().setOnMouseEntered(appGameMouseEvent);
        view.getAppGameHeroes().getDownButton().setOnMouseExited(appGameMouseEvent);

        view.getAppGameBeast().getUpButton().setOnMouseEntered(appGameMouseEvent);
        view.getAppGameBeast().getUpButton().setOnMouseExited(appGameMouseEvent);
        view.getAppGameBeast().getDeleteButton().setOnMouseEntered(appGameMouseEvent);
        view.getAppGameBeast().getDeleteButton().setOnMouseExited(appGameMouseEvent);
        view.getAppGameBeast().getDownButton().setOnMouseEntered(appGameMouseEvent);
        view.getAppGameBeast().getDownButton().setOnMouseExited(appGameMouseEvent);

        view.getAppGameContainer().getAppGameFight().getFight().setOnMouseEntered(appGameMouseEvent);
        view.getAppGameContainer().getAppGameFight().getFight().setOnMouseExited(appGameMouseEvent);

        view.getAppGameHeroes().getListView().setOnMouseClicked(appGameMouseEvent);
        view.getAppGameBeast().getListView().setOnMouseClicked(appGameMouseEvent);

        view.getAppGameContainer().getAppGameFight().getExit().setOnMouseEntered(appGameMouseEvent);
        view.getAppGameContainer().getAppGameFight().getExit().setOnMouseExited(appGameMouseEvent);

        view.getAppGameContainer().getAppGameExitStage().getLabelOk().setOnMouseClicked(appGameMouseEvent);
        view.getAppGameContainer().getAppGameExitStage().getLabelOk().setOnMouseEntered(appGameMouseEvent);
        view.getAppGameContainer().getAppGameExitStage().getLabelOk().setOnMouseExited(appGameMouseEvent);

        view.getAppGameContainer().getAppGameExitStage().getLabelCancel().setOnMouseClicked(appGameMouseEvent);
        view.getAppGameContainer().getAppGameExitStage().getLabelCancel().setOnMouseEntered(appGameMouseEvent);
        view.getAppGameContainer().getAppGameExitStage().getLabelCancel().setOnMouseExited(appGameMouseEvent);

        AppGameKeyEvent appGameKeyEvent = new AppGameKeyEvent(view);
        view.getAppGameHeroes().getTfName().setOnKeyTyped(appGameKeyEvent);
        view.getAppGameBeast().getTfName().setOnKeyTyped(appGameKeyEvent);
    }

    public void connectSave(){
        AppMenuMouseEvent appMenuMouseEvent = new AppMenuMouseEvent(view, model);
        if (model.isSave1()){
            view.getAppMenuLoad().getLoad1().setOnMouseClicked(appMenuMouseEvent);
            view.getAppMenuLoad().getLoad1().setOnMouseEntered(appMenuMouseEvent);
            view.getAppMenuLoad().getLoad1().setOnMouseExited(appMenuMouseEvent);
        }

        if (model.isSave2()){
            view.getAppMenuLoad().getLoad2().setOnMouseClicked(appMenuMouseEvent);
            view.getAppMenuLoad().getLoad2().setOnMouseEntered(appMenuMouseEvent);
            view.getAppMenuLoad().getLoad2().setOnMouseExited(appMenuMouseEvent);
        }

        if (model.isSave3()){
            view.getAppMenuLoad().getLoad3().setOnMouseClicked(appMenuMouseEvent);
            view.getAppMenuLoad().getLoad3().setOnMouseEntered(appMenuMouseEvent);
            view.getAppMenuLoad().getLoad3().setOnMouseExited(appMenuMouseEvent);
        }
    }
}
