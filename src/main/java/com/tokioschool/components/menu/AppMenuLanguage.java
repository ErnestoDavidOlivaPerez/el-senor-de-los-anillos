package com.tokioschool.components.menu;

import com.tokioschool.util.BorderUtil;
import com.tokioschool.util.ImageUtil;
import com.tokioschool.util.WindowUtil;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.io.IOException;
import java.util.ResourceBundle;

public class AppMenuLanguage extends StackPane {

    private ImageView imageSpanish, imageEnglish, imageFrench;
    private Button backButton;
    private final ResourceBundle res;

    public AppMenuLanguage(ResourceBundle res){
        super();
        this.res = res;

        initComponents();
    }

    private void initComponents(){
        setPrefHeight(WindowUtil.getDimension().height);
        setPrefWidth(WindowUtil.getDimension().width);
        setAlignment(Pos.CENTER);

        try {
            imageSpanish = ImageUtil.getImageView("spanish.png");
            imageSpanish.setUserData("spanish");

            imageEnglish = ImageUtil.getImageView("english.png");
            imageEnglish.setUserData("english");

            imageFrench = ImageUtil.getImageView("french.png");
            imageFrench.setUserData("french");
        } catch (IOException e) {
            e.printStackTrace();
        }

        DropShadow dropShadow = new DropShadow(10, Color.BLACK);

        Label labelSpanish = new Label(res.getString("spanish"));
        labelSpanish.setFont(Font.font("Cambria", null, null, 50));
        labelSpanish.setTextFill(Color.WHITE);
        labelSpanish.setEffect(dropShadow);
        VBox vBoxSpanish = new VBox(imageSpanish, labelSpanish);
        vBoxSpanish.setAlignment(Pos.CENTER);

        Label labelEnglish = new Label(res.getString("english"));
        labelEnglish.setFont(Font.font("Cambria", null, null, 50));
        labelEnglish.setTextFill(Color.WHITE);
        labelEnglish.setEffect(dropShadow);
        VBox vBoxEnglish = new VBox(imageEnglish, labelEnglish);
        vBoxEnglish.setAlignment(Pos.CENTER);

        Label labelFrench = new Label(res.getString("french"));
        labelFrench.setFont(Font.font("Cambria", null, null, 50));
        labelFrench.setTextFill(Color.WHITE);
        labelFrench.setEffect(dropShadow);
        VBox vBoxFrench = new VBox(imageFrench, labelFrench);
        vBoxFrench.setAlignment(Pos.CENTER);

        backButton = new Button(res.getString("back"));
        backButton.setTranslateX(WindowUtil.getDimension().width / 2.0 - 150);
        backButton.setTranslateY(WindowUtil.getDimension().height / 2.0 - 100);
        backButton.setBackground(Background.EMPTY);
        backButton.setBorder(BorderUtil.getBlack());
        backButton.setFont(Font.font("Cambria", null, null, 50));
        backButton.setTextFill(Color.WHITE);
        backButton.setUserData("languageBack");

        HBox hBox = new HBox(vBoxSpanish, vBoxEnglish, vBoxFrench);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(100);
        hBox.setPrefWidth(WindowUtil.getDimension().width);

        getChildren().addAll(hBox, backButton);
    }

    public ImageView getImageSpanish() {
        return imageSpanish;
    }

    public ImageView getImageEnglish() {
        return imageEnglish;
    }

    public ImageView getImageFrench() {
        return imageFrench;
    }

    public Button getBackButton() {
        return backButton;
    }
}
