package com.tokioschool.components.menu.listeners;

import com.tokioschool.AppView;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.KeyEvent;

public class AppMenuKeyEvent implements EventHandler<KeyEvent> {

    private final AppView view;

    public AppMenuKeyEvent(AppView view){
        super();
        this.view = view;
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        Node node = (Node) keyEvent.getSource();
        String userData = node.getUserData().toString();

        if ("newStageTextField".equals(userData)) {
            String tfName = view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().getTextField().getText();
            if (tfName.length() >= 14) {
                StringBuilder sb = new StringBuilder(tfName);
                sb.deleteCharAt(tfName.length() - 1);
                view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().getTextField().setText(sb.toString());
                view.getAppMenuContainer().getAppMenuNew().getAppMenuNewStage().getTextField().positionCaret(tfName.length());
            }
        }
    }
}
