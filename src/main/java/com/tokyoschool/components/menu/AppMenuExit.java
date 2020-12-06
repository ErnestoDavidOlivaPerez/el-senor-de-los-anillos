package com.tokyoschool.components.menu;

import com.tokyoschool.util.BorderUtil;
import com.tokyoschool.util.ImageUtil;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.util.ResourceBundle;

public class AppMenuExit extends Stage {

    private Label okLabel;
    private Label cancelLabel;
    private ImageView imageViewExit;
    private final ResourceBundle res;

    public AppMenuExit(Stage ownerStage, ResourceBundle res){
        super(StageStyle.TRANSPARENT);
        this.res = res;

        initComponents();

        initModality(Modality.APPLICATION_MODAL);
        setHeight(250);
        setWidth(600);
        initOwner(ownerStage);
    }

    private void initComponents(){
        DropShadow dropShadow = new DropShadow();
        dropShadow.setSpread(0.5);
        dropShadow.setOffsetX(5);

        Label titleLabel = new Label(res.getString("exit!"));
        titleLabel.setFont(Font.font("Cambria", FontWeight.NORMAL, FontPosture.REGULAR, 30));
        titleLabel.setTextFill(Color.WHITE);
        titleLabel.setEffect(dropShadow);

        Line line = new Line(5, 5, 5, 5);
        line.setFill(Color.BLACK);
        line.setStartX(0);
        line.setEndX(600);
        line.setTranslateY(-25);

        try {
            imageViewExit = ImageUtil.getImageView("cerrar.png");
            imageViewExit.setTranslateX(245);
            imageViewExit.setUserData("exitImage");
        } catch (IOException e) {
            e.printStackTrace();
        }
        HBox hBox = new HBox(titleLabel,imageViewExit);
        hBox.setAlignment(Pos.TOP_CENTER);

        Label infoLabel = new Label(res.getString("sure"));
        infoLabel.setFont(Font.font("Cambria", FontWeight.BOLD, FontPosture.REGULAR, 40));
        infoLabel.setTextFill(Color.WHITE);
        infoLabel.setEffect(dropShadow);

        okLabel = new Label(res.getString("yes"));
        okLabel.setFont(Font.font("Cambria", null, null, 35));
        okLabel.setTextFill(Color.WHITE);
        okLabel.setBorder(BorderUtil.getBlack());
        okLabel.setPadding(new Insets(0, 15, 0, 15));
        okLabel.setMinWidth(110);
        dropShadow = new DropShadow();
        dropShadow.setSpread(0.2);
        dropShadow.setOffsetX(5);
        okLabel.setEffect(dropShadow);
        okLabel.setUserData("exitOkButton");

        cancelLabel = new Label(res.getString("no!"));
        cancelLabel.setFont(Font.font("Cambria", null, null, 35));
        cancelLabel.setTextFill(Color.WHITE);
        cancelLabel.setBorder(BorderUtil.getBlack());
        cancelLabel.setPadding(new Insets(0, 15, 0, 15));
        cancelLabel.setMinWidth(110);
        dropShadow = new DropShadow();
        dropShadow.setSpread(0.2);
        dropShadow.setOffsetX(5);
        cancelLabel.setEffect(dropShadow);
        cancelLabel.setUserData("exitCancelButton");

        HBox hBox2 = new HBox(okLabel, cancelLabel);
        hBox2.setAlignment(Pos.CENTER);
        hBox2.setSpacing(30);
        hBox2.setPadding(new Insets(0, 0, 20, 0));

        VBox container = new VBox(hBox, line, infoLabel, hBox2);
        container.setSpacing(25);
        container.setBackground(new Background(new BackgroundFill(Color.rgb(193, 202, 238, 1),
                new CornerRadii(15), null)));
        container.setBorder(BorderUtil.getBlack());
        container.setAlignment(Pos.CENTER);

        Scene scene = new Scene(container);
        scene.setFill(Color.TRANSPARENT);
        setScene(scene);
    }

    public Label getOkLabel() {
        return okLabel;
    }

    public Label getCancelLabel() {
        return cancelLabel;
    }

    public ImageView getImageViewExit() {
        return imageViewExit;
    }
}
