package com.tokioschool.components.game;

import javafx.geometry.Pos;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class AppHBoxOfSlider extends HBox {

    private Slider slider;
    private TextField textField;
    private final String userDataSlider;
    private final String userDataTextField;

    public AppHBoxOfSlider(String userDataSlider, String userDataTextField){
        super();
        this.userDataSlider = userDataSlider;
        this.userDataTextField = userDataTextField;
        setAlignment(Pos.CENTER_LEFT);
        setSpacing(10);

        initComponents();
    }

    private void initComponents(){
        slider = new Slider();
        slider.setUserData(userDataSlider);
        setHgrow(slider, Priority.ALWAYS);
        slider.setSnapToTicks(true);
        slider.setMajorTickUnit(20);
        slider.setStyle("-fx-base: black");

        textField = new TextField();
        textField.setUserData(userDataTextField);
        textField.setMaxWidth(50);
        textField.setEditable(false);
        textField.setFont(new Font("Geordia", 16));
        textField.setBackground(Background.EMPTY);
        textField.setStyle("-fx-text-fill: white");
        textField.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(7),
                new BorderWidths(2))));
        DropShadow dropShadow = new DropShadow(10, Color.WHITE);
        textField.setEffect(dropShadow);

        getChildren().addAll(slider, textField);
    }

    public TextField getTextField() {
        return textField;
    }

    public double getSliderValue() {
        return slider.getValue();
    }

    public Slider getSlider() {
        return slider;
    }

    public void setSliderMax(int max){
        slider.setMax(max);
        slider.setMin(1);
        slider.setValue(25);
        textField.setText("25");

        if (slider.getMax() > 60){
            slider.setMajorTickUnit(50);
            slider.setValue(200);
            textField.setText("200");
        }

    }

    public void reset(){
        if (slider.getMax() > 60){
            slider.setValue(200);
            textField.setText("200");
        } else {
            slider.setValue(25);
            textField.setText("25");
        }
    }
}
