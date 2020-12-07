package com.tokioschool;

import com.tokioschool.database.AppModel;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        AppModel model = new AppModel();
        AppController controller = new AppController(model);
        AppView view = new AppView(stage, model, controller);
        controller.initListeners(view, view.getRes());
    }

    public static void main(String[] args) {
        launch();
    }

}