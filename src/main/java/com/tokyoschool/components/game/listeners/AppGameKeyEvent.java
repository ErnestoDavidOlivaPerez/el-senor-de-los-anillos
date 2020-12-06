package com.tokyoschool.components.game.listeners;

import com.tokyoschool.AppView;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.KeyEvent;

public class AppGameKeyEvent implements EventHandler<KeyEvent> {

    private final AppView view;

    public AppGameKeyEvent(AppView view){
        this.view = view;
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        Node node = (Node) keyEvent.getSource();
        String userData = node.getUserData().toString();
        switch (userData){
            case "heroName":
                String tfName = view.getAppGameHeroes().getTfName().getText().trim();
                if (tfName.contains(" ") || tfName.equals("")){
                    view.getAppGameHeroes().getAddButton().setDisable(true);
                    view.getAppGameHeroes().getTfName().setStyle("-fx-text-fill: red");
                } else {
                    view.getAppGameHeroes().getTfName().setStyle("-fx-text-fill: white");
                    view.getAppGameHeroes().getAddButton().setDisable(false);
                }

                tfName = view.getAppGameHeroes().getTfName().getText();
                if (tfName.length() >= 14){
                    StringBuilder sb = new StringBuilder(tfName);
                    sb.deleteCharAt(tfName.length() - 1);
                    view.getAppGameHeroes().getTfName().setText(sb.toString());
                    view.getAppGameHeroes().getTfName().positionCaret(tfName.length());
                }
                break;

            case "beastName":
                tfName = view.getAppGameBeast().getTfName().getText().trim();
                if (tfName.contains(" ") || tfName.equals("")){
                    view.getAppGameBeast().getAddButton().setDisable(true);
                    view.getAppGameBeast().getTfName().setStyle("-fx-text-fill: red");
                } else {
                    view.getAppGameBeast().getTfName().setStyle("-fx-text-fill: white");
                    view.getAppGameBeast().getAddButton().setDisable(false);
                }

                tfName = view.getAppGameBeast().getTfName().getText();
                if (tfName.length() >= 14){
                    StringBuilder sb = new StringBuilder(tfName);
                    sb.deleteCharAt(tfName.length() - 1);
                    view.getAppGameBeast().getTfName().setText(sb.toString());
                    view.getAppGameBeast().getTfName().positionCaret(tfName.length());
                }
                break;
        }
    }
}
