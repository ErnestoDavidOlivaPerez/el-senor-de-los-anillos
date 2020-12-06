package com.tokyoschool.components.menu.listeners;

import com.tokyoschool.AppView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;

public class AppMenuActionEvent implements EventHandler<ActionEvent> {

    private final AppView view;

    public AppMenuActionEvent(AppView view){
        super();

        this.view = view;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Node node = (Node) actionEvent.getSource();
        String userData = node.getUserData().toString();

        switch (userData){
            case "backLoad":

            case "backNew":

            case "languageBack":
                view.getAppMenuContainer().addMenu();
                break;
        }
    }
}
